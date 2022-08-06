package com.ennea.scm.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ennea.scm.dto.Inventory;
import com.ennea.scm.entity.ProductSupplier;
import com.ennea.scm.entity.ProductSupplierPK;

@Repository
public interface IProductSupplierRepository extends  PagingAndSortingRepository<ProductSupplier,ProductSupplierPK>{

	public List<ProductSupplier> findAll();
	
	@Query(value = "select p.code , p.name,  p.batch, p.expiry, p.company,  p.free , p.mrp, p.rate, ps.stock, ps.deal, ps.supplier from Product_Supplier  ps inner join Product p on p.code=ps.product_code where stock >0 and ps.supplier = ?1", 
			  nativeQuery = true)
	public List<Inventory> getInventoryStockBySupplierName(Pageable paging, String suppName);

	@Query(value = "select p.code , p.name,  p.batch, p.expiry, p.company,  p.free , p.mrp, p.rate, ps.stock, ps.deal, ps.supplier from Product_Supplier  ps inner join Product p on p.code=ps.product_code where stock >0 and ps.product_code = ?1", 
			  nativeQuery = true)
	public List<Inventory> getInventoryStockByProductName(Pageable paging, String pName);

	
	@Query(value = "select p.code , p.name,  p.batch, p.expiry, p.company,  p.free , p.mrp, p.rate, ps.stock, ps.deal, ps.supplier from Product_Supplier  ps inner join Product p on p.code=ps.product_code where p.expiry>current_date and ps.supplier = ?1", 
			  nativeQuery = true)
	public List<Inventory> getNonExpiredInventoryBySupplierName(Pageable paging, String suppName);

	@Query(value = "select p.code , p.name,  p.batch, p.expiry, p.company,  p.free , p.mrp, p.rate, ps.stock, ps.deal, ps.supplier from Product_Supplier  ps inner join Product p on p.code=ps.product_code where p.expiry>current_date", 
			  nativeQuery = true)
	public List<Inventory> getNonExpiredInventory(Pageable paging);
	
	
}
