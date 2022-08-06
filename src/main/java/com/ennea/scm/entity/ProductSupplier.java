package com.ennea.scm.entity;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.ennea.scm.dto.Inventory;

@Entity
@Table(name = "PRODUCT_SUPPLIER")
@IdClass(ProductSupplierPK.class)
@SqlResultSetMapping(
	    name="inventoryMapping",
	    classes={
	        @ConstructorResult(
	            targetClass=Inventory.class,
	            columns={
	                @ColumnResult(name="code"),
	               
	                
	            }
	        )
	    }
	)

public class ProductSupplier {

	@Id
	private String productCode;
	@Id
	private String supplier;
	@Id
	private int stock;
	@Id
	private int deal;
	@Id
	private String batch;

	public ProductSupplier(String productCode, String supplier, int stock, int deal, String batch) {
		super();
		this.productCode = productCode;
		this.supplier = supplier;
		this.stock = stock;
		this.deal = deal;
		this.batch = batch;
	}

	public ProductSupplier() {

	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getDeal() {
		return deal;
	}

	public void setDeal(int deal) {
		this.deal = deal;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

}
