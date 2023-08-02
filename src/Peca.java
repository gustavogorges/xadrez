import java.util.ArrayList;

public abstract class Peca {
    private String cor;
    private Posicao posicao;

    public Peca(String cor) {
        this.cor = cor;
    }

    public boolean verificaPeca(Posicao posicao, ArrayList<Posicao> possiveisMovimentos) {
        if(posicao.getPeca() == null) {
            possiveisMovimentos.add(posicao);
            return false;
        }
        if (!posicao.getPeca().getCor().equals(this.getCor())) {
            possiveisMovimentos.add(posicao);
        }
            return true;

    }

    public boolean mover(
            Tabuleiro tabuleiro,
            Posicao posicao
    ) {
        ArrayList<Posicao> possiveisPosicoes = possiveisMovimentos(tabuleiro, posicao);
        for (Posicao posicaoPossivel: possiveisPosicoes) {
            if(posicaoPossivel == posicao) {
                posicao.setPeca(this); //Atribuindo a peça para a nova posição no tabuleiro
                this.posicao.setPeca(null); //Removendo a peça da posição anterior do tabuleiro
                this.posicao = posicao; //Trocand a posição atual da peça
                return true;
            }
        }
        return false;
    }

    public boolean validaExtremidade(int posicaoNoTabuleiro) {
        return posicaoNoTabuleiro % 8 == 0;
    }

    public abstract ArrayList<Posicao> possiveisMovimentos(
            Tabuleiro tabuleiro,
            Posicao posicaoAtual
    );

    public Posicao getPosicao() {
        return posicao;
    }

    //    public abstract char icone();


    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "Peca{" +
                "Cor='" + cor + '\'' +
                ", Posicao=" + posicao +
                '}';
    }
}
