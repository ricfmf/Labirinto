package com.mycompany.projeto2gq;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Representa o programa/jogador que navega pela Rede Tron.
 */
public class Aventureiro {
    private String nome;
    private int[] localizacaoAtual;
    private ArrayList<Tesouro> tesourosColetados;
    private int pontos;

    public Aventureiro(String nome, int[] localizacaoInicial) {
        this.nome = nome;
        this.localizacaoAtual = localizacaoInicial;
        this.tesourosColetados = new ArrayList<>();
        this.pontos = 0;
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

    public int getPontos() {
        return pontos;
    }

    public void adicionarPontos(int valor) {
    this.pontos += valor;
}

    /**
     * Move o jogador para uma nova posição da grade digital,
     * e interage com elementos se presentes.
     */
    public void mover(int[] novaPosicao, Labirinto labirinto) throws IllegalArgumentException {
        if (!labirinto.posicaoValida(novaPosicao)) {
            throw new IllegalArgumentException("⚠ Erro: movimentação fora dos limites do sistema.");
        }

        this.localizacaoAtual = novaPosicao;

        Tesouro tesouro = labirinto.getTesouroNaPosicao(novaPosicao);
        if (tesouro != null) {
            coletarTesouro(tesouro, labirinto);
        }

        Perigo perigo = labirinto.getPerigoNaPosicao(novaPosicao);
        if (perigo != null) {
            enfrentarPerigo(perigo, labirinto);
        }
    }

    /**
     * Coleta um recurso digital (tesouro) na grade.
     */
    public void coletarTesouro(Tesouro t, Labirinto labirinto) {
        if (!Arrays.equals(t.getLocalizacao(), localizacaoAtual)) {
            throw new IllegalStateException("⚠ Nenhum fragmento de código na posição atual.");
        }

        tesourosColetados.add(t);
        pontos += t.getValor();
        System.out.println("✔ Fragmento de código \"" + t.getNome() + "\" coletado! +" + t.getValor() + " pontos.");
        t.efeito();
        labirinto.removerTesouro(t);
    }

    /**
     * Enfrenta uma ameaça digital presente na posição atual.
     */
    public void enfrentarPerigo(Perigo p, Labirinto labirinto) {
        System.out.println("\n⛔ ALERTA: Você encontrou " + p.getNome() + "!");
        System.out.println("→ " + p.getDescricao());
        System.out.println("→ Integridade comprometida: -" + p.getDano() + " pontos.");
        pontos = Math.max(0, pontos - p.getDano());
        labirinto.removerPerigo(p);
    }

    /**
     * Exibe os dados do jogador e os fragmentos de código coletados.
     */
    public void mostrarInventario() {
        System.out.println("\n📂 Inventário do programa \"" + nome + "\":");
        System.out.println("💠 Integridade atual (pontos): " + pontos);
        System.out.println("📦 Fragmentos de código coletados:");
        for (Tesouro t : tesourosColetados) {
            System.out.println("  - " + t.getNome() + " [" + t.getValor() + " pts]");
        }
    }
}
