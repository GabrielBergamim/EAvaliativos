package model;

public class Funcionario extends PessoaU {
    private static final int dias = 4;

    /**
     * Cria um funcionario.
     * @param nome do funcionario.
     * @param senha senha do funcionario.
     * @param prontuario do funcionario.
     */
    public Funcionario(String nome, String senha, int prontuario){
        super(nome, senha, prontuario);
        setConstanteD(dias);
    }

}
