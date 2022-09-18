package com.javatraineeprogram.finalproject.service.impl;

import com.javatraineeprogram.finalproject.dto.AddressDto;
import com.javatraineeprogram.finalproject.dto.AddressDtoForReturn;
import com.javatraineeprogram.finalproject.entity.Address;
import com.javatraineeprogram.finalproject.entity.Customer;
import com.javatraineeprogram.finalproject.exception.NotFoundException;
import com.javatraineeprogram.finalproject.mapper.AddressMapper;
import com.javatraineeprogram.finalproject.mapper.MyMapper;
import com.javatraineeprogram.finalproject.repository.AddressRepository;
import com.javatraineeprogram.finalproject.repository.CustomerRepository;
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

    private CustomerRepository customerRepository;

    private AddressMapper addressMapper;

    @Override
    public Address saveAddress(AddressDto addressDto) throws NotFoundException {
        try {
            Address address = addressMapper.addressDtoToAddressEntity(addressDto);
            Customer customer = customerRepository.getReferenceById(addressDto.getCustomerId());
            address.setCustomer(customer);
            return addressRepository.save(address);

        } catch (Exception e) {
            throw new NotFoundException("Couldn't find a customer with the given id");
        }
    }

    @Override
    public AddressDtoForReturn getAddressById(int id) throws NotFoundException {
        try {
            return addressMapper.addressEntityToAddressDto(addressRepository.getReferenceById(id));
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("Couldn't find an address with the given id");
        }
    }

    @Override
    public List<AddressDtoForReturn> getAAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        List<AddressDtoForReturn> addressDtoForReturnList = new ArrayList<>();
        for (Address address : addresses) {
            addressDtoForReturnList.add(addressMapper.addressEntityToAddressDto(address));
        }
        return addressDtoForReturnList;
    }

    @Override
    public Address updateAddress(AddressDto addressDto, int id) throws NotFoundException {
        try {
            Address address = addressRepository.getReferenceById(id);
            address.setStreet(addressDto.getStreet());
            address.setCity(addressDto.getCity());
            address.setState(addressDto.getState());
            address.setCountry(addressDto.getCountry());
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
