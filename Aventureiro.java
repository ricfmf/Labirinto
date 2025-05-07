import java.util.ArrayList;

public class Aventureiro {
    private String nome;
    private int[] localizacaoAtual;
    private ArrayList<Tesouro> tesourosColetados;
    private int pontos;
    private int vidas;

    public Aventureiro(String nome, int[] localizacaoInicial) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do aventureiro não pode ser vazio");
        }
        if (localizacaoInicial == null || localizacaoInicial.length != 2) {
            throw new IllegalArgumentException("Localização inicial inválida");
        }
        
        this.nome = nome;
        this.localizacaoAtual = localizacaoInicial.clone();
        this.tesourosColetados = new ArrayList<>();
        this.pontos = 0;
        this.vidas = 3; // O aventureiro começa com 3 vidas
    }

    // Getters e Setters
    public String getNome() { 
        return nome; 
    }
    
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome; 
    }

    public int[] getLocalizacaoAtual() { 
        return localizacaoAtual.clone(); // Retorna cópia para proteger encapsulamento
    }
    
    public void setLocalizacaoAtual(int[] localizacaoAtual) {
        if (localizacaoAtual == null || localizacaoAtual.length != 2) {
            throw new IllegalArgumentException("Localização deve conter 2 coordenadas");
        }
        this.localizacaoAtual = localizacaoAtual.clone();
    }

    public ArrayList<Tesouro> getTesourosColetados() { 
        return new ArrayList<>(tesourosColetados); // Retorna cópia para encapsulamento
    }
    
    public int getPontos() {
        return pontos;
    }
    
    public int getVidas() {
        return vidas;
    }

    // Métodos de ação
    public void mover(int[] novaPosicao, Labirinto labirinto) throws IllegalArgumentException {
        if (labirinto == null) {
            throw new IllegalArgumentException("Labirinto não pode ser nulo");
        }
        
        if (!labirinto.posicaoValida(novaPosicao)) {
            throw new IllegalArgumentException("Posição [" + novaPosicao[0] + "," + novaPosicao[1] + "] fora do labirinto");
        }
        
        this.localizacaoAtual = novaPosicao.clone();
        
        // Verifica se há tesouro na nova posição
        Tesouro tesouro = labirinto.getTesouroNaPosicao(novaPosicao);
        if (tesouro != null) {
            coletarTesouro(tesouro, labirinto);
        }
        
        // Verifica se há perigo na nova posição
        Perigo perigo = labirinto.getPerigoNaPosicao(novaPosicao);
        if (perigo != null) {
            enfrentarPerigo(perigo, labirinto);
        }
    }

    public void coletarTesouro(Tesouro t, Labirinto labirinto) {
        if (t == null || labirinto == null) {
            throw new IllegalArgumentException("Tesouro e labirinto não podem ser nulos");
        }
        
        if (!estaNaMesmaPosicao(t.getLocalizacao())) {
            throw new IllegalStateException("O tesouro não está na mesma posição do aventureiro");
        }
        
        this.tesourosColetados.add(t);
        this.pontos += t.getValor();
        t.efeito();
        labirinto.removerTesouro(t);
    }

    public void enfrentarPerigo(Perigo p, Labirinto labirinto) {
        if (p == null || labirinto == null) {
            throw new IllegalArgumentException("Perigo e labirinto não podem ser nulos");
        }
        
        System.out.println("\n⚠️ PERIGO! " + nome + " sofreu " + p.getDano() + " pontos de dano!");
        this.pontos = Math.max(0, this.pontos - p.getDano());
        this.vidas--;
        
        if (this.vidas <= 0) {
            System.out.println("\n💀 " + nome + " ficou sem vidas! Fim do jogo!");
            mostrarInventario();
            System.exit(0); // Encerra o jogo
        } else {
            System.out.println("Você ainda tem " + this.vidas + " vidas restantes.");
        }
        
        labirinto.removerPerigo(p);
    }

    // Métodos auxiliares
    private boolean estaNaMesmaPosicao(int[] posicao) {
        return this.localizacaoAtual[0] == posicao[0] && this.localizacaoAtual[1] == posicao[1];
    }

    public void mostrarInventario() {
        System.out.println("\n=== INVENTÁRIO DE " + nome.toUpperCase() + " ===");
        System.out.println("Vidas: " + vidas);
        System.out.println("Pontuação: " + pontos);
        System.out.println("Tesouros coletados (" + tesourosColetados.size() + "):");
        
        if (tesourosColetados.isEmpty()) {
            System.out.println("  Nenhum tesouro coletado ainda");
        } else {
            for (Tesouro t : tesourosColetados) {
                System.out.println("  - " + t.getNome() + " (" + t.getValor() + " pontos)");
            }
        }
        
        System.out.println("======================");
    }
}
