/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperGole.model;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Adroan
 */
public class Bebidas {
    private int id;
    private String nome;
    private String image;
    private double TeorAlco;
    private double preco;
    private double custBene;
    private int gosto;
    private int Amnesia;
    protected  static ArrayList<Bebidas> deck = new ArrayList<Bebidas>();
    protected static int [] numerosSorteados = new int[32];

    public Bebidas(int id, String nome, String image, double TeorAlco, double preco, double custBene, int gosto, int Amnesia) {
        this.id = id;
        this.nome = nome;
        this.image = image;
        this.TeorAlco = TeorAlco;
        this.preco = preco;
        this.custBene = custBene;
        this.gosto = gosto;
        this.Amnesia = Amnesia;
    }
  public Bebidas() {
        }


    public static ArrayList<Bebidas> getDeck() {
        return deck;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getTeorAlco() {
        return TeorAlco;
    }

    public void setTeorAlco(double TeorAlco) {
        this.TeorAlco = TeorAlco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getCustBene() {
        return custBene;
    }

    public void setCustBene(double custBene) {
        this.custBene = custBene;
    }

    public int getGosto() {
        return gosto;
    }

    public void setGosto(int gosto) {
        this.gosto = gosto;
    }

    public int getAmnesia() {
        return Amnesia;
    }

    public void setAmnesia(int Amnesia) {
        this.Amnesia = Amnesia;
    }
    
    
    
    public static void gerarBebidas(){
        int [] id ={25,28,22,20,11,27,30,4,10,8,6,31,16,9,26,7,24,5,14,2,13,21,12,15,32,1,19,29,18,17,3,23};
        String[] nome = {"51","3 pipa","Absinto neto costa","absolut","amarula","Bacardi","carta oro","balakov","brahma",
        "catuaba selvagem","Cerveja Lassberg","Cerveja Saint Bier","corote","dreher","Jurupinga","Natasha","Nova Schin","Rajska","Remy Martin Louis XIII conhaque",
        "Run Captain Morgan","Saquê Junmai","Skol Beats","Smirnoff","Smirnoff ice","Tequila José Cuervo Ouro","Terere Alcoólico","toddynho do mal premium",
        "Tonturinha","Velho barreiro","Vinho Campo Largo Suave","Vodka Cîroc","Whisky Jack Daniels Honey","White horse"};
        Double[] teorAlcool = {39d, 37.5d, 53.5d, 40d, 17d, 38d, 38d, 4.8d, 14d, 4.8d, 5d, 39d, 38d, 10d, 38d, 4.8d, 37d, 40d, 35d, 16d, 7.9d, 37.5d, 5d, 38d, 50d, 4d, 36d, 39d, 10d, 40d, 35d, 40d};
        Double [] preco = {10d,4.99d,125d,119.9d,79d,39.9d,6.69d,3.5d,13.9d,10d,11d,3d,14.25d,23d,18.9d,6.55d,18d,40041.14d,65d,120d,5.49d,42d,5d,119.9d,9d,42000d,2d,75d,8d,10d,219.9d,199.9d,68.9d};
        Double[] custBene = {78.1d,90.6d,34.3d,28.1d,12.5d,59.3d,87.5d,43.7d,65.6d,40.6d,21.8d,93.7d,75d,31.2d,68.7d,53.1d,71.8d,3.1d,46.8d,6.2d,37.5d,56.2d,25d,18.75d,100d,0d,81.2d,84.3d,62.5d,9.3d,15.6d,50d};
        int [] gosto = {10,2,21,22,80,50,5,11,16,91,91,5,9,83,14,21,15,95,35,70,86,31,90,30,100,1,5,13,85,25,71,23};
        int [] amnesia ={61,76,98,91,83,85,87,26,30,4,4,82,32,58,89,10,90,0,73,55,5,88,5,92,100,1,60,62,43,93,67,80};
        int i = 0;
        iniciarArray(); // Seta todas as posições do vetor como null
        while(i < 32){
            Random gerador = new Random();
            Bebidas bebida = new Bebidas();
            bebida.setId(id[i]);
            bebida.setNome(nome[i]);
            bebida.setTeorAlco(teorAlcool[i]);
            bebida.setCustBene(custBene[i]);
            bebida.setGosto(gosto[i]);
            bebida.setAmnesia(amnesia[i]);
            boolean cartaInserida = false;
            while(cartaInserida == false){
              int numAleatorio = gerador.nextInt(32); // Gera um numero aleatório entre 0 e 31
                if(deck.get(numAleatorio) == null){ // Verifica se o deck na posição aleatória está null
                    deck.set(numAleatorio,bebida);
                    i += 1;
                    cartaInserida = true;
                }
            }


           
       }
        mostrarCartas(); // Mostra as cartas inseridas no vetor
    } 
     public static void main(String [] args){
         gerarBebidas();
     }
     public static void iniciarArray(){
         for(int i = 0; i < 32; i++){
             deck.add(i,null);
         }
     }
     public static void mostrarCartas(){
         for (int i = 0; i < 32; i++) {
             System.out.println("Posição: " + i + "  Carta: " + deck.get(i).getNome());
         }
     }

}
         
     
     
     

     

    

      
    

    

