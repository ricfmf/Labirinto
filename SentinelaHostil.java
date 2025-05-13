package com.mycompany.projeto2gq;

/**
 * Representa uma sentinela hostil que patrulha a grade digital.
 */
public class SentinelaHostil extends Perigo {

    public SentinelaHostil(int[] localizacao) {
        super(localizacao, 35, "Sentinela Hostil",
            "Programa de segurança desviado que ataca usuários não autorizados.");
    }
}
