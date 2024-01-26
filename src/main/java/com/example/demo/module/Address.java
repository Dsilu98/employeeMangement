package com.example.demo.module;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Validated
@Table(name = "capgemini_address")
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@NotEmpty
	private String state;
	@NotBlank
	@NotEmpty
	private String dist;
	@NotBlank
	@NotEmpty
	private String pin;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(Long id, @NotBlank @NotEmpty String state, @NotBlank @NotEmpty String dist,
			@NotBlank @NotEmpty String pin) {
		super();
		this.id = id;
		this.state = state;
		this.dist = dist;
		this.pin = pin;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDist() {
		return dist;
	}
	public void setDist(String dist) {
		this.dist = dist;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", state=" + state + ", dist=" + dist + ", pin=" + pin + "]";
	}
	
	

}
