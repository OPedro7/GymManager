package br.edu.fiec.GymManager.model.entity;

import br.edu.fiec.GymManager.model.dto.AvaliacaoFisicaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "AvaliacoesFisica" )
public class AvaliacaoFisica {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private Integer alunoId;

    @Column(nullable = false)
    private double peso;

    @Column(nullable = false)
    private double altura;

    @Column(nullable = false)
    private double IMC;

    @Column(nullable = false)
    private String Objetivo;

    public AvaliacaoFisica(AvaliacaoFisicaDTO avaliacaoFisicaDTO) {
        this.alunoId = avaliacaoFisicaDTO.getAlunoId();
        this.peso = avaliacaoFisicaDTO.getPeso();
        this.altura = avaliacaoFisicaDTO.getAltura();
        this.IMC = avaliacaoFisicaDTO.getIMC();
        this.Objetivo = avaliacaoFisicaDTO.getObjetivo();
    }
}
