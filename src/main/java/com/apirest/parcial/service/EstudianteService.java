package com.apirest.parcial.service;

import com.apirest.parcial.entitys.Estudiante;

import java.util.Optional;

public interface EstudianteService extends GenericService<Estudiante,Long> {
    Optional<Estudiante> findByMatricula(String matricula);
}
