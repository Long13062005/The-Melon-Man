package com.example.shopdemo.service.imp;

import com.example.shopdemo.dto.ProductDto;
import com.example.shopdemo.entities.*;
import com.example.shopdemo.repository.*;
import com.example.shopdemo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private StyleRepository styleRepository;
    @Autowired
    private PromotionRepository promotionRepository;
    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private ColorRepository colorRepository;


    @Override
 public void saveProduct(Product product) {
    productRepository.save(product);
}

    @Override
    public Page<Product> findProductsByNameContainingIgnoreCase(String name, Pageable pageable) {
        return productRepository.findProductsByNameContainingIgnoreCase(name, pageable);
    }

    @Override
    public Page<Product> findProductsByFiltersAndKeyword(Long price, String category, String color, String size, String style, String keyword, Pageable pageable) {
        return productRepository.findProductsByFiltersAndKeyword(price, category, color, size, style, keyword, pageable);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void updateProduct(Product product,Long id) {
        product.setId(id);
        productRepository.save(product);
    }

}
