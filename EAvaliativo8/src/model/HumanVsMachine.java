package model;

public class HumanVsMachine extends Jogo {
    private Humano humano;
    private Computador computador;

    /**
     * Cria um jogo com um jogador humano e virtual.
     * @param jogador humano.
     * @param computador virtual.
     */
    public HumanVsMachine(Humano jogador, Computador computador) {
        super(jogador, computador);
        this.humano = jogador;
        this.computador = computador;
    }

    /**
     * Permite que o jogador humano defina mais uma vez a sua coisa e também altera a coisa do jogador virtual.
     * @param constante definida pelo jogador humano.
     */
    public void jogaDnv(int constante){
        super.j1.setCoisa(humano.criaCoisa(constante));
        super.j2.setCoisa(computador.criaCoisa());
    }


}
