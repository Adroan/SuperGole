/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperGole.control;

import SuperGole.model.Bebidas;
import java.util.ArrayList;
import linear.queue.LinkedQueue;

/**
 *
 * @author vinny
 */
public class IniciarJogo {
    protected static ArrayList<Bebidas> maoPc = new ArrayList<Bebidas>();
    protected static ArrayList<Bebidas> maoUsuario = new ArrayList<Bebidas>();
    protected static ArrayList<Bebidas> deck = new ArrayList<Bebidas>();
    protected static LinkedQueue<Bebidas> deckPc = new LinkedQueue<Bebidas>();
    protected static LinkedQueue<Bebidas> deckUsuario = new LinkedQueue<Bebidas>();

  

    public IniciarJogo() {
    
    }
    
    public static void criarDecks(){
        Bebidas bebida = new Bebidas();
        bebida.gerarBebidas();
        deck = bebida.getDeck();
        for(int i = 0; i < 32; i++){
            if( i < 16){
                deckUsuario.enqueue(deck.get(i));
            }else{
                deckPc.enqueue(deck.get(i));
            }
        }
    }
     public static void criarMao() {
        for(int i = 0; i < 5; i++){
            maoUsuario.add(deckUsuario.dequeue());
            maoPc.add(deckPc.dequeue());
        }
    }
     public static int batalha(Bebidas cartaPC, Bebidas cartaUsu, int atributo){
         switch(atributo){
             case 1:  if(cartaPC.getPreco() > cartaUsu.getPreco()){return -1;}else{return 1;}
             case 2:  if(cartaPC.getGosto() > cartaUsu.getGosto()){return 1;}else{return -1;}
             case 3:  if(cartaPC.getTeorAlco()> cartaUsu.getTeorAlco()){return 1;}else{return -1;}
             case 4:  if(cartaPC.getAmnesia()> cartaUsu.getAmnesia()){return 1;}else{return -1;}
             case 5:  if(cartaPC.getCustBene()> cartaUsu.getCustBene()){return 1;}else{return -1;}

             default: return 0;
         }
     }
    
    public static void main(String [] args){
        MecanicaPC pc = new MecanicaPC();
        int posicao = 0;
        criarDecks(); // Feito
        criarMao(); // Feito
        int cartaSelecionada = pc.verificarId(maoPc);
        for (int i = 0; i < 5; i++) {
            if(maoPc.get(i).getId() == cartaSelecionada){
                System.out.println("Melhor carta:  " + maoPc.get(i).getNome() + "  ID:  " + maoPc.get(i).getId() );
                posicao = i;
            }else{
                // System.out.println("Carta não escolhida:  " + maoPc.get(i).getNome()  + "  ID:  " + maoPc.get(i).getId() );
            }
        }
        String atributo = pc.verificarAtributo(maoPc.get(posicao));
        System.out.println("Nome:  " + maoPc.get(posicao).getNome());
        System.out.println("Preco:  " + maoPc.get(posicao).getPreco() + "    Media: " + pc.getMediaPreco());
        System.out.println("Gosto:  " + maoPc.get(posicao).getGosto() + "    Media: " + pc.getMediaGosto());
        System.out.println("Teor:  " + maoPc.get(posicao).getTeorAlco() + "    Media: " + pc.getMediaTeorAlcoolico());
        System.out.println("Amnesia:  " + maoPc.get(posicao).getAmnesia() + "    Media: " + pc.getMediaAmnesia());
        System.out.println("CustoBene:  " + maoPc.get(posicao).getCustBene() + "    Media: " + pc.getMediaCustoBeneficio());
        System.out.println("---------------------");
        System.out.println("Atributo:  " + atributo);

    }

    public static ArrayList<Bebidas> getMaoPc() {
        return maoPc;
    }

    public static ArrayList<Bebidas> getMaoUsuario() {
        return maoUsuario;
    }

    public static ArrayList<Bebidas> getDeck() {
        return deck;
    }

    public static LinkedQueue<Bebidas> getDeckPc() {
        return deckPc;
    }

    public static LinkedQueue<Bebidas> getDeckUsuario() {
        return deckUsuario;
    }
    
    
}
