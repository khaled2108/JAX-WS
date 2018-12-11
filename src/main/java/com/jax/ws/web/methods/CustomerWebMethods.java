package com.jax.ws.web.methods;

import java.util.logging.Logger;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jax.ws.model.Customer;
import com.jax.ws.service.CustomerService;

@Component
@WebService
public class CustomerWebMethods {

	private final static Logger LOGGER = Logger.getLogger(CustomerWebMethods.class.getName());

	@Autowired
	private CustomerService customerService;

	@WebMethod(operationName = "findById")
	@WebResult(name = "Customer")
	public Customer findById(@WebParam(name = "id") Long id) {
		LOGGER.info("id::" + id);
		Customer customer = customerService.findById(id);
		LOGGER.info("customer::" + customer);
		return customer;
	}
}