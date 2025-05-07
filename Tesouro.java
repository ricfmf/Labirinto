package com.mycompany.projeto2gq;

/**
 *
 * @author ricar
 */

public class Tesouro {
    private String nome;
    private int[] localizacao;
    private int valor;

    public Tesouro(String nome, int[] localizacao, int valor) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.valor = valor;
    }

    public String getNome() { 
        return nome; 
    }
    public void setNome(String nome) { 
        this.nome = nome; 
    }

    public int[] getLocalizacao() { 
        return localizacao; 
    }
    public void setLocalizacao(int[] localizacao) { 
        this.localizacao = localizacao; 
    }

    public int getValor() { 
        return valor; 
    }
    public void setValor(int valor) { 
        this.valor = valor; 
    }

    public void efeito() {
        System.out.println("Tesouro coletado! Pontos: " + valor);
    }
}
