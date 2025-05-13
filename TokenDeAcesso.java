package com.mycompany.projeto2gq;

public class TokenDeAcesso extends Tesouro {

    public TokenDeAcesso(int[] localizacao) {
        super("Token de Acesso", 20, localizacao);
    }

    @Override
    public void efeito() {
        System.out.println("🔓 Um novo setor da grade foi desbloqueado!");
    }
}
