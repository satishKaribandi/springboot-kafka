package com.saka.kafkaDemo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer  implements Serializable{
	

	  /*public Customer(String customerId, String customerName, float d, Status employee) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.salary = d;
		this.status = employee;
		
	}*/
	   
	 

	  private String customerId;
	  public Customer(String customerId, String customerName, float salary, Status status) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.salary = salary;
		this.status = status;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	private String customerName;
	  private float salary;
	  private Status status;

	  public enum Status {
	    EMPLOYEE, CONTRACTOR, RESIGNED, SELECTED, TERMINATED
	  }
	}

