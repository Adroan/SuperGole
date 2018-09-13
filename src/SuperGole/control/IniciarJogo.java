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
    
    public static void main(String [] args){
        criarDecks(); // Feito
        criarMao();

    }
    
    
}
