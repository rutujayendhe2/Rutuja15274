package com.cakeapp.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class CustomerData {
	
	private static final long SerialVersionUID = 10l;
	
	private long customerId;
	
	@NotEmpty(message = "First name is required")
	private String firstName;
	
	@NotEmpty(message = "Last name is required")
	private String lastName;
	
	@NotEmpty(message = "Email is required")
	@Email
	private String emailAdd;
	
	@NotEmpty(message = "Phone number is required")
    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
             message="Phone number is invalid")
	private String phoneNo;
	
	@NotEmpty(message = "Address is required")
	private String address;
	
	@NotEmpty
	@Size(min = 8, message = "password should have at least 8 characters")
	private String password;

	public CustomerData() {
		super();
	}



	public CustomerData(long customerId, String firstName, String lastName, String emailAdd, String phoneNo,
			String address, String password) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAdd = emailAdd;
		this.phoneNo = phoneNo;
		this.address = address;
		this.password = password;
	}



	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
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

	public String getEmailAdd() {
		return emailAdd;
	}

	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return SerialVersionUID;
	}

	@Override
	public String toString() {
		return "CustomerData [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailAdd=" + emailAdd + ", phoneNo=" + phoneNo + ", address=" + address + ", password=" + password
				+ "]";
	}

}
