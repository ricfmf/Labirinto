package com.mycompany.projeto2gq;

public class Main {

    public static void main(String[] args) {

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

        // Simular alguns movimentos
        try {
            jogador.mover(new int[]{1, 2}, labirinto); // Coleta TokenDeAcesso
            jogador.mover(new int[]{2, 2}, labirinto); // Enfrenta Firewall
            jogador.mover(new int[]{3, 3}, labirinto); // Coleta AtualizacaoDeSistema
            jogador.mover(new int[]{4, 1}, labirinto); // Coleta Fragmento
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Movimento inválido: " + e.getMessage());
        }

        // Mostrar estado final
        jogador.mostrarInventario();

        System.out.println("\n🏁 Fim da simulação. Saindo da Grade Digital...");
    }
}
