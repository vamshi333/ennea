package com.ennea.scm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ennea.scm.entity.Supplier;
import com.ennea.scm.service.ISupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	ISupplierService supplierService;
 
	@GetMapping
    public List<Supplier> getAllSuppliers() {
        List<Supplier> list = supplierService.findAll();
 
        return list;
    }
}
