/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Hospital.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "cita")
public class Cita {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private int id_cita; 
    
    @Column(name = "nombrePaciente")
    private String nombrePaciente;

    @Column(name = "fechaConsulta")
    private LocalDateTime fechaConsulta;

    @ManyToMany
    @JoinTable(name = "cita_doctor",joinColumns = @JoinColumn(name = "cita_id"),
    inverseJoinColumns = @JoinColumn(name = "doctor_id"))
    private Set<Doctor> doctors;
    
    @ManyToMany
    @JoinTable(name = "cita_consultorio",joinColumns = @JoinColumn(name = "cita_id"),
    inverseJoinColumns = @JoinColumn(name = "consultorio_id"))
    private Set<Consultorio> consultorios;
    
    public Cita() {
    }
    
    public Cita(String nombrePaciente, LocalDateTime fechaConsulta, Set<Doctor> doctors, Set<Consultorio> consultorios) {
        this.nombrePaciente = nombrePaciente;
        this.fechaConsulta = fechaConsulta;
        this.doctors = doctors;
        this.consultorios = consultorios;
    }

    public int getId_cita() {
        return id_cita;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public LocalDateTime getFechaConsulta() {
        return fechaConsulta;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public Set<Consultorio> getConsultorios() {
        return consultorios;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public void setFechaConsulta(LocalDateTime fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void setConsultorios(Set<Consultorio> consultorios) {
        this.consultorios = consultorios;
    }

    public void setDoctor(Doctor get) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setConsultorio(Consultorio get) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
