package com.example.doctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doctor.entity.Doctor;
import com.example.doctor.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepo;
	
	public Doctor addDoctor(Doctor doctor) {
		doctorRepo.save(doctor);
		return doctor;
	}
	public List<Doctor>getAllDoctors(){
		return doctorRepo.findAll();
	}
	public Doctor getDoctorById(int id) {
		return doctorRepo.findById(id);
	}
}
