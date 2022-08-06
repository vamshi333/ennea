package com.ennea.scm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ennea.scm.entity.Product;
import com.ennea.scm.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
    ProductService productService;
 
    @GetMapping
    @ResponseBody
    public List<Product> getAllProducts() {
        List<Product> list = productService.findAll();
 
        return list;
    }
}
