package model;

public abstract class PessoaU {
    private String nome;
    private int prontuario;
    private String senha;
    private int constanteD;
    private boolean logado;

    /**
     * Cria uma pessoa universitaria.
     * @param nome da pessoa.
     * @param senha da pessoa.
     * @param prontuario da pessoa.
     */
    public PessoaU(String nome, String senha, int prontuario){
        this.nome = nome;
        this.prontuario = prontuario;
        this.senha = Senha.criptografar(senha);
        this.logado = false;
    }

    /**
     *
     * @return Retorna se a pessoa esta logada ou não no sistema.
     */
    public boolean isLogado() {
        return logado;
    }

    /**
     * Altera a situação do login da pessoa.
     * @param logado definido para a alteração.
     */
    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    /**
     * Verifica a senha, sendo que a senha é guardada em criptografia md5. Criptografa a senha digitada e
     * compara com a que esta salva na pessoa.
     * @param senha digitada pelo usuario.
     * @return Verdadeiro se esta igual Falso se esta diferente.
     */
    public boolean verificaSenha(String senha){
        return this.senha.equals(Senha.criptografar(senha));
    }

    /**
     *
     * @return Retorna a quantidade de dias que uma pessoa pode ficar com um livro emprestado.
     */
    public int getConstanteD() {
        return constanteD;
    }

    /**
     *
     * @return Retorna o nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return Retorna o prontuario da pessoa.
     */
    public int getProntuario() {
        return prontuario;
    }

    /**
     * Altera a quantidade de dias que a pessoa pode ficar com o livro emprestado.
     * @param constanteD
     */
    protected void setConstanteD(int constanteD) {
        this.constanteD = constanteD;
    }

    /**
     *
     * @return Retorna uma String com o nome e o prontuario da pessoa.
     */
    @Override
    public String toString() {
        return nome+" - "+prontuario;
    }
}
