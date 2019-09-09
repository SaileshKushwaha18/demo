package com.example.demo.model;

import java.util.Date;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the demouser. ")
public class DemoUser {

	@ApiModelProperty(notes = "First Name of the demo user")
	private String firstName;

	@ApiModelProperty(notes = "Last Name of the demo user")
	private String lastName;

	@ApiModelProperty(notes = "Age of the demo user")
	@Size(min = 18, message = "Age of the demo user should be atleast 18 years")
	private Integer age;

	@ApiModelProperty(notes = "Date Of Birth of the demo user")
	private Date dob;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public DemoUser() {
	}

	public DemoUser(String firstName, String lastName, Integer age, Date dob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dob = dob;
	}

}
