package com.ennea.scm.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ennea.scm.entity.Supplier;

@Repository
public interface ISupplierRepository extends  PagingAndSortingRepository<Supplier,String>{

	public List<Supplier> findAll();
	
	
}
