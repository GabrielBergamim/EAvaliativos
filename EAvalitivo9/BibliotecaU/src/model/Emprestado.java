package model;

import java.time.LocalDate;

public class Emprestado {
    private Exemplar exemplar;
    private PessoaU pessoa;
    private LocalDate dateEmp;
    private LocalDate dateDev;


    public Emprestado(Exemplar exemplar, PessoaU pessoa, LocalDate dateEmp){
        this.exemplar = exemplar;
        this.dateEmp = dateEmp;
        this.pessoa = pessoa;
        this.dateDev = dateEmp.plusDays(pessoa.getConstanteD());
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public LocalDate getDateEmp() {
        return dateEmp;
    }

    public LocalDate getDateDev() {
        return dateDev;
    }

    public PessoaU getPessoa() {
        return pessoa;
    }
}
