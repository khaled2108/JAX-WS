package com.jax.ws.repository;

import org.springframework.data.repository.CrudRepository;

import com.jax.ws.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
