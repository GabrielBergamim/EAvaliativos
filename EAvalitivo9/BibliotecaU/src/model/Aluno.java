package model;

public class Aluno extends PessoaU {
    private static final int dias = 7;

    /**
     * Cria um aluno.
     * @param nome do aluno.
     * @param senha senha do aluno.
     * @param prontuario do aluno.
     */
    public Aluno(String nome, String senha, int prontuario){
        super(nome, senha, prontuario);
        setConstanteD(dias);
    }

}
