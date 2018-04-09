package model;

public abstract class Coisa {
    protected String coisa;
    protected int constante;

    /**
     * Costrutor de Coisa. Representa um coisa abstrata, podendo ser qualquer uma delas.
     * @param coisa define o nome da coisa.
     * @param constante define o valor da coisa, cada coisa tem o seu numero.
     */
    public Coisa(String coisa, int constante){
        this.coisa = coisa;
        this.constante = constante;
    }

    /**
     * Metodo abstrato, ação de cada coisa.
     * @return A ação em String de cada coisa.
     */
    public abstract String agir();

    /**
     * @return O nome da coisa.
     */
    public String getCoisa() {
        return coisa;
    }

    /**
     *
     * @return A constante da coisa.
     */
    public int getConstante() {
        return constante;
    }
}
