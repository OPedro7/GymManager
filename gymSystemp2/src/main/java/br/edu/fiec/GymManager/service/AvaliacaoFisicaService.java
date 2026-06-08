package br.edu.fiec.GymManager.service;

import br.edu.fiec.GymManager.model.dto.AvaliacaoFisicaDTO;
import br.edu.fiec.GymManager.model.entity.AvaliacaoFisica;
import br.edu.fiec.GymManager.repository.AvaliacaoFisicaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class AvaliacaoFisicaService {

    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    public void criarAvaliacao(AvaliacaoFisicaDTO avaliacaoFisicaDTO) { avaliacaoFisicaRepository.save(new AvaliacaoFisica(avaliacaoFisicaDTO)); }

    public List<AvaliacaoFisica> buscarAvaliacoes() { return avaliacaoFisicaRepository.findAll(); }

    public AvaliacaoFisica buscarAvaliacaoPorId(Integer id) {
        return avaliacaoFisicaRepository.findAllById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Avaliação não encontrada"));
    }

    public List<AvaliacaoFisica>

    public AvaliacaoFisica atualizar(Integer id, AvaliacaoFisicaDTO avaliacaoFisicaDTO) {
        AvaliacaoFisica avaliacaoFisica = buscarAvaliacaoPorId(id);
        avaliacaoFisica.setAlunoId(avaliacaoFisica.getAlunoId());
        avaliacaoFisica.setAltura(avaliacaoFisicaDTO.getAltura());
        avaliacaoFisica.setPeso(avaliacaoFisicaDTO.getPeso());
        avaliacaoFisica.setIMC(avaliacaoFisicaDTO.getIMC());
        avaliacaoFisica.setObjetivo(avaliacaoFisica.getObjetivo());
        return AvaliacaoFisicaDTO.save(avaliacaoFisica);
    }
}
