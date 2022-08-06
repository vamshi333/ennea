package com.ennea.scm.dto;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.ennea.scm.entity.ProductSupplier;

@Projection(name = "inventoryMapping", types = { ProductSupplier.class })
public interface Inventory {

	    @Value("#{target.code}")
	    String getProductCode();
	    
	    @Value("#{target.name}")
	    String getName();
	    
	    @Value("#{target.batch}")
	    String getBatch();
	    
	    @Value("#{target.expiry}")
	    Date getExpiry();
	    
	    @Value("#{target.company}")
	    String getCompany();
	    
	    @Value("#{target.free}")
	    float getFree();
	    
	    @Value("#{target.mrp}")
	    float getMrp();
	    
	    @Value("#{target.rate}")
	    float getRate();
	    
	    @Value("#{target.stock}")
	    int getStock();
	    
	    @Value("#{target.deal}")
	    int getDeal();
	    
	    @Value("#{target.supplier}")
	    String getSupplier();


	}
