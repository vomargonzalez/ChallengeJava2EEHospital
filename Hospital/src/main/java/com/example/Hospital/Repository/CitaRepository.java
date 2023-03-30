/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Hospital.Repository;
import com.example.Hospital.Entity.Cita;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {
        Optional<Cita> findByConsultorioIdAndFechaConsulta(int idConsultorio, LocalDateTime fechaConsulta);

        
        int countByDoctorIdAndFechaConsulta(int idDoctor, LocalDateTime fechaConsulta);
        
        public int countByNombrePacienteAndConsultorioIdAndFechaConsultaBetween(String nombrePaciente, int idConsultorio, LocalDateTime fechaConsultaMin, LocalDateTime fechaConsultaMax);
        
        int countByDoctorIdAndFechaConsultaBetween(int idDoctor, LocalDateTime fechaConsultaStart, LocalDateTime fechaConsultaEnd);


}
