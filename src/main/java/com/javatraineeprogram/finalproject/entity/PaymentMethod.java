package com.javatraineeprogram.finalproject.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "paymentMethod")
public class PaymentMethod implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentMethod_id")
    private Integer id;

    @Column(name = "type")
    @NotBlank(message = "Type is required")
    private String type;

    @Column(name = "number")
    @NotBlank(message = "Number is required")
    private String number;
}
