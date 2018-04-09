package model;

public abstract class Jogo {
    private Jogador vencedor;
    private Jogador [] maquinas;
    protected Jogador j1, j2;
    private boolean empate;

    /**
     * Cria um jogo abstrato.
     * @param j1 jogador 1.
     * @param j2 jogador 2.
     */
    public Jogo(Jogador j1, Jogador j2){
        this.j1 = j1;
        this.j2 = j2;
        this.empate = false;
        this.maquinas = null;
    }


    /**
     * Cria um jogo abstrato.
     * @param j1 jogador 1 humano.
     * @param maquinas array de maquinas.
     */
    public Jogo(Jogador j1, Jogador[] maquinas){
        this.j1 = j1;
        this.maquinas = maquinas;
        this.empate = false;
    }

    /**
     *
     * @return Retorna o jogado 1.
     */
    public Jogador getJ1() {
        return j1;
    }

    /**
     *
     * @return Retorna o jogado 2.
     */
    public Jogador getJ2() {
        return j2;
    }

    /**
     *
     * @return Retorna o vencedor do jogo.
     */
    public Jogador getVencedor(){
        return this.vencedor;
    }

    /**
     *
     * @return Se esta ou não empatado.
     */
    public boolean isEmpate() {
        return empate;
    }

    /**
     * Define um novo vencedor
     * @param jogador vencedor
     */
    protected void setVencedor(Jogador jogador){
        this.vencedor = jogador;
    }

    /**
     * Altera empate para verdadeiro ou falso.
     * @param empate
     */
    protected void setVencedorEmpate(boolean empate){
        this.empate = empate;
    }

    /**
     * Realiza a regra do jogo, sendo ela: Pedra>Tesoura, Papel>Pedra e Tesoura>Papel.
     */
    public void verificaVencedor(){
        Coisa c1, c2;

        c1 = j1.getCoisa();
        c2 = j2.getCoisa();

        if(c1.constante == c2.constante){
            setVencedorEmpate(true);
        }else{
            if(c1.constante == 0 && c2.constante == 1){
                setVencedor(j2);
            }else{
                if(c1.constante == 0 && c2.constante == 2){
                    setVencedor(j1);
                }else{
                    if(c1.constante == 1 && c2.constante == 0){
                        setVencedor(j1);
                    }else{
                        if(c1.constante == 1 && c2.constante == 2) {
                            setVencedor(j2);
                        }else{
                            if(c1.constante == 2 && c2.constante == 1) {
                                setVencedor(j1);
                            }else{
                                if(c1.constante == 2 && c2.constante == 0){
                                    setVencedor(j2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
