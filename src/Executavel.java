import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Scanner;

public class Executavel {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Jogador> listaJogadores = new ArrayList<Jogador>();
    static Jogador j1, j2;
    static Jogador jogadorAtual, JogadorEsperando;
    static int cont;

    public static void main(String[] args) {
        menuInicial();
    }

    private static boolean validarVitoria(Jogador adversario) {
        for (Peca peca : adversario.getPecas()) {
            if (peca instanceof Rei) {
                return false;
            }
        }
        return true;
    }

    public static void menuInicial() {
        int opcao;
        do {
            jogar();
        } while (true);
        //       do {
//            System.out.println("""
//                    1- Nova Conta
//                    2- Jogar
//                    3- Visualizar Contas
//                    """);
//            opcao = sc.nextInt();
//
//            switch (opcao) {
//                case 1:
//                    System.out.println("Digite o seu nome: ");
//                    String nome = sc.next();
//                    System.out.println("Digite a sua senha: ");
//                    String senha = sc.next();
//                    Jogador jogadorNovo = new Jogador(nome, senha);
//                    listaJogadores.add(jogadorNovo);
//                    System.out.println(listaJogadores);
//                    break;
//                case 2:
//                    jogar();
//                    break;
//                case 3:
//                    System.out.println(listaJogadores);
//            }
//        } while (opcao != 2 || opcao != 3);
    }

    public static void jogar() {
//        if(loginJogador()) {
        Tabuleiro tabuleiroPecas = new Tabuleiro();

        Jogador j1 = new Jogador("1", "1");
        listaJogadores.add(j1);
        Jogador j2 = new Jogador("1", "1");
        listaJogadores.add(j2);

        listaJogadores.get(0).setCor("Preta", tabuleiroPecas);
        listaJogadores.get(1).setCor("Branca", tabuleiroPecas);


        for (int i = 0; i < 9999; i++) {
            if (i % 2 == 0) {
                jogadorAtual = j1;
            } else if (i % 2 == 1) {
                jogadorAtual = j2;
            }
            if (jogadorAtual == j1) {
                cont = 1;
            } else {
                cont = 2;
            }
            System.out.println(tabuleiroPecas);

            if (jogadorAtual == j1) {
                if (verificaXeque(j2.getPecas(), tabuleiroPecas) != null) {
                    System.out.println("/////// JOGADOR 1, SEU REI ESTÁ EM XEQUE ///////");
                    System.out.println(verificaFuga(j1.getPecas(), tabuleiroPecas, verificaXeque(j2.getPecas(),tabuleiroPecas)));
                }
            } else {
                if (verificaXeque(j1.getPecas(), tabuleiroPecas) != null) {
                    System.out.println("/////// JOGADOR 2, SEU REI ESTÁ EM XEQUE ///////");
                    System.out.println(verificaFuga(j2.getPecas(), tabuleiroPecas, verificaXeque(j1.getPecas(),tabuleiroPecas)));
                }
            }

            // Escolha da peça jogador
            System.out.println("Escolha da peça jogador " + cont + " das peças " + jogadorAtual.getCor() + "s : ");
//                System.out.println(jogadorAtual.getPecas());
            int escolhaPeca = sc.nextInt();
            Posicao posicao = tabuleiroPecas.getPosicoes().get(escolhaPeca);
            Peca pecaEscolhida = posicao.getPeca();
            // Possiveis Movimentos
            for (Posicao posicaoteste : tabuleiroPecas.getPosicoes()) {
                if (posicao.getPeca().possiveisMovimentos(tabuleiroPecas).contains(posicaoteste)) {
                    System.out.println("Possivel movimento : " + tabuleiroPecas.getPosicoes().indexOf(posicaoteste));
                }
            }

            int escolhaPosicao = sc.nextInt();
            Posicao posicaoEscolhida = tabuleiroPecas.getPosicoes().get(escolhaPosicao);
            jogadorAtual.moverPeca(pecaEscolhida, posicaoEscolhida, tabuleiroPecas, j2);


            Peca novaPecaPromovida = null;
            if (pecaEscolhida instanceof Peao) {
                int posicaoNoTabuleiro = tabuleiroPecas.getPosicoes().indexOf(pecaEscolhida.getPosicao());
                if (posicaoNoTabuleiro >= 0 && posicaoNoTabuleiro <= 7 || posicaoNoTabuleiro >= 56 && posicaoNoTabuleiro <= 63) {
                    System.out.println("""
                            Escolha uma peça para promover:
                            1- Rainha
                            2- Torre
                            3- Cavalo
                            4- Bispo
                            """);
                    int pecaPromovida = sc.nextInt();

                    switch (pecaPromovida) {
                        case 1 -> novaPecaPromovida = new Rainha(posicaoEscolhida, pecaEscolhida.getCor());
                        case 2 -> novaPecaPromovida = new Torre(posicaoEscolhida, pecaEscolhida.getCor());
                        case 3 -> novaPecaPromovida = new Cavalo(posicaoEscolhida, pecaEscolhida.getCor());
                        case 4 -> novaPecaPromovida = new Bispo(posicaoEscolhida, pecaEscolhida.getCor());
                    }
                    posicaoEscolhida.setPeca(novaPecaPromovida);
                    ArrayList<Peca> novasPecas = jogadorAtual.getPecas();
                    novasPecas.remove(pecaEscolhida);
                    novasPecas.add(novaPecaPromovida);
                    jogadorAtual.setPecas(novasPecas);
                }
            }

        }


//        } else {
//            System.out.println("O login falhou");
//        }
    }

    public static boolean loginJogador() {
        int cont = 0;
        boolean verifica = true;
        do {
            System.out.println("Selecione o jogador 1 : ");
            for (Jogador jogadorFor : listaJogadores) {
                System.out.println(cont + " " + jogadorFor.getNome());
                cont++;
            }
            int escolha = sc.nextInt();
            j1 = listaJogadores.get(escolha);
            System.out.println(j1.getNome());
            System.out.println("Digite a senha do usuário escolhido: ");
            String senha = sc.next();
            if (verificaSenha(j1, senha)) {
                System.out.println("Jogador 1 logado com sucesso!");
            } else {
                System.out.println("Senha incorreta!");
                verifica = false;
            }

            System.out.println("Selecione o jogador 2 : ");
            cont = 0;
            for (Jogador jogadorFor : listaJogadores) {
                System.out.println(cont + " " + jogadorFor.getNome());
                cont++;
            }
            int escolha2 = sc.nextInt();
            j2 = listaJogadores.get(escolha);
            System.out.println("Digite a senha do usuário escolhido: ");
            String senha2 = sc.next();
            if (verificaSenha(j2, senha2)) {
                System.out.println("Jogador 2 logado com sucesso!");
                return true;
            } else {
                System.out.println("Senha incorreta!");
                verifica = false;
                return false;
            }
        } while (verifica);
    }

    public static boolean verificaSenha(Jogador jogador, String senha) {
        for (Jogador jogadorFor : listaJogadores) {
            if (jogador.getSenha().equals(jogadorFor.getSenha())) {
                return true;
            }
        }
        return false;
    }

    public static Peca verificaXeque(ArrayList<Peca> pecaInimigas, Tabuleiro tabuleiro) {
        //System.out.println("entrou no verifica xeque");
        for (Peca pecasFor : pecaInimigas) {

            Peca pecaInimiga = pecasFor;
            for (Posicao pecaFor2 : pecaInimiga.possiveisMovimentos(tabuleiro)) {
                //   System.out.println("entrou no for pecaFor2");
                if (pecaFor2.getPeca() instanceof Rei) {
                    return pecaInimiga;
                }
            }
        }

        return null;
    }

    public static ArrayList<Peca> verificaFuga(ArrayList<Peca> pecasAmigas, Tabuleiro tabuleiro, Peca pecaInimiga) {
        ArrayList<Peca> pecasPossiveis = new ArrayList<>();
//        System.out.println("Entrou no verifica fuga !");
        for (Posicao possiveisMovimentosPecaInimiga : ) {
            // pegar os possiveis movimentos da peça inimiga que afetam o rei, para então fazer a verificação dos possiveis movimentos das peças amigas que interferem ou anulam este movimento
        }
        return pecasPossiveis;
    }

//    public static boolean simulaMovimento(Peca pecaFor, Tabuleiro tabuleiro, ArrayList<Peca> pecasInimigas) {
//
//    }
}