package br.edu.fiec.GymManager.repository;

import br.edu.fiec.GymManager.model.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    List<Aluno> findAllByNome(String nome);

    List<Aluno> findAllBySexo(String sexo);
}
