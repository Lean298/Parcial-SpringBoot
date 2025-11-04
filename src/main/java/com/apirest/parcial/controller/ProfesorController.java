package com.apirest.parcial.controller;

import com.apirest.parcial.entitys.DTO.NuevoCursoRequest;
import com.apirest.parcial.entitys.Profesor;
import com.apirest.parcial.repository.ProfesorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
@CrossOrigin(origins = "*")
public class ProfesorController {

    private final ProfesorRepository profesorRepository;
    public ProfesorController(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    //listar profes
    @GetMapping
    public List<Profesor> listar(){
        return profesorRepository.findAll();
    }

    //crar profe
    @PostMapping
    public Profesor crear(@RequestBody Profesor p){
        return profesorRepository.save(p);

    }
}
