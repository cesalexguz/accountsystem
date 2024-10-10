package com.accountsystem.accountsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="client")
public class Client extends Person {
	
	@NotNull
    private Long clientId;
    
	@NotBlank
	private String password;
    
    private boolean status;

	public Client() {
		super();
	}

	public Client(String identification, @NotBlank String name, @NotBlank String gender, @NotNull int age,
			@NotBlank String address, @NotBlank String phone, Long clientId, @NotBlank String password, boolean status) {
		super(identification, name, gender, age, address, phone);
		this.clientId = clientId;
		this.password = password;
		this.status = status;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", password=" + password + ", status=" + status + "]";
	}

}
