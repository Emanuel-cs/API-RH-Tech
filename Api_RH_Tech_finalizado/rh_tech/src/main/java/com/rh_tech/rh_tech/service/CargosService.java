package com.rh_tech.rh_tech.service;

import java.util.*;

import com.rh_tech.rh_tech.model.Cargos;
import com.rh_tech.rh_tech.repository.CargosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargosService {
    @Autowired
    private CargosRepository cargosRepository;

    public List<Cargos> listarCargos() {
        return cargosRepository.findAll();
    }

    public Optional<Cargos> getCargosById(Long id) {
        return cargosRepository.findById(id);
    }

    public Cargos salvarCargo(Cargos cargos) {
        return cargosRepository.save(cargos);
    }

    public void deletarCargo(Long id) {
        cargosRepository.deleteById(id);
    }
}
