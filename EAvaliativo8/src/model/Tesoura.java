package model;

public class Tesoura extends Coisa {
    private static final String TESOURA = "Tesoura";
    private static final int CONSTANTE  = 2;

    /**
     * Cria uma tesoura.
     */
    public Tesoura(){
        super(TESOURA, CONSTANTE);
    }

    /**
     * @return Retorna um string com a sua acão
     */
    @Override
    public String agir() {
        return "Cortou o papel!";
    }

}
