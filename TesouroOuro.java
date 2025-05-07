
public class TesouroOuro {
    public class TesouroOuro extends Tesouro {
        public TesouroOuro(String nome, int[] localizacao, int valor) {
            super(nome, localizacao, valor);
        }
    
        @Override
        public void efeito() {
            System.out.println("Ouro coletado! +" + getValor() + " pontos");
        }
    }
    
}
