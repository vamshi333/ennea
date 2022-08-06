package com.ennea.scm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
@IdClass(ProductPK.class)

public class Product {

	@Id
	@Column(name = "code", nullable = false)
	private String code;

	@Id
	@Column(name = "batch", nullable = false)
	private String batch;

	@Column(name = "company", nullable = false)
	private String company;
	@Id
	@Column(name = "expiry", nullable = true)
	private Date expiry;
	@Column(name = "free", nullable = false)
	private int free;
	@Column(name = "mrp", nullable = false)
	private float mrp;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "rate", nullable = false)
	private float rate;

	public Product() {

	}

	public Product(String batch, String code, String company, Date expiry, int free, float mrp, String name,
			float rate) {
		super();
		this.batch = batch;
		this.code = code;
		this.company = company;
		this.expiry = expiry;
		this.free = free;
		this.mrp = mrp;
		this.name = name;
		this.rate = rate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFree() {
		return free;
	}

	public void setFree(int free) {
		this.free = free;
	}

	public float getMrp() {
		return mrp;
	}

	public void setMrp(float mrp) {
		this.mrp = mrp;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

}
