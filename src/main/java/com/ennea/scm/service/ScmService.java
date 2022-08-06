package com.ennea.scm.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ennea.scm.dto.Inventory;
import com.ennea.scm.entity.Product;
import com.ennea.scm.entity.ProductSupplier;
import com.ennea.scm.entity.Supplier;
import com.ennea.scm.repository.IProductRepository;
import com.ennea.scm.repository.IProductSupplierRepository;
import com.ennea.scm.repository.ISupplierRepository;

@Service
public class ScmService implements IScmService {

	@Autowired
	IProductRepository productRepository;

	@Autowired
	ISupplierRepository supplierRepository;

	@Autowired
	IProductSupplierRepository productSupplierRepository;

	@Override
	public String uploadCSV(MultipartFile file) {
		if (!file.isEmpty()) {
			try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
					CSVParser csvParser = new CSVParser(fileReader,
							CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
				List<Product> productList = new ArrayList<Product>();
				Set<String> supplierSet = new HashSet<String>();
				List<Supplier> supplierList = new ArrayList<Supplier>();

				List<ProductSupplier> psList = new ArrayList<ProductSupplier>();
				
				Iterable<CSVRecord> csvRecords = csvParser.getRecords();
				for (CSVRecord eachRecord : csvRecords) {
					Date date=new Date();
					try {

						if(eachRecord.get("exp").length()>=6){
							date= new SimpleDateFormat("dd/MM/yyyy").parse(eachRecord.get("exp"));
						}

						Product p = new Product(eachRecord.get("batch"), eachRecord.get("code"), eachRecord.get("company"),
								date, Integer.parseInt(eachRecord.get("free")),
								Float.parseFloat(eachRecord.get("mrp")), eachRecord.get("name"),
								Float.parseFloat(eachRecord.get("rate")));
						if (!supplierSet.contains(eachRecord.get("supplier"))) {
							supplierSet.add(eachRecord.get("supplier"));
							Supplier s = new Supplier(eachRecord.get("supplier"));
							supplierList.add(s);
						}
						ProductSupplier ps = new ProductSupplier(eachRecord.get("code"), eachRecord.get("supplier"),
								Integer.parseInt(eachRecord.get("stock")), Integer.parseInt(eachRecord.get("deal")),
								eachRecord.get("batch"));
						productList.add(p);
						psList.add(ps);
					
					}catch(Exception e) {
						System.out.println(e);
					}
				}
				productRepository.saveAll(productList);
				supplierRepository.saveAll(supplierList);
				productSupplierRepository.saveAll(psList);

				return "file uploaded successfully";
			} catch (IOException e) {
				throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
			}
		} else {
			return "unable to upload file";
		}
	}

	@Override
	public List<Inventory> getInventoryStockByParam(Integer pageNo, Integer pageSize, String suppName, String pName) {
		
		Pageable paging = PageRequest.of(pageNo,pageSize);
		List<Inventory> list =new ArrayList<Inventory>();
		if((suppName!=null && !suppName.isEmpty()) && (pName!=null && !pName.isEmpty())) {
			return list;
		}else if((suppName!=null && !suppName.isEmpty())) {
			list= productSupplierRepository.getInventoryStockBySupplierName(paging, suppName);
		}else if(pName!=null && !pName.isEmpty()) {
			list= productSupplierRepository.getInventoryStockByProductName(paging, pName);

		}
		return list;
	}

	@Override
	public List<Inventory> getNonExpiredInvetoryBySupplierName(Integer pageNo, Integer pageSize, String suppName) {
		Pageable paging = PageRequest.of(pageNo,pageSize);
		if(suppName==null || suppName.isEmpty()) {
			return productSupplierRepository.getNonExpiredInventory(paging);
		}else {
			return productSupplierRepository.getNonExpiredInventoryBySupplierName(paging,suppName);			
		}
	}

}
