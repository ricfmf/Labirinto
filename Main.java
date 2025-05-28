package com.mycompany.projeto2gq;

import java.util.Scanner;
import java.util.Arrays;

// Imports were duplicated in the original, cleaned up
// import java.util.Scanner;
// import java.util.Arrays;


public class Projeto2GQ { // Corrected class name to match file content
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
        labirinto.adicionarTesouro(new VitoriaTesouro(new int[]{5, 4})); // This treasure also grants victory
       
        // Adicionar perigos
        labirinto.adicionarPerigo(new BugCorrompido(new int[]{2, 2}));
        labirinto.adicionarPerigo(new SentinelaHostil(new int[]{3, 1}));
        labirinto.adicionarPerigo(new GameOverPerigo(new int[]{5, 5})); // This danger causes game over
        
        // Criar jogador na posição [0, 0]
        Aventureiro jogador = new Aventureiro("ProgramaPrincipal", new int[]{0, 0}); //
        
        boolean jogando = true;
        while (jogando) {
            // Limpar a tela (simulado)
            for (int i = 0; i < 50; i++) System.out.println();
            
            // Mostrar status e labirinto
            System.out.println("=== SISTEMA TRON ===");
            System.out.println("Jogador: " + jogador.getNome()); //
            System.out.println("Posição: [" + jogador.getLocalizacaoAtual()[0] + ", " + jogador.getLocalizacaoAtual()[1] + "]"); //
            System.out.println("Pontos: " + jogador.getPontos() + "\n"); //
            
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
                boolean performMove = false;
                int[] novaPosicao = jogador.getLocalizacaoAtual().clone(); //
                
                switch (comando) {
                    case "W":
                        novaPosicao[0]--;
                        performMove = true;
                        break;
                    case "S":
                        novaPosicao[0]++;
                        performMove = true;
                        break;
                    case "A":
                        novaPosicao[1]--;
                        performMove = true;
                        break;
                    case "D":
                        novaPosicao[1]++;
                        performMove = true;
                        break;
                    case "I":
                        jogador.mostrarInventario(); //
                        System.out.println("\nPressione ENTER para continuar...");
                        scanner.nextLine();
                        continue; // Skip point check for this iteration
                    case "M":
                        System.out.println("\n=== MAPA COMPLETO ===");
                        exibirLabirintoComJogador(labirinto, jogador);
                        System.out.println("\nPressione ENTER para continuar...");
                        scanner.nextLine();
                        continue; // Skip point check for this iteration
                    case "Q":
                        jogando = false;
                        System.out.println("Saindo do Sistema Tron...");
                        continue; // Skip point check and end game
                    case "LOL":
                        System.out.println("\n🌫️ Você ouviu passos suaves... algo se esconde nas sombras...");
                        System.out.println("✨ TEEMO apareceu furtivamente no campo de batalha!");
                        System.out.println("\"O escoteiro nunca recua!\" - Teemo");

                        System.out.println("\n🧠 Teemo quer testar seus conhecimentos sobre League of Legends...");
                        System.out.println("Pergunta: Qual é o nome verdadeiro do jogador conhecido como Faker?");
                        System.out.println("A) Lee Sang-hyeok");
                        System.out.println("B) Park Jae-sang");
                        System.out.println("C) Kim Seon-woo");
                        System.out.println("D) Ryu Sang-wook");
                        System.out.print("Digite a letra da resposta correta: ");

                        String resposta = scanner.nextLine().toUpperCase();

                        if (resposta.equals("A")) {
                            System.out.println("\n✅ Resposta correta!");
                            System.out.println("Você ganhou um bônus secreto de 13 pontos por sabedoria lendária!");
                            jogador.adicionarPontos(13); //
                        } else {
                            System.out.println("\n❌ Resposta incorreta!");
                            System.out.println("Teemo desapareceu nas sombras... nenhuma recompensa foi concedida.");
                        }

                        System.out.println("\nPressione ENTER para continuar...");
                        scanner.nextLine();
                        // Do not 'continue', fall through to allow victory check after adding points
                        break; 
                    default:
                        System.out.println("Comando inválido! Tente novamente.");
                        Thread.sleep(1000); // Original behavior
                        continue; // Skip point check for this iteration
                }
                
                if (performMove) {
                    jogador.mover(novaPosicao, labirinto); // This might trigger System.exit() via VitoriaTesouro or GameOverPerigo
                }
                
                // The original code had a redundant message display here for collected treasures.
                // The Aventureiro.coletarTesouro method already handles these messages.
                
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
                // Consider adding a "Press ENTER to continue..." here for better UX
                // System.out.println("\nPressione ENTER para continuar...");
                // scanner.nextLine();
            } catch (InterruptedException e) { // For Thread.sleep in default case
                Thread.currentThread().interrupt();
            }

            // Check for 40-point victory condition, if the game hasn't already ended
            // by VitoriaTesouro, GameOverPerigo, or the 'Q' command.
            if (jogando && jogador.getPontos() >= 40) {
                // Limpar a tela (simulado)
                for (int i = 0; i < 50; i++) System.out.println();
            
                System.out.println("🎉🎉🎉 VOCÊ ATINGIU 40 PONTOS OU MAIS! 🎉🎉🎉");
                System.out.println("Você demonstrou grande habilidade e venceu o desafio da Rede Tron!");
                jogando = false; // Set to false to exit the loop and show final score
            }
        }
        
        // Fim do jogo
        System.out.println("\n=== RESULTADO FINAL ===");
        jogador.mostrarInventario(); //
        System.out.println("\n🏁 Fim da simulação. Desconectando da Grade Digital...");
        scanner.close();
    }
    
    // Método para exibir o labirinto com a posição do jogador marcada ( 그대로 유지 )
    private static void exibirLabirintoComJogador(Labirinto labirinto, Aventureiro jogador) {
        int[] posJogador = jogador.getLocalizacaoAtual(); //
        
        for (int i = 0; i < labirinto.getEstrutura().size(); i++) { //
            for (int j = 0; j < labirinto.getEstrutura().get(i).size(); j++) { //
                int[] pos = {i, j};
                
                if (i == posJogador[0] && j == posJogador[1]) {
                    System.out.print("P "); // Ícone do jogador
                } else {
                    Tesouro tesouro = labirinto.getTesouroNaPosicao(pos); //
                    Perigo perigo = labirinto.getPerigoNaPosicao(pos); //
                    
                    if (tesouro != null) {
                        if (tesouro instanceof TokenDeAcesso) { //
                            System.out.print("T ");
                        } else if (tesouro instanceof AtualizacaoDeSistema) { //
                            System.out.print("A ");
                        } else if (tesouro instanceof FragmentoDeCodigo) { //
                             System.out.print("F ");
                        } else if (tesouro instanceof VitoriaTesouro) { //
                             System.out.print("V "); // Added a 'V' for VitoriaTesouro for clarity on map
                        } else {
                             System.out.print("⚡ "); // Generic treasure from original Labirinto.exibirLabirinto()
                        }
                    } else if (perigo != null) {
                        if (perigo instanceof BugCorrompido) { //
                            System.out.print("B ");
                        } else if (perigo instanceof SentinelaHostil) { //
                            System.out.print("S ");
                        } else if (perigo instanceof GameOverPerigo) { //
                            System.out.print("X "); // Added 'X' for GameOverPerigo for clarity
                        } else {
                            System.out.print("☠ "); // Generic danger from original Labirinto.exibirLabirinto()
                        }
                    } else {
                        System.out.print("░ "); // Empty space
                    }
                }
            }
            System.out.println();
        }
    }
}
