package com.rh_tech.rh_tech.repository;

import com.rh_tech.rh_tech.model.FuncionariosPorCargo;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface FuncionariosPorCargoRepository extends JpaRepository<FuncionariosPorCargo, Long> {
}
