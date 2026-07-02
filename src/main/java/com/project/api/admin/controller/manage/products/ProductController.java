package com.project.api.admin.controller.manage.products;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.api.entities.dtos.ProductDto;
import com.project.api.utils.HtmlSanitizerUtil;

@Controller
@RequestMapping("/admin")
public class ProductController {

    @GetMapping("/products")
    public String products(Model model){
        return "manage/products/products";
    }

    @GetMapping("/add-new-product")
    public String addNewProduct(Model model){
    	model.addAttribute("product" , new ProductDto());
        return "manage/products/add-new-product";
    }
    
    @PostMapping("/create")
    public String createProduct(@ModelAttribute ProductDto dto) {
    	System.out.println(HtmlSanitizerUtil.sanitize(dto.getDescription() )+ " ---> ");
    	System.out.println(HtmlSanitizerUtil.sanitize(dto.getShortDescription() )+ " ---> ");
    	return "redirect:/admin/product?id="+1;
    }
    
    @GetMapping("/product")
    public String edit(Model model ,@RequestParam(required = false) Long id) {
    	model.addAttribute("product", new ProductDto());	
    	return "manage/products/add-new-product";
    }
}
