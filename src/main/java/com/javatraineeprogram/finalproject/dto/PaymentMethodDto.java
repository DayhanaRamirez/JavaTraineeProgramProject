package com.javatraineeprogram.finalproject.dto;

import com.javatraineeprogram.finalproject.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentMethodDto implements Serializable {

    @NotBlank(message = "Type is required")
    private String type;

    @NotBlank(message = "Number is required")
    private String number;

    private Customer customer;
}
