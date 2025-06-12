package com.rh_tech.rh_tech.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity

@Table(name = "cargos")

@Getter
@Setter

@NoArgsConstructor
public class Cargos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;

    @OneToMany(mappedBy = "cargo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FuncionariosPorCargo> funcionarios_por_cargo;
}
