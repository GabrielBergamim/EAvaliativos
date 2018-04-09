package model;

public class Papel extends Coisa{
    private static final String PAPEL = "Papel";
    private static final int CONSTANTE  = 1;

    /**
     * Cria uma papel.
     */
    public Papel(){
        super(PAPEL, CONSTANTE);
    }

    /**
     * @return Retorna um string com a sua acão
     */
    @Override
    public String agir() {
        return "Embrulhou a pedra!";
    }
}
