package com.ennea.scm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ennea.scm.dto.Inventory;
import com.ennea.scm.service.IScmService;

@RestController
@RequestMapping("/scm")
public class ScmController {

	@Autowired
	IScmService scmService;

	@PostMapping("/upload")
	public String uploadCSV(@RequestParam("file") MultipartFile file) {
		String str = scmService.uploadCSV(file);
		return str;
	}

	@GetMapping("/product/stock")
	public List<Inventory> getInventoryStockByParam(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(name="supplierName", required = false) String suppName,
			@RequestParam(name="productCode", required = false) String pName) {
		return scmService.getInventoryStockByParam(pageNo, pageSize, suppName, pName);
	}
	
	@GetMapping("/product/nonExpired")
	public List<Inventory> getNonExpiredInvetoryBySupplierName(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(name="supplierName", required = false) String suppName) {
		List<Inventory> a = scmService.getNonExpiredInvetoryBySupplierName(pageNo, pageSize, suppName);
		return a;
	}
}
