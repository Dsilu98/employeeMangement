package com.example.demo.module;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Table(name = "capgemini_employee")
@Data
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "First name can't be blanck")
	@NotEmpty(message = "First name can't be empty")
	private String firstName;
	@NotBlank(message = "Last name can't be blanck")
	@NotEmpty(message = "Last name can't be empty")
	private String lastName;
	@NotBlank(message = "Designation can't be blanck")
	@NotEmpty(message = "Designation can't be empty")
	private String Designation;
	@NotBlank(message = "salary can't be blanck")
	@NotEmpty(message = "salary can't be empty")
	private Long	salary;
	@Email(message = "Enter a valid email id")
	private String email;
	@NotBlank
	@NotEmpty
	@Pattern(regexp = "\\d{10}",message = "Mobilenumber must be 10 digits")
	private String mobile;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Address address;


	
	
}
