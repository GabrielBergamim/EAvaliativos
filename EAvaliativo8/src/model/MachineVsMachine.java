package model;

public class MachineVsMachine extends Jogo {
    Computador maquina1, maquina2;

    /**
     * Cria um jogo de maquina contra maquina.
     * @param maquina1
     * @param maquina2
     */
    public MachineVsMachine(Computador maquina1, Computador maquina2) {
        super(maquina1, maquina2);

        this.maquina1 = maquina1;
        this.maquina2 = maquina2;
    }

    /**
     * Maquinas setam a sua coisa automaticamente.
     */
    public void jogaDnv(){
        super.j1.setCoisa(maquina1.criaCoisa());
        super.j2.setCoisa(maquina2.criaCoisa());
    }
}

