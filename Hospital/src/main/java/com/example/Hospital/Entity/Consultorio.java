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
import jakarta.persistence.Table;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "consultorio")
public class Consultorio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consultorio")
    private int id_consultorio;
    
    @Column(name = "numeroConsultorio")
    private int numeroConsultorio;
    
    @Column(name = "piso")
    private int piso;
    
    public Consultorio() {
    }
    
    public Consultorio(int numeroConsultorio, int piso) {
        this.numeroConsultorio = numeroConsultorio;
        this.piso = piso;
    }

    public int getId_consultorio() {
        return id_consultorio;
    }

    public int getNumeroConsultorio() {
        return numeroConsultorio;
    }

    public int getPiso() {
        return piso;
    }

    public void setId_consultorio(int id_consultorio) {
        this.id_consultorio = id_consultorio;
    }

    public void setNumeroConsultorio(int numeroConsultorio) {
        this.numeroConsultorio = numeroConsultorio;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }
    
    
}
