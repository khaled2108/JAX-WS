package com.jax.ws.service.impl;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jax.ws.model.Customer;
import com.jax.ws.repository.CustomerRepository;
import com.jax.ws.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final static Logger LOGGER = Logger.getLogger(CustomerServiceImpl.class.getName());

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer findById(Long id) {
		LOGGER.info("id::" + id);
		Optional<Customer> customer = customerRepository.findById(id);
		return customer.get();
	}
}