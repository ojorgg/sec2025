package ifsp.pep.vsec.api_inscricoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifsp.pep.vsec.api_inscricoes.dto.InscricaoRequest;
import ifsp.pep.vsec.api_inscricoes.model.Inscricao;
import ifsp.pep.vsec.api_inscricoes.service.InscricaoService;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {


    @Autowired
    private InscricaoService inscricaoService;

    @GetMapping
    public ResponseEntity<List<Inscricao>> listar() {
        return ResponseEntity.ok(inscricaoService.listar());
    }

    @PostMapping
    public ResponseEntity<Inscricao> cadastrar(@RequestBody InscricaoRequest inscricaoAdd) {
        Inscricao inscricao = inscricaoService.adicionar(inscricaoAdd);

//        URI enderecoUri = UriComponentsBuilder.
//                fromPath("/inscricoes/{codigo}").
//                buildAndExpand(curso.getId_curso()).toUri();
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.set("location", enderecoUri.toString());

        return new ResponseEntity<>(inscricao, HttpStatus.CREATED);

    }

    @DeleteMapping
    public ResponseEntity<Void> excluir(@RequestBody InscricaoRequest inscricaoRequest) {
        inscricaoService.excluir(inscricaoRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
