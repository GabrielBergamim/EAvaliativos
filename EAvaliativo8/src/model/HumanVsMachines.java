package model;

public class HumanVsMachines extends Jogo {
    private Humano jogador;
    private Computador[] computadores;
    private int cont;

    /**
     * Cria um jogo de humano contra diversas maquinas definida pelo humano.
     * @param jogador humano.
     * @param computadores array de maquinas adversarias.
     */
    public HumanVsMachines(Humano jogador, Computador[] computadores) {
        super(jogador, computadores);
        this.jogador = jogador;
        this.computadores = computadores;
        this.cont = 0;
    }

    /**
     * Retorna uma maquina da posicão desejada.
     * @param pos posicão desejada.
     * @return
     */
    public Jogador getComputadorAt(int pos){
        return pos<computadores.length?computadores[pos]:null;
    }

    /**
     * Sobrescreve a funcão, setando como jogador2 um jogador virtual do array de computadores na posicão.
     */
    @Override
    public void verificaVencedor() {
        Coisa c1, c2;

        c1 = j1.getCoisa();
        j2 = getComputadorAt(cont);
        c2 = j2.getCoisa();
        cont++;

        if(c1.constante == c2.constante){
            setVencedorEmpate(true);
        }else{
            if(c1.constante == 0 && c2.constante == 1){
                setVencedor(j2);
                setVencedorEmpate(false);
            }else{
                if(c1.constante == 0 && c2.constante == 2){
                    setVencedor(j1);
                    setVencedorEmpate(false);
                }else{
                    if(c1.constante == 1 && c2.constante == 0){
                        setVencedor(j1);
                        setVencedorEmpate(false);
                    }else{
                        if(c1.constante == 1 && c2.constante == 2) {
                            setVencedor(j2);
                            setVencedorEmpate(false);
                        }else{
                            if(c1.constante == 2 && c2.constante == 1) {
                                setVencedor(j1);
                                setVencedorEmpate(false);
                            }else{
                                if(c1.constante == 2 && c2.constante == 0){
                                    setVencedor(j2);
                                    setVencedorEmpate(false);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
