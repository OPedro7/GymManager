package br.edu.fiec.GymManager.controller;

import br.edu.fiec.GymManager.model.dto.TreinoDTO;
import br.edu.fiec.GymManager.model.entity.Treino;
import br.edu.fiec.GymManager.service.TreinoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping("/Treino")
public class TreinoController {

    private final TreinoService treinoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/criarTreino", consumes = APPLICATION_JSON_VALUE)
    public void criarTreino(@RequestBody TreinoDTO treinoDTO) { treinoService.criarTreino(treinoDTO); }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Treino> buscarTreinos() { return treinoService.buscarTreinos(); }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{/id}", produces = APPLICATION_JSON_VALUE)
    public Treino buscarTreinosId(@PathVariable Integer id) {
        return treinoService.buscarTreinoPorId(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/grupo", produces = APPLICATION_JSON_VALUE)
    public List<Treino> buscarTreinoGrupoMuscular(@RequestParam String grupoMuscular) {
        return treinoService.buscarTreinoGrupoMuscular(grupoMuscular);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/dificuldade", produces = APPLICATION_JSON_VALUE)
    public List<Treino> buscarTreinoDificuldade(@RequestParam String dificuldade) {
        return treinoService.buscarTreinoDificuldade(dificuldade);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/duracao", produces = APPLICATION_JSON_VALUE)
    public List<Treino> buscarTreinoDuracao(@RequestParam Integer duracaoMinutos) {
        return treinoService.buscarTreinoDuracao(duracaoMinutos);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{/id}")
    public void apagar(@PathVariable Integer id) { treinoService.apagar(id); }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Treino atualizar(@PathVariable Integer id, @RequestBody TreinoDTO treinoDTO) {
        return treinoService.atualizar(id, treinoDTO);
    }
}
