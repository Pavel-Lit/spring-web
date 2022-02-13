package com.geekbrains.controllers;

import com.geekbrains.entity.Product;
import com.geekbrains.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/product")
    public String productPage(){
        return "product/products";
    }
    @GetMapping("products-page")
    public String productsPage(Model model){
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("productList",productList);
        return "product/products-page";
    }
    @GetMapping("show-product/{sid}")
    public String showProductById(Model model, @PathVariable(value = "sid") int id){
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product/show-product";
    }

    @RequestMapping("/product-form")
    public String showForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "product/product-form";
    }


    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("product") Product product) {
        productService.addProduct(product);
        return "product/added-page";
    }
}
