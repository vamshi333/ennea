package com.ennea.scm.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProductSupplierPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productCode;
	private String supplier;
	private int stock;
	private int deal;
	private String batch;

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
