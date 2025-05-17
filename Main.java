/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto2gq;
import java.util.Scanner;
import java.util.Arrays;
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
        labirinto.adicionarTesouro(new VitoriaTesouro (new int[] {5, 4}));
       
        // Adicionar perigos
        labirinto.adicionarPerigo(new BugCorrompido(new int[]{2, 2}));
        labirinto.adicionarPerigo(new SentinelaHostil(new int[]{3, 1}));
        labirinto.adicionarPerigo(new GameOverPerigo(new int[] {5, 5}));
        
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
            
            // Exibir labirinto com a posição do jogador marcada
            exibirLabirintoComJogador(labirinto, jogador);
            
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
                        exibirLabirintoComJogador(labirinto, jogador);
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
                
                // Antes de mover, verifique se há tesouros ou perigos na nova posição
                Tesouro tesouro = labirinto.getTesouroNaPosicao(novaPosicao);
                Perigo perigo = labirinto.getPerigoNaPosicao(novaPosicao);
                
                if (tesouro != null) {
                    System.out.println("\n🔍 Você avistou um " + tesouro.getNome() + " na próxima posição!");
                    System.out.print("Deseja se mover para lá? (S/N): ");
                    String resposta = scanner.nextLine().toUpperCase();
                    if (!resposta.equals("S")) {
                        continue;
                    }
                } else if (perigo != null) {
                    System.out.println("\n⚠ ALERTA: Há um " + perigo.getNome() + " na próxima posição!");
                    System.out.print("Deseja continuar mesmo assim? (S/N): ");
                    String resposta = scanner.nextLine().toUpperCase();
                    if (!resposta.equals("S")) {
                        continue;
                    }
                }
                
                jogador.mover(novaPosicao, labirinto);
                
                // Mostrar mensagem específica se coletou tesouro
                if (tesouro != null && Arrays.equals(jogador.getLocalizacaoAtual(), novaPosicao)) {
                    System.out.println("\n✅ " + tesouro.getNome() + " coletado com sucesso!");
                    System.out.println("Pontos: +" + tesouro.getValor());
                    tesouro.efeito();
                    System.out.println("\nPressione ENTER para continuar...");
                    scanner.nextLine();
                }
                
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
    
    // Método para exibir o labirinto com a posição do jogador marcada
    private static void exibirLabirintoComJogador(Labirinto labirinto, Aventureiro jogador) {
        int[] posJogador = jogador.getLocalizacaoAtual();
        
        for (int i = 0; i < labirinto.getEstrutura().size(); i++) {
            for (int j = 0; j < labirinto.getEstrutura().get(i).size(); j++) {
                int[] pos = {i, j};
                
                if (i == posJogador[0] && j == posJogador[1]) {
                    System.out.print("P "); // Ícone do jogador
                } else {
                    Tesouro tesouro = labirinto.getTesouroNaPosicao(pos);
                    Perigo perigo = labirinto.getPerigoNaPosicao(pos);
                    
                    if (tesouro != null) {
                        if (tesouro instanceof TokenDeAcesso) {
                            System.out.print("T ");
                        } else if (tesouro instanceof AtualizacaoDeSistema) {
                            System.out.print("A ");
                        } else if (tesouro instanceof FragmentoDeCodigo) {
                            System.out.print("F ");
                        }
                    } else if (perigo != null) {
                        if (perigo instanceof BugCorrompido) {
                            System.out.print("B ");
                        } else if (perigo instanceof SentinelaHostil) {
                            System.out.print("S ");
                        }
                    } else {
                        System.out.print("░ ");
                    }
                }
            }
            System.out.println();
        }
    }
}
