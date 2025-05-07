/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto2gq;

/**
 *
 * @author ricar
 */
public class Projeto2GQ {
    public static void main(String[] args) {
        Labirinto labirinto = new Labirinto();
        labirinto.gerarLabirinto(5, 5);

        int[] posInicial = {0, 0};
        Aventureiro aventureiro = new Aventureiro("Indiana Jones", posInicial);

        Tesouro tesouro1 = new TesouroOuro("Baú de Ouro", new int[]{2, 1}, 15);
        Tesouro tesouro2 = new TesouroGema("Diamante Azul", new int[]{3, 3}, 10);

        labirinto.adicionarTesouro(tesouro1);
        labirinto.adicionarTesouro(tesouro2);

        Perigo perigo1 = new Perigo(new int[]{1, 0}, 5);
        Perigo perigo2 = new Perigo(new int[]{4, 4}, 8);

        labirinto.adicionarPerigo(perigo1);
        labirinto.adicionarPerigo(perigo2);

        System.out.println("=== Labirinto Gerado ===");
        labirinto.exibirLabirinto();

        try {
            System.out.println("\nMovendo para (1,0) - Deve encontrar perigo:");
            aventureiro.mover(new int[]{1, 0}, labirinto);

            System.out.println("\nMovendo para (2,1) - Deve coletar tesouro:");
            aventureiro.mover(new int[]{2, 1}, labirinto);

            System.out.println("\nMovendo para (3,3) - Deve coletar gema:");
            aventureiro.mover(new int[]{3, 3}, labirinto);

            System.out.println("\nMovendo para (4,4) - Deve encontrar outro perigo:");
            aventureiro.mover(new int[]{4, 4}, labirinto);

        } catch (Exception e) {
            System.out.println("Erro durante o movimento: " + e.getMessage());
        }

        aventureiro.mostrarInventario();
    }
}
