package br.edu.fiec.GymManager.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO {

    private Integer id;

    private String nome;

    private String sexo;

    private String email;

    private Long telefone;

    private String dataNascimento;

    private String objetivo;

}
