package view;

import model.*;

import javax.swing.*;

public class Main {
    private static final String OPCJ = "1-MachineVsMachine\n2-HumanVsMachine\n3-HumanVsMachines";
    private static final String OPCME = "1-Melhor de 1\n2-Melhor de 3";
    private static final String COISA = "0-Pedra\n1-Papel\n2-Tesoura";

    public static void main(String[] args){
        Papel papel;
        Pedra pedra;
        Tesoura tesoura;
        Humano humano;
        Computador m1, m2;
        Computador[] computadores;
        HumanVsMachine humanVsMachine;
        HumanVsMachines humanVsMachines;
        MachineVsMachine machineVsMachine;
        Jogador vencedor;
        String nome;
        int opcJ, opcMe, qtdM, obj;

        do {
            opcJ = Integer.parseInt(JOptionPane.showInputDialog(null, OPCJ));
        }while(opcJ<1 || opcJ>3);

        switch (opcJ){
            case 1: m1 = new Computador("PC-1");
                    m2 = new Computador("PC-2");
                    machineVsMachine = new MachineVsMachine(m1, m2);
                    do {
                        opcMe = Integer.parseInt(JOptionPane.showInputDialog(null, OPCME));
                    }while(opcMe<1 || opcMe>2);

                    if(opcMe == 1) {
                        vencedor = md1(machineVsMachine);
                        mostraVencedor(vencedor);
                    }else{
                        vencedor = md3MvsM(machineVsMachine);
                        mostraVencedorFinal(vencedor);
                    }

                    break;

            case 2: nome = JOptionPane.showInputDialog(null, "Nome:");
                    obj = Integer.parseInt(JOptionPane.showInputDialog(null, COISA));
                    do {
                        opcMe = Integer.parseInt(JOptionPane.showInputDialog(null, OPCME));
                    }while(opcMe<1 || opcMe>2);
                    humano = new Humano(nome, obj);
                    m1 = new Computador("PC-destroyer");
                    humanVsMachine = new HumanVsMachine(humano, m1);

                    if(opcMe == 1){
                        vencedor = md1(humanVsMachine);
                        mostraVencedor(vencedor);
                    }else{
                        vencedor = md3HvsM(humanVsMachine);
                        mostraVencedorFinal(vencedor);
                    }
                    break;
            case 3: nome = JOptionPane.showInputDialog(null, "Nome:");
                    obj = Integer.parseInt(JOptionPane.showInputDialog(null, COISA));
                    qtdM = Integer.parseInt(JOptionPane.showInputDialog(null,"Quantidade de maquinas"));
                    humano = new Humano(nome, obj);
                    computadores = new Computador[qtdM];
                    for(int i=0; i<qtdM; i++){
                        computadores[i] = new Computador("PC-"+(i+1));
                    }
                    humanVsMachines = new HumanVsMachines(humano, computadores);
                    humVsMacs(humanVsMachines, qtdM);
        }

    }


    /**
     * Enche o vetor de computadores instaciando novos jogadores virtuais.
     * @param computadores
     * @param qtdMaquinas
     */
    private void encheComputadores(Computador[] computadores ,int qtdMaquinas){
        for(int i=0; i<qtdMaquinas; i++){
            computadores[i] = new Computador("PC-"+(i+1));
        }
    }

    /**
     * Realiza uma partida melhor de 1 monstrando o que cada jogador usou.
     * @param jogo
     * @return Retorna um jogador vencedor.
     */
    public static Jogador md1(Jogo jogo){
        Jogador m1, m2;
        Jogador vencedor;

        m1 = jogo.getJ1();
        m2 = jogo.getJ2();

        jogo.verificaVencedor();
        mostraAdversario(m1, m2);

        if(!jogo.isEmpate()){
            vencedor =  jogo.getVencedor();
        }else{
            vencedor = null;
        }

        return vencedor;
    }


    /**
     * Realiza uma partida melhor de 3 entre maquinas,  monstrando o que cada jogador usou e quem
     * ganhou em cada rodada, e depois define quem ganhou a partida.
     * @param jogo
     * @return Retorna um jogador vencedor (venceu duas rodadas).
     */
    public static Jogador md3MvsM(MachineVsMachine jogo){
        Computador m1, m2;
        Jogador vencedor = null;
        int vit1, vit2;

        m1 = (Computador) jogo.getJ1();
        m2 = (Computador) jogo.getJ2();
        vit1 = 0;
        vit2 = 0;

        for(int i=1; vit1<2&&vit2<2; i++){
            jogo.verificaVencedor();
            mostraAdversario(m1, m2, i);
            vencedor = jogo.getVencedor();
            mostraVencedorRound(vencedor, i);
            if(!jogo.isEmpate()) {
                if (vencedor == m1) {
                    vit1++;
                }else {
                    vit2++;
                }
            }

            jogo.jogaDnv();
        }

        if(vit1 == 2){
            vencedor = m1;
        }else{
            vencedor = m2;
        }

        return vencedor;
    }


    /**
     * Realiza uma partida melhor de 3 entre humano e maquina, monstrando o que cada jogador usou e quem
     * ganhou em cada rodada, e depois define quem ganhou a partida.
     * @param jogo
     * @return Retorna um jogador vencedor (venceu duas rodadas).
     */
    public static Jogador md3HvsM(HumanVsMachine jogo){
        Computador m1;
        Humano h1;
        Jogador vencedor = null;
        int constante;
        int vit1, vit2;

        h1 =  (Humano) jogo.getJ1();
        m1 = (Computador) jogo.getJ2();
        vit1 = 0;
        vit2 = 0;

        for(int i=1; vit1<2&&vit2<2; i++){
            jogo.verificaVencedor();
            mostraAdversario(h1, m1, i);
            vencedor = jogo.getVencedor();
            mostraVencedorRound(vencedor, i);
            if(!jogo.isEmpate()) {
                if (vencedor == m1) {
                    vit1++;
                }else {
                    vit2++;
                }
            }

            if(vit1<2 && vit2<2){
                do{
                    constante = Integer.parseInt(JOptionPane.showInputDialog(null, COISA));
                }while (constante<0 || constante>2);

                jogo.jogaDnv(constante);
            }
        }

        if(vit1 == 2){
            vencedor = h1;
        }else{
            vencedor = m1;
        }

        return vencedor;
    }

    /**
     * Mostra os resultados de cada partida entre o humano e os jogadores virtuais.
     * @param jogo
     * @param qtd
     */
    public static void humVsMacs(HumanVsMachines jogo, int qtd){
        Humano h;
        Computador m;
        Jogador vencedor;

        h = (Humano) jogo.getJ1();

        for(int i=0; i<qtd; i++){
            m = (Computador) jogo.getComputadorAt(i);
            vencedor = humVsMac(jogo, h, m);
            mostraVencedorRound(vencedor, i);
        }
    }

    private static Jogador humVsMac(HumanVsMachines jogo, Jogador m1, Jogador m2){
        Jogador vencedor;

        jogo.verificaVencedor();
        mostraAdversario(m1, m2);
        if(!jogo.isEmpate()){
            vencedor =  jogo.getVencedor();
        }else{
            vencedor = null;
        }

        return vencedor;
    }


    /**
     * Mostra cada um dos adversários e cada coisa que jogou.
     * @param j1
     * @param j2
     */
    public static void mostraAdversario(Jogador j1, Jogador j2){
        StringBuffer str = new StringBuffer();

        str.append(j1.toString());
        str.append("\n---------VS---------\n");
        str.append(j2.toString());

        JOptionPane.showMessageDialog(null, str);
    }

    /**
     * Mostra cada um dos adversários e cada coisa que jogou e a rodada.
     * @param j1
     * @param j2
     */
    public static void mostraAdversario(Jogador j1, Jogador j2, int round){
        StringBuffer str = new StringBuffer();

        str.append("Rodada: "+round+"\n");
        str.append(j1.toString());
        str.append("\n---------VS---------\n");
        str.append(j2.toString());

        JOptionPane.showMessageDialog(null, str);
    }

    /**
     * Mostra o vencedor da partida.
     * @param vencedor
     */
    private static void mostraVencedor(Jogador vencedor){
        String frase;
        if (vencedor != null) {
            frase = vencedor.toString() + "\n";
            frase += vencedor.getCoisa().agir();
            JOptionPane.showMessageDialog(null, frase);
        } else {
            JOptionPane.showMessageDialog(null, "Empate!");
        }
    }

    /**
     * Mostra o vencedor final da partida melhor de 3.
     * @param vencedor
     */
    private static void mostraVencedorFinal(Jogador vencedor){
        JOptionPane.showMessageDialog(null, "Vencedor da partida: "+vencedor.getNome());
    }

    /**
     * Mostra o vencedor de cada round da partida melhor de 3.
     * @param vencedor
     */
    private static void mostraVencedorRound(Jogador vencedor, int round){
        StringBuffer frase = new StringBuffer();
        if (vencedor != null) {
            frase.append("Vencedor do Round- "+round+"\n");
            frase.append(vencedor.toString() + "\n");
            frase.append( vencedor.getCoisa().agir());
            JOptionPane.showMessageDialog(null, frase);
        } else {
            JOptionPane.showMessageDialog(null, "Empate!");
        }
    }
}
