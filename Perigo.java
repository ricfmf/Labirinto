/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto2gq;
import java.util.Arrays;

public class Perigo {
    private int[] localizacao;
    private int dano;

    public Perigo(int[] localizacao, int dano) {
        this.localizacao = localizacao;
        this.dano = dano;
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

    public boolean estaNaPosicao(int[] posicao) {
        return Arrays.equals(this.localizacao, posicao);
    }
}
