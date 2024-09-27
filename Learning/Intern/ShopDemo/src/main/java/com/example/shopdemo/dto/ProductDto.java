package com.example.shopdemo.dto;

import com.example.shopdemo.entities.Color;
import com.example.shopdemo.entities.Size;
import com.example.shopdemo.entities.Style;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private int quantity;
    private Long price;
    private int review;
    private int rating;
    private String category;
    private String promotion;
    private List<Color> color;
    private List<Style> style;
    private List<Size> size;
}
