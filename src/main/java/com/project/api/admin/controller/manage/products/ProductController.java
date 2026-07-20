package com.project.api.admin.controller.manage.products;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.api.entities.dtos.ProductDto;
import com.project.api.services.ProductService;
import com.project.api.utils.HtmlSanitizerUtil;

@Controller
@RequestMapping("/admin")
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

    @GetMapping("/products")
    public String products( 
    		@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size, 
            Model model){
    	
    	int currentPage = page > 0 ? page -1 : page;
    	Page<ProductDto> productDtoList = productService.findAllWithPaging(PageRequest.of(currentPage, size));
    	
		model.addAttribute("currentPage", productDtoList.getNumber() + 1);
		model.addAttribute("totalItems", productDtoList.getTotalElements());
     	model.addAttribute("totalPages", productDtoList.getTotalPages());
     	model.addAttribute("pageSize", size);
     	
     	model.addAttribute("target", "/admin/products");
    	
    	model.addAttribute("productlist" , productDtoList);
    	
        return "manage/products/products";
    }

    @GetMapping("/add-new-product")
    public String addNewProduct(Model model){
    	model.addAttribute("product" , new ProductDto());
        return "manage/products/add-new-product";
    }
    
    @PostMapping("/create")
    public String createProduct(@ModelAttribute ProductDto dto) {
    	
    	ProductDto product = productService.createProduct(dto);
    	
    	return "redirect:/admin/product?id="+product.getId();
    }
    
    @GetMapping("/product")
    public String edit(Model model ,@RequestParam(required = false) Long id) {
    	if(id != null) {
    		model.addAttribute("product", productService.find(id));
    	}	
    	return "manage/products/add-new-product";
    }
}
