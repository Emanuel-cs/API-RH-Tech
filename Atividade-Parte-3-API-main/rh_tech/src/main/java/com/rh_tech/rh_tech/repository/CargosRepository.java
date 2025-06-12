package com.rh_tech.rh_tech.repository;

import com.rh_tech.rh_tech.model.Cargos;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface CargosRepository extends JpaRepository<Cargos, Long> {
}
