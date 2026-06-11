package br.edu.fiec.GymManager.service;

import br.edu.fiec.GymManager.model.dto.TreinoDTO;
import br.edu.fiec.GymManager.model.entity.Treino;
import br.edu.fiec.GymManager.repository.TreinoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TreinoService {

    private final TreinoRepository treinoRepository;

    public void criarTreino(TreinoDTO treinoDTO) {
        treinoRepository.save(new Treino(treinoDTO));
    }

    public List<Treino> buscarTreinos() { return treinoRepository.findAll(); }

    public Treino buscarTreinoPorId(Integer id) { return treinoRepository.findById(id).get(); }

    public List<Treino> buscarTreinoGrupoMuscular(String grupoMuscular) { return treinoRepository.findAllByGrupoMuscular(grupoMuscular); }

    public List<Treino> buscarTreinoDificuldade(String dificuldade) { return treinoRepository.findAllByDificuldade(dificuldade); }

    public List<Treino> buscarTreinoDuracao(Integer duracaoMinutos) { return treinoRepository.findAllByDuracaoMinutos(duracaoMinutos); }

    public void apagar (Integer id) { treinoRepository.deleteById(id); }

    public Treino atualizar(Integer id, TreinoDTO treinoDTO) {
        Treino treino = buscarTreinoPorId(id);
        treino.setNome(treinoDTO.getNome());
        treino.setDificuldade(treinoDTO.getDificuldade());
        treino.setGrupoMuscular(treinoDTO.getGrupoMuscular());
        treino.setDuracaoMinutos(treinoDTO.getDuracaoMinutos());
        return treinoRepository.save(treino);
    }
}
