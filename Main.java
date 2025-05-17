package com.mycompany.projeto2gq;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Representa a grade digital da Rede Tron, onde o jogador navega.
 */
public class Labirinto {
    private ArrayList<ArrayList<String>> estrutura;
    private ArrayList<Tesouro> tesouros;
    private ArrayList<Perigo> perigos;

    public Labirinto() {
        this.estrutura = new ArrayList<>();
        this.tesouros = new ArrayList<>();
        this.perigos = new ArrayList<>();
    }

    // Gera a grade com espaços vazios representados por '░'
    public void gerarLabirinto(int linhas, int colunas) {
        estrutura.clear();
        for (int i = 0; i < linhas; i++) {
            ArrayList<String> linha = new ArrayList<>();
            for (int j = 0; j < colunas; j++) {
                linha.add("░"); // Espaço livre no sistema Tron
            }
            estrutura.add(linha);
        }
    }

    public boolean posicaoValida(int[] posicao) {
        int linha = posicao[0];
        int coluna = posicao[1];
        return linha >= 0 && linha < estrutura.size()
            && coluna >= 0 && coluna < estrutura.get(0).size();
    }

    public Tesouro getTesouroNaPosicao(int[] posicao) {
        for (Tesouro t : tesouros) {
            if (Arrays.equals(t.getLocalizacao(), posicao)) {
                return t;
            }
        }
        return null;
    }

    public Perigo getPerigoNaPosicao(int[] posicao) {
        for (Perigo p : perigos) {
            if (Arrays.equals(p.getLocalizacao(), posicao)) {
                return p;
            }
        }
        return null;
    }

    // Exibe a grade do sistema com ícones temáticos
    public void exibirLabirinto() {
        for (int i = 0; i < estrutura.size(); i++) {
            for (int j = 0; j < estrutura.get(i).size(); j++) {
                int[] pos = {i, j};
                if (getTesouroNaPosicao(pos) != null) {
                    System.out.print("⚡ "); // Tesouro: Fragmento de código
                } else {
                    Perigo perigo = getPerigoNaPosicao(pos);
                    if (perigo != null) {
                        if (perigo instanceof BugCorrompido) {
                            System.out.print("☣ "); // Bug Corrompido
                        } else if (perigo instanceof SentinelaHostil) {
                            System.out.print("⛨ "); // Sentinela
                        } else {
                            System.out.print("☠ "); // Outro tipo genérico
                        }
                    } else {
                        System.out.print(estrutura.get(i).get(j) + " ");
                    }
                }
            }
            System.out.println();
        }
    }

    public void adicionarTesouro(Tesouro t) {
        tesouros.add(t);
    }

    public void removerTesouro(Tesouro t) {
        tesouros.remove(t);
    }

    public void adicionarPerigo(Perigo p) {
        perigos.add(p);
    }

    public void removerPerigo(Perigo p) {
        perigos.remove(p);
    }

    public ArrayList<ArrayList<String>> getEstrutura() {
        return estrutura;
    }

    public ArrayList<Tesouro> getTesouros() {
        return tesouros;
    }

    public ArrayList<Perigo> getPerigos() {
        return perigos;
    }
}
