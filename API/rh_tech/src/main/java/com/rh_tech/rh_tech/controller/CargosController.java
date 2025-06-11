package com.rh_tech.rh_tech.controller;

import org.springframework.web.bind.annotation.*;

import com.rh_tech.rh_tech.model.Cargos;
import com.rh_tech.rh_tech.service.CargosService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/cargos")
@CrossOrigin(origins = "*")
public class CargosController {

    @Autowired
    private CargosService cargosService;

    @GetMapping
    public List<Cargos> listarCargos() {
        return cargosService.listarCargos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargos> getCargosById(@PathVariable Long id){
        return cargosService.getCargosById(id)
               .map(ResponseEntity :: ok)
               .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cargos salvarCargo(@RequestBody Cargos cargos){
        return cargosService.salvarCargo(cargos);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Cargos> atualizar(@PathVariable Long id, @RequestBody Cargos cargos){
       
        if(!cargosService.getCargosById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        cargos.setId(id);

        return ResponseEntity.ok(cargosService.salvarCargo((cargos)));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Cargos> deletar(@PathVariable Long id){

        if(!cargosService.getCargosById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }

        cargosService.deletarCargo(id);
        
        return ResponseEntity.noContent().build();
    }
}
