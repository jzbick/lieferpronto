package com.lieferpronto.lieferpronto.address.components;

import com.lieferpronto.lieferpronto.address.models.Address;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable String id) {
        Optional<Address> address = addressService.findById(UUID.fromString(id));
        if (address.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(address.get(), HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAddress() {
        return new ResponseEntity<>(addressService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createOrUpdateAddress(@RequestBody Address address) {
        return new ResponseEntity<>(String.format("Successfully updated or created address with id: %s",
            addressService.saveAddress(address).getId()),
            HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable UUID id) {
        Optional<Address> addressOptional = addressService.findById(id);

        if (addressOptional.isEmpty()) {
            return new ResponseEntity<>(String.format("Address with id: %s doesn't exist", id), HttpStatus.NOT_FOUND);
        }
        addressService.deleteAddress(addressOptional.get());
        return new ResponseEntity<>(String.format("Successfully deleted address with id: %s", addressOptional.get().getId()),
            HttpStatus.OK);
    }
}
