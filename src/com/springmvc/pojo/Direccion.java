package com.springmvc.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Direccion {
	private String calle;
	private String codigoPostal;

	public Direccion() {
	}

	public Direccion(String calle, String codigoPostal) {
		this.calle = calle;
		this.codigoPostal = codigoPostal;
	}

	@Autowired
	public void setCalle(@Value("Leona Vicario") String calle) {
		this.calle = calle;
	}

	@Autowired
	public void setCodigoPostal(@Value("61940") String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", codigoPostal=" + codigoPostal + "]";
	}
}
