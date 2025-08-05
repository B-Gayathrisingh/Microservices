package com.example.doctor.entity;

import jakarta.persistence.*;

@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String specialization;
	public Doctor(int id, String name, String specialization) {
		super();
		this.id = id;
		this.name = name;
		this.specialization = specialization;
	}
	public Doctor() {
	
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
}
