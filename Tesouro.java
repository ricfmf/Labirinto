package com.mycompany.projeto2gq;

/**
 * Representa um artefato digital valioso no sistema Tron.
 */
public abstract class Tesouro {
    private String nome;
    private int valor;
    private int[] localizacao;

    public Tesouro(String nome, int valor, int[] localizacao) {
        this.nome = nome;
        this.valor = valor;
        this.localizacao = localizacao;
    }

    public String getNome() {
        return nome;
    }

    public int getValor() {
        return valor;
    }

    public int[] getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(int[] localizacao) {
        this.localizacao = localizacao;
    }

    /**
     * Executa um efeito especial quando o tesouro é coletado.
     */
    public abstract void efeito();
}
