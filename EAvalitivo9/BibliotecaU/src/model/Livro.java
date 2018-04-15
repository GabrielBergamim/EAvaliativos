package model;

public abstract class Livro {
    private String titulo;
    private String autor;
    private String subtitulo;
    private String editora;
    private long isbn;

    /**
     * Cria um livro.
     * @param titulo do livro.
     * @param subtitulo do livro.
     * @param autor do livro.
     * @param editora do livro.
     * @param isbn do livro.
     */
    public Livro(String titulo, String subtitulo, String autor, String editora, long isbn){
        this.titulo = titulo;
        this.autor = autor;
        this.subtitulo = subtitulo;
        this.editora = editora;
        this.isbn = isbn;
    }

    /**
     *
     * @return Retorna o titulo do livro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     *
     * @return Retorna o autor do livro.
     */
    public String getAutor() {
        return autor;
    }


    /**
     *
     * @return Retorna o subtitulo do livro.
     */
    public String getSubtitulo() {
        return subtitulo;
    }

    /**
     *
     * @return Retorna a editora do livro.
     */
    public String getEditora() {
        return editora;
    }

    /**
     *
     * @return Retorna o codigo isbn do livro.
     */
    public long getIsbn() {
        return isbn;
    }
}
