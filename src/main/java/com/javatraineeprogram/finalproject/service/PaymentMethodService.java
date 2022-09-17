package com.javatraineeprogram.finalproject.service;

import com.javatraineeprogram.finalproject.dto.PaymentMethodDto;
import com.javatraineeprogram.finalproject.entity.PaymentMethod;
import com.javatraineeprogram.finalproject.exception.NotFoundException;

import java.util.List;

public interface PaymentMethodService {

    PaymentMethod savePaymentMethod(PaymentMethodDto paymentMethodDto);

    PaymentMethodDto getPaymentMethodDtoById(int id) throws NotFoundException;

    List<PaymentMethodDto> getAllPaymentMethods();

    PaymentMethod updatePaymentMethod(PaymentMethodDto paymentMethodDto, int id) throws NotFoundException;

    void deletePaymentMethodById(int id) throws NotFoundException;
}
