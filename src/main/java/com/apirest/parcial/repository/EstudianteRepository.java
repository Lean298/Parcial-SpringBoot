package com.apirest.parcial.repository;

import com.apirest.parcial.entitys.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {
    Optional<Estudiante> findByMatricula(String matricula);
}
