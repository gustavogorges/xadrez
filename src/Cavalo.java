import java.util.ArrayList;

public class Cavalo extends Peca {

    public Cavalo(String cor) {
        super(cor);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro =
                tabuleiro.getPosicoes().indexOf(posicaoAtual);

        for (Posicao posicao : tabuleiro.getPosicoes()) {
            int indice =  tabuleiro.getPosicoes().indexOf(posicao);
            if (tabuleiro.getPosicoes().indexOf(posicao) == posicaoNoTabuleiro - 17 ||
                    indice == posicaoNoTabuleiro - 15 ||
                    indice == posicaoNoTabuleiro - 10 ||
                    indice == posicaoNoTabuleiro - 6 ||
                    indice == posicaoNoTabuleiro + 6 ||
                    indice == posicaoNoTabuleiro + 10 ||
                    indice == posicaoNoTabuleiro + 15 ||
                    indice == posicaoNoTabuleiro + 17) {
                // COLUNA H
                if (validaExtremidade(posicaoNoTabuleiro + 1) && (
                        indice == posicaoNoTabuleiro - 15 ||
                        indice == posicaoNoTabuleiro - 6 ||
                        indice == posicaoNoTabuleiro + 10 ||
                        indice == posicaoNoTabuleiro + 17 )) {
                    verificaPeca(posicao, possiveisMovimentos);
                }
                // COLUNA A
                else if (validaExtremidade(posicaoNoTabuleiro) && (
                        indice == posicaoNoTabuleiro - 17 ||
                                indice == posicaoNoTabuleiro - 10 ||
                                indice == posicaoNoTabuleiro + 6 ||
                                indice == posicaoNoTabuleiro + 15 )) {
                    verificaPeca(posicao, possiveisMovimentos);
                }
                // COLUNA B
                else if (validaExtremidade(posicaoNoTabuleiro - 1) && (
                                indice == posicaoNoTabuleiro - 10 ||
                                indice == posicaoNoTabuleiro + 6)) {
                    verificaPeca(posicao, possiveisMovimentos);
                }
                    // COLUNA G
                else if (validaExtremidade(posicaoNoTabuleiro + 2) && (
                            indice == posicaoNoTabuleiro + 17 ||
                                    indice == posicaoNoTabuleiro - 15)) {
                    verificaPeca(posicao, possiveisMovimentos);
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
        return "Cavalo " + super.toString();
    }
}
