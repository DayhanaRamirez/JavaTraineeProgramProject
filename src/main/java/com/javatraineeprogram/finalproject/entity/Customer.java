package com.javatraineeprogram.finalproject.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

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
