package com.javatraineeprogram.finalproject.service.impl;

import com.javatraineeprogram.finalproject.dto.AddressDto;
import com.javatraineeprogram.finalproject.entity.Address;
import com.javatraineeprogram.finalproject.exception.NotFoundException;
import com.javatraineeprogram.finalproject.mapper.MyMapper;
import com.javatraineeprogram.finalproject.repository.AddressRepository;
import com.javatraineeprogram.finalproject.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;
    private MyMapper myMapper;

    @Override
    public Address saveAddress(AddressDto addressDto) {
        return addressRepository.save(myMapper.addressDtoToAddressEntity(addressDto));
    }

    @Override
    public AddressDto getAddressById(int id) throws NotFoundException {
        try {
            return myMapper.addressEntityToAddressDto(addressRepository.getReferenceById(id));
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("Couldn't find an address with the given id");
        }
    }

    @Override
    public List<AddressDto> getAAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        List<AddressDto> addressDtoList = new ArrayList<>();
        for (Address address : addresses) {
            addressDtoList.add(myMapper.addressEntityToAddressDto(address));
        }
        return addressDtoList;
    }

    @Override
    public Address updateAddress(AddressDto addressDto, int id) throws NotFoundException {
        try {
            Address address = addressRepository.getReferenceById(id);
            address.setStreet(addressDto.getStreet());
            address.setCity(addressDto.getCity());
            address.setState(addressDto.getState());
            address.setCustomer(addressDto.getCustomer());
            return addressRepository.save(address);

        } catch (EntityNotFoundException e) {
            throw new NotFoundException("Couldn't find an address with the given id");
        }
    }

    @Override
    public void deleteAddressById(int id) throws NotFoundException {
        try {
            addressRepository.deleteById(id);
        } catch (Exception e) {
            throw new NotFoundException("Couldn't find an address with the given id");
        }
    }
}
