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
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "capgemini_employee")
//@Data
//@Getter
//@Setter
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

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Long id,
			@NotBlank(message = "First name can't be blanck") @NotEmpty(message = "First name can't be empty") String firstName,
			@NotBlank(message = "Last name can't be blanck") @NotEmpty(message = "Last name can't be empty") String lastName,
			@NotBlank(message = "Designation can't be blanck") @NotEmpty(message = "Designation can't be empty") String designation,
			@NotBlank(message = "salary can't be blanck") @NotEmpty(message = "salary can't be empty") Long salary,
			@Email(message = "Enter a valid email id") String email,
			@NotBlank @NotEmpty @Pattern(regexp = "\\d{10}", message = "Mobilenumber must be 10 digits") String mobile,
			Address address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		Designation = designation;
		this.salary = salary;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", Designation="
				+ Designation + ", salary=" + salary + ", email=" + email + ", mobile=" + mobile + ", address="
				+ address + "]";
	}

	
	
	
}
