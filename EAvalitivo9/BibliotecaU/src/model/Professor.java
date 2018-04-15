package model;

public class Professor extends PessoaU {
    private static final int dias = 30;

    /**
     * Cria um professor.
     * @param nome do professor.
     * @param senha senha do professor.
     * @param prontuario do professor.
     */
    public Professor(String nome, String senha, int prontuario){
        super(nome, senha, prontuario);
        setConstanteD(dias);
    }

}
