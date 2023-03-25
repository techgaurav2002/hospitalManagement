package com.entity;

public class specalist {

public specalist() {
		super();
		// TODO Auto-generated constructor stub
	}
private int id;
private String specialistName;
public specalist(int id, String specialistName) {
	super();
	this.id = id;
	this.specialistName = specialistName;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSpecialistName() {
	return specialistName;
}
public void setSpecialistName(String specialistName) {
	this.specialistName = specialistName;
}
}
