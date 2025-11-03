package com.apirest.parcial.repository;

import com.apirest.parcial.entitys.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
