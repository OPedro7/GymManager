package br.edu.fiec.GymManager.service;

import br.edu.fiec.GymManager.model.dto.AlunoDTO;
import br.edu.fiec.GymManager.model.entity.Aluno;
import br.edu.fiec.GymManager.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AlunosService {

    private final AlunoRepository alunoRepository;

    public void criarAlunoMasculino(AlunoDTO alunoDTO) {
        alunoRepository.save(new Aluno("Masculino", alunoDTO));
    }

    public void criarAlunoFeminino(AlunoDTO alunoDTO) {
        alunoRepository.save(new Aluno("Feminino", alunoDTO));
    }

    public List<Aluno> buscarTodos() {
        return alunoRepository.findAll();
    }

    public List<Aluno> buscarTodosAlunosMasculinos() {
        return alunoRepository.findAllBySexo("Masculino");
    }

    public List<Aluno> buscarTodosAlunosFemininos() {
        return alunoRepository.findAllBySexo("Feminino");
    }

    public Aluno buscarAlunoPorId(Integer id) {
        return alunoRepository.findById(id).get();
    }

    public List<Aluno> buscarTodosAlunosPorNome(String nome) {
        return alunoRepository.findAllByNome(nome);
    }

    public void apagar(Integer id) {
        alunoRepository.deleteById(id);
    }

    public Aluno atualizar(Integer id, AlunoDTO alunoDTO) {
        Aluno aluno = buscarAlunoPorId(id);
        aluno.setNome(alunoDTO.getNome());
        if (alunoDTO.getSexo() != null) {
            aluno.setSexo(alunoDTO.getSexo());
        }
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setTelefone(alunoDTO.getTelefone());
        aluno.setDataNascimento(alunoDTO.getDataNascimento());
        aluno.setObjetivo(alunoDTO.getObjetivo());
        return alunoRepository.save(aluno);
    }
}
