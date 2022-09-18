package com.javatraineeprogram.finalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDtoForReturn implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private Double price;
}
