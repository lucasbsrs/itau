package spring.boot.desafio.itau.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


public class TransacaoRequisicaoDTO {

    private BigDecimal valor;

    private OffsetDateTime dataHora;

    public TransacaoRequisicaoDTO(BigDecimal valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public OffsetDateTime getDataHora() {
        return this.dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }

}