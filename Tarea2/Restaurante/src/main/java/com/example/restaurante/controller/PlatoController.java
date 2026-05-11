package com.example.restaurante.controller;

import com.example.restaurante.dto.request.PlatoRequestDTO;
import com.example.restaurante.dto.response.PlatoResponseDTO;
import com.example.restaurante.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platos")
public class PlatoController {

    @Autowired
    private PlatoService platoService;

    // Crear plato (POST)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlatoResponseDTO crearPlato(@RequestBody PlatoRequestDTO dto) {
        return platoService.crearPlato(dto);
    }

    // Listar todos (GET)
    @GetMapping
    public List<PlatoResponseDTO> listarTodos() {
        return platoService.obtenerTodos();
    }

    // Obtener por ID (GET)
    @GetMapping("/{id}")
    public PlatoResponseDTO obtenerPlatoByID(@PathVariable Long id) {
        return platoService.obtenerPorId(id);
    }

    // Actualizar (PUT)
    @PutMapping("/{id}")
    public PlatoResponseDTO actualizarPlato(@PathVariable Long id, @RequestBody PlatoRequestDTO dto) {
        return platoService.actualizarPlato(id, dto);
    }

    // Eliminar (DELETE)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarPlato(@PathVariable Long id) {
        platoService.eliminarPlato(id);
    }
}