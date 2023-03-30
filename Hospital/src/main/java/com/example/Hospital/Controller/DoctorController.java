/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Hospital.Controller;

import com.example.Hospital.Entity.Doctor;
import com.example.Hospital.Services.DoctorService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    
    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
    Doctor savedDoctor = doctorService.addDoctor(doctor);
    return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> findDoctorById(@PathVariable int id) {
    Optional<Doctor> optionalDoctor = doctorService.findDoctorById(id);
    if (optionalDoctor.isPresent()) {
        Doctor doctor = optionalDoctor.get();
    return new ResponseEntity<>(doctor, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> modifyDoctor(@PathVariable int id, @RequestBody Doctor doctor) {
        Optional<Doctor> optionalDoctor = doctorService.findDoctorById(id);
        if (optionalDoctor.isPresent()) {
            Doctor existingDoctor = optionalDoctor.get();
            existingDoctor.setNombre(doctor.getNombre());
            existingDoctor.setApellidoPaterno(doctor.getApellidoPaterno());
            existingDoctor.setApellidoMaterno(doctor.getApellidoMaterno());
            existingDoctor.setEspecialidad(doctor.getEspecialidad());
            Doctor savedDoctor = doctorService.modifyDoctor(existingDoctor);
            return new ResponseEntity<>(savedDoctor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable int id) {
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
}
