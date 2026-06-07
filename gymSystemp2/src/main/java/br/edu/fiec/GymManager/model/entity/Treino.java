package br.edu.fiec.GymManager.model.entity;

import br.edu.fiec.GymManager.model.dto.TreinoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "treinos")
public class Treino {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String grupoMuscular;

    @Column(nullable = false)
    private String dificuldade;

    @Column(nullable = false)
    private Integer duracaoMinutos;

    public Treino(TreinoDTO treinoDTO) {
        this.nome = treinoDTO.getNome();
        this.grupoMuscular = treinoDTO.getGrupoMuscular();
        this.dificuldade = treinoDTO.getDificuldade();
        this.duracaoMinutos = treinoDTO.getDuracaoMinutos();
    }
}
