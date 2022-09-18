package com.javatraineeprogram.finalproject.service.impl;

import com.javatraineeprogram.finalproject.dto.PaymentMethodDto;
import com.javatraineeprogram.finalproject.dto.PaymentMethodDtoForReturn;
import com.javatraineeprogram.finalproject.entity.Customer;
import com.javatraineeprogram.finalproject.entity.PaymentMethod;
import com.javatraineeprogram.finalproject.exception.NotFoundException;
import com.javatraineeprogram.finalproject.mapper.PaymentMethodMapper;
import com.javatraineeprogram.finalproject.repository.CustomerRepository;
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
    private PaymentMethodMapper paymentMethodMapper;
    private CustomerRepository customerRepository;

    @Override
    public PaymentMethod savePaymentMethod(PaymentMethodDto paymentMethodDto) throws NotFoundException {
        try {
            PaymentMethod paymentMethod = paymentMethodMapper.paymentMethodDtoToPaymentMethodEntity(paymentMethodDto);
            Customer customer = customerRepository.getReferenceById(paymentMethodDto.getCustomerId());
            paymentMethod.setCustomer(customer);
            return paymentMethodRepository.save(paymentMethod);
        } catch (Exception e) {
            throw new NotFoundException("Couldn't find a customer with the given id");
        }

    }

    @Override
    public PaymentMethodDtoForReturn getPaymentMethodDtoById(int id) throws NotFoundException {
        try {
            return paymentMethodMapper.paymentMethodEntityToPaymentMethodDto(paymentMethodRepository.getReferenceById(id));
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("Couldn't find a payment method with the given id");
        }
    }

    @Override
    public List<PaymentMethodDtoForReturn> getAllPaymentMethods() {
        List<PaymentMethod> paymentMethods = paymentMethodRepository.findAll();
        List<PaymentMethodDtoForReturn> paymentMethodDtoForReturnList = new ArrayList<>();
        for (PaymentMethod paymentMethod : paymentMethods) {
            paymentMethodDtoForReturnList.add(paymentMethodMapper.paymentMethodEntityToPaymentMethodDto(paymentMethod));
        }
        return paymentMethodDtoForReturnList;
    }

    @Override
    public PaymentMethod updatePaymentMethod(PaymentMethodDto paymentMethodDto, int id) throws NotFoundException {
        try {
            PaymentMethod paymentMethod = paymentMethodRepository.getReferenceById(id);
            paymentMethod.setType(paymentMethodDto.getType());
            paymentMethod.setNumber(paymentMethodDto.getNumber());
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

