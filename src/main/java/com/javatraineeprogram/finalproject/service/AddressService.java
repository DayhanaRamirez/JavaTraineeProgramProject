package com.javatraineeprogram.finalproject.service;

import com.javatraineeprogram.finalproject.dto.AddressDto;
import com.javatraineeprogram.finalproject.entity.Address;
import com.javatraineeprogram.finalproject.exception.NotFoundException;

import java.util.List;

public interface AddressService {

    Address saveAddress(AddressDto addressDto);

    AddressDto getAddressById(int id) throws NotFoundException;

    List<AddressDto> getAAllAddresses();

    Address updateAddress(AddressDto addressDto, int id) throws NotFoundException;

    void deleteAddressById(int id) throws NotFoundException;
}
