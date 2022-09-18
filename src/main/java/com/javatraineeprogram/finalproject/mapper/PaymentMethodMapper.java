package com.javatraineeprogram.finalproject.mapper;

import com.javatraineeprogram.finalproject.dto.PaymentMethodDto;
import com.javatraineeprogram.finalproject.dto.PaymentMethodDtoForReturn;
import com.javatraineeprogram.finalproject.entity.PaymentMethod;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class PaymentMethodMapper {

    public PaymentMethod paymentMethodDtoToPaymentMethodEntity(PaymentMethodDto paymentMethodDto) {
        return PaymentMethod.builder()
                .type(paymentMethodDto.getType())
                .number(paymentMethodDto.getNumber())
                .build();
    }

    public PaymentMethodDtoForReturn paymentMethodEntityToPaymentMethodDto(PaymentMethod paymentMethod) {
        return PaymentMethodDtoForReturn.builder()
                .id(paymentMethod.getId())
                .type(paymentMethod.getType())
                .number(paymentMethod.getNumber())
                .customerId(paymentMethod.getCustomer().getId())
                .build();
    }
}
