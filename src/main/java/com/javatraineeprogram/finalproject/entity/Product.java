package com.javatraineeprogram.finalproject.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "name", unique = true)
    @NotBlank(message = "First name is required")
    private String name;

    @Column(name = "description")
    @NotBlank(message = "Description name is required")
    private String description;

    @Column(name = "price")
    @NotNull(message = "Price is required")
    private Double price;
}
