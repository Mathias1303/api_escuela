package org.cibertec.apiescuela.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DocenteDTO implements Serializable {

    private Integer idDocente;
    private String nombre;
    private String apellido;
    private Double sueldo;
}
