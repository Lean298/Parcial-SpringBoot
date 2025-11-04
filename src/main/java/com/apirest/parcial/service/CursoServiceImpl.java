package com.apirest.parcial.service;

import com.apirest.parcial.entitys.Curso;
import com.apirest.parcial.entitys.DTO.NuevoCursoRequest;
import com.apirest.parcial.entitys.Estudiante;
import com.apirest.parcial.entitys.Profesor;
import com.apirest.parcial.repository.CursoRepository;
import com.apirest.parcial.repository.EstudianteRepository;
import com.apirest.parcial.repository.ProfesorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CursoServiceImpl extends GenericServiceImpl<Curso,Long> implements CursoService {

    private final EstudianteRepository estudianteRepository;
    private final ProfesorRepository profesorRepository;

    public CursoServiceImpl(CursoRepository cursoRepository,
                            EstudianteRepository estudianteRepository,
                            ProfesorRepository profesorRepository) {
        super(cursoRepository);
        this.estudianteRepository = estudianteRepository;
        this.profesorRepository = profesorRepository;
    }

    @Override
    public Curso crearCurso(NuevoCursoRequest request){
        Profesor profesor = profesorRepository.findById(request.getProfesorId()).orElseThrow(() -> new IllegalArgumentException("Profesor no encontrado"));
        Curso curso = Curso.builder()
                .nombre(request.getNombre())
                .profesor(profesor)
                .build();
        return save(curso);
    }
    @Override
    public Curso asignarEstudiante(Long cursoId, Long estudianteId) {
        Curso curso = repository.findById(cursoId).orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado"));
        curso.getEstudiantes().add(estudiante);
        return save(curso);
    }
}
