package com.lieferpronto.lieferpronto.address.components;

import com.lieferpronto.lieferpronto.address.models.Address;
import com.lieferpronto.lieferpronto.address.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AddressService {

    private final AddressRepository addressRepository;

    public Optional<Adress> findById(UUID id) {
        return addressRepository.findById(id);
    }

    public List<Address> findAll() {
        var addresses = new ArrayList<Address>();
        addressRepository.findAll().forEach(addresses::add);
        return addresses;
    }

    public Address saveAddress(Address address) {
        addressRepository.save(address);
        return address;
    }

    public void deleteAddress(Address address) {
        addressRepository.deleteById(address.getId());
    }
}
