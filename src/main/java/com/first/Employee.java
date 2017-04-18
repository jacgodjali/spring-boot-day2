package com.first;
 
 public class Employee {
 	String gender;
 	int id;
 	
 	public Employee(int id, String gender) {
 		this.id = id;
 		this.gender = gender;
 	}
 	
 	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee() {}
 
 	public String getGender() {
 		return gender;
 	}
 
 	public void setGender(String gender) {
 		this.gender = gender;
 	}
 }