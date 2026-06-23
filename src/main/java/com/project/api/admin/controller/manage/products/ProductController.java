package com.project.api.admin.controller.manage.products;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ProductController {

    @GetMapping("/products")
    public String products(Model model){
        return "manage/products/products";
    }

    @GetMapping("/add-new-product")
    public String addNewProduct(Model model){
        return "manage/products/add-new-product";
    }
}
