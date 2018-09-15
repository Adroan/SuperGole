/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperGole.view.internalFrame;

import SuperGole.control.IniciarJogo;
import SuperGole.control.MecanicaPC;
import SuperGole.model.Bebidas;
import SuperGole.view.panels.JpanelDeck;
import SuperGole.view.panels.jpanelCarta;
import SuperGole.view.panels.jpanelMao;
import java.awt.Color;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import linear.queue.LinkedQueue;

/**
 *
 * @author Eduardo Woloszyn
 */
public class JInternalFrameNovoJogo extends javax.swing.JInternalFrame {
    
    private static JInternalFrameNovoJogo instance ;
    protected static ArrayList<Bebidas> maoPc = new ArrayList<Bebidas>();
    protected static ArrayList<Bebidas> maoUsuario = new ArrayList<Bebidas>();
    protected static LinkedQueue<Bebidas> deckPc = new LinkedQueue<Bebidas>();
    protected static LinkedQueue<Bebidas> deckUsuario = new LinkedQueue<Bebidas>();
    protected static int turno;
    protected static IniciarJogo jogo = new IniciarJogo();
    protected static int posicaoPc;
    protected static int atributoBatalha;
    /**
     * Creates new form JInternalFrameNovoJogo
     * @return 
     */
    /*public static JInternalFrameNovoJogo getInstance(){
        if (instance == null) {
           instance = new JInternalFrameNovoJogo();
        }
        return instance;
    }*/
    
    public JInternalFrameNovoJogo() {
        initComponents();
        iniciaJogo();
    }
    
    private void iniciaJogo(){
    
       jogo.criarDecks();
       jogo.criarMao();
       deckPc = jogo.getDeckPc();
       deckUsuario = jogo.getDeckUsuario();
       maoPc = jogo.getMaoPc();
       maoUsuario = jogo.getMaoUsuario();
       preencherMaoTela(maoUsuario);
       Random gerador = new Random();
       turno = gerador.nextInt(2);
       nomeCarta6.setVisible(false);
       nomeCarta7.setVisible(false);
       mecanicaJogo();
    }
    
    private void mecanicaJogo(){
        if((maoPc.get(0) == null) && (maoPc.get(1) == null) && (maoPc.get(1) == null) && (maoPc.get(3) == null) && (maoPc.get(4) == null)){
            JOptionPane.showMessageDialog(null,"Computador Venceu!!!");
        }
        if((maoUsuario.get(0) == null) && (maoUsuario.get(1) == null) && (maoUsuario.get(1) == null) && (maoUsuario.get(3) == null) && (maoUsuario.get(4) == null)){
            JOptionPane.showMessageDialog(null,"Jogador Venceu!!!");
        }
        QtdDeckPc.setText(""+deckPc.size());
        QtdDeckUsu.setText(""+deckUsuario.size());
        if(turno == 0){
            MostrarBotaoAtributo();
            turno = 1;
        }else{
            EsconderBotaoAtributo();
            turno = 0;
        }
        
    }
    
    private static void preencherMaoTela(ArrayList<Bebidas> maoUsuario){
        setCarta(Teor1,Preco1,Gosto1,Amnesia1,CustoBen1,maoUsuario.get(0),nomeCarta1);
        setCarta(Teor2,Preco2,Gosto2,Amnesia2,CustoBen2,maoUsuario.get(1),nomeCarta2);
        setCarta(Teor3,Preco3,Gosto3,Amnesia3,CustoBen3,maoUsuario.get(2),nomeCarta3);
        setCarta(Teor4,Preco4,Gosto4,Amnesia4,CustoBen4,maoUsuario.get(3),nomeCarta4);
        setCarta(Teor5,Preco5,Gosto5,Amnesia5,CustoBen5,maoUsuario.get(4),nomeCarta5);
    }
    
    private static void setCarta(JLabel teor,JLabel preco, JLabel gosto, JLabel amnesia, JLabel custBen,Bebidas carta, JPanel nome){
        teor.setText(String.valueOf(carta.getTeorAlco()));
        preco.setText(String.valueOf(carta.getPreco()));
        gosto.setText(String.valueOf(carta.getGosto()));
        amnesia.setText(String.valueOf(carta.getAmnesia()));
        custBen.setText(String.valueOf(carta.getCustBene()));
        nome.setBorder(javax.swing.BorderFactory.createTitledBorder(carta.getNome()));
    }
    
    private static void MostrarBotaoAtributo(){
        bTeor1.setEnabled(true); bTeor2.setEnabled(true); bTeor3.setEnabled(true); bTeor4.setEnabled(true); bTeor5.setEnabled(true);
        bPreco1.setEnabled(true); bPreco2.setEnabled(true); bPreco3.setEnabled(true); bPreco4.setEnabled(true); bPreco5.setEnabled(true);
        bGosto1.setEnabled(true); bGosto2.setEnabled(true); bGosto3.setEnabled(true); bGosto4.setEnabled(true); bGosto5.setEnabled(true);
        bAmnesia1.setEnabled(true); bAmnesia2.setEnabled(true); bAmnesia3.setEnabled(true); bAmnesia4.setEnabled(true); bAmnesia5.setEnabled(true);
        bCustBen1.setEnabled(true); bCustBen2.setEnabled(true); bCustBen3.setEnabled(true); bCustBen4.setEnabled(true); bCustBen5.setEnabled(true);
        UsarCarta1.setVisible(false); UsarCarta2.setVisible(false); UsarCarta3.setVisible(false); UsarCarta4.setVisible(false); UsarCarta5.setVisible(false);
    }
    private static void EsconderBotaoAtributo(){
        bTeor1.setEnabled(false); bTeor2.setEnabled(false); bTeor3.setEnabled(false); bTeor4.setEnabled(false); bTeor5.setEnabled(false);
        bPreco1.setEnabled(false); bPreco2.setEnabled(false); bPreco3.setEnabled(false); bPreco4.setEnabled(false); bPreco5.setEnabled(false);
        bGosto1.setEnabled(false); bGosto2.setEnabled(false); bGosto3.setEnabled(false); bGosto4.setEnabled(false); bGosto5.setEnabled(false);
        bAmnesia1.setEnabled(false); bAmnesia2.setEnabled(false); bAmnesia3.setEnabled(false); bAmnesia4.setEnabled(false); bAmnesia5.setEnabled(false);
        bCustBen1.setEnabled(false); bCustBen2.setEnabled(false); bCustBen3.setEnabled(false); bCustBen4.setEnabled(false); bCustBen5.setEnabled(false);
        UsarCarta1.setVisible(true); UsarCarta2.setVisible(true); UsarCarta3.setVisible(true); UsarCarta4.setVisible(true); UsarCarta5.setVisible(true);
    }

    private static void enviarBebidaBatalha(Bebidas cartaUsuario){
        MecanicaPC pc = new MecanicaPC();
        Bebidas cartaPc = new Bebidas();
        cartaPc = pc.verificarId(maoPc);
        int i = 0;
        while(i < 5) {
            if(cartaPc.equals(maoPc.get(i))){
                posicaoPc = i;
            }
            i++;
        }
        atributoBatalha = pc.verificarAtributo(maoPc.get(posicaoPc));
        int vencedor = jogo.batalha(maoPc.get(posicaoPc), cartaUsuario, atributoBatalha);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        panelMaoJogador.setVisible(false);
        setCarta(Teor6,Preco6,Gosto6,Amnesia6,CustoBen6,cartaUsuario,nomeCarta6);
        setCarta(Teor7,Preco7,Gosto7,Amnesia7,CustoBen7,maoPc.get(posicaoPc),nomeCarta7);
        switch(atributoBatalha){
            case 1: AtributoPc.setText("Preco"); break;
            case 2: AtributoPc.setText("Gosto"); break;
            case 3: AtributoPc.setText("TeorAlc"); break; 
            case 4: AtributoPc.setText("Amnesia"); break;
            case 5: AtributoPc.setText("CustoBene"); break;
            default: AtributoPc.setText("Erro"); break;
        }
        
        if(vencedor == -1){
            TextoVencedor.setText("Jogador Venceu!!!");
            BotaoContinuar.setEnabled(true);
            jogo.vitoriaBatalha(deckUsuario,cartaUsuario,maoPc.get(posicaoPc));
        }else if(vencedor == 1){
            TextoVencedor.setText("Computador Venceu!!!");
            BotaoContinuar.setEnabled(true);
            jogo.vitoriaBatalha(deckPc,maoPc.get(posicaoPc),cartaUsuario);
        }else{
            TextoVencedor.setText("Empate!!!");
            BotaoContinuar.setEnabled(true);
        }
        
        
    }
    private static void enviarBebidaBatalhaUsuario(Bebidas cartaUsuario, int atributo){
        MecanicaPC pc = new MecanicaPC();
        Bebidas cartaPc = new Bebidas();
        cartaPc = pc.verificarId(maoPc);
        int i = 0;
        while(i < 5) {
            if(cartaPc.equals(maoPc.get(i))){
                posicaoPc = i;
            }
            i++;
        }
        int vencedor = jogo.batalha(maoPc.get(posicaoPc), cartaUsuario, atributo);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        panelMaoJogador.setVisible(false);
        setCarta(Teor6,Preco6,Gosto6,Amnesia6,CustoBen6,cartaUsuario,nomeCarta6);
        setCarta(Teor7,Preco7,Gosto7,Amnesia7,CustoBen7,maoPc.get(posicaoPc),nomeCarta7);
        if(vencedor == -1){
            TextoVencedor.setText("Jogador Venceu!!!");
            BotaoContinuar.setEnabled(true);
            jogo.vitoriaBatalha(deckUsuario,cartaUsuario,maoPc.get(posicaoPc));
        }else  if(vencedor == 1){
            TextoVencedor.setText("Computador Venceu!!!");
            BotaoContinuar.setEnabled(true);
            jogo.vitoriaBatalha(deckPc,maoPc.get(posicaoPc),cartaUsuario);
        }else{
            TextoVencedor.setText("Empate!!!");
            BotaoContinuar.setEnabled(true);
        }
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelMaoCpu = new javax.swing.JPanel();
        cartaPc1 = new javax.swing.JPanel();
        btnPcTAlcoolico1 = new javax.swing.JButton();
        btnPcPreco1 = new javax.swing.JButton();
        btnPcGosto1 = new javax.swing.JButton();
        btnPcCusto1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblTeorPc1 = new javax.swing.JLabel();
        ImagemCarta1 = new javax.swing.JLabel();
        cartaPc2 = new javax.swing.JPanel();
        btnPcTAlcoolico2 = new javax.swing.JButton();
        btnPcPreco2 = new javax.swing.JButton();
        btnPcGosto2 = new javax.swing.JButton();
        btnPcCusto2 = new javax.swing.JButton();
        imgPc2 = new javax.swing.JLabel();
        rtyrty = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cartaPc3 = new javax.swing.JPanel();
        btnPcTAlcoolico3 = new javax.swing.JButton();
        btnPcPreco3 = new javax.swing.JButton();
        btnPcGosto3 = new javax.swing.JButton();
        btnPcCusto3 = new javax.swing.JButton();
        imgPc3 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cartaPc4 = new javax.swing.JPanel();
        btnPcTAlcoolico4 = new javax.swing.JButton();
        btnPcCusto4 = new javax.swing.JButton();
        btnPcGosto4 = new javax.swing.JButton();
        btnPcPreco4 = new javax.swing.JButton();
        imgPc4 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        cartaPc5 = new javax.swing.JPanel();
        btnPcTAlcoolico5 = new javax.swing.JButton();
        btnPcCusto5 = new javax.swing.JButton();
        btnPcGosto5 = new javax.swing.JButton();
        btnPcPreco5 = new javax.swing.JButton();
        imgPc5 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanelDeckUsuario1 = new javax.swing.JPanel();
        QtdDeckPc = new javax.swing.JLabel();
        panelMaoJogador = new javax.swing.JPanel();
        nomeCarta1 = new javax.swing.JPanel();
        bTeor1 = new javax.swing.JButton();
        bCustBen1 = new javax.swing.JButton();
        bGosto1 = new javax.swing.JButton();
        bPreco1 = new javax.swing.JButton();
        ImagemCarta = new javax.swing.JLabel();
        Teor1 = new javax.swing.JLabel();
        Preco1 = new javax.swing.JLabel();
        Gosto1 = new javax.swing.JLabel();
        CustoBen1 = new javax.swing.JLabel();
        bAmnesia1 = new javax.swing.JButton();
        Amnesia1 = new javax.swing.JLabel();
        UsarCarta1 = new javax.swing.JButton();
        nomeCarta3 = new javax.swing.JPanel();
        bTeor3 = new javax.swing.JButton();
        bCustBen3 = new javax.swing.JButton();
        bGosto3 = new javax.swing.JButton();
        bPreco3 = new javax.swing.JButton();
        ImagemCarta3 = new javax.swing.JLabel();
        Teor3 = new javax.swing.JLabel();
        Preco3 = new javax.swing.JLabel();
        Gosto3 = new javax.swing.JLabel();
        CustoBen3 = new javax.swing.JLabel();
        bAmnesia3 = new javax.swing.JButton();
        Amnesia3 = new javax.swing.JLabel();
        UsarCarta3 = new javax.swing.JButton();
        nomeCarta2 = new javax.swing.JPanel();
        bTeor2 = new javax.swing.JButton();
        bCustBen2 = new javax.swing.JButton();
        bGosto2 = new javax.swing.JButton();
        bPreco2 = new javax.swing.JButton();
        ImagemCarta2 = new javax.swing.JLabel();
        Teor2 = new javax.swing.JLabel();
        Preco2 = new javax.swing.JLabel();
        Gosto2 = new javax.swing.JLabel();
        CustoBen2 = new javax.swing.JLabel();
        bAmnesia2 = new javax.swing.JButton();
        Amnesia2 = new javax.swing.JLabel();
        UsarCarta2 = new javax.swing.JButton();
        nomeCarta4 = new javax.swing.JPanel();
        bTeor4 = new javax.swing.JButton();
        bCustBen4 = new javax.swing.JButton();
        bGosto4 = new javax.swing.JButton();
        bPreco4 = new javax.swing.JButton();
        ImagemCarta4 = new javax.swing.JLabel();
        Teor4 = new javax.swing.JLabel();
        Preco4 = new javax.swing.JLabel();
        Gosto4 = new javax.swing.JLabel();
        CustoBen4 = new javax.swing.JLabel();
        bAmnesia4 = new javax.swing.JButton();
        Amnesia4 = new javax.swing.JLabel();
        UsarCarta4 = new javax.swing.JButton();
        nomeCarta5 = new javax.swing.JPanel();
        bTeor5 = new javax.swing.JButton();
        bCustBen5 = new javax.swing.JButton();
        bGosto5 = new javax.swing.JButton();
        bPreco5 = new javax.swing.JButton();
        ImagemCarta5 = new javax.swing.JLabel();
        Teor5 = new javax.swing.JLabel();
        Preco5 = new javax.swing.JLabel();
        Gosto5 = new javax.swing.JLabel();
        CustoBen5 = new javax.swing.JLabel();
        bAmnesia5 = new javax.swing.JButton();
        Amnesia5 = new javax.swing.JLabel();
        UsarCarta5 = new javax.swing.JButton();
        jPanelDeckUsuario2 = new javax.swing.JPanel();
        QtdDeckUsu = new javax.swing.JLabel();
        nomeCarta6 = new javax.swing.JPanel();
        bTeor6 = new javax.swing.JButton();
        bCustBen6 = new javax.swing.JButton();
        bGosto6 = new javax.swing.JButton();
        bPreco6 = new javax.swing.JButton();
        ImagemCarta6 = new javax.swing.JLabel();
        Teor6 = new javax.swing.JLabel();
        Preco6 = new javax.swing.JLabel();
        Gosto6 = new javax.swing.JLabel();
        CustoBen6 = new javax.swing.JLabel();
        bAmnesia6 = new javax.swing.JButton();
        Amnesia6 = new javax.swing.JLabel();
        nomeCarta7 = new javax.swing.JPanel();
        bTeor7 = new javax.swing.JButton();
        bCustBen7 = new javax.swing.JButton();
        bGosto7 = new javax.swing.JButton();
        bPreco7 = new javax.swing.JButton();
        ImagemCarta7 = new javax.swing.JLabel();
        Teor7 = new javax.swing.JLabel();
        Preco7 = new javax.swing.JLabel();
        Gosto7 = new javax.swing.JLabel();
        CustoBen7 = new javax.swing.JLabel();
        bAmnesia7 = new javax.swing.JButton();
        Amnesia7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        TextoVencedor = new javax.swing.JLabel();
        BotaoContinuar = new javax.swing.JButton();
        AtributoPc = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 0, 0));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setForeground(java.awt.Color.darkGray);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1020, 868));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enviarCartaBatalha(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Mostrar(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SuperGole/view/images/VERSUS Graphic50.png"))); // NOI18N

        panelMaoCpu.setBackground(new java.awt.Color(153, 255, 153));
        panelMaoCpu.setBorder(javax.swing.BorderFactory.createTitledBorder("Mão"));

        cartaPc1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome_Carta"));

        btnPcTAlcoolico1.setText("TeorAlcoólico");

        btnPcPreco1.setText("Preço");
        btnPcPreco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPcPreco1ActionPerformed(evt);
            }
        });

        btnPcGosto1.setText("Gosto");

        btnPcCusto1.setText("Custo Beneficio");

        jLabel14.setText("ata");

        jLabel15.setText("ata");

        jLabel16.setText("ata");

        lblTeorPc1.setForeground(new java.awt.Color(0, 153, 153));
        lblTeorPc1.setText("ata");

        ImagemCarta1.setText("jLabel2");

        javax.swing.GroupLayout cartaPc1Layout = new javax.swing.GroupLayout(cartaPc1);
        cartaPc1.setLayout(cartaPc1Layout);
        cartaPc1Layout.setHorizontalGroup(
            cartaPc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartaPc1Layout.createSequentialGroup()
                .addGroup(cartaPc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cartaPc1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(cartaPc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cartaPc1Layout.createSequentialGroup()
                                .addComponent(btnPcTAlcoolico1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTeorPc1))
                            .addGroup(cartaPc1Layout.createSequentialGroup()
                                .addGroup(cartaPc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnPcCusto1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(btnPcGosto1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPcPreco1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(cartaPc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(cartaPc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel15))
                                    .addComponent(jLabel14)))))
                    .addGroup(cartaPc1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(ImagemCarta1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        cartaPc1Layout.setVerticalGroup(
            cartaPc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cartaPc1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(ImagemCarta1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(cartaPc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPcTAlcoolico1)
                    .addComponent(lblTeorPc1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cartaPc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPcPreco1)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cartaPc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPcGosto1)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cartaPc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPcCusto1)
                    .addComponent(jLabel16))
                .addContainerGap())
        );

        cartaPc2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome_Carta"));

        btnPcTAlcoolico2.setText("TeorAlcoólico");

        btnPcPreco2.setText("Preço");

        btnPcGosto2.setText("Gosto");

        btnPcCusto2.setText("Custo Beneficio");

        imgPc2.setText("jLabel3");

        rtyrty.setText("ata");

        jLabel19.setText("ata");

        jLabel20.setText("ata");

        jLabel21.setText("ata");

        javax.swing.GroupLayout cartaPc2Layout = new javax.swing.GroupLayout(cartaPc2);
        cartaPc2.setLayout(cartaPc2Layout);
        cartaPc2Layout.setHorizontalGroup(
            cartaPc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartaPc2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cartaPc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPcCusto2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnPcGosto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPcPreco2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPcTAlcoolico2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(cartaPc2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(imgPc2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(cartaPc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rtyrty, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        cartaPc2Layout.setVerticalGroup(
            cartaPc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cartaPc2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(imgPc2)
                .addGap(64, 64, 64)
                .addGroup(cartaPc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPcTAlcoolico2)
                    .addComponent(rtyrty))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cartaPc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cartaPc2Layout.createSequentialGroup()
                        .addGroup(cartaPc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPcPreco2)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPcGosto2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPcCusto2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cartaPc2Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21)))
                .addContainerGap())
        );

        cartaPc3.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome_Carta"));

        btnPcTAlcoolico3.setText("TeorAlcoólico");

        btnPcPreco3.setText("Preço");

        btnPcGosto3.setText("Gosto");

        btnPcCusto3.setText("Custo Beneficio");

        imgPc3.setText("jLabel4");

        jLabel22.setText("ata");

        jLabel23.setText("ata");

        jLabel24.setText("ata");

        jLabel25.setText("ata");

        javax.swing.GroupLayout cartaPc3Layout = new javax.swing.GroupLayout(cartaPc3);
        cartaPc3.setLayout(cartaPc3Layout);
        cartaPc3Layout.setHorizontalGroup(
            cartaPc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartaPc3Layout.createSequentialGroup()
                .addGroup(cartaPc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cartaPc3Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(imgPc3))
                    .addGroup(cartaPc3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(cartaPc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnPcCusto3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(btnPcGosto3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPcPreco3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPcTAlcoolico3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(cartaPc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cartaPc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel25)
                                .addComponent(jLabel24)
                                .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cartaPc3Layout.setVerticalGroup(
            cartaPc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cartaPc3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imgPc3)
                .addGap(60, 60, 60)
                .addGroup(cartaPc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPcTAlcoolico3)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cartaPc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPcPreco3)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cartaPc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPcGosto3)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cartaPc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPcCusto3)
                    .addComponent(jLabel25))
                .addContainerGap())
        );

        cartaPc4.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome_Carta"));

        btnPcTAlcoolico4.setText("TeorAlcoólico");

        btnPcCusto4.setText("Custo Beneficio");

        btnPcGosto4.setText("Gosto");

        btnPcPreco4.setText("Preço");

        imgPc4.setText("jLabel5");

        jLabel26.setText("ata");

        jLabel27.setText("ata");

        jLabel28.setText("ata");

        jLabel29.setText("ata");

        javax.swing.GroupLayout cartaPc4Layout = new javax.swing.GroupLayout(cartaPc4);
        cartaPc4.setLayout(cartaPc4Layout);
        cartaPc4Layout.setHorizontalGroup(
            cartaPc4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartaPc4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cartaPc4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnPcCusto4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(btnPcGosto4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPcPreco4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPcTAlcoolico4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cartaPc4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cartaPc4Layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addGroup(cartaPc4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(cartaPc4Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(cartaPc4Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(imgPc4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cartaPc4Layout.setVerticalGroup(
            cartaPc4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cartaPc4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imgPc4)
                .addGap(63, 63, 63)
                .addGroup(cartaPc4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPcTAlcoolico4)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cartaPc4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPcPreco4)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cartaPc4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPcGosto4)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cartaPc4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPcCusto4)
                    .addComponent(jLabel29))
                .addContainerGap())
        );

        cartaPc5.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome_Carta"));

        btnPcTAlcoolico5.setText("TeorAlcoólico");

        btnPcCusto5.setText("Custo Beneficio");

        btnPcGosto5.setText("Gosto");

        btnPcPreco5.setText("Preço");

        imgPc5.setText("jLabel6");

        jLabel30.setText("ata");

        jLabel31.setText("ata");

        jLabel32.setText("ata");

        jLabel33.setText("ata");

        javax.swing.GroupLayout cartaPc5Layout = new javax.swing.GroupLayout(cartaPc5);
        cartaPc5.setLayout(cartaPc5Layout);
        cartaPc5Layout.setHorizontalGroup(
            cartaPc5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartaPc5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cartaPc5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imgPc5)
                    .addGroup(cartaPc5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnPcCusto5, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addComponent(btnPcGosto5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPcPreco5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPcTAlcoolico5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cartaPc5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(jLabel32)
                    .addComponent(jLabel31)
                    .addComponent(jLabel30))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        cartaPc5Layout.setVerticalGroup(
            cartaPc5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cartaPc5Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(imgPc5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(cartaPc5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPcTAlcoolico5)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cartaPc5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPcPreco5)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cartaPc5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPcGosto5)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cartaPc5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPcCusto5)
                    .addComponent(jLabel33))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelMaoCpuLayout = new javax.swing.GroupLayout(panelMaoCpu);
        panelMaoCpu.setLayout(panelMaoCpuLayout);
        panelMaoCpuLayout.setHorizontalGroup(
            panelMaoCpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMaoCpuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cartaPc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartaPc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartaPc3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartaPc4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartaPc5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMaoCpuLayout.setVerticalGroup(
            panelMaoCpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cartaPc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cartaPc2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cartaPc3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cartaPc4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cartaPc5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cartaPc1.getAccessibleContext().setAccessibleName("Nome_Carta2");
        cartaPc1.getAccessibleContext().setAccessibleDescription("");

        jPanelDeckUsuario1.setBorder(javax.swing.BorderFactory.createTitledBorder("Deck"));

        QtdDeckPc.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        QtdDeckPc.setText("jLabel2");

        javax.swing.GroupLayout jPanelDeckUsuario1Layout = new javax.swing.GroupLayout(jPanelDeckUsuario1);
        jPanelDeckUsuario1.setLayout(jPanelDeckUsuario1Layout);
        jPanelDeckUsuario1Layout.setHorizontalGroup(
            jPanelDeckUsuario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDeckUsuario1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(QtdDeckPc)
                .addGap(19, 19, 19))
        );
        jPanelDeckUsuario1Layout.setVerticalGroup(
            jPanelDeckUsuario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeckUsuario1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(QtdDeckPc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMaoJogador.setBackground(new java.awt.Color(153, 255, 153));
        panelMaoJogador.setBorder(javax.swing.BorderFactory.createTitledBorder("Mão"));

        nomeCarta1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome_Carta"));

        bTeor1.setText("TeorAlcoólico");
        bTeor1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bTeor1MouseClicked(evt);
            }
        });
        bTeor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTeor1ActionPerformed(evt);
            }
        });

        bCustBen1.setText("Custo Beneficio");
        bCustBen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCustBen1ActionPerformed(evt);
            }
        });

        bGosto1.setText("Gosto");
        bGosto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGosto1ActionPerformed(evt);
            }
        });

        bPreco1.setText("Preço");
        bPreco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPreco1ActionPerformed(evt);
            }
        });

        ImagemCarta.setText("sfsdfsdf");

        Teor1.setText("ata");

        Preco1.setText("ata");

        Gosto1.setText("ata");

        CustoBen1.setText("ata");

        bAmnesia1.setText("Amnesia");
        bAmnesia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAmnesia1ActionPerformed(evt);
            }
        });

        Amnesia1.setText("ata");

        UsarCarta1.setText("Usar Carta");
        UsarCarta1.setToolTipText("");
        UsarCarta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseClickedUsarCarta1(evt);
            }
        });
        UsarCarta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsarCarta1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout nomeCarta1Layout = new javax.swing.GroupLayout(nomeCarta1);
        nomeCarta1.setLayout(nomeCarta1Layout);
        nomeCarta1Layout.setHorizontalGroup(
            nomeCarta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomeCarta1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nomeCarta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UsarCarta1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addGroup(nomeCarta1Layout.createSequentialGroup()
                        .addGroup(nomeCarta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bCustBen1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(bGosto1, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(bPreco1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bTeor1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(bAmnesia1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(nomeCarta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CustoBen1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Teor1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Preco1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Gosto1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Amnesia1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nomeCarta1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ImagemCarta)
                .addGap(57, 57, 57))
        );
        nomeCarta1Layout.setVerticalGroup(
            nomeCarta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomeCarta1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(ImagemCarta)
                .addGap(18, 18, 18)
                .addGroup(nomeCarta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bTeor1)
                    .addComponent(Teor1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bPreco1)
                    .addComponent(Preco1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bGosto1)
                    .addComponent(Gosto1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bAmnesia1)
                    .addComponent(Amnesia1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bCustBen1)
                    .addComponent(CustoBen1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UsarCarta1))
        );

        nomeCarta3.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome_Carta"));

        bTeor3.setText("TeorAlcoólico");
        bTeor3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTeor3ActionPerformed(evt);
            }
        });

        bCustBen3.setText("Custo Beneficio");
        bCustBen3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCustBen3ActionPerformed(evt);
            }
        });

        bGosto3.setText("Gosto");
        bGosto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGosto3ActionPerformed(evt);
            }
        });

        bPreco3.setText("Preço");
        bPreco3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPreco3ActionPerformed(evt);
            }
        });

        ImagemCarta3.setText("sfsdfsdf");

        Teor3.setText("ata");

        Preco3.setText("ata");

        Gosto3.setText("ata");

        CustoBen3.setText("ata");

        bAmnesia3.setText("Amnesia");
        bAmnesia3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAmnesia3ActionPerformed(evt);
            }
        });

        Amnesia3.setText("ata");

        UsarCarta3.setText("Usar Carta");
        UsarCarta3.setToolTipText("");
        UsarCarta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsarCarta3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout nomeCarta3Layout = new javax.swing.GroupLayout(nomeCarta3);
        nomeCarta3.setLayout(nomeCarta3Layout);
        nomeCarta3Layout.setHorizontalGroup(
            nomeCarta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomeCarta3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nomeCarta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UsarCarta3, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addGroup(nomeCarta3Layout.createSequentialGroup()
                        .addGroup(nomeCarta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bCustBen3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(bGosto3, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(bPreco3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bTeor3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(bAmnesia3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(nomeCarta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CustoBen3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Teor3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Preco3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Gosto3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Amnesia3, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nomeCarta3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ImagemCarta3)
                .addGap(57, 57, 57))
        );
        nomeCarta3Layout.setVerticalGroup(
            nomeCarta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomeCarta3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(ImagemCarta3)
                .addGap(18, 18, 18)
                .addGroup(nomeCarta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bTeor3)
                    .addComponent(Teor3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bPreco3)
                    .addComponent(Preco3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bGosto3)
                    .addComponent(Gosto3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bAmnesia3)
                    .addComponent(Amnesia3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bCustBen3)
                    .addComponent(CustoBen3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UsarCarta3))
        );

        nomeCarta2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome_Carta"));

        bTeor2.setText("TeorAlcoólico");
        bTeor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTeor2ActionPerformed(evt);
            }
        });

        bCustBen2.setText("Custo Beneficio");
        bCustBen2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCustBen2ActionPerformed(evt);
            }
        });

        bGosto2.setText("Gosto");
        bGosto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGosto2ActionPerformed(evt);
            }
        });

        bPreco2.setText("Preço");
        bPreco2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPreco2ActionPerformed(evt);
            }
        });

        ImagemCarta2.setText("sfsdfsdf");

        Teor2.setText("ata");

        Preco2.setText("ata");

        Gosto2.setText("ata");

        CustoBen2.setText("ata");

        bAmnesia2.setText("Amnesia");
        bAmnesia2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAmnesia2ActionPerformed(evt);
            }
        });

        Amnesia2.setText("ata");

        UsarCarta2.setText("Usar Carta");
        UsarCarta2.setToolTipText("");
        UsarCarta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsarCarta2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout nomeCarta2Layout = new javax.swing.GroupLayout(nomeCarta2);
        nomeCarta2.setLayout(nomeCarta2Layout);
        nomeCarta2Layout.setHorizontalGroup(
            nomeCarta2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomeCarta2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nomeCarta2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UsarCarta2, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addGroup(nomeCarta2Layout.createSequentialGroup()
                        .addGroup(nomeCarta2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bCustBen2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(bGosto2, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(bPreco2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bTeor2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(bAmnesia2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(nomeCarta2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CustoBen2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Teor2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Preco2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Gosto2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Amnesia2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nomeCarta2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ImagemCarta2)
                .addGap(57, 57, 57))
        );
        nomeCarta2Layout.setVerticalGroup(
            nomeCarta2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomeCarta2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(ImagemCarta2)
                .addGap(18, 18, 18)
                .addGroup(nomeCarta2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bTeor2)
                    .addComponent(Teor2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bPreco2)
                    .addComponent(Preco2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bGosto2)
                    .addComponent(Gosto2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bAmnesia2)
                    .addComponent(Amnesia2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bCustBen2)
                    .addComponent(CustoBen2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UsarCarta2))
        );

        nomeCarta4.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome_Carta"));

        bTeor4.setText("TeorAlcoólico");
        bTeor4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTeor4ActionPerformed(evt);
            }
        });

        bCustBen4.setText("Custo Beneficio");
        bCustBen4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCustBen4ActionPerformed(evt);
            }
        });

        bGosto4.setText("Gosto");
        bGosto4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGosto4ActionPerformed(evt);
            }
        });

        bPreco4.setText("Preço");
        bPreco4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPreco4ActionPerformed(evt);
            }
        });

        ImagemCarta4.setText("sfsdfsdf");

        Teor4.setText("ata");

        Preco4.setText("ata");

        Gosto4.setText("ata");

        CustoBen4.setText("ata");

        bAmnesia4.setText("Amnesia");
        bAmnesia4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAmnesia4ActionPerformed(evt);
            }
        });

        Amnesia4.setText("ata");

        UsarCarta4.setText("Usar Carta");
        UsarCarta4.setToolTipText("");
        UsarCarta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsarCarta4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout nomeCarta4Layout = new javax.swing.GroupLayout(nomeCarta4);
        nomeCarta4.setLayout(nomeCarta4Layout);
        nomeCarta4Layout.setHorizontalGroup(
            nomeCarta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomeCarta4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nomeCarta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UsarCarta4, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addGroup(nomeCarta4Layout.createSequentialGroup()
                        .addGroup(nomeCarta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bCustBen4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(bGosto4, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(bPreco4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bTeor4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(bAmnesia4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(nomeCarta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CustoBen4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Teor4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Preco4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Gosto4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Amnesia4, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nomeCarta4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ImagemCarta4)
                .addGap(57, 57, 57))
        );
        nomeCarta4Layout.setVerticalGroup(
            nomeCarta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomeCarta4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(ImagemCarta4)
                .addGap(18, 18, 18)
                .addGroup(nomeCarta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bTeor4)
                    .addComponent(Teor4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bPreco4)
                    .addComponent(Preco4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bGosto4)
                    .addComponent(Gosto4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bAmnesia4)
                    .addComponent(Amnesia4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bCustBen4)
                    .addComponent(CustoBen4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UsarCarta4))
        );

        nomeCarta5.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome_Carta"));

        bTeor5.setText("TeorAlcoólico");
        bTeor5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTeor5ActionPerformed(evt);
            }
        });

        bCustBen5.setText("Custo Beneficio");
        bCustBen5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCustBen5ActionPerformed(evt);
            }
        });

        bGosto5.setText("Gosto");
        bGosto5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGosto5ActionPerformed(evt);
            }
        });

        bPreco5.setText("Preço");
        bPreco5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPreco5ActionPerformed(evt);
            }
        });

        ImagemCarta5.setText("sfsdfsdf");

        Teor5.setText("ata");

        Preco5.setText("ata");

        Gosto5.setText("ata");

        CustoBen5.setText("ata");

        bAmnesia5.setText("Amnesia");
        bAmnesia5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAmnesia5ActionPerformed(evt);
            }
        });

        Amnesia5.setText("ata");

        UsarCarta5.setText("Usar Carta");
        UsarCarta5.setToolTipText("");
        UsarCarta5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsarCarta5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout nomeCarta5Layout = new javax.swing.GroupLayout(nomeCarta5);
        nomeCarta5.setLayout(nomeCarta5Layout);
        nomeCarta5Layout.setHorizontalGroup(
            nomeCarta5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomeCarta5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nomeCarta5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UsarCarta5, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addGroup(nomeCarta5Layout.createSequentialGroup()
                        .addGroup(nomeCarta5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bCustBen5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(bGosto5, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(bPreco5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bTeor5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(bAmnesia5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(nomeCarta5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CustoBen5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Teor5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Preco5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Gosto5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Amnesia5, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nomeCarta5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ImagemCarta5)
                .addGap(57, 57, 57))
        );
        nomeCarta5Layout.setVerticalGroup(
            nomeCarta5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomeCarta5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(ImagemCarta5)
                .addGap(18, 18, 18)
                .addGroup(nomeCarta5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bTeor5)
                    .addComponent(Teor5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bPreco5)
                    .addComponent(Preco5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bGosto5)
                    .addComponent(Gosto5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bAmnesia5)
                    .addComponent(Amnesia5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bCustBen5)
                    .addComponent(CustoBen5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UsarCarta5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelMaoJogadorLayout = new javax.swing.GroupLayout(panelMaoJogador);
        panelMaoJogador.setLayout(panelMaoJogadorLayout);
        panelMaoJogadorLayout.setHorizontalGroup(
            panelMaoJogadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMaoJogadorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nomeCarta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeCarta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(nomeCarta3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeCarta4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nomeCarta5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelMaoJogadorLayout.setVerticalGroup(
            panelMaoJogadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nomeCarta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nomeCarta3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nomeCarta2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nomeCarta4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nomeCarta5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        nomeCarta1.getAccessibleContext().setAccessibleName("Nome_Carta2");
        nomeCarta1.getAccessibleContext().setAccessibleDescription("");

        jPanelDeckUsuario2.setBorder(javax.swing.BorderFactory.createTitledBorder("Deck"));

        QtdDeckUsu.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        QtdDeckUsu.setText("jLabel2");

        javax.swing.GroupLayout jPanelDeckUsuario2Layout = new javax.swing.GroupLayout(jPanelDeckUsuario2);
        jPanelDeckUsuario2.setLayout(jPanelDeckUsuario2Layout);
        jPanelDeckUsuario2Layout.setHorizontalGroup(
            jPanelDeckUsuario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeckUsuario2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(QtdDeckUsu)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanelDeckUsuario2Layout.setVerticalGroup(
            jPanelDeckUsuario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeckUsuario2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(QtdDeckUsu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        nomeCarta6.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome_Carta"));

        bTeor6.setText("TeorAlcoólico");
        bTeor6.setEnabled(false);

        bCustBen6.setText("Custo Beneficio");
        bCustBen6.setEnabled(false);

        bGosto6.setText("Gosto");
        bGosto6.setEnabled(false);

        bPreco6.setText("Preço");
        bPreco6.setEnabled(false);

        ImagemCarta6.setText("sfsdfsdf");

        Teor6.setText("ata");

        Preco6.setText("ata");

        Gosto6.setText("ata");

        CustoBen6.setText("ata");

        bAmnesia6.setText("Amnesia");
        bAmnesia6.setEnabled(false);

        Amnesia6.setText("ata");

        javax.swing.GroupLayout nomeCarta6Layout = new javax.swing.GroupLayout(nomeCarta6);
        nomeCarta6.setLayout(nomeCarta6Layout);
        nomeCarta6Layout.setHorizontalGroup(
            nomeCarta6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomeCarta6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nomeCarta6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bCustBen6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(bGosto6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bPreco6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bTeor6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(bAmnesia6, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(nomeCarta6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CustoBen6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Teor6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Preco6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Gosto6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Amnesia6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nomeCarta6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ImagemCarta6)
                .addGap(57, 57, 57))
        );
        nomeCarta6Layout.setVerticalGroup(
            nomeCarta6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomeCarta6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(ImagemCarta6)
                .addGap(18, 18, 18)
                .addGroup(nomeCarta6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bTeor6)
                    .addComponent(Teor6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bPreco6)
                    .addComponent(Preco6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bGosto6)
                    .addComponent(Gosto6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bAmnesia6)
                    .addComponent(Amnesia6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bCustBen6)
                    .addComponent(CustoBen6))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        nomeCarta7.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome_Carta"));

        bTeor7.setText("TeorAlcoólico");
        bTeor7.setEnabled(false);

        bCustBen7.setText("Custo Beneficio");
        bCustBen7.setEnabled(false);

        bGosto7.setText("Gosto");
        bGosto7.setEnabled(false);

        bPreco7.setText("Preço");
        bPreco7.setEnabled(false);

        ImagemCarta7.setText("sfsdfsdf");

        Teor7.setText("ata");

        Preco7.setText("ata");

        Gosto7.setText("ata");

        CustoBen7.setText("ata");

        bAmnesia7.setText("Amnesia");
        bAmnesia7.setEnabled(false);

        Amnesia7.setText("ata");

        javax.swing.GroupLayout nomeCarta7Layout = new javax.swing.GroupLayout(nomeCarta7);
        nomeCarta7.setLayout(nomeCarta7Layout);
        nomeCarta7Layout.setHorizontalGroup(
            nomeCarta7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomeCarta7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nomeCarta7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bCustBen7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(bGosto7, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(bPreco7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bTeor7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(bAmnesia7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(nomeCarta7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CustoBen7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Teor7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Preco7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Gosto7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Amnesia7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nomeCarta7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ImagemCarta7)
                .addGap(57, 57, 57))
        );
        nomeCarta7Layout.setVerticalGroup(
            nomeCarta7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomeCarta7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(ImagemCarta7)
                .addGap(18, 18, 18)
                .addGroup(nomeCarta7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bTeor7)
                    .addComponent(Teor7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bPreco7)
                    .addComponent(Preco7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bGosto7)
                    .addComponent(Gosto7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bAmnesia7)
                    .addComponent(Amnesia7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nomeCarta7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bCustBen7)
                    .addComponent(CustoBen7))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        TextoVencedor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        TextoVencedor.setToolTipText("");

        BotaoContinuar.setText("Continuar");
        BotaoContinuar.setToolTipText("");
        BotaoContinuar.setEnabled(false);
        BotaoContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoContinuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BotaoContinuar)
                    .addComponent(TextoVencedor))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(TextoVencedor)
                .addGap(74, 74, 74)
                .addComponent(BotaoContinuar)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        AtributoPc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AtributoPc.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelMaoJogador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelDeckUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(287, 287, 287)
                            .addComponent(nomeCarta6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(AtributoPc))
                            .addGap(18, 18, 18)
                            .addComponent(nomeCarta7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(panelMaoCpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jPanelDeckUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelMaoCpu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDeckUsuario1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomeCarta7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nomeCarta6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(AtributoPc)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDeckUsuario2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelMaoJogador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPcPreco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPcPreco1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPcPreco1ActionPerformed

    private void Mostrar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Mostrar
        // TODO add your handling:
    }//GEN-LAST:event_Mostrar

    private void enviarCartaBatalha(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enviarCartaBatalha

        
    }//GEN-LAST:event_enviarCartaBatalha

    private void bTeor1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bTeor1MouseClicked

    }//GEN-LAST:event_bTeor1MouseClicked

    private void bTeor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTeor1ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(0),3);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(0,null);
        }else{
            maoUsuario.set(0,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bTeor1ActionPerformed

    private void mouseClickedUsarCarta1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseClickedUsarCarta1
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        enviarBebidaBatalha(maoUsuario.get(0));
        if(deckUsuario.isEmpty()  == true){
            maoUsuario.set(0,null);
        }else{
            maoUsuario.set(0,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty() == true){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 1;
    }//GEN-LAST:event_mouseClickedUsarCarta1

    private void BotaoContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoContinuarActionPerformed
        nomeCarta6.setVisible(false);
        nomeCarta7.setVisible(false);
        TextoVencedor.setText("");
        panelMaoJogador.setVisible(true);
        BotaoContinuar.setEnabled(false);
        preencherMaoTela(maoUsuario);
        AtributoPc.setText("");
        if(turno == 1){
            turno = 0;
        }else{
            turno = 1;
        }
        mecanicaJogo();
    }//GEN-LAST:event_BotaoContinuarActionPerformed

    private void UsarCarta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsarCarta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsarCarta1ActionPerformed

    private void bPreco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPreco1ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(0),1);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(0,null);
        }else{
            maoUsuario.set(0,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bPreco1ActionPerformed

    private void bGosto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGosto1ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(0),2);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(0,null);
        }else{
            maoUsuario.set(0,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bGosto1ActionPerformed

    private void bAmnesia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAmnesia1ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(0),4);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(0,null);
        }else{
            maoUsuario.set(0,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bAmnesia1ActionPerformed

    private void bCustBen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCustBen1ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(0),5);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(0,null);
        }else{
            maoUsuario.set(0,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bCustBen1ActionPerformed

    private void UsarCarta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsarCarta2ActionPerformed
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        enviarBebidaBatalha(maoUsuario.get(1));
        if(deckUsuario.isEmpty()){
            maoUsuario.set(1,null);
        }else{
            maoUsuario.set(1,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 1;
    }//GEN-LAST:event_UsarCarta2ActionPerformed

    private void UsarCarta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsarCarta3ActionPerformed
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        enviarBebidaBatalha(maoUsuario.get(2));
        if(deckUsuario.isEmpty()){
            maoUsuario.set(2,null);
        }else{
            maoUsuario.set(2,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 1;
    }//GEN-LAST:event_UsarCarta3ActionPerformed

    private void UsarCarta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsarCarta4ActionPerformed
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        enviarBebidaBatalha(maoUsuario.get(3));
        if(deckUsuario.isEmpty()){
            maoUsuario.set(3,null);
        }else{
            maoUsuario.set(3,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 1;
    }//GEN-LAST:event_UsarCarta4ActionPerformed

    private void UsarCarta5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsarCarta5ActionPerformed
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        enviarBebidaBatalha(maoUsuario.get(4));
        if(deckUsuario.isEmpty()){
            maoUsuario.set(4,null);
        }else{
            maoUsuario.set(4,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 1;
    }//GEN-LAST:event_UsarCarta5ActionPerformed

    private void bTeor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTeor2ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(1),3);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(1,null);
        }else{
            maoUsuario.set(1,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bTeor2ActionPerformed

    private void bTeor3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTeor3ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(2),3);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(2,null);
        }else{
            maoUsuario.set(2,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bTeor3ActionPerformed

    private void bTeor4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTeor4ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(3),3);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(3,null);
        }else{
            maoUsuario.set(3,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bTeor4ActionPerformed

    private void bTeor5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTeor5ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(4),3);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(4,null);
        }else{
            maoUsuario.set(4,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bTeor5ActionPerformed

    private void bPreco2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPreco2ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(1),1);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(1,null);
        }else{
            maoUsuario.set(1,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bPreco2ActionPerformed

    private void bPreco3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPreco3ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(2),1);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(2,null);
        }else{
            maoUsuario.set(2,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bPreco3ActionPerformed

    private void bPreco4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPreco4ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(3),1);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(3,null);
        }else{
            maoUsuario.set(3,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bPreco4ActionPerformed

    private void bPreco5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPreco5ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(4),1);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(4,null);
        }else{
            maoUsuario.set(4,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bPreco5ActionPerformed

    private void bGosto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGosto2ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(1),2);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(1,null);
        }else{
            maoUsuario.set(1,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bGosto2ActionPerformed

    private void bGosto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGosto3ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(2),2);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(2,null);
        }else{
            maoUsuario.set(2,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bGosto3ActionPerformed

    private void bGosto4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGosto4ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(3),2);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(3,null);
        }else{
            maoUsuario.set(3,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bGosto4ActionPerformed

    private void bGosto5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGosto5ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(4),2);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(4,null);
        }else{
            maoUsuario.set(4,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bGosto5ActionPerformed

    private void bAmnesia2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAmnesia2ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(1),4);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(1,null);
        }else{
            maoUsuario.set(1,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bAmnesia2ActionPerformed

    private void bAmnesia3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAmnesia3ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(2),4);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(2,null);
        }else{
            maoUsuario.set(2,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bAmnesia3ActionPerformed

    private void bAmnesia4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAmnesia4ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(3),4);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(3,null);
        }else{
            maoUsuario.set(3,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bAmnesia4ActionPerformed

    private void bAmnesia5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAmnesia5ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(4),4);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(4,null);
        }else{
            maoUsuario.set(4,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bAmnesia5ActionPerformed

    private void bCustBen2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCustBen2ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(1),5);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(1,null);
        }else{
            maoUsuario.set(1,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bCustBen2ActionPerformed

    private void bCustBen3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCustBen3ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(2),5);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(2,null);
        }else{
            maoUsuario.set(2,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bCustBen3ActionPerformed

    private void bCustBen4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCustBen4ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(3),5);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(3,null);
        }else{
            maoUsuario.set(3,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bCustBen4ActionPerformed

    private void bCustBen5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCustBen5ActionPerformed
        enviarBebidaBatalhaUsuario(maoUsuario.get(4),5);
        nomeCarta6.setVisible(true);
        nomeCarta7.setVisible(true);
        if(deckUsuario.isEmpty()){
            maoUsuario.set(4,null);
        }else{
            maoUsuario.set(4,deckUsuario.dequeue());
        }
        if(deckPc.isEmpty()){
            maoPc.set(posicaoPc,null);
        }else{
            maoPc.set(posicaoPc,deckPc.dequeue());
        }
        turno = 0;
    }//GEN-LAST:event_bCustBen5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel Amnesia1;
    private static javax.swing.JLabel Amnesia2;
    private static javax.swing.JLabel Amnesia3;
    private static javax.swing.JLabel Amnesia4;
    private static javax.swing.JLabel Amnesia5;
    private static javax.swing.JLabel Amnesia6;
    private static javax.swing.JLabel Amnesia7;
    private static javax.swing.JLabel AtributoPc;
    private static javax.swing.JButton BotaoContinuar;
    private static javax.swing.JLabel CustoBen1;
    private static javax.swing.JLabel CustoBen2;
    private static javax.swing.JLabel CustoBen3;
    private static javax.swing.JLabel CustoBen4;
    private static javax.swing.JLabel CustoBen5;
    private static javax.swing.JLabel CustoBen6;
    private static javax.swing.JLabel CustoBen7;
    private static javax.swing.JLabel Gosto1;
    private static javax.swing.JLabel Gosto2;
    private static javax.swing.JLabel Gosto3;
    private static javax.swing.JLabel Gosto4;
    private static javax.swing.JLabel Gosto5;
    private static javax.swing.JLabel Gosto6;
    private static javax.swing.JLabel Gosto7;
    private static javax.swing.JLabel ImagemCarta;
    private static javax.swing.JLabel ImagemCarta1;
    private static javax.swing.JLabel ImagemCarta2;
    private static javax.swing.JLabel ImagemCarta3;
    private static javax.swing.JLabel ImagemCarta4;
    private static javax.swing.JLabel ImagemCarta5;
    private static javax.swing.JLabel ImagemCarta6;
    private static javax.swing.JLabel ImagemCarta7;
    private static javax.swing.JLabel Preco1;
    private static javax.swing.JLabel Preco2;
    private static javax.swing.JLabel Preco3;
    private static javax.swing.JLabel Preco4;
    private static javax.swing.JLabel Preco5;
    private static javax.swing.JLabel Preco6;
    private static javax.swing.JLabel Preco7;
    private static javax.swing.JLabel QtdDeckPc;
    private static javax.swing.JLabel QtdDeckUsu;
    private static javax.swing.JLabel Teor1;
    private static javax.swing.JLabel Teor2;
    private static javax.swing.JLabel Teor3;
    private static javax.swing.JLabel Teor4;
    private static javax.swing.JLabel Teor5;
    private static javax.swing.JLabel Teor6;
    private static javax.swing.JLabel Teor7;
    private static javax.swing.JLabel TextoVencedor;
    private static javax.swing.JButton UsarCarta1;
    private static javax.swing.JButton UsarCarta2;
    private static javax.swing.JButton UsarCarta3;
    private static javax.swing.JButton UsarCarta4;
    private static javax.swing.JButton UsarCarta5;
    private static javax.swing.JButton bAmnesia1;
    private static javax.swing.JButton bAmnesia2;
    private static javax.swing.JButton bAmnesia3;
    private static javax.swing.JButton bAmnesia4;
    private static javax.swing.JButton bAmnesia5;
    private static javax.swing.JButton bAmnesia6;
    private static javax.swing.JButton bAmnesia7;
    private static javax.swing.JButton bCustBen1;
    private static javax.swing.JButton bCustBen2;
    private static javax.swing.JButton bCustBen3;
    private static javax.swing.JButton bCustBen4;
    private static javax.swing.JButton bCustBen5;
    private static javax.swing.JButton bCustBen6;
    private static javax.swing.JButton bCustBen7;
    private static javax.swing.JButton bGosto1;
    private static javax.swing.JButton bGosto2;
    private static javax.swing.JButton bGosto3;
    private static javax.swing.JButton bGosto4;
    private static javax.swing.JButton bGosto5;
    private static javax.swing.JButton bGosto6;
    private static javax.swing.JButton bGosto7;
    private static javax.swing.JButton bPreco1;
    private static javax.swing.JButton bPreco2;
    private static javax.swing.JButton bPreco3;
    private static javax.swing.JButton bPreco4;
    private static javax.swing.JButton bPreco5;
    private static javax.swing.JButton bPreco6;
    private static javax.swing.JButton bPreco7;
    private static javax.swing.JButton bTeor1;
    private static javax.swing.JButton bTeor2;
    private static javax.swing.JButton bTeor3;
    private static javax.swing.JButton bTeor4;
    private static javax.swing.JButton bTeor5;
    private static javax.swing.JButton bTeor6;
    private static javax.swing.JButton bTeor7;
    private javax.swing.JButton btnPcCusto1;
    private javax.swing.JButton btnPcCusto2;
    private javax.swing.JButton btnPcCusto3;
    private javax.swing.JButton btnPcCusto4;
    private javax.swing.JButton btnPcCusto5;
    private javax.swing.JButton btnPcGosto1;
    private javax.swing.JButton btnPcGosto2;
    private javax.swing.JButton btnPcGosto3;
    private javax.swing.JButton btnPcGosto4;
    private javax.swing.JButton btnPcGosto5;
    private javax.swing.JButton btnPcPreco1;
    private javax.swing.JButton btnPcPreco2;
    private javax.swing.JButton btnPcPreco3;
    private javax.swing.JButton btnPcPreco4;
    private javax.swing.JButton btnPcPreco5;
    private javax.swing.JButton btnPcTAlcoolico1;
    private javax.swing.JButton btnPcTAlcoolico2;
    private javax.swing.JButton btnPcTAlcoolico3;
    private javax.swing.JButton btnPcTAlcoolico4;
    private javax.swing.JButton btnPcTAlcoolico5;
    private javax.swing.JPanel cartaPc1;
    private javax.swing.JPanel cartaPc2;
    private javax.swing.JPanel cartaPc3;
    private javax.swing.JPanel cartaPc4;
    private javax.swing.JPanel cartaPc5;
    private javax.swing.JLabel imgPc2;
    private javax.swing.JLabel imgPc3;
    private javax.swing.JLabel imgPc4;
    private javax.swing.JLabel imgPc5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelDeckUsuario1;
    private javax.swing.JPanel jPanelDeckUsuario2;
    private javax.swing.JLabel lblTeorPc1;
    private static javax.swing.JPanel nomeCarta1;
    private static javax.swing.JPanel nomeCarta2;
    private static javax.swing.JPanel nomeCarta3;
    private static javax.swing.JPanel nomeCarta4;
    private static javax.swing.JPanel nomeCarta5;
    private static javax.swing.JPanel nomeCarta6;
    private static javax.swing.JPanel nomeCarta7;
    private javax.swing.JPanel panelMaoCpu;
    private static javax.swing.JPanel panelMaoJogador;
    private static javax.swing.JLabel rtyrty;
    // End of variables declaration//GEN-END:variables
}
