package com.javatraineeprogram.finalproject.dto;

import com.javatraineeprogram.finalproject.entity.Customer;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@Data
@Builder
public class PaymentMethodDto implements Serializable {

    @Column(name = "type")
    @NotBlank(message = "Type is required")
    private String type;

    @Column(name = "number")
    @NotBlank(message = "Number is required")
    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;
}
