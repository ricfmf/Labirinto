package com.mycompany.projeto2gq;

/**
 * Um tesouro que encerra o jogo com vitória assim que coletado.
 */
public class VitoriaTesouro extends Tesouro {

    public VitoriaTesouro(int[] localizacao) {
        super("Tesouro da Vitória", 999, localizacao);
    }

    @Override
    public void efeito() {
        System.out.println("🎉🎉🎉 VOCÊ VENCEU! 🎉🎉🎉");
        System.out.println("Você encontrou o tesouro lendário e completou sua missão!");
        System.exit(0); // Encerra o programa com sucesso
    }
}
