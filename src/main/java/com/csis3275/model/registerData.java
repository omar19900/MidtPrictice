package com.csis3275.model;

public class registerData {
	//name, email, paswords, fullName, gender, phone
	private int id;	
	private String name; 
	private String email;
	private String paswords;
	private String fullName;
	private String gender; 
	private String phone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPaswords() {
		return paswords;
	}
	public void setPaswords(String paswords) {
		this.paswords = paswords;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public String getMessage() {

		String message = "";

		if (this.name == "") {
			message +="not allowed to leave the name empty"; 
		}
		else if (this.name != null) {
			message += this.name+ " added"; 
			
		}

		return message;
	}
	@Override
	public String toString() {
		return "registerData [id=" + id + ", name=" + name + ", email=" + email + ", paswords=" + paswords
				+ ", fullName=" + fullName + ", gender=" + gender + ", phone=" + phone + "]";
	}
	
	
	
	
	
	
	
	

}
