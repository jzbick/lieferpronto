package com.lieferpronto.lieferpronto.customer.components;

import com.lieferpronto.lieferpronto.address.components.AddressService;
import com.lieferpronto.lieferpronto.address.models.Address;
import com.lieferpronto.lieferpronto.customer.models.Customer;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class CustomerController {

    private final CustomerService customerService;
    private final AddressService addressService;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        Optional<Customer> customer = customerService.findById(UUID.fromString(id));
        if (customer.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomer() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createOrUpdateCustomer(@RequestBody Customer customer) {
        List<Address> addresses = new ArrayList<>();
        customer.getAddresses().forEach(address -> {
            Optional<Address> optionalAddress = addressService.findAddressByCityAndZipAndStreet(address);
            optionalAddress.ifPresentOrElse(
                addresses::add,
                () -> {
                    address.setId(addressService.saveAddress(address).getId());
                    addresses.add(address);
                });
        });
        customer.setAddresses(addresses);
        return new ResponseEntity<>(String.format("Successfully updated or created customer with id: %s",
            customerService.saveCustomer(customer).getId()),
            HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable UUID id) {
        Optional<Customer> customerOptional = customerService.findById(id);

        if (customerOptional.isEmpty()) {
            return new ResponseEntity<>(String.format("Customer with id: %s doesn't exist", id), HttpStatus.NOT_FOUND);
        }
        customerService.deleteCustomer(customerOptional.get());
        return new ResponseEntity<>(String.format("Successfully deleted customer with id: %s", customerOptional.get().getId()),
            HttpStatus.OK);
    }
}
