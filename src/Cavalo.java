import java.util.ArrayList;

public class Cavalo extends Peca {
    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro =
                tabuleiro.getPosicoes().indexOf(posicaoAtual);

        if (posicaoNoTabuleiro % 8 == 0) {
            if (posicaoNoTabuleiro > 8 && posicaoNoTabuleiro < 48) {
                possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro - 15));
                possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro - 6));
                possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro + 17));
                possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro + 10));
            }
            if (posicaoNoTabuleiro == 0) {
                possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro + 17));
                possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro + 10));
            } else if (posicaoNoTabuleiro == 56) {
                possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro - 15));
                possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro - 6));
            } else if (posicaoNoTabuleiro == 8) {
                possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro + 17));
                possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro + 10));
                possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro - 6));
            }
        }
        possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro - 17));

        possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro - 10));

        possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro + 6));

        possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro + 15));

        for (Posicao posicao : tabuleiro.getPosicoes()) {
            if (tabuleiro.getPosicoes().indexOf(posicao) == posicaoNoTabuleiro - 17 ||
                    tabuleiro.getPosicoes().indexOf(posicao) == posicaoNoTabuleiro - 15 ||
                    tabuleiro.getPosicoes().indexOf(posicao) == posicaoNoTabuleiro - 10 ||
                    tabuleiro.getPosicoes().indexOf(posicao) == posicaoNoTabuleiro - 6 ||
                    tabuleiro.getPosicoes().indexOf(posicao) == posicaoNoTabuleiro + 6 ||
                    tabuleiro.getPosicoes().indexOf(posicao) == posicaoNoTabuleiro + 10 ||
                    tabuleiro.getPosicoes().indexOf(posicao) == posicaoNoTabuleiro + 15 ||
                    tabuleiro.getPosicoes().indexOf(posicao) == posicaoNoTabuleiro + 17) {
                possiveisMovimentos.add(posicao);
            }
        }
        return possiveisMovimentos;
    }
}
