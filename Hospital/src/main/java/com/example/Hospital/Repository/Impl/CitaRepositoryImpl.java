/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Hospital.Repository.Impl;

import com.example.Hospital.Entity.Cita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository
public class CitaRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;
     
    
    public List<Cita> findByConsultorioIdAndFechaConsultaBetween(int idConsultorio, LocalDateTime fechaConsultaStart, LocalDateTime fechaConsultaEnd) {
        return entityManager.createQuery(
                "SELECT id_doctor as 'idDoctor', fechaConsulta as 'fechaCita' FROM Cita WHERE consultorio.idConsultorio = id_Consultorio AND fechaConsulta BETWEEN :fechaConsultaStart AND :fechaConsultaEnd", Cita.class)
                .setParameter("idConsultorio", idConsultorio)
                .setParameter("fechaConsultaStart", fechaConsultaStart)
                .setParameter("fechaConsultaEnd", fechaConsultaEnd)
                .getResultList();
    }
    
    public int countByDoctorIdAndFechaConsulta(int idDoctor, LocalDateTime fechaConsulta) {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(c) FROM Cita c WHERE c.doctor.id = :idDoctor AND c.fechaConsulta = :fechaConsulta", Long.class);
        query.setParameter("idDoctor", idDoctor);
        query.setParameter("fechaConsulta", fechaConsulta);
        return query.getSingleResult().intValue();
    }
    
    
    public int countByNombrePacienteAndConsultorioIdAndFechaConsultaBetween(String nombrePaciente, int idConsultorio, LocalDateTime fechaConsultaMin, LocalDateTime fechaConsultaMax) {
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT COUNT(c) FROM Cita c WHERE c.nombrePaciente = :nombrePaciente AND c.consultorio.id = :idConsultorio AND c.fechaConsulta BETWEEN :fechaConsultaMin AND :fechaConsultaMax",
                Long.class);

        query.setParameter("nombrePaciente", nombrePaciente);
        query.setParameter("idConsultorio", idConsultorio);
        query.setParameter("fechaConsultaMin", fechaConsultaMin);
        query.setParameter("fechaConsultaMax", fechaConsultaMax);

        return query.getSingleResult().intValue();
    }
    
    
    public int countByDoctorIdAndFechaConsultaBetween(int idDoctor, LocalDateTime fechaConsultaStart, LocalDateTime fechaConsultaEnd) {
        String queryString = "SELECT COUNT(c) FROM Cita c WHERE c.doctor.id = :idDoctor AND c.fechaConsulta BETWEEN :fechaConsultaStart AND :fechaConsultaEnd";
        TypedQuery<Long> query = entityManager.createQuery(queryString, Long.class);
        query.setParameter("idDoctor", idDoctor);
        query.setParameter("fechaConsultaStart", fechaConsultaStart);
        query.setParameter("fechaConsultaEnd", fechaConsultaEnd);
    return query.getSingleResult().intValue();
    }
    
}
