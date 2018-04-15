package model;

import data.*;

import java.time.LocalDate;

public class Biblioteca {
    ListaEmprestados emprestimos;
    ListaPessoas pessoas;
    ListaExemplares exemplares;

    /**
     * Cria um biblioteca com array de pessoas, exemplares e emprestimos.
     */
    public Biblioteca(){
        this.pessoas = new ListaPessoas();
        this.emprestimos = new ListaEmprestados();
        this.exemplares = new ListaExemplares();
    }

    /**
     * Cadastra um pessoa no array.
     * @param pessoa pessoa definada para ser cadastrada.
     * @return Verdadeiro casdastrou com sucesso ou Falso não cadastrou.
     */
    public boolean cadastraPessoa(PessoaU pessoa){
        return pessoas.cadastraPessoa(pessoa);
    }

    /**
     * Cadastra a quantidade de exemplar e gera seu codigo automaticamente.
     * @param livro exemplar a ser cadastrado.
     * @param qtd quatidade definida para o cadastro de exemplar
     * @return Verdadeiro se conseguiu cadastrar Falso senão.
     */
    public boolean cadastraExemplarAuto(Exemplar livro, int qtd){
        return exemplares.cadastraExemplarAuto(livro, qtd);
    }

    /**
     * Cadastra um emprestimo no array de emprestimos.
     * @param isbn do exemplar.
     * @param codE do exemplar.
     * @param p pessoa que emprestou.
     * @param dateEmp data do emprestimo.
     * @return Verdadeiro casdastrou com sucesso ou Falso não cadastrou.
     */
    public boolean cadastraEmprestimo(long isbn, int codE, PessoaU p, LocalDate dateEmp){
        boolean deuCerto = false;
        Exemplar e;
        Emprestado em;

        e = exemplares.getExemplarIsbnCod(isbn, codE);

        if(e!=null && e.isDisponivel() && p.isLogado()){
            em = new Emprestado(e, p, dateEmp);
            deuCerto = emprestimos.cadastraEmprestimo(em);
        }

        if(deuCerto){
            e.setEmprestado(true);
        }

        return deuCerto;
    }

    /**
     * Registra a devolução de um exemplar emprestado verificando se existe no array de emprestimos.
     * @param isbn do livro a ser devolvido.
     * @param codE do livro a ser devolvido.
     * @param dateDev data do dia da devolução.
     * @return Retorna uma string com uma messagem de sucesso caso o dia da devolução esteja no prazo.
     * multa que sera gerada caso esteja atrasado, ou erro se as informações estiverem incorretas.
     */
    public String registraDev(long isbn, int codE, LocalDate dateDev){
        String resultado = null;
        Emprestado e = null;
        boolean achou = false;

        for(int i=0; i<emprestimos.getSize() && !achou; i++){
            e = emprestimos.getEmprestadoAt(i);

            if(e.getExemplar().getIsbn()==isbn && e.getExemplar().getCod() == codE){
                achou = true;
            }
        }

        if(achou) {
            if(e.getDateDev().equals(dateDev)|| e.getDateDev().isAfter(dateDev)){
                resultado = "Devolução registrada com sucesso!";
                e.getExemplar().setEmprestado(false);
                emprestimos.atualizaListaEmp(e);
            }else{
                if(e.getDateDev().isBefore(dateDev)) {
                    resultado = "Multa será gerada!";
                    e.getExemplar().setEmprestado(false);
                    emprestimos.atualizaListaEmp(e);
                }
            }
        }else{
            resultado = "Erro! Livro não encontrado!";
        }


        return resultado;
    }

    /**
     *
     * @return Retorna a quantidade de pessoas cadastradas.
     */
    public int getSizePessoas(){
        return pessoas.getSize();
    }

    /**
     *
     * @return Retorna a quantidade de emprestados cadastrados.
     */
    public int getSizeEmprestimos(){
        return emprestimos.getSize();
    }

    /**
     *
     * @return Retorna a quantidade de exemplares cadastrados.
     */
    public int getSizeExemplares(){
        return exemplares.getSize();
    }

    /**
     * Realiza o login de uma pessoa no sistema, sendo que essa pessoa deve estar cadastrada.
     * @param prontuario da pessoa.
     * @param senha da pessoa.
     * @return Retorna Verdadeiro se conseguiu logar e Falso se não conseguiu logar.
     */
    public boolean login(int prontuario, String senha){
        boolean acertou = false;
        PessoaU p = pessoas.getPessoaPront(prontuario);

        if(p != null){
            acertou = p.verificaSenha(senha);
        }

        if(acertou){
            p.setLogado(true);
        }

        return acertou;
    }

    /**
     * Lista todos os livros e a quantidade de exemplares cadastrado no sistema.
     * @return Uma string com os livros e as quantidades de cada um.
     */
    public String relatorioLivros(){
        StringBuffer str = new StringBuffer();
        Exemplar aux;
        boolean continua;
        int i, j, cont;

        str.append("\n\nRelatorio de exemplares cadastrados:\n");
        for(i=0; i<getSizeExemplares();i++){
            aux = exemplares.getExemplarAt(i);
            cont = 0;
            continua = true;
            for(j=i; j<exemplares.getSize()&&continua;j++){
                if(aux.getIsbn() == exemplares.getExemplarAt(j).getIsbn()){
                    cont++;
                }else{
                    continua = false;
                }
            }
            i += cont-1;
            str.append(aux.getTitulo());
            str.append(": "+cont);
            str.append(" exemplar(es)");
            str.append("\n------------------------\n");
        }

        return str.toString();
    }

    /**
     * Lista todas as pessoas com o(s) livro(s) emprestado(s).
     * @return Retorna uma String com todas as pessoas e os livros emprestados.
     */
    public String relatorioPessoaLivros(){
        StringBuffer str = new StringBuffer();
        Emprestado aux;

        str.append("\nRelatorio de emprestimo (Pessoa-Livros):\n");
        for(int i=0; i<emprestimos.getSize();i++){
            aux = emprestimos.getEmprestadoAt(i);
            str.append(aux.getPessoa().getNome());
            str.append(": ");
            str.append(aux.getExemplar().getTitulo());
            str.append("\n");
        }

        str.append("------------------------\n");

        return str.toString();
    }

    /**
     * Lista todos os livros e as pessoas que emprestaram esse livro.
     * @return Retorna uma String com todos os livros e as pessoas que emprestaram.
     */
    public String relatorioLivroPessoas(){
        StringBuffer str = new StringBuffer();
        StringBuffer pessoas = new StringBuffer();
        Emprestado aux, aux2;
        boolean continua;
        int i, j, cont;

        str.append("\nRelatorio de emprestimo (Livro-Pessoas):\n");
        for(i=0; i<getSizeEmprestimos();i++){
            aux = emprestimos.getEmprestadoAt(i);
            cont = 0;
            continua = true;
            for(j=i; j<emprestimos.getSize()&&continua;j++){
                aux2 = emprestimos.getEmprestadoAt(j);
                if(aux.getExemplar().getIsbn() == aux2.getExemplar().getIsbn()){
                    cont++;
                    pessoas.append(aux2.getPessoa().toString());
                    pessoas.append("\n");
                }else{
                    continua = false;
                }
            }
            i += cont-1;
            str.append(aux.getExemplar().getTitulo());
            str.append(":\n");
            str.append(pessoas);
            str.append("------------------------\n");
            pessoas.delete(0, pessoas.length());
        }

        return str.toString();
    }

}
