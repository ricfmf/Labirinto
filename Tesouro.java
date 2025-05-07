public abstract class Tesouro {
    private String nome;
    private int[] localizacao;
    private int valor;

    public Tesouro(String nome, int[] localizacao, int valor) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.valor = valor;
    }

    public String getNome() { 
        return nome; 
    }
    public void setNome(String nome) { 
        this.nome = nome; 
    }

    public int[] getLocalizacao() { 
        return localizacao; 
    }
    public void setLocalizacao(int[] localizacao) { 
        this.localizacao = localizacao; 
    }

    public int getValor() { 
        return valor; 
    }
    public void setValor(int valor) { 
        this.valor = valor; 
    }

    public abstract void efeito();
}

public class TesouroOuro extends Tesouro {
    public TesouroOuro(String nome, int[] localizacao, int valor) {
        super(nome, localizacao, valor);
    }

    @Override
    public void efeito() {
        System.out.println("Ouro coletado! +" + getValor() + " pontos");
    }
}

public class TesouroGema extends Tesouro {
    public TesouroGema(String nome, int[] localizacao, int valor) {
        super(nome, localizacao, valor * 2); // Gemas valem o dobro
    }

    @Override
    public void efeito() {
        System.out.println("Gema preciosa coletada! +" + getValor() + " pontos");
    }
}
