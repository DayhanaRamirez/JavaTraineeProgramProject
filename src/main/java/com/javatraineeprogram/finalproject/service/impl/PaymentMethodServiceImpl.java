package com.javatraineeprogram.finalproject.service.impl;

import com.javatraineeprogram.finalproject.dto.PaymentMethodDto;
import com.javatraineeprogram.finalproject.entity.PaymentMethod;
import com.javatraineeprogram.finalproject.exception.NotFoundException;
import com.javatraineeprogram.finalproject.mapper.MyMapper;
import com.javatraineeprogram.finalproject.repository.PaymentMethodRepository;
import com.javatraineeprogram.finalproject.service.PaymentMethodService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    private PaymentMethodRepository paymentMethodRepository;

    private MyMapper myMapper;

    @Override
    public PaymentMethod savePaymentMethod(PaymentMethodDto paymentMethodDto) {
        return paymentMethodRepository.save(myMapper.paymentMethodDtoToPaymentMethodEntity(paymentMethodDto));
    }

    @Override
    public PaymentMethodDto getPaymentMethodDtoById(int id) throws NotFoundException {
        try {
            return myMapper.paymentMethodEntityToPaymentMethodDto(paymentMethodRepository.getReferenceById(id));
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("Couldn't find a payment method with the given id");
        }
    }

    @Override
    public List<PaymentMethodDto> getAllPaymentMethods() {
        List<PaymentMethod> paymentMethods = paymentMethodRepository.findAll();
        List<PaymentMethodDto> paymentMethodDtoList = new ArrayList<>();
        for (PaymentMethod paymentMethod : paymentMethods) {
            paymentMethodDtoList.add(myMapper.paymentMethodEntityToPaymentMethodDto(paymentMethod));
        }
        return paymentMethodDtoList;
    }

    @Override
    public PaymentMethod updatePaymentMethod(PaymentMethodDto paymentMethodDto, int id) throws NotFoundException {
        try {
            PaymentMethod paymentMethod = paymentMethodRepository.getReferenceById(id);
            paymentMethod.setType(paymentMethodDto.getType());
            paymentMethod.setNumber(paymentMethodDto.getNumber());
            paymentMethod.setCustomer(paymentMethodDto.getCustomer());
            return paymentMethodRepository.save(paymentMethod);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("Couldn't find a payment method with the given id");
        }
    }

    @Override
    public void deletePaymentMethodById(int id) throws NotFoundException {
        try {
            paymentMethodRepository.deleteById(id);
        } catch (Exception e) {
            throw new NotFoundException("Couldn't find a payment method with the given id");
        }
    }
}

