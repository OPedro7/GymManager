package br.edu.fiec.GymManager.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO {

    private String id;

    private String nome;

    private String sexo;

    private String email;

    private Long telefone;

    private Integer dataNascimento;

    private String objetivo;

}
