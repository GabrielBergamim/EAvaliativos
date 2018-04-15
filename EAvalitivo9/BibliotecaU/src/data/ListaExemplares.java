package data;

import model.Exemplar;

public class ListaExemplares {
    private static final int MAXL=100;
    private Exemplar[] estante;
    private int exem;

    /**
     * Cria uma lista de exemplares
     */
    public ListaExemplares(){
        this.estante = new Exemplar[MAXL];
        this.exem = 0;
    }


    /**
     * Cadastra a quantidade de exemplar e gera seu codigo automaticamente.
     * @param e exemplar a ser cadastrado.
     * @param qtd quatidade definida para o cadastro de exemplar
     * @return Verdadeiro se conseguiu cadastrar Falso senão.
     */
    public boolean cadastraExemplarAuto(Exemplar e, int qtd){
        boolean deuCerto = false;
        Exemplar novo;

        if(e!=null && exem<MAXL && qtd>0){
            for(int i =0; i<qtd && qtd<MAXL; i++){
                novo = new Exemplar(e.getTitulo(), e.getSubtitulo(), e.getAutor(), e.getEditora(),
                        e.getIsbn(), true, e.getCod()+i);
                estante[exem] = novo;
                exem++;
                deuCerto = true;
            }
        }
        if(deuCerto) {
            sortIsbn();
        }

        return deuCerto;
    }

    /**
     *
     * @param isbn do exemplar que deseja obter.
     * @param cod do exemplar que deseja obter.
     * @return Retorna um exemplar que contem o isbn e o codigo desejado.
     */
    public Exemplar getExemplarIsbnCod(long isbn, int cod){
        Exemplar retorno=null;
        boolean achou = false;

        for(int i=0; i<exem && !achou; i++){
            if(estante[i].getCod() == cod && estante[i].getIsbn() == isbn){
                retorno = estante[i];
                achou = true;
            }
        }

        return retorno;
    }

    /**
     * Ordena o array pelo Isbn de cada exemplar.
     */
    private void sortIsbn(){
        int i, j;
        Exemplar elemento_auxiliar;
        boolean trocou = true;
        for(i=0; i<exem && trocou; i++) {
            trocou = false;
            for (j = 0; j < exem - (1 + i); j++) {
                if (estante[j].getIsbn() > estante[j + 1].getIsbn()) {
                    elemento_auxiliar = estante[j];
                    estante[j] = estante[j + 1];
                    estante[j + 1] = elemento_auxiliar;
                    trocou = true;
                }
            }
        }
    }

    /**
     * Obtem um emprestado pela posição definida.
     * @param pos posição desejada para retirar um emprestado.
     * @return Retorna um emprestado na posição desejada.
     */
    public Exemplar getExemplarAt(int pos){
        return pos<exem?estante[pos]:null;
    }

    /**
     *
     * @return Retorna a quantidade de exemplares cadastrados.
     */
    public int getSize() {
        return exem;
    }

}
