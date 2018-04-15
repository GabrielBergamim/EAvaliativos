package model;

public class Exemplar extends Livro{
    private int cod;
    private boolean emprestado;
    private boolean podeEmprestar;

    /**
     * Cria um exemplar.
     * @param titulo do exemplar.
     * @param subtitulo do exemplar.
     * @param autor do exemplar.
     * @param editora do exemplar.
     * @param isbn do exemplar.
     * @param podeEmprestar do exemplar.
     * @param cod do exemplar.
     */
    public Exemplar(String titulo, String subtitulo, String autor, String editora,
                    long  isbn, boolean podeEmprestar, int cod){
        super(titulo, subtitulo, autor, editora, isbn);
        this.cod = cod;
        this.emprestado = false;
        this.podeEmprestar = podeEmprestar;

    }

    /**
     *
     * @return Retorna o codigo do exemplar.
     */
    public int getCod() {
        return cod;
    }

    /**
     *
     * @return Retorna se o exemplar esta ou não emprestado.
     */
    public boolean isEmprestado() {
        return emprestado;
    }

    /**
     * Altera se o livro esta alterado ou não.
     * @param emprestado define se o livro estara emprestado ou não.
     */
    public void setEmprestado(boolean emprestado){
        this.emprestado = emprestado;
    }

    /**
     *
     * @return Retorna se o livro esta disponivel, estad disponivel quando pode emprestar e não esta emprestado.
     */
    public boolean isDisponivel(){
        return podeEmprestar&&!emprestado;
    }

}
