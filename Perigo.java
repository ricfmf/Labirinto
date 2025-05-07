public class Perigo {
    private int[] localizacao;
    private int dano;
    private String tipo;

    public Perigo(int[] localizacao, int dano) {
        this(localizacao, dano, "Genérico");
    }

    public Perigo(int[] localizacao, int dano, String tipo) {
        if (localizacao == null || localizacao.length != 2) {
            throw new IllegalArgumentException("Localização deve conter 2 coordenadas");
        }
        if (dano <= 0) {
            throw new IllegalArgumentException("Dano deve ser positivo");
        }
        
        this.localizacao = localizacao.clone();
        this.dano = dano;
        this.tipo = tipo;
    }

    // Getters e Setters
    public int[] getLocalizacao() { 
        return localizacao.clone(); // Retorna cópia para encapsulamento
    }
    
    public void setLocalizacao(int[] localizacao) {
        if (localizacao == null || localizacao.length != 2) {
            throw new IllegalArgumentException("Localização deve conter 2 coordenadas");
        }
        this.localizacao = localizacao.clone();
    }

    public int getDano() { 
        return dano; 
    }
    
    public void setDano(int dano) {
        if (dano <= 0) {
            throw new IllegalArgumentException("Dano deve ser positivo");
        }
        this.dano = dano;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Método para descrição do perigo
    public String getDescricao() {
        return tipo + " (Dano: " + dano + ")";
    }
}
