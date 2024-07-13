package com.epharmacy.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;

	private String orderFullName;// means users full name
	private String orderFullOrder; // full address
	private String orderContactNumber;
	private String orderAlternateContactNumber;
	private String orderStatus;
	private Double orderAmount;

//	@ManyToOne
	@OneToOne
	private Medicine medicine;

//	@ManyToOne
	@OneToOne
	private User user;

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(String orderFullName, String orderFullOrder, String orderContactNumber,
			String orderAlternateContactNumber, String orderStatus, Double orderAmount, Medicine medicine, User user) {
		super();
		this.orderFullName = orderFullName;
		this.orderFullOrder = orderFullOrder;
		this.orderContactNumber = orderContactNumber;
		this.orderAlternateContactNumber = orderAlternateContactNumber;
		this.orderStatus = orderStatus;
		this.orderAmount = orderAmount;
		this.medicine = medicine;
		this.user = user;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderFullName() {
		return orderFullName;
	}

	public void setOrderFullName(String orderFullName) {
		this.orderFullName = orderFullName;
	}

	public String getOrderFullOrder() {
		return orderFullOrder;
	}

	public void setOrderFullOrder(String orderFullOrder) {
		this.orderFullOrder = orderFullOrder;
	}

	public String getOrderContactNumber() {
		return orderContactNumber;
	}

	public void setOrderContactNumber(String orderContactNumber) {
		this.orderContactNumber = orderContactNumber;
	}

	public String getOrderAlternateContactNumber() {
		return orderAlternateContactNumber;
	}

	public void setOrderAlternateContactNumber(String orderAlternateContactNumber) {
		this.orderAlternateContactNumber = orderAlternateContactNumber;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
