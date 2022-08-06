package com.ennea.scm.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ennea.scm.entity.Product;
import com.ennea.scm.entity.ProductPK;

@Repository
public interface IProductRepository extends  PagingAndSortingRepository<Product,ProductPK>{

	public List<Product> findAll();
}
