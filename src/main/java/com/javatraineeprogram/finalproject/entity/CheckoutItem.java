package com.javatraineeprogram.finalproject.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class CheckoutItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checkoutItem_id")
    private Integer id;

    @Column(name = "quantity")
    @NotNull(message = "Quantity is required")
    private Integer quantity;

    private Product product;
}
