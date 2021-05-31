package com.lieferpronto.lieferpronto.customer.components;

import com.lieferpronto.lieferpronto.customer.models.Customer;
import com.lieferpronto.lieferpronto.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Optional<Customer> findById(UUID id) {
        return customerRepository.findById(id);
    }

    public List<Customer> findAll() {
        var customers = new ArrayList<Customer>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    public Customer saveCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    public void deleteCustomer(Customer customer) {
        customerRepository.deleteById(customer.getId());
    }
}
