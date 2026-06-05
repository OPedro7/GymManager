package br.edu.fiec.GymManager.model.entity;

import br.edu.fiec.GymManager.model.dto.AlunoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column
    private String sexo;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Long telefone;

    @Column(nullable = false)
    private Integer dataNascimento;

    @Column(nullable = false)
    private String objetivo;

    public Aluno(String sexo, AlunoDTO alunoDTO) {
        this.nome = alunoDTO.getNome();
        this.sexo = sexo;
        this.email = alunoDTO.getEmail();
        this.telefone = alunoDTO.getTelefone();
        this.dataNascimento = alunoDTO.getDataNascimento();
        this.objetivo = alunoDTO.getObjetivo();
    }
}
