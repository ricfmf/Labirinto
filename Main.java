package com.mycompany.projeto2gq;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🌀 Bem-vindo ao SISTEMA TRON!");
        System.out.println("🔷 Iniciando simulação da Grade Digital...\n");

        // Criar o labirinto
        Labirinto labirinto = new Labirinto();
        labirinto.gerarLabirinto(6, 6);

        // Adicionar tesouros digitais
        labirinto.adicionarTesouro(new TokenDeAcesso(new int[]{1, 2}));
        labirinto.adicionarTesouro(new AtualizacaoDeSistema(new int[]{3, 3}));
        labirinto.adicionarTesouro(new FragmentoDeCodigo(new int[]{4, 1}));

        // Adicionar perigos
        labirinto.adicionarPerigo(new PerigoTron("Firewall Hostil", "Um bloqueio de segurança com código ofensivo.", new int[]{2, 2}, 15));
        labirinto.adicionarPerigo(new PerigoTron("Antivírus Corrompido", "Um processo de verificação fora de controle.", new int[]{3, 1}, 10));

        // Criar o jogador
        Aventureiro jogador = new Aventureiro("UsuárioDesvinculado", new int[]{0, 0});

        // Loop principal do jogo
        boolean jogando = true;
        while (jogando) {
            // Mostrar posição atual
            System.out.println("\nPosição atual: [" + jogador.getPosicao()[0] + ", " + jogador.getPosicao()[1] + "]");
            
            // Mostrar opções de movimento
            System.out.println("\nOpções:");
            System.out.println("W - Mover para cima");
            System.out.println("S - Mover para baixo");
            System.out.println("A - Mover para esquerda");
            System.out.println("D - Mover para direita");
            System.out.println("I - Ver inventário");
            System.out.println("Q - Sair do jogo");
            System.out.print("\nDigite sua escolha: ");
            
            String input = scanner.nextLine().toUpperCase();
            
            try {
                int[] novaPosicao = jogador.getPosicao().clone();
                
                switch (input) {
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
                        continue;
                    case "Q":
                        jogando = false;
                        System.out.println("Saindo do jogo...");
                        continue;
                    default:
                        System.out.println("Opção inválida! Use W, A, S, D para mover ou Q para sair.");
                        continue;
                }
                
                // Tentar mover o jogador
                jogador.mover(novaPosicao, labirinto);
                
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Movimento inválido: " + e.getMessage());
            }
        }

        // Mostrar estado final
        System.out.println("\nEstado final:");
        jogador.mostrarInventario();

        System.out.println("\n🏁 Fim da simulação. Saindo da Grade Digital...");
        scanner.close();
    }
}
