package br.com.mateus.conciliacao;

import br.com.mateus.conciliacao.model.Transacao;

        import java.math.BigDecimal;
        import java.time.LocalDate;

// trasacao teste para verificar se o main está executando corretamente a classe transacao
public class Main {

     public static void main (String[] args){

    Transacao t = new Transacao(LocalDate.of(2026, 10, 25), "99app       *99app",
            new BigDecimal("11.8"), 0, 0, "****xxxx", "Físico", "2026-11",
            "fatura-aberta-final_xxxx-novembro2026.xlsx");
System.out.println(t.getChave());
}
}
