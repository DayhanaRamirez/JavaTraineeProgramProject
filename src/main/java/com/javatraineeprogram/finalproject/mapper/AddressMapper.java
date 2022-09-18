package com.javatraineeprogram.finalproject.mapper;

import com.javatraineeprogram.finalproject.dto.AddressDto;
import com.javatraineeprogram.finalproject.dto.AddressDtoForReturn;
import com.javatraineeprogram.finalproject.entity.Address;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class AddressMapper {

    public Address addressDtoToAddressEntity(AddressDto addressDto) {
        return Address.builder()
                .street(addressDto.getStreet())
                .city(addressDto.getCity())
                .state(addressDto.getState())
                .country(addressDto.getCountry())
                .build();
    }

    public AddressDtoForReturn addressEntityToAddressDto(Address address) {
        return AddressDtoForReturn.builder()
                .id(address.getId())
                .street(address.getStreet())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .customerId(address.getCustomer().getId())
                .build();
    }
}
