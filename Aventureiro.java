package com.mycompany.projeto2gq;
import java.util.ArrayList;

/**
 *
 * @author ricar
 */

public class Aventureiro {
    private String nome;
    private int[] localizacaoAtual;
    private ArrayList<Tesouro> tesourosColetados;

    public Aventureiro(String nome, int[] localizacaoInicial) {
        this.nome = nome;
        this.localizacaoAtual = localizacaoInicial;
        this.tesourosColetados = new ArrayList<>();
    }

    public String getNome() { 
        return nome; 
    }
    public void setNome(String nome) { 
        this.nome = nome; 
    }

    public int[] getLocalizacaoAtual() { 
        return localizacaoAtual; 
    }
    public void setLocalizacaoAtual(int[] localizacaoAtual) { 
        this.localizacaoAtual = localizacaoAtual; 
    }

    public ArrayList<Tesouro> getTesourosColetados() { 
        return tesourosColetados; 
    }

    public void mover(int[] novaPosicao) {
        this.localizacaoAtual = novaPosicao;
    }

    public void coletarTesouro(Tesouro t) {
        this.tesourosColetados.add(t);
    }
}
