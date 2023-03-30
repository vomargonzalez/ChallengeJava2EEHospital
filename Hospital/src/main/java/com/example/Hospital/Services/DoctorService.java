/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Hospital.Services;

import com.example.Hospital.Entity.Doctor;
import com.example.Hospital.Repository.DoctorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class DoctorService {
   @Autowired
    private DoctorRepository doctorRepository; 

    public Doctor addDoctor(Doctor doctor) {
      return doctorRepository.save(doctor);
    } 
    
    public void deleteDoctor(int id) {
        doctorRepository.deleteById(id);
    }
    
    public Optional<Doctor> findDoctorById(int id) {
        return doctorRepository.findById(id);
    }
    
    public Doctor modifyDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
    
}
