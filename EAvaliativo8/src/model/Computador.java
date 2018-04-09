package model;

import java.util.Random;

public class Computador extends Jogador {
    /**
     * Cria um computador, jogador virtual.
     * @param nome do jogador virtual.
     */
    public Computador(String nome){
        super(nome);
        setCoisa(criaCoisa());
    }

    /**
     * Cria uma coisa aleatoriamente.
     * @return Retorna a coisa criada.
     */
    protected Coisa criaCoisa(){
        Coisa coisa;
        Random rand = new Random();

        switch (rand.nextInt(3)){
            case 0: coisa = new Pedra();break;
            case 1: coisa = new Papel();break;
            case 2: coisa = new Tesoura();break;
            default: coisa = null;
        }

        return coisa;
    }
}
