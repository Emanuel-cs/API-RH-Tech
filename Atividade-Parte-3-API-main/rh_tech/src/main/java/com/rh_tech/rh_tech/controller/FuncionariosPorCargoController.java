package com.rh_tech.rh_tech.controller;

import org.springframework.web.bind.annotation.*;

import com.rh_tech.rh_tech.model.FuncionariosPorCargo;
import com.rh_tech.rh_tech.service.FuncionariosPorCargoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/funcionarios-por-cargo")
@CrossOrigin(origins = "*")
public class FuncionariosPorCargoController {

    @Autowired
    private FuncionariosPorCargoService funcionariosPorCargoService;

    @GetMapping
    public List<FuncionariosPorCargo> listarFuncionariosPorCargo() {
        return funcionariosPorCargoService.listarFuncionariosPorCargo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionariosPorCargo> getFuncionarioPorCargoById(@PathVariable Long id) {
        return funcionariosPorCargoService.getFuncionarioPorCargoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("?cargoId={cargo_id}")
    public List<FuncionariosPorCargo> getFuncionariosPorCargoByCargoId(@PathVariable Long cargo_id) {
        return funcionariosPorCargoService.listarFuncionariosPorCargo().stream()
                .filter(funcionario -> funcionario.getCargo().equals(cargo_id))
                .toList();
    }

    @GetMapping("?funcionarioId={funcionario_id}")
    public List<FuncionariosPorCargo> getFuncionariosPorCargoByFuncionarioId(@PathVariable Long funcionario_id) {
        return funcionariosPorCargoService.listarFuncionariosPorCargo().stream()
                .filter(funcionario -> funcionario.getFuncionario().equals(funcionario_id))
                .toList();
    }

    @PostMapping
    public FuncionariosPorCargo salvarFuncionarioPorCargo(@RequestBody FuncionariosPorCargo funcionarioPorCargo) {
        return funcionariosPorCargoService.salvarFuncionarioPorCargo(funcionarioPorCargo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionariosPorCargo> atualizar(@PathVariable Long id, @RequestBody FuncionariosPorCargo funcionarioPorCargo) {
        if (!funcionariosPorCargoService.getFuncionarioPorCargoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        funcionarioPorCargo.setId(id);
        return ResponseEntity.ok(funcionariosPorCargoService.salvarFuncionarioPorCargo(funcionarioPorCargo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!funcionariosPorCargoService.getFuncionarioPorCargoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        funcionariosPorCargoService.deletarFuncionarioPorCargo(id);
        return ResponseEntity.noContent().build();
    }
}
