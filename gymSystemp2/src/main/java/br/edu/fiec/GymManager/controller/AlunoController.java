package br.edu.fiec.GymManager.controller;

import br.edu.fiec.GymManager.model.dto.AlunoDTO;
import br.edu.fiec.GymManager.model.entity.Aluno;
import br.edu.fiec.GymManager.service.AlunosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping("/Aluno")
public class AlunoController {

    private final AlunosService alunosService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/AlunoMasculino", consumes = APPLICATION_JSON_VALUE)
    public void criarAlunoMasculino(@RequestBody AlunoDTO alunoDTO) {
        alunosService.criarAlunoMasculino(alunoDTO);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/AlunoFeminino", consumes = APPLICATION_JSON_VALUE)
    public void criarAlunoFeminino(@RequestBody AlunoDTO alunoDTO) {
        alunosService.criarAlunoFeminino(alunoDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Aluno> buscarTodos() {
        return alunosService.buscarTodos();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/AlunoMasculino", produces = APPLICATION_JSON_VALUE)
    public List<Aluno> buscarTodosAlunosMasculinos() {
        return alunosService.buscarTodosAlunosMasculinos();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/AlunoFeminino", produces = APPLICATION_JSON_VALUE)
    public List<Aluno> buscarTodosAlunosFemininos() {
        return alunosService.buscarTodosAlunosFemininos();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Aluno buscarAlunoPorId(@PathVariable Integer id) {
        return alunosService.buscarAlunoPorId(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/nome", produces = APPLICATION_JSON_VALUE)
    public List<Aluno> buscarTodosAlunosPorNome(@RequestParam String nome) {
        return alunosService.buscarTodosAlunosPorNome(nome);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void apagar(@PathVariable Integer id) {
        alunosService.apagar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Aluno atualizar(@PathVariable Integer id, @RequestBody AlunoDTO alunoDTO) {
        return alunosService.atualizar(id, alunoDTO);
    }
}
