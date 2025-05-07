/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto2gq;

/**
 *
 * @author ricar
 */

import java.util.Arrays;

public abstract class Tesouro {
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

    public boolean estaNaPosicao(int[] posicao) {
        return Arrays.equals(this.localizacao, posicao);
    }

    public abstract void efeito();
}

class TesouroOuro extends Tesouro {
    public TesouroOuro(String nome, int[] localizacao, int valor) {
        super(nome, localizacao, valor);
    }

    @Override
    public void efeito() {
        System.out.println("Ouro coletado! +" + getValor() + " pontos");
    }
}

class TesouroGema extends Tesouro {
    public TesouroGema(String nome, int[] localizacao, int valorBase) {
        super(nome, localizacao, valorBase * 2); // Gema vale o dobro
    }

    @Override
    public void efeito() {
        System.out.println("Gema preciosa coletada! +" + getValor() + " pontos");
    }
}
