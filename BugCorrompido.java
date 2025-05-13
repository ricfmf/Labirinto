package com.mycompany.projeto2gq;

/**
 * Representa um bug do sistema fora de controle.
 */
public class BugCorrompido extends Perigo {

    public BugCorrompido(int[] localizacao) {
        super(localizacao, 20, "Bug Corrompido", 
            "Fragmento instável de código que causa falhas no sistema.");
    }
}
