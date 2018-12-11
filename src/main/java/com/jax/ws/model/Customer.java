package com.jax.ws.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@XmlElement(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@XmlElement(name = "firstName")
	@Column(name = "firstname")
	private String firstName;

	@XmlElement(name = "lastName")
	@Column(name = "lastname")
	private String lastName;

	protected Customer() {
	}

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
	}
}
