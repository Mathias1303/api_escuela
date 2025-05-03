package org.cibertec.apiescuela.service;

import org.cibertec.apiescuela.dto.DocenteDTO;
import org.cibertec.apiescuela.entity.DocenteEntity;
import org.cibertec.apiescuela.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    private DocenteDTO convertToDTO(DocenteEntity entity) {
        DocenteDTO dto = new DocenteDTO();
        dto.setIdDocente(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setApellido(entity.getApellido());
        dto.setSueldo(entity.getSueldo());
        return dto;
    }

    private DocenteEntity convertToEntity(DocenteDTO dto) {
        DocenteEntity entity = new DocenteEntity();
        entity.setId(dto.getIdDocente());
        entity.setNombre(dto.getNombre());
        entity.setApellido(dto.getApellido());
        entity.setSueldo(dto.getSueldo());
        return entity;
    }

    public DocenteDTO registrarDocente(DocenteDTO dto) {
        DocenteEntity entity = convertToEntity(dto);
        entity = docenteRepository.save(entity);
        return convertToDTO(entity);
    }

    public DocenteDTO actualizarDocente(Integer id, DocenteDTO dto) {
        Optional<DocenteEntity> optionalEntity = docenteRepository.findById(id);
        if (optionalEntity.isPresent()) {
            DocenteEntity entity = optionalEntity.get();
            entity.setNombre(dto.getNombre());
            entity.setApellido(dto.getApellido());
            entity.setSueldo(dto.getSueldo());
            entity = docenteRepository.save(entity);
            return convertToDTO(entity);
        } else {
            return null;
        }
    }

    public List<DocenteDTO> listarDocentes() {
        return docenteRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public DocenteDTO buscarDocente(Integer id) {
        Optional<DocenteEntity> optionalEntity = docenteRepository.findById(id);
        return optionalEntity.map(this::convertToDTO).orElse(null); // o lanzar una excepción
    }

    public void eliminarDocente(Integer id) {
        docenteRepository.deleteById(id);
    }
}
