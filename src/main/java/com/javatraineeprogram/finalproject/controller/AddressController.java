package com.javatraineeprogram.finalproject.controller;

import com.javatraineeprogram.finalproject.dto.AddressDto;
import com.javatraineeprogram.finalproject.exception.NotFoundException;
import com.javatraineeprogram.finalproject.service.AddressService;
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
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable("id") int id) throws NotFoundException {
        return new ResponseEntity<>(addressService.getAddressById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AddressDto>> getAddresses() {
        return new ResponseEntity<>(addressService.getAAllAddresses(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> saveAddress(@Valid @RequestBody AddressDto addressDto) {
        addressService.saveAddress(addressDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateAddress(@PathVariable("id") int id, @Valid @RequestBody AddressDto addressDto) throws NotFoundException {
        addressService.updateAddress(addressDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAddress(@PathVariable("id") int id) throws NotFoundException {
        addressService.deleteAddressById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
