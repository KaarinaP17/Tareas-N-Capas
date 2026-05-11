package com.example.restaurante.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatoResponseDTO {
    private Long id;
    private String nombre;
    private String descripcion;
}