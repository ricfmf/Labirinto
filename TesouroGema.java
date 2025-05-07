
public class TesouroGema extends Tesouro {
    public TesouroGema(String nome, int[] localizacao, int valor) {
        super(nome, localizacao, valor * 2); // Gemas valem o dobro
    }

    @Override
    public void efeito() {
        System.out.println("Gema preciosa coletada! +" + getValor() + " pontos");
    }
}
