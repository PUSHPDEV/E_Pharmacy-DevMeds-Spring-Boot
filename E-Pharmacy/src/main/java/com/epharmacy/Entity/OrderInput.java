package com.epharmacy.Entity;

import java.util.List;

public class OrderInput { // This class will take the full details of user

	private String fullName; // full name of user
	private String fullAddress;
	private String contactNumber;
	private String alternateContactNumber;

	// User can add multiple medicine in the cart.
	private List<OrderMedicineQuantity> orderMedicineQuantityList;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAlternateContactNumber() {
		return alternateContactNumber;
	}

	public void setAlternateContactNumber(String alternateContactNumber) {
		this.alternateContactNumber = alternateContactNumber;
	}

	public List<OrderMedicineQuantity> getOrderMedicineQuantityList() {
		return orderMedicineQuantityList;
	}

	public void setOrderMedicineQuantityList(List<OrderMedicineQuantity> orderMedicineQuantityList) {
		this.orderMedicineQuantityList = orderMedicineQuantityList;
	}

}
