package com.apirest.parcial.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String matricula;

    @ManyToMany(mappedBy = "estudiantes")
    @JsonIgnore
    private Set<Curso> cursos;
}
