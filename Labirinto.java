package com.mycompany.projeto2gq;

/**
 *
 * @author ricar
 */
import java.util.ArrayList;

public class Labirinto {
    private ArrayList<ArrayList<String>> estrutura;
    private ArrayList<Tesouro> tesouros;
    private ArrayList<Perigo> perigos;

    public Labirinto() {
        this.estrutura = new ArrayList<>();
        this.tesouros = new ArrayList<>();
        this.perigos = new ArrayList<>();
    }

    public void gerarLabirinto(int linhas, int colunas) {
        estrutura.clear();
        for (int i = 0; i < linhas; i++) {
            ArrayList<String> linha = new ArrayList<>();
            for (int j = 0; j < colunas; j++) {
                linha.add(".");
            }
            estrutura.add(linha);
        }
    }

    public void adicionarTesouro(Tesouro t) {
        tesouros.add(t);
    }

    public void removerTesouro(Tesouro t) {
        tesouros.remove(t);
    }

    public void adicionarPerigo(Perigo p) {
        perigos.add(p);
    }

    public void removerPerigo(Perigo p) {
        perigos.remove(p);
    }

    public ArrayList<ArrayList<String>> getEstrutura() { 
        return estrutura; 
    }
    public ArrayList<Tesouro> getTesouros() { 
        return tesouros; 
    }
    public ArrayList<Perigo> getPerigos() { 
        return perigos; 
    }
}
