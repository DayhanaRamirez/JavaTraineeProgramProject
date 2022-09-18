package com.javatraineeprogram.finalproject.controller;

import com.javatraineeprogram.finalproject.dto.PaymentMethodDto;
import com.javatraineeprogram.finalproject.dto.PaymentMethodDtoForReturn;
import com.javatraineeprogram.finalproject.exception.NotFoundException;
import com.javatraineeprogram.finalproject.service.PaymentMethodService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Validated
@RestController
@RequestMapping("/paymentmethod")
public class PaymentMethodController {
    private PaymentMethodService paymentMethodService;

    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethodDtoForReturn> getPaymentMethodById(@PathVariable("id") int id) throws NotFoundException {
        return new ResponseEntity<>(paymentMethodService.getPaymentMethodDtoById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PaymentMethodDtoForReturn>> getPaymentMethods() {
        return new ResponseEntity<>(paymentMethodService.getAllPaymentMethods(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> savePaymentMethod(@Valid @RequestBody PaymentMethodDto paymentMethodDto) {
        paymentMethodService.savePaymentMethod(paymentMethodDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updatePaymentMethod(@PathVariable("id") int id, @Valid @RequestBody PaymentMethodDto paymentMethodDto) throws NotFoundException {
        paymentMethodService.updatePaymentMethod(paymentMethodDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePaymentMethod(@PathVariable("id") int id) throws NotFoundException {
        paymentMethodService.deletePaymentMethodById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
