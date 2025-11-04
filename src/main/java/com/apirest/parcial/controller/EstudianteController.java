package com.apirest.parcial.controller;

import com.apirest.parcial.entitys.Curso;
import com.apirest.parcial.entitys.DTO.CursoResumenDTO;
import com.apirest.parcial.entitys.Estudiante;
import com.apirest.parcial.repository.EstudianteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteRepository estudianteRepository;
    public EstudianteController(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    //listar estudiantes

    @GetMapping
    public List<Estudiante> listarEstudiantes(){
        return estudianteRepository.findAll();
    }

    // crear estudiante
    @PostMapping
    public Estudiante crearEstudiante(@RequestBody Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }

    // cursos de un estudiante
    @GetMapping("/{id}/cursos")
    public List<CursoResumenDTO> listarCursos(@PathVariable Long id){
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado"));
        return estudiante.getCursos().stream()
                .map(c -> new CursoResumenDTO(
                        c.getId(),
                        c.getNombre(),
                        c.getProfesor() != null ? c.getProfesor().getNombre() : null
                )).toList();
    }
}
