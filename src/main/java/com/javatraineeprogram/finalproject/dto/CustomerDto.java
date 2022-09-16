package com.javatraineeprogram.finalproject.dto;

import com.javatraineeprogram.finalproject.entity.Address;
import com.javatraineeprogram.finalproject.entity.PaymentMethod;
import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CustomerDto implements Serializable {
    @Column(name = "firstName")
    @NotBlank(message = "First name is required")
    private String firstName;

    @Column(name = "lastName")
    @NotBlank(message = "Last name is required")
    private String lastName;

    @Column(name = "email", unique = true)
    @Email(message = "The format of the email address isn't correct")
    @NotBlank(message = "Email is required")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", orphanRemoval = true)
    private List<PaymentMethod> paymentMethods = new ArrayList<>();
}
