package ifsp.pep.vsec.api_inscricoes.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ifsp.pep.vsec.api_inscricoes.model.Curso;
import ifsp.pep.vsec.api_inscricoes.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController  {

    @Autowired
    CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> listar() {
        return ResponseEntity.ok(cursoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(cursoService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Curso> cadastrar(@RequestBody Curso cursoAdd) {
        Curso curso = cursoService.salvar(cursoAdd);

        URI enderecoUri = UriComponentsBuilder.
                fromPath("/curso/{codigo}").
                buildAndExpand(curso.getId_curso()).toUri();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("lsocation", enderecoUri.toString());

        return new ResponseEntity<>(curso,
                httpHeaders,
                HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizar(@PathVariable Integer id, @RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.alterar(id, curso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        cursoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}