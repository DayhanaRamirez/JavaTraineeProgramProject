package com.javatraineeprogram.finalproject.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
public class ProductDto implements Serializable {
    @Column(name = "name")
    @NotBlank(message = "First name is required")
    private String name;

    @Column(name = "description")
    @NotBlank(message = "Description name is required")
    private String description;

    @Column(name = "price")
    @NotNull(message = "Price is required")
    private Double price;
}
