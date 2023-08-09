import java.util.ArrayList;

public class Bispo extends Peca {

    public Bispo(Posicao posicao, String cor) {
        super(posicao, cor);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        int posicaoNoTabuleiro =
                tabuleiro.getPosicoes().indexOf(this.getPosicao());
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();
        for (int i = (validaExtremidade(posicaoNoTabuleiro) ?
                64 : posicaoNoTabuleiro + 7);
             i < tabuleiro.getPosicoes().size();
             i += 7) {

            if(verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i)) {
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro + 1) ?
                -1 : posicaoNoTabuleiro - 7);
             i >= 0;
             i -= 7) {

            if(verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i + 1)) {
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro + 1) ?
                64 : posicaoNoTabuleiro + 9);
             i < tabuleiro.getPosicoes().size();
             i += 9) {

            if(verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) || (validaExtremidade(i + 1) )) {
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro) ?
                -1 : posicaoNoTabuleiro - 9);
             i >= 0;
             i -= 9) {
            
            if( verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i)) {
                break;
            }
        }

//        for (Posicao posicao: tabuleiro.getPosicoes()) {
//            int cont = tabuleiro.getPosicoes().indexOf(posicao);
//            if((cont - posicaoNoTabuleiro) % 7 == 0) {
//                possiveisMovimentos.add(posicao);
//            }
//            else if((cont - posicaoNoTabuleiro) % 9 == 0) {
//                possiveisMovimentos.add(posicao);
//            }
//
//        }
//        return possiveisMovimentos;
//    }
        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        if (this.getCor().equals("Branca")) {
            return "♗";
        } else {
            return "♝";
        }
    }

}
