public class Posicao {
    private Peca peca;
    private int numeroPosicao;

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public Peca getPeca() {
        return peca;
    }


    public int getNumeroPosicao() {
        return numeroPosicao;
    }

    public void setNumeroPosicao(int numeroPosicao) {
        this.numeroPosicao = numeroPosicao;
    }

    @Override
    public String toString() {
        return "Posicao " +
                "peca=" + peca ;
    }
}
