package model;

public class Pedra extends Coisa{
    private static final String PEDRA = "Pedra";
    private static final int CONSTANTE  = 0;

    /**
     * Cria uma pedra.
     */
    public Pedra(){
        super(PEDRA, CONSTANTE);
    }

    /**
     * @return Retorna um string com a sua acão
     */
    @Override
    public String agir() {
        return "Amaçou a tesoura!";
    }
}
