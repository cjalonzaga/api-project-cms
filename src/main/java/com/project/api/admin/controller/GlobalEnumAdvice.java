package com.project.api.admin.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.project.api.enums.ProductStatus;

@ControllerAdvice
public class GlobalEnumAdvice {
	@ModelAttribute("productStatusEnum")
	public ProductStatus[] productStatusValues() {
		return ProductStatus.values();
	}
}
