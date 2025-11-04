package com.apirest.parcial.controller;

import com.apirest.parcial.entitys.Curso;
import com.apirest.parcial.entitys.DTO.NuevoCursoRequest;
import com.apirest.parcial.entitys.Profesor;
import com.apirest.parcial.repository.CursoRepository;
import com.apirest.parcial.service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    private final CursoService cursoService;
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<Curso> listar(){
        return cursoService.findAll();
    }

    @PostMapping
    public Curso crear(@RequestBody NuevoCursoRequest request){
        return cursoService.crearCurso(request);
    }

    @PostMapping("/{cursoId}/estudiantes/{EstudianteId}")
    public Curso asignarEstudiante(@PathVariable Long cursoId, @PathVariable Long EstudianteId){
        return cursoService.asignarEstudiante(cursoId, EstudianteId);
    }
}
