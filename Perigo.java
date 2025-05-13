package com.mycompany.projeto2gq;

import java.util.Arrays;

/**
 * Classe base para ameaças digitais no universo Tron.
 */
public abstract class Perigo {
    protected int[] localizacao;
    protected int dano;
    protected String nome;
    protected String descricao;

    public Perigo(int[] localizacao, int dano, String nome, String descricao) {
        this.localizacao = localizacao;
        this.dano = dano;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int[] getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(int[] localizacao) {
        this.localizacao = localizacao;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean estaNaPosicao(int[] posicao) {
        return Arrays.equals(this.localizacao, posicao);
    }

    public void exibirInfo() {
        System.out.println("⚠ Ameaça detectada: " + nome);
        System.out.println("✦ Descrição: " + descricao);
        System.out.println("✦ Dano ao programa: " + dano + "%");
        System.out.println("✦ Localização digital: [" + localizacao[0] + ", " + localizacao[1] + "]");
    }
}
