package com.rh_tech.rh_tech.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity

@Table(name = "funcionarios")

@Getter
@Setter

@NoArgsConstructor
public class Funcionarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String senha;

    @Column(nullable = false, length = 8)
    private String cep;

    @Column(nullable = false, length = 50)
    private String endereco;

    @Column(nullable = false)
    private Long numero;

    @Column(nullable = false, length = 50)
    private String bairro;

    @Column(nullable = false, length = 50)
    private String cidade;

    @Column(nullable = false, length = 50)
    private String estado;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FuncionariosPorCargo> funcionarios_por_cargo;
}