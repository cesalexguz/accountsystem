package com.accountsystem.accountsystem.entities;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/*
 * Base class for all person-related entities
 */
@MappedSuperclass
public class Person {
	
	// Unique identification for the person
	@Id
	private String identification;
	 
	// Name of the person
	@NotBlank
	private String name;
	 
	// Gender of the person
	@NotBlank
	private String gender;
	 
	// Age of the person
	@NotNull
	private int age;
	 
	// Address of the person
	@NotBlank
	private String address;
	 
	// Phone number of the person
	@NotBlank
	private String phone;

	// Constructors 
	public Person() {
		super();
	}
	
	public Person(String identification, @NotBlank String name, @NotBlank String gender, @NotNull int age,
			@NotBlank String address, @NotBlank String phone) {
		super();
		this.identification = identification;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.phone = phone;
	}
	
	// Getters and Setters
	public String getIdentification() {
		return identification;
	}
	
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Person [identification=" + identification + ", name=" + name + ", gender=" + gender + ", age=" + age
				+ ", address=" + address + ", phone=" + phone + "]";
	}
	
}
