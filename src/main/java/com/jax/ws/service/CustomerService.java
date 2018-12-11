package com.jax.ws.service;

import com.jax.ws.model.Customer;

public interface CustomerService {

	Customer findById(Long id);
}
