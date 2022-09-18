package com.javatraineeprogram.finalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDtoForReturn implements Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private List<AddressDtoForReturn> addressDtoForReturnList;
    private List<PaymentMethodDtoForReturn> paymentMethodDtoForReturnList;
}
