package com.apirest.parcial.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToOne(optional = false)
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @ManyToMany
    @JoinTable(
            name = "curso_estudiante",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "estudiante_id")
    )
    @Builder.Default
    private Set<Estudiante> estudiantes = new HashSet<>();

}
