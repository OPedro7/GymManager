package br.edu.fiec.GymManager.repository;

import br.edu.fiec.GymManager.model.entity.Treino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreinoRepository extends JpaRepository<Treino, Integer> {

    List<Treino> findAllByGrupoMuscular(String grupoMuscular);

    List<Treino> findAllByDificuldade(String dificuldade);

    List<Treino> findAllByDuracaoMinutos(Integer duracaoMinutos);
}
