/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperGole.control;

import SuperGole.model.Bebidas;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
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
    
    public static void criarDecks(){ //  Separa o deck principal ao meio para o usuário e o pc
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
     public static void criarMao() { // Cria as primeiras 5 cartas do usuario e pc
        for(int i = 0; i < 5; i++){
            maoUsuario.add(deckUsuario.dequeue());
            maoPc.add(deckPc.dequeue());
        }   
    }
     
     
     public static void vitoriaBatalha(LinkedQueue<Bebidas> deck,Bebidas cartaWin, Bebidas cartaLose){
         deck.enqueue(cartaWin);
         deck.enqueue(cartaLose);
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
    
//    public static void main(String [] args){
        
 
        
    

//    }

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
