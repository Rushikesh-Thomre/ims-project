package com.uok.oop.ims.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDto {
    private String client_id;       
    private String client_NIC;     
    private String client_name;     
    private String client_address;  
    private String client_contact; 
    private String client_email;   
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getClient_NIC() {
		return client_NIC;
	}
	public void setClient_NIC(String client_NIC) {
		this.client_NIC = client_NIC;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getClient_address() {
		return client_address;
	}
	public void setClient_address(String client_address) {
		this.client_address = client_address;
	}
	public String getClient_contact() {
		return client_contact;
	}
	public void setClient_contact(String client_contact) {
		this.client_contact = client_contact;
	}
	public String getClient_email() {
		return client_email;
	}
	public void setClient_email(String client_email) {
		this.client_email = client_email;
	}
	
}
