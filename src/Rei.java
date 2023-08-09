import java.util.ArrayList;

public class Rei extends Peca{
    private boolean primMov;

    public Rei(Posicao posicao, String cor) {
        super(posicao, cor);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        int posicaoNoTabuleiro =
                tabuleiro.getPosicoes().indexOf(this.getPosicao());
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        for (Posicao posicao: tabuleiro.getPosicoes()) {
            int indice = tabuleiro.getPosicoes().indexOf(posicao);
            if(indice == posicaoNoTabuleiro - 9 ||
                    indice == posicaoNoTabuleiro - 8 ||
                    indice == posicaoNoTabuleiro - 7 ||
                    indice == posicaoNoTabuleiro - 1 ||
                    indice == posicaoNoTabuleiro + 1 ||
                    indice == posicaoNoTabuleiro + 7 ||
                    indice == posicaoNoTabuleiro + 8 ||
                    indice == posicaoNoTabuleiro + 9 ) {
                // COLUNA H
                if (validaExtremidade(posicaoNoTabuleiro + 1) &&
                        !( indice == posicaoNoTabuleiro - 7 ||
                                indice == posicaoNoTabuleiro + 1 ||
                                indice == posicaoNoTabuleiro + 9 )) {
                    verificaPeca(posicao, possiveisMovimentos);
                }
                // COLUNA A
                else if (validaExtremidade(posicaoNoTabuleiro) &&
                        !( indice == posicaoNoTabuleiro + 7 ||
                                indice == posicaoNoTabuleiro - 1 ||
                                indice == posicaoNoTabuleiro - 9 )) {
                    verificaPeca(posicao, possiveisMovimentos);
                }
            }
        }

        return possiveisMovimentos;
    }

    public static boolean verificaXeque(Tabuleiro tabuleiroInimigo) {
        for (Posicao posicaoFor : tabuleiroInimigo.getPosicoes()) {
            if (posicaoFor.getPeca() != null) {
                Peca pecaInimiga = posicaoFor.getPeca();
                for (Posicao posicaoFor2 : pecaInimiga.possiveisMovimentos(tabuleiroInimigo)) {
                    if(posicaoFor2.getPeca() instanceof Rei) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public String toString() {
        if (this.getCor().equals("Branco")) {
            return "♔";
        } else {
            return "♚";
        }
    }
}
