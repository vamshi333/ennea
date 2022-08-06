package com.ennea.scm.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ennea.scm.dto.Inventory;
import com.ennea.scm.entity.ProductSupplier;

public interface IScmService {
	
	public String uploadCSV(MultipartFile file) ;

	public List<Inventory> getInventoryStockByParam(Integer pageNo, Integer pageSize, String suppName, String pName);

	public List<Inventory> getNonExpiredInvetoryBySupplierName(Integer pageNo, Integer pageSize, String suppName);
}
