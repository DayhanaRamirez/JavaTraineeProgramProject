package com.javatraineeprogram.finalproject.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
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

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Address.class)
    @JoinColumn(name = "fk_customerId", referencedColumnName = "customer_id")
    private List<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = PaymentMethod.class)
    @JoinColumn(name = "fk_customerId", referencedColumnName = "customer_id")
    private List<PaymentMethod> paymentMethods;
}
