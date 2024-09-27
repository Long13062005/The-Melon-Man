package com.example.shopdemo.repository;

import com.example.shopdemo.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM Products WHERE LOWER(name) LIKE LOWER(CONCAT('%', :name, '%')) AND is_deleted = false",
            countQuery = "SELECT COUNT(*) FROM Products WHERE LOWER(name) LIKE LOWER(CONCAT('%', :name, '%')) AND is_deleted = false",
            nativeQuery = true)
    Page<Product> findProductsByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);

@Modifying
@Query("UPDATE Product p SET p.isDeleted = true WHERE p.id = :id")
void deleteById(@Param("id") Long id);

@Query(value = "SELECT p.* " +
        "FROM Products p " +
        "JOIN product_styles ps ON p.id = ps.product_id " +
        "JOIN Styles s ON ps.style_id = s.id " +
        "JOIN product_colors pc ON p.id = pc.product_id " +
        "JOIN Colors c ON pc.color_id = c.id " +
        "JOIN product_sizes psz ON p.id = psz.product_id " +
        "JOIN Sizes sz ON psz.size_id = sz.id " +
        "JOIN Categories cat ON p.category_id = cat.id " +
        "WHERE (:price IS NULL OR p.price <= :price) " +
        "AND (:category IS NULL OR LOWER(cat.name) LIKE LOWER(CONCAT('%', :category, '%'))) " +
        "AND (:color IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :color, '%'))) " +
        "AND (:size IS NULL OR LOWER(sz.name) LIKE LOWER(CONCAT('%', :size, '%'))) " +
        "AND (:style IS NULL OR LOWER(s.name) LIKE LOWER(CONCAT('%', :style, '%'))) " +
        "AND (:keyword IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%'))) " +
        "AND p.isDeleted = false",
        nativeQuery = true)
Page<Product> findProductsByFiltersAndKeyword(
        @Param("price") Long price,
        @Param("category") String category,
        @Param("color") String color,
        @Param("size") String size,
        @Param("style") String style,
        @Param("keyword") String keyword,
        Pageable pageable);
}
