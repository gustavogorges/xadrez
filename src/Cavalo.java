import java.util.ArrayList;

public class Cavalo extends Peca {

    public Cavalo(Posicao posicao, String cor) {
        super(posicao, cor);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        int posicaoNoTabuleiro =
                tabuleiro.getPosicoes().indexOf(this.getPosicao());

        for (Posicao posicao : tabuleiro.getPosicoes()) {
            int indice = tabuleiro.getPosicoes().indexOf(posicao);
            if (tabuleiro.getPosicoes().indexOf(posicao) == posicaoNoTabuleiro - 17 ||
                    indice == posicaoNoTabuleiro - 15 ||
                    indice == posicaoNoTabuleiro - 10 ||
                    indice == posicaoNoTabuleiro - 6 ||
                    indice == posicaoNoTabuleiro + 6 ||
                    indice == posicaoNoTabuleiro + 10 ||
                    indice == posicaoNoTabuleiro + 15 ||
                    indice == posicaoNoTabuleiro + 17) {
                // COLUNA H
                if (validaExtremidade(posicaoNoTabuleiro + 1)) {
                    if (!(indice == posicaoNoTabuleiro - 15 ||
                            indice == posicaoNoTabuleiro - 6 ||
                            indice == posicaoNoTabuleiro + 10 ||
                            indice == posicaoNoTabuleiro + 17)) {
                        verificaPeca(posicao, possiveisMovimentos);
                    }
                }
                // COLUNA A
                else if (validaExtremidade(posicaoNoTabuleiro)) {
                    if (!(indice == posicaoNoTabuleiro - 17 ||
                            indice == posicaoNoTabuleiro - 10 ||
                            indice == posicaoNoTabuleiro + 6 ||
                            indice == posicaoNoTabuleiro + 15)) {

                        verificaPeca(posicao, possiveisMovimentos);
                    }
                }
                // COLUNA B
                else if (validaExtremidade(posicaoNoTabuleiro - 1)) {
                    if (!(indice == posicaoNoTabuleiro - 10 ||
                            indice == posicaoNoTabuleiro + 6)) {
                        verificaPeca(posicao, possiveisMovimentos);
                    }
                }
                // COLUNA G
                else if (validaExtremidade(posicaoNoTabuleiro + 2)) {
                    if (
                            !(
                                    indice == posicaoNoTabuleiro + 10 ||
                                            indice == posicaoNoTabuleiro - 6)) {
                        verificaPeca(posicao, possiveisMovimentos);
                    }
                }
                //NÃO É DE CANTO
                else {
                    verificaPeca(posicao, possiveisMovimentos);
                }
            }
        }
        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        if (this.getCor().equals("Branca")) {
            return "♘";
        } else {
            return "♞";
        }
    }

}
