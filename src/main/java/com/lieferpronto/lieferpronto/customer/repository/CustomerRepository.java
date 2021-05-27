package com.lieferpronto.lieferpronto.customer.repository;

import com.lieferpronto.lieferpronto.customer.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, UUID> {

}
