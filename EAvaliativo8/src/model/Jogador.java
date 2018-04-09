package model;

public abstract class Jogador {
    protected String nome;
    protected Coisa coisa;

    /**
     * Cria um jogador abstrato, podendo ser maquina ou humano.
     * @param nome do jogador.
     */
    public Jogador(String nome){
        this.nome = nome;
    }

    /**
     *
     * @return Nome do jogador.
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return A coisa do jogador.
     */
    public Coisa getCoisa() {
        return coisa;
    }

    /**
     * Altera a coisa.
     * @param coisa definida pela classe que chamou.
     */
    protected void setCoisa(Coisa coisa){
        this.coisa = coisa;
    }

    /**
     *
     * @return Retorna a string do Jogador com seu nome e sua coisa.
     */
    @Override
    public String toString() {
        return "Jogador: "+getNome()+"\nCoisa: "+getCoisa().coisa;
    }
}
