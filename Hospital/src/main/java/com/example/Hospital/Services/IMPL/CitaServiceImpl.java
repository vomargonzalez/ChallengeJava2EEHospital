/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Hospital.Services.IMPL;

import com.example.Hospital.Entity.Cita;
import com.example.Hospital.Repository.CitaRepository;
import com.example.Hospital.Repository.ConsultorioRepository;
import com.example.Hospital.Repository.DoctorRepository;
import com.example.Hospital.Services.CitaService;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class CitaServiceImpl implements CitaService {
    @Autowired
    private CitaRepository citaRepository;
    
    @Autowired
    private DoctorRepository doctorRepository;
    
    @Autowired
    private ConsultorioRepository consultorioRepository;

 @Override
    public boolean altaCita(int idDoctor, int idConsultorio, String nombrePaciente, LocalDateTime fechaConsulta) {

        // Restriction 1: Check if there is already a register with the same idConsultorio and fechaConsulta
        Optional<Cita> cita = citaRepository.findByConsultorioIdAndFechaConsulta(idConsultorio, fechaConsulta);
        if (cita.isPresent()) {
            return false;
        }

        // Restriction 2: Check if there is already a register with the same idDoctor and fechaConsulta
        int citasCount = citaRepository.countByDoctorIdAndFechaConsulta(idDoctor, fechaConsulta);
        if (citasCount > 0) {
            return false;
        }

        // Restriction 3: Check if there is already a register with the same nombrePaciente and idConsultorio
        LocalDateTime fechaConsultaMin = fechaConsulta.minusHours(2);
        LocalDateTime fechaConsultaMax = fechaConsulta.plusHours(2);
        citasCount = citaRepository.countByNombrePacienteAndConsultorioIdAndFechaConsultaBetween(nombrePaciente, idConsultorio, fechaConsultaMin, fechaConsultaMax);
        if (citasCount > 0) {
            return false;
        }

        // Restriction 4: Check if the idDoctor has more than 8 records in the same day
        LocalDate fechaConsultaDate = fechaConsulta.toLocalDate();
        citasCount = citaRepository.countByDoctorIdAndFechaConsultaBetween(idDoctor, fechaConsultaDate.atStartOfDay(), fechaConsultaDate.atTime(LocalTime.MAX));
        if (citasCount >= 8) {
            return false;
        }

        // Create the new cita entity
        Cita newCita = new Cita();
        newCita.setDoctor(doctorRepository.findById(idDoctor).get());
        newCita.setConsultorio(consultorioRepository.findById(idConsultorio).get());
        newCita.setNombrePaciente(nombrePaciente);
        newCita.setFechaConsulta(fechaConsulta);
        citaRepository.save(newCita);
        return true;
    }  

    @Override
    public Optional<Cita> getCitaById(int idCita) {
        return citaRepository.findById(idCita);
    }



    
}
