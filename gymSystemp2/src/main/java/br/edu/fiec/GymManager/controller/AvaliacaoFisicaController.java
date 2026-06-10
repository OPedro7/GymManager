package br.edu.fiec.GymManager.controller;

import br.edu.fiec.GymManager.model.dto.AvaliacaoFisicaDTO;
import br.edu.fiec.GymManager.model.entity.AvaliacaoFisica;
import br.edu.fiec.GymManager.service.AvaliacaoFisicaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping("/AvaliacaoFisica")
public class AvaliacaoFisicaController {

    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/criarAvaliacaoFisica", consumes = APPLICATION_JSON_VALUE)
    public void criarAvaliacao(@RequestBody AvaliacaoFisicaDTO avaliacaoFisicaDTO) {
        avaliacaoFisicaService.criarAvaliacao(avaliacaoFisicaDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<AvaliacaoFisica> buscarAvaliacoes() {
        return avaliacaoFisicaService.buscarAvaliacoes();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/aluno")
    public List<AvaliacaoFisica> buscarPorAlunoId(@RequestParam Integer alunoId) {
        return avaliacaoFisicaService.buscarPorAlunoId(alunoId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/objetivo")
    public List<AvaliacaoFisica> buscarPorObjetivo(@RequestParam String objetivo) {
        return avaliacaoFisicaService.buscarAvaliacaoObjetivo(objetivo);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/imc")
    public List<AvaliacaoFisica> buscarPorImc(@RequestParam Double imc) {
        return avaliacaoFisicaService.buscarPorImc(imc);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void apagar(@PathVariable Integer id) {
        avaliacaoFisicaService.apagar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public AvaliacaoFisica atualizar(@PathVariable Integer id,
                                     @RequestBody AvaliacaoFisicaDTO avaliacaoFisicaDTO) {
        return avaliacaoFisicaService.atualizar(id, avaliacaoFisicaDTO);
    }
}