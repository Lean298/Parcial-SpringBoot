package com.apirest.parcial.repository;

import com.apirest.parcial.entitys.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
