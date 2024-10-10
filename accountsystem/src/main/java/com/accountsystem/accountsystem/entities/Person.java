package com.accountsystem.accountsystem.entities;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@MappedSuperclass
public class Person {
    @Id
    private String identification;
    
    @NotBlank
    private String name;
    
    @NotBlank
    private String gender;
    
    @NotNull
    private int age;
    
    @NotBlank
    private String address;
    
    @NotBlank
    private String phone;

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
