package com.example.restaurante.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatoRequestDTO {
    private String nombre;
    private String descripcion;
}