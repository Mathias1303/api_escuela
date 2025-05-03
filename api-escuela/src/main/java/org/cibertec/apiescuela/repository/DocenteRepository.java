package org.cibertec.apiescuela.repository;

import org.cibertec.apiescuela.entity.DocenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocenteRepository extends JpaRepository<DocenteEntity, Integer> {
}
