package com.apirest.parcial.entitys.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CursoResumenDTO {
    private Long id;
    private String nombreCurso;
    private String profesorNombre;
}
