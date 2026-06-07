package br.edu.fiec.GymManager.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreinoDTO {

    private Integer id;

    private String nome;

    private String grupoMuscular;

    private String dificuldade;

    private Integer duracaoMinutos;
}
