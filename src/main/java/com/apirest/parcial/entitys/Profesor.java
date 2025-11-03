package com.apirest.parcial.entitys;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Profesor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String email;

     @OneToMany(mappedBy = "profesor")
     @JsonIgnore
    private List<Curso> cursos;
}
