package br.edu.fiec.GymManager.service;

import br.edu.fiec.GymManager.model.dto.AvaliacaoFisicaDTO;
import br.edu.fiec.GymManager.model.entity.AvaliacaoFisica;
import br.edu.fiec.GymManager.repository.AvaliacaoFisicaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AvaliacaoFisicaService {

    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    public void criarAvaliacao(AvaliacaoFisicaDTO avaliacaoFisicaDTO) {
        double imc = calcularImc(avaliacaoFisicaDTO.getPeso(), avaliacaoFisicaDTO.getAltura());
        avaliacaoFisicaDTO.setIMC(imc);
        avaliacaoFisicaRepository.save(new AvaliacaoFisica(avaliacaoFisicaDTO));
    }

    private double calcularImc(double peso, double altura) { return peso / (altura * altura); }

    public List<AvaliacaoFisica> buscarAvaliacoes() { return avaliacaoFisicaRepository.findAll(); }

    public AvaliacaoFisica buscarAvaliacaoPorId(Integer id) { return avaliacaoFisicaRepository.findById(id).get(); }

    public List<AvaliacaoFisica> buscarPorAlunoId(Integer alunoId) { return avaliacaoFisicaRepository.findAllByAlunoId(alunoId); }

    public List<AvaliacaoFisica> buscarAvaliacaoObjetivo(String objetivo) { return avaliacaoFisicaRepository.findAllByObjetivo(objetivo); }

    public List<AvaliacaoFisica> buscarPorImc(Double imc) { return avaliacaoFisicaRepository.findAllByImc(imc); }

    public void apagar(Integer id) { avaliacaoFisicaRepository.deleteById(id); }

    public AvaliacaoFisica atualizar(Integer id, AvaliacaoFisicaDTO avaliacaoFisicaDTO) {
        AvaliacaoFisica avaliacaoFisica = buscarAvaliacaoPorId(id);
        avaliacaoFisica.setAlunoId(avaliacaoFisicaDTO.getAlunoId());
        avaliacaoFisica.setPeso(avaliacaoFisicaDTO.getPeso());
        avaliacaoFisica.setAltura(avaliacaoFisicaDTO.getAltura());
        avaliacaoFisica.setObjetivo(avaliacaoFisicaDTO.getObjetivo());
        avaliacaoFisica.setImc(calcularImc(avaliacaoFisicaDTO.getPeso(), avaliacaoFisicaDTO.getAltura()));
        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }
}
