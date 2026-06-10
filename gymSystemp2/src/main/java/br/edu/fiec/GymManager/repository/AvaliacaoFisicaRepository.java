package br.edu.fiec.GymManager.repository;

import br.edu.fiec.GymManager.model.dto.AvaliacaoFisicaDTO;
import br.edu.fiec.GymManager.model.entity.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Integer> {

    List<AvaliacaoFisica> findAllByAlunoId(Integer alunoId);

    List<AvaliacaoFisica> findAllByObjetivo(String objetivo);

    List<AvaliacaoFisica> findAllByImc(Double imc);
}