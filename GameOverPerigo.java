package com.mycompany.projeto2gq;

/**
 * Um perigo que encerra o jogo imediatamente quando o jogador o encontra.
 */
public class GameOverPerigo extends Perigo {

    public GameOverPerigo(int[] localizacao) {
        super(localizacao, 100, "Game Over", "Você encontrou um perigo fatal! Fim de jogo.");
    }

    @Override
    public void exibirInfo() {
        System.out.println("☠☠☠ GAME OVER ☠☠☠");
        System.out.println("Você caiu em uma armadilha mortal!");
        System.exit(0); // Encerra o programa imediatamente
    }
}
