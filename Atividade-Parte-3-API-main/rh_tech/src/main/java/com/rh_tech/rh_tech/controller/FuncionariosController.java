package com.rh_tech.rh_tech.controller;

import org.springframework.web.bind.annotation.*;

import com.rh_tech.rh_tech.model.Funcionarios;
import com.rh_tech.rh_tech.service.FuncionariosService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/funcionarios")
@CrossOrigin(origins = "*")
public class FuncionariosController {

    @Autowired
    private FuncionariosService funcionariosService;

    @GetMapping
    public List<Funcionarios> listarFuncionarios() {
        return funcionariosService.listarFuncionarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionarios> getFuncionarioById(@PathVariable Long id){
        return funcionariosService.getFuncionarioById(id)
               .map(ResponseEntity :: ok)
               .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Funcionarios salvarFuncionario(@RequestBody Funcionarios funcionarios){
        return funcionariosService.salvarFuncionario(funcionarios);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Funcionarios> atualizar(@PathVariable Long id, @RequestBody Funcionarios funcionarios){
       
        if(!funcionariosService.getFuncionarioById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        funcionarios.setId(id);

        return ResponseEntity.ok(funcionariosService.salvarFuncionario((funcionarios)));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Funcionarios> deletar(@PathVariable Long id){

        if(!funcionariosService.getFuncionarioById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }

        funcionariosService.deletarFuncionario(id);
        
        return ResponseEntity.noContent().build();
    }
}
