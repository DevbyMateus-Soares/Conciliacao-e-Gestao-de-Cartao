package br.com.mateus.conciliacao.model;

//classes de fora do meu arquivo que serão usadas

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;

public class Transacao {

        private final LocalDate data;
        private final String descricao;
        private final BigDecimal valor;
        private final int parcelaAtual;   // 0 quando a compra é à vista
        private final int totalParcelas;  // 0 quando a compra é à vista
        private final String cartaoFinal;
        private final String tipoCartao;
        private final String referenciaFatura;
        private final String arquivoOrigem;

        public Transacao(LocalDate data, String descricao, BigDecimal valor,
                         int parcelaAtual, int totalParcelas, String cartaoFinal,
                         String tipoCartao, String referenciaFatura, String arquivoOrigem) {
            this.data = data;
            this.descricao = descricao.trim().replaceAll("\\s+", " ");
            this.valor = valor.setScale(2, RoundingMode.HALF_UP);
            this.parcelaAtual = parcelaAtual;
            this.totalParcelas = totalParcelas;
            // aceita "****8186" e guarda só "8186"
            this.cartaoFinal = cartaoFinal.replace("*", "");
            this.tipoCartao = tipoCartao;
            this.referenciaFatura = referenciaFatura;
            this.arquivoOrigem = arquivoOrigem;

        }
        public LocalDate getData() {
            return data;
        }
        public String getDescricao() {
            return descricao;
        }
        public BigDecimal getValor() {
            return valor;
        }
        public int getParcelaAtual() {
            return parcelaAtual;
        }
        public int getTotalParcelas() {
            return totalParcelas;
        }
        public String getCartaoFinal() {
            return cartaoFinal;
        }
        public String getTipoCartao() {
            return tipoCartao;
        }
        public String getReferenciaFatura() {
            return referenciaFatura;
        }
        public String getArquivoOrigem() {
            return arquivoOrigem;
        }
        public String getChave() {
            return data + "|" + descricao + "|" + valor.toPlainString() + "|"
                    + parcelaAtual + "/" + totalParcelas + "|" + cartaoFinal;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Transacao that = (Transacao) o;
            return parcelaAtual == that.parcelaAtual
                    && totalParcelas == that.totalParcelas
                    && Objects.equals(data, that.data)
                    && Objects.equals(descricao, that.descricao)
                    && Objects.equals(valor, that.valor)
                    && Objects.equals(cartaoFinal, that.cartaoFinal);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, descricao, valor, parcelaAtual, totalParcelas, cartaoFinal);
        }

        @Override
        public String toString() {
            return "Transacao{" + data + ", " + descricao + ", R$ " + valor
                    + ", parcela " + parcelaAtual + "/" + totalParcelas
                    + ", cartão final " + cartaoFinal + "}";
        }
    }