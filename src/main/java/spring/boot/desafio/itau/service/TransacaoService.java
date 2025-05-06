package spring.boot.desafio.itau.service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import spring.boot.desafio.itau.exception.ValidacaoException;
import spring.boot.desafio.itau.model.TransacaoRequisicaoDTO;

@Service
public class TransacaoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransacaoService.class);

    private List<BigDecimal> listaTransacoes = new ArrayList<>();
    private DoubleSummaryStatistics estatisticas;

    public TransacaoService() {
    }

    public void efetuarTransacao(TransacaoRequisicaoDTO transacaoRequisicao) {
        LOGGER.info("Iniciando processamento da transação...");

        if(Objects.isNull(transacaoRequisicao.getValor())) {
            throw new ValidacaoException("Campo valor é obrigatório");
        }

        if(Objects.isNull(transacaoRequisicao.getDataHora())) {
            throw new ValidacaoException("Campo dataHora é obrigatório");
        }

        if(transacaoRequisicao.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new ValidacaoException("Campo dataHora não pode ser uma data futura");
        }

        if(transacaoRequisicao.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidacaoException("Campo valor deve ser maior que zero");
        }

        listaTransacoes.add(transacaoRequisicao.getValor());

        estatisticas = listaTransacoes.stream()
                .mapToDouble(BigDecimal::doubleValue)
                .summaryStatistics();

        LOGGER.info("Transação efetivada com sucesso");
    }

}