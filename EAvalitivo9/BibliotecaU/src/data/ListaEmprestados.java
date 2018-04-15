package data;

import model.Emprestado;
import model.Exemplar;

public class ListaEmprestados {
    private static final int MAXL=100;
    private Emprestado[] emprestados;
    private int empr;

    /**
     * Cria um array de Emprestado(um exemplar emprestado por tal pessoa).
     */
    public ListaEmprestados(){
        this.emprestados = new Emprestado[MAXL];
        this.empr = 0;
    }

    /**
     * Cadastra um emprestimo no array.
     * @param e emprestado que contem um exemplar emprestado e a pessoa que emprestou.
     * @return Verdadeiro casdastrou com sucesso ou Falso não cadastrou.
     */
    public boolean cadastraEmprestimo(Emprestado e){
        boolean deuCerto = false;

        if(e!=null && empr<MAXL){
            emprestados[empr] = e;
            empr++;
            deuCerto = true;
        }

        if(deuCerto){
            sortIsbn();
        }

        return deuCerto;
    }

    /**
     * Ordena o array pelo Isbn de cada exemplar.
     */
    private void sortIsbn(){
        int i, j;
        Emprestado elemento_auxiliar;
        boolean trocou = true;

        for(i=0; i<empr && trocou; i++) {
            trocou = false;
            for (j = 0; j < empr - (1 + i); j++) {
                if (emprestados[j].getExemplar().getIsbn() > emprestados[j + 1].getExemplar().getIsbn()) {
                    elemento_auxiliar = emprestados[j];
                    emprestados[j] = emprestados[j + 1];
                    emprestados[j + 1] = elemento_auxiliar;
                    trocou = true;
                }
            }
        }
    }

    /**
     * Realiza a atualização do array removendo o emprestado definido e realoca os outros emprestados.
     * @param e emprestado definido para se retirado.
     * @return Verdadeiro se encontrou o emprestado definido e retirou ou Falso se não encontrou.
     */
    public boolean atualizaListaEmp(Emprestado e){
        boolean achou = false;
        int i, j=0;

        for(i=0; i<empr && !achou; i++){
            if(e == emprestados[i]){
                achou = true;
                j=i;
            }
        }

        if(achou){
            for(; j<empr-1; j++){
                emprestados[j] = emprestados[j+1];
            }
            empr--;
        }

        return achou;
    }

    /**
     *
     * @return Retorna a quantidade de emprestados cadastrados.
     */
    public int getSize() {
        return empr;
    }

    /**
     * Obtem um emprestado pela posição definida.
     * @param pos posição desejada para retirar um emprestado.
     * @return Retorna um emprestado na posição desejada.
     */
    public Emprestado getEmprestadoAt(int pos){
        return pos<empr?emprestados[pos]:null;
    }
}
