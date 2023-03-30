/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Hospital.Services;


import com.example.Hospital.Entity.Cita;
import java.time.LocalDateTime;
import java.util.List;

public interface CitaService {
    
    public boolean altaCita(int idDoctor, int idConsultorio, String nombrePaciente, LocalDateTime fechaConsulta);

}
