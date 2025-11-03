package com.apirest.parcial.entitys.DTO;
import lombok.Data;

@Data
public class NuevoCursoRequest {
    private String nombre;
    private Long profesorId;
}
