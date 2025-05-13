package com.mycompany.projeto2gq;

public class AtualizacaoDeSistema extends Tesouro {

    public AtualizacaoDeSistema(int[] localizacao) {
        super("Atualização de Sistema", 30, localizacao);
    }

    @Override
    public void efeito() {
        System.out.println("📥 Sistema otimizado! Tempo de resposta aprimorado.");
    }
}
