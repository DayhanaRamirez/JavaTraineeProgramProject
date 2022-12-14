package com.javatraineeprogram.finalproject.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "address")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer id;

    @Column(name = "street")
    @NotBlank(message = "Street is required")
    private String street;

    @Column(name = "city")
    @NotBlank(message = "City is required")
    private String city;

    @Column(name = "state")
    @NotBlank(message = "State name is required")
    private String state;

    @Column(name = "state")
    @NotBlank(message = "Country name is required")
    private String country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Customer customer;
}
