package com.lieferpronto.lieferpronto.customer.components;

import com.lieferpronto.lieferpronto.customer.models.Customer;
import com.lieferpronto.lieferpronto.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> findAll() {

        var customers = new ArrayList<Customer>();
        customerRepository.findAll().forEach(customers::add);

        return customers;
    }

    public ResponseEntity<Customer> createOrder(Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
}
