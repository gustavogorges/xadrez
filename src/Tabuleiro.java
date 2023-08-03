import java.util.ArrayList;

public class Tabuleiro {
    private ArrayList<Posicao> posicoes = new ArrayList<>();

    Tabuleiro() {
        for (int i = 0; i < 64; i++) {
            posicoes.add(new Posicao());
            if(i >= 8 && i <= 15){
                posicoes.get(i).setPeca(new Peao(posicoes.get(i),"Preto"));
            }
            if(i >= 48 && i <= 55){
                posicoes.get(i).setPeca(new Peao(posicoes.get(i),"Branco"));
            }
            if(i == 0 || i == 7) {
                posicoes.get(i).setPeca(new Torre(posicoes.get(i),"Preto"));
            }
            if(i == 56 || i == 63) {
                posicoes.get(i).setPeca(new Torre(posicoes.get(i),"Branco"));
            }

            if(i == 1 || i == 6) {
                posicoes.get(i).setPeca(new Cavalo(posicoes.get(i),"Preto"));
            }
            if(i == 57 || i == 62) {
                posicoes.get(i).setPeca(new Cavalo(posicoes.get(i),"Branco"));
            }

            if(i == 2 || i == 5) {
                posicoes.get(i).setPeca(new Bispo(posicoes.get(i),"Preto"));
            }
            if(i == 58 || i == 61) {
                posicoes.get(i).setPeca(new Bispo(posicoes.get(i),"Branco"));
            }
            if(i == 3 ) {
                posicoes.get(i).setPeca(new Rainha(posicoes.get(i),"Preto"));
            }
            if(i == 59) {
                posicoes.get(i).setPeca(new Rainha(posicoes.get(i),"Branco"));
            }
            if(i == 4) {
                posicoes.get(i).setPeca(new Rei(posicoes.get(i),"Preto"));
            }
            if(i == 60) {
                posicoes.get(i).setPeca(new Rei(posicoes.get(i),"Branco"));
            }
        }
    }

    public ArrayList<Posicao> getPosicoes() {
        return posicoes;
    }

    public void removerPeca(
            Posicao posicao
    ) {

    }

    private  String tabuleiroToString(){
        StringBuilder tabuleiro= new StringBuilder();
        for (int i = 0; i <64 ; i++) {
            if (i%8 ==0 && i!= 0 && i!=63 ){
                tabuleiro.append("\n-----------------------------------------\n");
                tabuleiro.append(" ["+i).append(posicoes.get(i).getPeca()!=null ? posicoes.get(i).getPeca() : " " ).append("] ");
            }else {
                tabuleiro.append(" ["+i).append(posicoes.get(i).getPeca()!=null ? posicoes.get(i).getPeca() : " " ).append("] ");
            }

        }

        return tabuleiro.toString();
    }

    @Override
    public String toString() {
        return tabuleiroToString();
    }
}
