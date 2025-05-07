import java.util.ArrayList;

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

    public void mover(int[] novaPosicao, Labirinto labirinto) throws IllegalArgumentException {
        if (!labirinto.posicaoValida(novaPosicao)) {
            throw new IllegalArgumentException("Movimento inválido: posição fora do labirinto");
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

    public void coletarTesouro(Tesouro t, Labirinto labirinto) {
        if (t.getLocalizacao()[0] != localizacaoAtual[0] || t.getLocalizacao()[1] != localizacaoAtual[1]) {
            throw new IllegalStateException("Não há tesouro na posição atual do aventureiro");
        }
        this.tesourosColetados.add(t);
        this.pontos += t.getValor();
        t.efeito();
        labirinto.removerTesouro(t);
    }

    public void enfrentarPerigo(Perigo p, Labirinto labirinto) {
        System.out.println("Oh não! Você encontrou um perigo e perdeu " + p.getDano() + " pontos!");
        this.pontos = Math.max(0, this.pontos - p.getDano());
        labirinto.removerPerigo(p);
    }

    public void mostrarInventario() {
        System.out.println("\nInventário de " + nome + ":");
        System.out.println("Total de pontos: " + pontos);
        System.out.println("Tesouros coletados:");
        for (Tesouro t : tesourosColetados) {
            System.out.println("- " + t.getNome() + " (" + t.getValor() + " pontos)");
        }
    }
}
