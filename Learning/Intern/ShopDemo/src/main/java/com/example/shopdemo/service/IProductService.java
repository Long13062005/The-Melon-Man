package com.example.shopdemo.service;

import com.example.shopdemo.dto.ProductDto;
import com.example.shopdemo.entities.Categories;
import com.example.shopdemo.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    void saveProduct(Product product);
    Page<Product> findProductsByNameContainingIgnoreCase(String name, Pageable pageable);

    public Page<Product> findProductsByFiltersAndKeyword(Long price, String category, String color, String size, String style, String keyword, Pageable pageable) ;

    void deleteProductById(Long id);

    Optional<Product> findProductById(Long id);

    void updateProduct(Product product,Long id);
}
