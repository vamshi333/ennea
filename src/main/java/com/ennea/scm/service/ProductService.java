package com.ennea.scm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ennea.scm.entity.Product;
import com.ennea.scm.repository.IProductRepository;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	IProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		 List<Product> productList = productRepository.findAll();
	        if(productList.size() > 0) {
	            return productList;
	        } else {
	            return productList;
	        }
	}

}
