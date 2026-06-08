package br.edu.fiec.GymManager.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaDTO {

    private Integer id;

    private Integer alunoId;

    private double peso;

    private double altura;

    private double IMC;

    private String Objetivo;
}
