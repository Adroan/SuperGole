/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperGole.model;



/**
 *
 * @author vinny
 */
public class TesteMain {
    protected static Bebidas arrayBebida = new Bebidas();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        arrayBebida.gerarBebidas();
        System.out.println(arrayBebida.getDeck().toString());
    }
    
}
