package com.ennea.scm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ennea.scm.entity.Supplier;
import com.ennea.scm.repository.ISupplierRepository;

@Service
public class SupplierService implements ISupplierService {
	
	@Autowired
	ISupplierRepository supplierRepository;

	@Override
	public List<Supplier> findAll() {
		 List<Supplier> supplierList = supplierRepository.findAll();
	        if(supplierList.size() > 0) {
	            return supplierList;
	        } else {
	            return supplierList;
	        }
	}

}
