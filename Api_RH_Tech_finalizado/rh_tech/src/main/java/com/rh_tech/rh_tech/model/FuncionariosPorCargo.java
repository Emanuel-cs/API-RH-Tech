package com.rh_tech.rh_tech.model;

import jakarta.persistence.*;
import lombok.*;

@Entity

@Table(name = "funcionarios_por_cargo")

@Getter
@Setter

@NoArgsConstructor
public class FuncionariosPorCargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cargo", nullable = false)
    private Cargos cargo;

    @ManyToOne
    @JoinColumn(name = "funcionario", nullable = false)
    private Funcionarios funcionario;

    @Column(name = "detalhes", length = 255)
    private String detalhes;

    @Column(name = "data_inicio", nullable = false, updatable = false)
    private java.time.LocalDate data_inicio;

    @Column(name = "data_fim", updatable = false)
    private java.time.LocalDate data_fim;

    // Método que define a data antes de enviar para o banco de dados
    @PrePersist
    public void prePersist() {
        this.data_inicio = java.time.LocalDate.now();
    }
}
