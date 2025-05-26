package ifsp.pep.vsec.api_inscricoes.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ifsp.pep.vsec.api_inscricoes.model.Aluno;
import ifsp.pep.vsec.api_inscricoes.service.AlunoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @GetMapping(value = "")
    public ResponseEntity<List<Aluno>> listar() {
        return ResponseEntity.ok(alunoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Integer id) {

        try {
            return ResponseEntity.ok(alunoService.buscarPorId(id));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PostMapping("")
    public ResponseEntity<Aluno> cadastrar(@RequestBody Aluno alunoAdd) {
        Aluno aluno = alunoService.salvar(alunoAdd);

        URI enderecoUri = UriComponentsBuilder.fromPath("/aluno/{codigo}")
                .buildAndExpand(aluno.getId_aluno()).toUri();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("location", enderecoUri.toString());

        return new ResponseEntity<>(aluno,
                httpHeaders,
                HttpStatus.CREATED);

    }


    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Integer id, @RequestBody Aluno aluno){

        return ResponseEntity.ok(alunoService.alterar(id, aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id){
        alunoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
