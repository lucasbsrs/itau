package spring.boot.desafio.itau.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import spring.boot.desafio.itau.model.TransacaoRequisicaoDTO;
import spring.boot.desafio.itau.service.TransacaoService;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    
    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<TransacaoRequisicaoDTO> efetuarTransacao(@Valid @RequestBody TransacaoRequisicaoDTO transacaoRequisicao) {
        transacaoService.efetuarTransacao(transacaoRequisicao);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
