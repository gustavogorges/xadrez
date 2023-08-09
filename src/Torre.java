import java.util.ArrayList;

public class Torre extends Peca {
    private boolean primMov = true;

    public Torre(Posicao posicao, String cor) {
        super(posicao, cor);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        int posicaoNoTabuleiro =
                tabuleiro.getPosicoes().indexOf(this.getPosicao());
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();


        for (int i = posicaoNoTabuleiro + 8;
             i < tabuleiro.getPosicoes().size();
             i += 8) {

            if (verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos)) {
                break;
            }
        }
        for (int i = posicaoNoTabuleiro - 8;
             i >= 0;
             i -= 8) {

            if (verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos)) {
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro + 1) ?
                64 : posicaoNoTabuleiro + 1);
             i < tabuleiro.getPosicoes().size();
             i++) {

            if ((verificaPeca(tabuleiro.getPosicoes().get(i),
                    possiveisMovimentos)) ||
                    validaExtremidade(i + 1)) {
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro) ?
                -1 : posicaoNoTabuleiro - 1);
             i >= 0;
             i--) {

            if (verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i)) {
                break;
            }
        }

        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        if (this.getCor().equals("Branca")) {
            return "♖";
        } else {
            return "♜";
        }
    }
}
