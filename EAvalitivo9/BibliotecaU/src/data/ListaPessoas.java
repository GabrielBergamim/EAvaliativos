package data;

import model.PessoaU;

public class ListaPessoas {
    private static final int MAXP=50;
    private PessoaU[] pessoas;
    private int pess;

    /**
     * Cria um array de pessoas(Aluno, Professor ou Funcionario).
     */
    public ListaPessoas(){
        this.pessoas = new PessoaU[MAXP];
        this.pess = 0;
    }

    /**
     * Cadastra um pessoa no array.
     * @param p pessoa definada para ser cadastrada.
     * @return Verdadeiro casdastrou com sucesso ou Falso não cadastrou.
     */
    public boolean cadastraPessoa(PessoaU p){
        boolean deuCerto = false;

        if(p!=null && pess<MAXP){
            pessoas[pess] = p;
            pess++;
            deuCerto = true;
        }

        return deuCerto;
    }

    /**
     *
     * @param prontuario da pessoa que deseja obter.
     * @return Retorna uma pessoa pelo prontuario desejado.
     */
    public PessoaU getPessoaPront(int prontuario){
        PessoaU p=null;
        boolean achou = false;

        for(int i=0; i<pess && !achou; i++){
            if(pessoas[i].getProntuario() == prontuario){
                p = pessoas[i];
                achou = true;
            }
        }

        return p;
    }

    /**
     *
     * @return Retorna a quantidade de pessoas cadastradas.
     */
    public int getSize(){
        return pess;
    }
}
