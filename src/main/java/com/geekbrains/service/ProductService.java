package com.geekbrains.service;

import com.geekbrains.entity.Product;
import com.geekbrains.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(int id) {
        Product product = productRepository.findOneById(id);
        return product;
    }

    public List<Product> getAllProducts(){
        return productRepository.getAllProduct();
    }

    public List<Product> addProduct(Product product){
        return productRepository.addProductToList(product);

    }
    
}
