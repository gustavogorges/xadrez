import java.util.ArrayList;

public class Jogador {
    private String nome;
    private String senha;
    private String cor;
    private double pontos;
    private ArrayList<Peca> pecas;

    public Jogador(String nome, String senha) {
        this.senha = senha;
        this.nome = nome;
        this.pecas = new ArrayList<>();
    }

    public void setCor(String cor, Tabuleiro tabuleiro) {
        this.cor = cor;
        for ( Posicao posicao : tabuleiro.getPosicoes() ) {
           if(posicao.getPeca() != null && posicao.getPeca().getCor().equals(this.cor)){
                this.pecas.add(posicao.getPeca());
            }
        }
    }

    public ArrayList<Peca> getPecas() {
        return pecas;
    }

    public boolean moverPeca(Peca peca, Posicao posicao, Tabuleiro tabuleiro, Jogador adversario) {

        Peca pecaAdversaria = posicao.getPeca();
        boolean valida = peca.mover(tabuleiro, posicao);
        if(pecaAdversaria != null && valida) {
            adversario.pecas.remove(pecaAdversaria);
        }
        return valida;
    }

    public boolean proporEmpate(
            Jogador jogador
    ) {
        return true;
    }

    public void desistir() {

    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }
}
