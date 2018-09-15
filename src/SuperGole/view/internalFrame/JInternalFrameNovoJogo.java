/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperGole.view.internalFrame;

import SuperGole.control.IniciarJogo;
import SuperGole.model.Bebidas;
import SuperGole.view.panels.JpanelDeck;
import SuperGole.view.panels.jpanelCarta;
import SuperGole.view.panels.jpanelMao;
import java.awt.Color;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
       IniciarJogo jogo = new IniciarJogo();
       jogo.criarDecks();
       jogo.criarMao();
       deckPc = jogo.getDeckPc();
       deckUsuario = jogo.getDeckUsuario();
       maoPc = jogo.getMaoPc();
       maoUsuario = jogo.getMaoUsuario();
       int turno = jogo.sorteioInicio();
       preencherMaoTela(maoUsuario);
       while(maoPc.isEmpty() == false || maoUsuario.isEmpty() == false){
           if(turno == 1){ // Vez do jogador
               MostrarBotaoAtributo();
           }else if(turno == -1){ // Vez do pc
               EsconderBotaoAtributo();
           }
       }
        
    }
    
    private static void preencherMaoTela(ArrayList<Bebidas> maoUsuario){
        setCarta(Teor1,Preco1,Gosto1,Amnesia1,CustoBen1,maoUsuario.get(0),nomeCarta1,ImagemCarta);
        setCarta(Teor2,Preco2,Gosto2,Amnesia2,CustoBen2,maoUsuario.get(1),nomeCarta2,ImagemCarta2);
        setCarta(Teor3,Preco3,Gosto3,Amnesia3,CustoBen3,maoUsuario.get(2),nomeCarta3,ImagemCarta3);
        setCarta(Teor4,Preco4,Gosto4,Amnesia4,CustoBen4,maoUsuario.get(3),nomeCarta4,ImagemCarta4);
        setCarta(Teor5,Preco5,Gosto5,Amnesia5,CustoBen5,maoUsuario.get(4),nomeCarta5,ImagemCarta5);
    }
    
    private static void setCarta(JLabel teor,JLabel preco, JLabel gosto, JLabel amnesia, JLabel custBen,Bebidas carta, JPanel nome, JLabel imagem ){
        URL url = Bebidas.class.getResource(carta.getImage());
        ImageIcon icone = new ImageIcon(url);
        teor.setText(String.valueOf(carta.getTeorAlco()));
        preco.setText(String.valueOf(carta.getPreco()));
        gosto.setText(String.valueOf(carta.getGosto()));
        amnesia.setText(String.valueOf(carta.getAmnesia()));
        custBen.setText(String.valueOf(carta.getCustBene()));
        nome.setBorder(javax.swing.BorderFactory.createTitledBorder(carta.getNome()));
        imagem.setIcon(icone);
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
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cartaSelecionadaCpu = new javax.swing.JPanel();
        pcCartaSelecionada = new javax.swing.JPanel();
        btnPcSelectTAlcoolico1 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();
        btnPcGostoSelect = new javax.swing.JButton();
        jButton66 = new javax.swing.JButton();
        imgPcSelect = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cartaSelecionadaUsuario = new javax.swing.JPanel();
        usuarioCartaSelecionada = new javax.swing.JPanel();
        btnUserSelectTAlcoolico1 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        btnUserGostoSelect = new javax.swing.JButton();
        btnUserSelectPreco = new javax.swing.JButton();
        imgUserSelect = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
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
        panelMaoCpu1 = new javax.swing.JPanel();
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

        cartaSelecionadaCpu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selected Card", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Eras Light ITC", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N

        pcCartaSelecionada.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome_Carta"));

        btnPcSelectTAlcoolico1.setText("TeorAlcoólico");

        jButton64.setText("Custo Beneficio");

        btnPcGostoSelect.setText("Gosto");

        jButton66.setText("Preço");

        imgPcSelect.setText("jLabel8");

        jLabel38.setText("ata");

        jLabel39.setText("ata");

        jLabel40.setText("ata");

        jLabel41.setText("ata");

        javax.swing.GroupLayout pcCartaSelecionadaLayout = new javax.swing.GroupLayout(pcCartaSelecionada);
        pcCartaSelecionada.setLayout(pcCartaSelecionadaLayout);
        pcCartaSelecionadaLayout.setHorizontalGroup(
            pcCartaSelecionadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcCartaSelecionadaLayout.createSequentialGroup()
                .addGroup(pcCartaSelecionadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pcCartaSelecionadaLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(imgPcSelect)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pcCartaSelecionadaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pcCartaSelecionadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton64, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(btnPcGostoSelect, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton66, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPcSelectTAlcoolico1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pcCartaSelecionadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pcCartaSelecionadaLayout.createSequentialGroup()
                                .addGap(0, 4, Short.MAX_VALUE)
                                .addComponent(jLabel41))
                            .addGroup(pcCartaSelecionadaLayout.createSequentialGroup()
                                .addGroup(pcCartaSelecionadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel40)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel38))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        pcCartaSelecionadaLayout.setVerticalGroup(
            pcCartaSelecionadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pcCartaSelecionadaLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(imgPcSelect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pcCartaSelecionadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPcSelectTAlcoolico1)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pcCartaSelecionadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton66)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pcCartaSelecionadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPcGostoSelect)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pcCartaSelecionadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton64)
                    .addComponent(jLabel41))
                .addContainerGap())
        );

        javax.swing.GroupLayout cartaSelecionadaCpuLayout = new javax.swing.GroupLayout(cartaSelecionadaCpu);
        cartaSelecionadaCpu.setLayout(cartaSelecionadaCpuLayout);
        cartaSelecionadaCpuLayout.setHorizontalGroup(
            cartaSelecionadaCpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartaSelecionadaCpuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pcCartaSelecionada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cartaSelecionadaCpuLayout.setVerticalGroup(
            cartaSelecionadaCpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pcCartaSelecionada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SuperGole/view/images/VERSUS Graphic50.png"))); // NOI18N

        cartaSelecionadaUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selected Card", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Eras Light ITC", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N

        usuarioCartaSelecionada.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome_Carta"));

        btnUserSelectTAlcoolico1.setText("TeorAlcoólico");

        jButton61.setText("Custo Beneficio");

        btnUserGostoSelect.setText("Gosto");

        btnUserSelectPreco.setText("Preço");

        imgUserSelect.setText("jLabel7");

        jLabel34.setText("ata");

        jLabel35.setText("ata");

        jLabel36.setText("ata");

        jLabel37.setText("ata");

        javax.swing.GroupLayout usuarioCartaSelecionadaLayout = new javax.swing.GroupLayout(usuarioCartaSelecionada);
        usuarioCartaSelecionada.setLayout(usuarioCartaSelecionadaLayout);
        usuarioCartaSelecionadaLayout.setHorizontalGroup(
            usuarioCartaSelecionadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usuarioCartaSelecionadaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(usuarioCartaSelecionadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton61, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(btnUserGostoSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUserSelectPreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usuarioCartaSelecionadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(usuarioCartaSelecionadaLayout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(imgUserSelect))
                        .addComponent(btnUserSelectTAlcoolico1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(usuarioCartaSelecionadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(jLabel36)
                    .addComponent(jLabel35)
                    .addComponent(jLabel34))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        usuarioCartaSelecionadaLayout.setVerticalGroup(
            usuarioCartaSelecionadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usuarioCartaSelecionadaLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(imgUserSelect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(usuarioCartaSelecionadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUserSelectTAlcoolico1)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(usuarioCartaSelecionadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUserSelectPreco)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(usuarioCartaSelecionadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUserGostoSelect)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(usuarioCartaSelecionadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton61)
                    .addComponent(jLabel37))
                .addContainerGap())
        );

        javax.swing.GroupLayout cartaSelecionadaUsuarioLayout = new javax.swing.GroupLayout(cartaSelecionadaUsuario);
        cartaSelecionadaUsuario.setLayout(cartaSelecionadaUsuarioLayout);
        cartaSelecionadaUsuarioLayout.setHorizontalGroup(
            cartaSelecionadaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cartaSelecionadaUsuarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(usuarioCartaSelecionada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        cartaSelecionadaUsuarioLayout.setVerticalGroup(
            cartaSelecionadaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartaSelecionadaUsuarioLayout.createSequentialGroup()
                .addComponent(usuarioCartaSelecionada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout jPanelDeckUsuario1Layout = new javax.swing.GroupLayout(jPanelDeckUsuario1);
        jPanelDeckUsuario1.setLayout(jPanelDeckUsuario1Layout);
        jPanelDeckUsuario1Layout.setHorizontalGroup(
            jPanelDeckUsuario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 154, Short.MAX_VALUE)
        );
        jPanelDeckUsuario1Layout.setVerticalGroup(
            jPanelDeckUsuario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelMaoCpu1.setBackground(new java.awt.Color(153, 255, 153));
        panelMaoCpu1.setBorder(javax.swing.BorderFactory.createTitledBorder("Mão"));

        nomeCarta1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome_Carta"));

        bTeor1.setText("TeorAlcoólico");

        bCustBen1.setText("Custo Beneficio");

        bGosto1.setText("Gosto");

        bPreco1.setText("Preço");

        ImagemCarta.setText("sfsdfsdf");

        Teor1.setText("ata");

        Preco1.setText("ata");

        Gosto1.setText("ata");

        CustoBen1.setText("ata");

        bAmnesia1.setText("Amnesia");

        Amnesia1.setText("ata");

        UsarCarta1.setText("Usar Carta");
        UsarCarta1.setToolTipText("");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(UsarCarta1))
        );

        nomeCarta3.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome_Carta"));

        bTeor3.setText("TeorAlcoólico");

        bCustBen3.setText("Custo Beneficio");

        bGosto3.setText("Gosto");

        bPreco3.setText("Preço");

        ImagemCarta3.setText("sfsdfsdf");

        Teor3.setText("ata");

        Preco3.setText("ata");

        Gosto3.setText("ata");

        CustoBen3.setText("ata");

        bAmnesia3.setText("Amnesia");

        Amnesia3.setText("ata");

        UsarCarta3.setText("Usar Carta");
        UsarCarta3.setToolTipText("");

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

        bCustBen2.setText("Custo Beneficio");

        bGosto2.setText("Gosto");

        bPreco2.setText("Preço");

        ImagemCarta2.setText("sfsdfsdf");

        Teor2.setText("ata");

        Preco2.setText("ata");

        Gosto2.setText("ata");

        CustoBen2.setText("ata");

        bAmnesia2.setText("Amnesia");

        Amnesia2.setText("ata");

        UsarCarta2.setText("Usar Carta");
        UsarCarta2.setToolTipText("");

        javax.swing.GroupLayout nomeCarta2Layout = new javax.swing.GroupLayout(nomeCarta2);
        nomeCarta2.setLayout(nomeCarta2Layout);
        nomeCarta2Layout.setHorizontalGroup(
            nomeCarta2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomeCarta2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nomeCarta2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UsarCarta2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
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

        bCustBen4.setText("Custo Beneficio");

        bGosto4.setText("Gosto");

        bPreco4.setText("Preço");

        ImagemCarta4.setText("sfsdfsdf");

        Teor4.setText("ata");

        Preco4.setText("ata");

        Gosto4.setText("ata");

        CustoBen4.setText("ata");

        bAmnesia4.setText("Amnesia");

        Amnesia4.setText("ata");

        UsarCarta4.setText("Usar Carta");
        UsarCarta4.setToolTipText("");

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

        bCustBen5.setText("Custo Beneficio");

        bGosto5.setText("Gosto");

        bPreco5.setText("Preço");

        ImagemCarta5.setText("sfsdfsdf");

        Teor5.setText("ata");

        Preco5.setText("ata");

        Gosto5.setText("ata");

        CustoBen5.setText("ata");

        bAmnesia5.setText("Amnesia");

        Amnesia5.setText("ata");

        UsarCarta5.setText("Usar Carta");
        UsarCarta5.setToolTipText("");

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
                .addComponent(UsarCarta5))
        );

        javax.swing.GroupLayout panelMaoCpu1Layout = new javax.swing.GroupLayout(panelMaoCpu1);
        panelMaoCpu1.setLayout(panelMaoCpu1Layout);
        panelMaoCpu1Layout.setHorizontalGroup(
            panelMaoCpu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMaoCpu1Layout.createSequentialGroup()
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
        panelMaoCpu1Layout.setVerticalGroup(
            panelMaoCpu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nomeCarta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nomeCarta3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nomeCarta2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nomeCarta4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nomeCarta5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        nomeCarta1.getAccessibleContext().setAccessibleName("Nome_Carta2");
        nomeCarta1.getAccessibleContext().setAccessibleDescription("");

        jPanelDeckUsuario2.setBorder(javax.swing.BorderFactory.createTitledBorder("Deck"));

        javax.swing.GroupLayout jPanelDeckUsuario2Layout = new javax.swing.GroupLayout(jPanelDeckUsuario2);
        jPanelDeckUsuario2.setLayout(jPanelDeckUsuario2Layout);
        jPanelDeckUsuario2Layout.setHorizontalGroup(
            jPanelDeckUsuario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        jPanelDeckUsuario2Layout.setVerticalGroup(
            jPanelDeckUsuario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(cartaSelecionadaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)
                        .addGap(40, 40, 40)
                        .addComponent(cartaSelecionadaCpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelMaoCpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelDeckUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelMaoCpu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelDeckUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cartaSelecionadaCpu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cartaSelecionadaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel1)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDeckUsuario2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelMaoCpu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPcPreco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPcPreco1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPcPreco1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel Amnesia1;
    private static javax.swing.JLabel Amnesia2;
    private static javax.swing.JLabel Amnesia3;
    private static javax.swing.JLabel Amnesia4;
    private static javax.swing.JLabel Amnesia5;
    private static javax.swing.JLabel CustoBen1;
    private static javax.swing.JLabel CustoBen2;
    private static javax.swing.JLabel CustoBen3;
    private static javax.swing.JLabel CustoBen4;
    private static javax.swing.JLabel CustoBen5;
    private static javax.swing.JLabel Gosto1;
    private static javax.swing.JLabel Gosto2;
    private static javax.swing.JLabel Gosto3;
    private static javax.swing.JLabel Gosto4;
    private static javax.swing.JLabel Gosto5;
    private static javax.swing.JLabel ImagemCarta;
    private static javax.swing.JLabel ImagemCarta1;
    private static javax.swing.JLabel ImagemCarta2;
    private static javax.swing.JLabel ImagemCarta3;
    private static javax.swing.JLabel ImagemCarta4;
    private static javax.swing.JLabel ImagemCarta5;
    private static javax.swing.JLabel Preco1;
    private static javax.swing.JLabel Preco2;
    private static javax.swing.JLabel Preco3;
    private static javax.swing.JLabel Preco4;
    private static javax.swing.JLabel Preco5;
    private static javax.swing.JLabel Teor1;
    private static javax.swing.JLabel Teor2;
    private static javax.swing.JLabel Teor3;
    private static javax.swing.JLabel Teor4;
    private static javax.swing.JLabel Teor5;
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
    private static javax.swing.JButton bCustBen1;
    private static javax.swing.JButton bCustBen2;
    private static javax.swing.JButton bCustBen3;
    private static javax.swing.JButton bCustBen4;
    private static javax.swing.JButton bCustBen5;
    private static javax.swing.JButton bGosto1;
    private static javax.swing.JButton bGosto2;
    private static javax.swing.JButton bGosto3;
    private static javax.swing.JButton bGosto4;
    private static javax.swing.JButton bGosto5;
    private static javax.swing.JButton bPreco1;
    private static javax.swing.JButton bPreco2;
    private static javax.swing.JButton bPreco3;
    private static javax.swing.JButton bPreco4;
    private static javax.swing.JButton bPreco5;
    private static javax.swing.JButton bTeor1;
    private static javax.swing.JButton bTeor2;
    private static javax.swing.JButton bTeor3;
    private static javax.swing.JButton bTeor4;
    private static javax.swing.JButton bTeor5;
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
    private javax.swing.JButton btnPcGostoSelect;
    private javax.swing.JButton btnPcPreco1;
    private javax.swing.JButton btnPcPreco2;
    private javax.swing.JButton btnPcPreco3;
    private javax.swing.JButton btnPcPreco4;
    private javax.swing.JButton btnPcPreco5;
    private javax.swing.JButton btnPcSelectTAlcoolico1;
    private javax.swing.JButton btnPcTAlcoolico1;
    private javax.swing.JButton btnPcTAlcoolico2;
    private javax.swing.JButton btnPcTAlcoolico3;
    private javax.swing.JButton btnPcTAlcoolico4;
    private javax.swing.JButton btnPcTAlcoolico5;
    private javax.swing.JButton btnUserGostoSelect;
    private javax.swing.JButton btnUserSelectPreco;
    private javax.swing.JButton btnUserSelectTAlcoolico1;
    private javax.swing.JPanel cartaPc1;
    private javax.swing.JPanel cartaPc2;
    private javax.swing.JPanel cartaPc3;
    private javax.swing.JPanel cartaPc4;
    private javax.swing.JPanel cartaPc5;
    private javax.swing.JPanel cartaSelecionadaCpu;
    private javax.swing.JPanel cartaSelecionadaUsuario;
    private javax.swing.JLabel imgPc2;
    private javax.swing.JLabel imgPc3;
    private javax.swing.JLabel imgPc4;
    private javax.swing.JLabel imgPc5;
    private javax.swing.JLabel imgPcSelect;
    private javax.swing.JLabel imgUserSelect;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton66;
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
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JPanel jPanelDeckUsuario1;
    private javax.swing.JPanel jPanelDeckUsuario2;
    private javax.swing.JLabel lblTeorPc1;
    private static javax.swing.JPanel nomeCarta1;
    private static javax.swing.JPanel nomeCarta2;
    private static javax.swing.JPanel nomeCarta3;
    private static javax.swing.JPanel nomeCarta4;
    private static javax.swing.JPanel nomeCarta5;
    private javax.swing.JPanel panelMaoCpu;
    private javax.swing.JPanel panelMaoCpu1;
    private javax.swing.JPanel pcCartaSelecionada;
    private static javax.swing.JLabel rtyrty;
    private javax.swing.JPanel usuarioCartaSelecionada;
    // End of variables declaration//GEN-END:variables
}
