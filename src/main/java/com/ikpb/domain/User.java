package com.ikpb.domain;

public class User {
	public enum UserType{
		NEW_USER,EMPLOYEE, DHEAD, DCHAIR, BENCO;
	}	
	private int id;
	
	private String firstName;

	private String lastName;

	private String email;

	private String password;
	
	private int reportsTo;
	
	private int title;
	
	private int remainingAmount;

	private UserType userType;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public int getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}

	public int getTitle() {
		return title;
	}

	public void setTitle(int title) {
		this.title = title;
	}

	public int getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(int remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	@Override
	public String toString() {
		return "id= "+id+"firstName="  + firstName + ", lastName= " + lastName + ", email= " + email + ", password= " + password
				+ ", userType= " + userType;
	}

	public User(int id, String firstName, String lastName, String email, String password, UserType userType) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userType = userType;
	}
	public User(int id, String firstName, String lastName, String email, int reportsTo, int title, int reimbursement, UserType userType) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.reportsTo=reportsTo;
		this.title=title;
		this.remainingAmount=reimbursement;
		this.userType = userType;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
