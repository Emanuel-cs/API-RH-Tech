package com.rh_tech.rh_tech.service;

import java.util.*;

import com.rh_tech.rh_tech.model.Funcionarios;
import com.rh_tech.rh_tech.repository.FuncionariosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionariosService {
    @Autowired
    private FuncionariosRepository funcionariosRepository;

    public List<Funcionarios> listarFuncionarios() {
        return funcionariosRepository.findAll();
    }

    public Optional<Funcionarios> getFuncionarioById(Long id) {
        return funcionariosRepository.findById(id);
    }

    public Funcionarios salvarFuncionario(Funcionarios funcionario) {
        return funcionariosRepository.save(funcionario);
    }

    public void deletarFuncionario(Long id) {
        funcionariosRepository.deleteById(id);
    }
}
