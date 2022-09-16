package com.javatraineeprogram.finalproject.dto;

import com.javatraineeprogram.finalproject.entity.Address;
import com.javatraineeprogram.finalproject.entity.PaymentMethod;
import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class NoEmailCustomerDto {
    @Column(name = "firstName")
    @NotBlank(message = "First name is required")
    private String firstName;

    @Column(name = "lastName")
    @NotBlank(message = "Last name is required")
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", orphanRemoval = true)
    private List<PaymentMethod> paymentMethods = new ArrayList<>();
}
