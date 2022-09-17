package com.javatraineeprogram.finalproject.dto;

import com.javatraineeprogram.finalproject.entity.Address;
import com.javatraineeprogram.finalproject.entity.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoEmailCustomerDto {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    private List<Address> addresses;

    private List<PaymentMethod> paymentMethods;
}
