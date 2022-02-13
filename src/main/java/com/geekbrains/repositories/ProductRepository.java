package com.geekbrains.repositories;

import com.geekbrains.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ProductRepository {

    private List<Product> productList = new ArrayList<Product>(){{
        add(new Product(1, "Milk", 50));
        add(new Product(2, "Bread", 20));
        add(new Product( 3, "Butter", 40));
    }};

    public void setProductList(List<Product> products) {
        products = productList;

    }


    public Product findOneById(int id){
        for (Product product: productList) {
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }
    public List<Product> getAllProduct(){
        return productList;
    }

    public List<Product> addProductToList (Product product){
        productList.add(product);
        return productList;
    }


}
