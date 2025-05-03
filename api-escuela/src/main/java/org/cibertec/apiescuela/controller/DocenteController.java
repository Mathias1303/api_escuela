package org.cibertec.apiescuela.controller;

import org.cibertec.apiescuela.dto.DocenteDTO;
import org.cibertec.apiescuela.service.DocenteService;
import org.cibertec.apiescuela.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("docentes")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class DocenteController {

    @Autowired
    private DocenteService service;

    @PostMapping("/registrar")
    public ResponseEntity<DocenteDTO> registrarDocente(@RequestBody DocenteDTO dto) {
        return ResponseEntity.ok(service.registrarDocente(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocenteDTO> actualizarDocente(@PathVariable Integer id, @RequestBody DocenteDTO dto) {
        return ResponseEntity.ok(service.actualizarDocente(id, dto));
    }

    @GetMapping("/list")
    public ResponseEntity<List<DocenteDTO>> listarDocentes() {
        return ResponseEntity.ok(service.listarDocentes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocenteDTO> buscarDocente(@PathVariable Integer id) {
        DocenteDTO dto = service.buscarDocente(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminarDocente(@PathVariable Integer id) {
        service.eliminarDocente(id);
        return ResponseEntity.noContent().build();
    }
}
