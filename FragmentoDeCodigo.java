package com.mycompany.projeto2gq;

public class FragmentoDeCodigo extends Tesouro {

    public FragmentoDeCodigo(int[] localizacao) {
        super("Fragmento de Código", 10, localizacao);
    }

    @Override
    public void efeito() {
        System.out.println("💾 Fragmento incorporado ao sistema.");
    }
}
