import java.util.ArrayList;

public class Peao extends Peca{
    private boolean primMov = true;

    public Peao(Posicao posicao, String cor) {
        super(posicao, cor);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(this.getPosicao());

        ArrayList<Posicao> posicoesTabuleiro = tabuleiro.getPosicoes();
        if (this.getCor().equals("Preto")) {
            if (posicaoNoTabuleiro > 15) {
                this.primMov = false;
            }
            if (posicoesTabuleiro.get(posicaoNoTabuleiro + 8).getPeca() == null) {
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 8));
                if (this.primMov) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro + 16).getPeca() == null) {
                        possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 16));
                    }
                }
            }
            if (posicoesTabuleiro.get(posicaoNoTabuleiro + 9).getPeca() != null
                    && !validaExtremidade(posicaoNoTabuleiro + 1)) {
                if (posicoesTabuleiro.get(posicaoNoTabuleiro + 9).getPeca().getCor().equals("Branco")) {
                    possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 9));
                }
            }
            if (posicoesTabuleiro.get(posicaoNoTabuleiro + 7).getPeca() != null
                    && !validaExtremidade(posicaoNoTabuleiro)) {
                if (posicoesTabuleiro.get(posicaoNoTabuleiro + 7).getPeca().getCor().equals("Branco")) {
                    possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 7));
                }
            }
        } else {
            if (posicaoNoTabuleiro < 48) {
                this.primMov = false;
            }
            if (posicoesTabuleiro.get(posicaoNoTabuleiro - 8).getPeca() == null) {
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 8));
                if (this.primMov) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro - 16).getPeca() == null) {
                        possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 16));
                    }
                }
            }
            if (posicoesTabuleiro.get(posicaoNoTabuleiro - 9).getPeca() != null
                    && !validaExtremidade(posicaoNoTabuleiro)) {
                if (posicoesTabuleiro.get(posicaoNoTabuleiro - 9).getPeca().getCor().equals("Preto")) {
                    possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 9));
                }
            }
            if (posicoesTabuleiro.get(posicaoNoTabuleiro - 7).getPeca() != null
                    && !validaExtremidade(posicaoNoTabuleiro + 1)) {
                if (posicoesTabuleiro.get(posicaoNoTabuleiro - 7).getPeca().getCor().equals("Preto")) {
                    possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 7));
                    posicoesTabuleiro.get(posicaoNoTabuleiro - 7).setNumeroPosicao(posicaoNoTabuleiro - 7);
                }
            }
        }

        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        if (this.getCor().equals("Branco")) {
            return "♙";
        } else {
            return "♟";
        }
    }
}
