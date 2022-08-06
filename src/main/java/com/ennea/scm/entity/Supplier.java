package com.ennea.scm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SUPPLIER")
public class Supplier {
	
	public Supplier() {
		
	}

	public Supplier( String supplierName) {
		super();
//		this.supplierCode = supplierCode;
		this.supplierName = supplierName;
	}

	@Id
	private String supplierName;
//	private String supplierCode;

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

//	public String getSupplierCode() {
//		return supplierCode;
//	}
//
//	public void setSupplierCode(String supplierCode) {
//		this.supplierCode = supplierCode;
//	}

	
}
