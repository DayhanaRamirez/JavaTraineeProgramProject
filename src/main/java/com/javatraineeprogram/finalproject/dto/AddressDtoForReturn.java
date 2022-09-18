package com.javatraineeprogram.finalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDtoForReturn implements Serializable {
    private Integer id;
    private String street;
    private String city;
    private String state;
    private String country;
    private Integer customerId;
}
