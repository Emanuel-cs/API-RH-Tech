package com.rh_tech.rh_tech.service;

import java.util.*;

import com.rh_tech.rh_tech.model.FuncionariosPorCargo;
import com.rh_tech.rh_tech.repository.FuncionariosPorCargoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionariosPorCargoService {
    @Autowired
    private FuncionariosPorCargoRepository funcionariosPorCargoRepository;

    public List<FuncionariosPorCargo> listarFuncionariosPorCargo() {
        return funcionariosPorCargoRepository.findAll();
    }

    public Optional<FuncionariosPorCargo> getFuncionarioPorCargoById(Long id) {
        return funcionariosPorCargoRepository.findById(id);
    }

    public FuncionariosPorCargo salvarFuncionarioPorCargo(FuncionariosPorCargo funcionarioPorCargo) {
        return funcionariosPorCargoRepository.save(funcionarioPorCargo);
    }

    public void deletarFuncionarioPorCargo(Long id) {
        funcionariosPorCargoRepository.deleteById(id);
    }
}
