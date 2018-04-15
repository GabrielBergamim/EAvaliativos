package view;

import model.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        Aluno aluno;
        Professor prof;
        Funcionario func;
        Exemplar exemplar;
        Biblioteca biblioteca;
        LocalDate dateEmp, dateDev;

        biblioteca = new Biblioteca();

        aluno = new Aluno("Caio", "asd123", 1710101);
        biblioteca.cadastraPessoa(aluno);
        prof = new Professor("Carlos", "abc123", 1610101);
        biblioteca.cadastraPessoa(prof);
        func = new Funcionario("João", "qwe123", 1710123);
        biblioteca.cadastraPessoa(func);

        exemplar = new Exemplar("Java: Como programar","","Paul Deitel",
                                "Pearson", 9789702605188L, true, 01);

        biblioteca.cadastraExemplarAuto(exemplar, 3);

        exemplar = new Exemplar("C Completo total", "", "Hebert Schildt", "Makron Books",
                9788534605953L, true, 01);
        biblioteca.cadastraExemplarAuto(exemplar, 5);

        exemplar = new Exemplar("Estrutura de dados usando C", "", "Aaron M. Tenenbaum",
                "Pearson" ,9788534603485L, true, 01);
        biblioteca.cadastraExemplarAuto(exemplar,5);

        /*Login correto*/
        logar(biblioteca, 1710101, "asd123");
        logar(biblioteca, 1710123, "qwe123");
        /*Login incorreto, senha incorreta*/
        logar(biblioteca, 1610101, "abc234");

        System.out.println("\n");
        dateEmp = LocalDate.now();
        /*Emprestar com sucesso*/
        emprestar(biblioteca, 9789702605188L, 1, aluno, dateEmp);
        emprestar(biblioteca, 9788534605953L, 2, aluno, dateEmp);
        emprestar(biblioteca, 9788534605953L, 1, func, dateEmp);
        emprestar(biblioteca, 9788534603485L, 3, func, dateEmp);
        /*Não pode emprestar o mesmo exemplar*/
        emprestar(biblioteca, 9789702605188L, 1, func, dateEmp);
        /*Emprestar sem estar logado*/
        emprestar(biblioteca, 9789702605188L, 1, prof, dateEmp);

        /*Relatorios*/
        System.out.println(biblioteca.relatorioLivros());
        System.out.println(biblioteca.relatorioPessoaLivros());
        System.out.println(biblioteca.relatorioLivroPessoas());

        /*Dentro do prazo*/
        dateDev = dateEmp.plusDays(3);
        System.out.println(biblioteca.registraDev(9788534605953L, 1,  dateDev));

        /*Fora do prazo*/
        dateDev = dateEmp.plusDays(8);
        System.out.println(biblioteca.registraDev(9788534605953L, 2,  dateDev));


    }

    public static void emprestar(Biblioteca biblioteca, long isbn, int codE, PessoaU pessoa, LocalDate data){
        if(biblioteca.cadastraEmprestimo(isbn, codE, pessoa, data)){
            System.out.println("Exemplar emprestado com sucesso!");
        }else{
            System.out.println("Erro!");
        }
    }

    public static void logar(Biblioteca biblioteca, int prontuario, String senha){
        if(biblioteca.login(prontuario, senha)){
            System.out.println("Logado com sucesso!");
        }else{
            System.out.println("Erro!");
        }
    }
}
