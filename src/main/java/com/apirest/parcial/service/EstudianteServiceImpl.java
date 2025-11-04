package com.apirest.parcial.service;

import com.apirest.parcial.entitys.Estudiante;
import com.apirest.parcial.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstudianteServiceImpl extends GenericServiceImpl<Estudiante,Long> implements EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteServiceImpl(EstudianteRepository repository, EstudianteRepository estudianteRepository) {
        super(repository);
        this.estudianteRepository = repository;
    }

    @Override
    public Optional<Estudiante> findByMatricula(String matricula) {
        return estudianteRepository.findByMatricula(matricula);
    }
}
