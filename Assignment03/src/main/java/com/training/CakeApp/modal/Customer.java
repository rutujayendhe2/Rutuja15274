package com.training.CakeApp.modal;

public class Customer {

	private int customerId;
	private String firstName;
	private String lastName;
	private String emailAdd;
	private String phoneNo;
	private String address;
	
	private static int counter = 100;
	
	public Customer() {
		super();
	}

	public Customer(String firstName, String lastName, String emailAdd, String phoneNo, String address 
		) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAdd = emailAdd;
		this.phoneNo = phoneNo;
		this.address = address;
	}

	public Customer(int customerId, String firstName, String lastName, String emailAdd, String phoneNo, String address
			) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAdd = emailAdd;
		this.phoneNo = phoneNo;
		this.address = address;
		
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
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

	

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailAdd=" + emailAdd + ", phoneNo=" + phoneNo + ", address=" + address  + "]";
	}
	
	
}
