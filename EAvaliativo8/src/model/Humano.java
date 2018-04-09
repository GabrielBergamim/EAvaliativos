package model;

public class Humano extends Jogador {

    /**
     * Cria um jogador humando e a coisa definida pela constante por ele.
     * @param nome definido pelo jogador.
     * @param constante da coisa para criar.
     */
    public Humano(String nome, int constante){
        super(nome);
        setCoisa(criaCoisa(constante));
    }

    /**
     * Cria uma coisa para o jogador humano.
     * @param constante da coisa para criar.
     * @return
     */
    protected Coisa criaCoisa(int constante){
        Coisa coisa;

        switch (constante){
            case 0: coisa = new Pedra();break;
            case 1: coisa = new Papel();break;
            case 2: coisa = new Tesoura();break;
            default: coisa = null;
        }

        return coisa;
    }

}
