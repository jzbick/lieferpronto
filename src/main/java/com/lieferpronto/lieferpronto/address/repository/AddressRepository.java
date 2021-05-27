package com.lieferpronto.lieferpronto.address.repository;

import com.lieferpronto.lieferpronto.address.models.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository extends CrudRepository<Address, UUID> {

}
