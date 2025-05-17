/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto2gq;
import java.util.Scanner;
/**
 *
 * @author ricar
 */
public class Projeto2GQ{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("🌀 Bem-vindo ao SISTEMA TRON!");
        System.out.println("🔷 Iniciando simulação da Grade Digital...\n");
        
        // Criar o labirinto 6x6
        Labirinto labirinto = new Labirinto();
        labirinto.gerarLabirinto(6, 6);
        
        // Adicionar tesouros
        labirinto.adicionarTesouro(new TokenDeAcesso(new int[]{1, 2}));
        labirinto.adicionarTesouro(new AtualizacaoDeSistema(new int[]{3, 3}));
        labirinto.adicionarTesouro(new FragmentoDeCodigo(new int[]{4, 1}));
        
        // Adicionar perigos
        labirinto.adicionarPerigo(new BugCorrompido(new int[]{2, 2}));
        labirinto.adicionarPerigo(new SentinelaHostil(new int[]{3, 1}));
        
        // Criar jogador na posição [0, 0]
        Aventureiro jogador = new Aventureiro("ProgramaPrincipal", new int[]{0, 0});
        
        boolean jogando = true;
        while (jogando) {
            // Limpar a tela (simulado)
            for (int i = 0; i < 50; i++) System.out.println();
            
            // Mostrar status e labirinto
            System.out.println("=== SISTEMA TRON ===");
            System.out.println("Jogador: " + jogador.getNome());
            System.out.println("Posição: [" + jogador.getLocalizacaoAtual()[0] + ", " + jogador.getLocalizacaoAtual()[1] + "]");
            System.out.println("Pontos: " + jogador.getPontos() + "\n");
            
            labirinto.exibirLabirinto();
            
            // Mostrar posição do jogador no mapa
            int[] pos = jogador.getLocalizacaoAtual();
            System.out.println("\nVocê está aqui: [" + pos[0] + ", " + pos[1] + "]");
            
            // Menu de opções
            System.out.println("\nComandos:");
            System.out.println("W - Mover para cima");
            System.out.println("S - Mover para baixo");
            System.out.println("A - Mover para esquerda");
            System.out.println("D - Mover para direita");
            System.out.println("I - Ver inventário");
            System.out.println("M - Mostrar mapa completo");
            System.out.println("Q - Sair do jogo");
            System.out.print("\nDigite seu comando: ");
            
            String comando = scanner.nextLine().toUpperCase();
            
            try {
                int[] novaPosicao = jogador.getLocalizacaoAtual().clone();
                
                switch (comando) {
                    case "W":
                        novaPosicao[0]--;
                        break;
                    case "S":
                        novaPosicao[0]++;
                        break;
                    case "A":
                        novaPosicao[1]--;
                        break;
                    case "D":
                        novaPosicao[1]++;
                        break;
                    case "I":
                        jogador.mostrarInventario();
                        System.out.println("\nPressione ENTER para continuar...");
                        scanner.nextLine();
                        continue;
                    case "M":
                        System.out.println("\n=== MAPA COMPLETO ===");
                        labirinto.exibirLabirinto();
                        System.out.println("\nPressione ENTER para continuar...");
                        scanner.nextLine();
                        continue;
                    case "Q":
                        jogando = false;
                        System.out.println("Saindo do Sistema Tron...");
                        continue;
                    default:
                        System.out.println("Comando inválido! Tente novamente.");
                        Thread.sleep(1000);
                        continue;
                }
                
                jogador.mover(novaPosicao, labirinto);
                
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
                //Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        // Fim do jogo
        System.out.println("\n=== RESULTADO FINAL ===");
        jogador.mostrarInventario();
        System.out.println("\n🏁 Fim da simulação. Desconectando da Grade Digital...");
        scanner.close();
    }
}
