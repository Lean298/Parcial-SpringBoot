package com.apirest.parcial.service;

import com.apirest.parcial.entitys.Curso;
import com.apirest.parcial.entitys.DTO.NuevoCursoRequest;

public interface CursoService extends GenericService<Curso,Long> {
    Curso crearCurso(NuevoCursoRequest request);
    Curso asignarEstudiante(Long cursoId, Long estudianteId);
}
