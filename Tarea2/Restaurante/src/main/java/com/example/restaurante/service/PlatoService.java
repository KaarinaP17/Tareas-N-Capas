package com.example.restaurante.service;

import com.example.restaurante.domain.entity.Plato;
import com.example.restaurante.dto.request.PlatoRequestDTO;
import com.example.restaurante.dto.response.PlatoResponseDTO;
import com.example.restaurante.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class PlatoService {

    @Autowired
    private PlatoRepository platoRepository;

    // Crear un nuevo plato
    public PlatoResponseDTO crearPlato(PlatoRequestDTO dto) {
        Plato plato = new Plato();
        plato.setNombre(dto.getNombre());
        plato.setDescripcion(dto.getDescripcion());

        Plato guardado = platoRepository.save(plato);
        return convertirADTO(guardado);
    }

    // Obtener todos los platos
    public List<PlatoResponseDTO> obtenerTodos() {
        return platoRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    // Obtener un plato por ID
    public PlatoResponseDTO obtenerPorId(Long id) {
        Plato plato = platoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plato no encontrado con ID: " + id));
        return convertirADTO(plato);
    }

    // Actualizar un plato existente
    public PlatoResponseDTO actualizarPlato(Long id, PlatoRequestDTO dto) {
        Plato plato = platoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plato no encontrado con ID: " + id));

        plato.setNombre(dto.getNombre());
        plato.setDescripcion(dto.getDescripcion());

        return convertirADTO(platoRepository.save(plato));
    }

    // Eliminar un plato
    public void eliminarPlato(Long id) {
        if (!platoRepository.existsById(id)) {
            throw new RuntimeException("Plato no encontrado con ID: " + id);
        }
        platoRepository.deleteById(id);
    }

    private PlatoResponseDTO convertirADTO(Plato plato) {
        PlatoResponseDTO dto = new PlatoResponseDTO();
        dto.setId(plato.getId());
        dto.setNombre(plato.getNombre());
        dto.setDescripcion(plato.getDescripcion());
        return dto;
    }
}