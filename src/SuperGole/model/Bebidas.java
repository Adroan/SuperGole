/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperGole.model;

import java.util.Random;

/**
 *
 * @author Adroan
 */
public class Bebidas {
    private int id;
    private String nome;
    private String image;
    private float TeorAlco;
    private float preco;
    private float custBene;
    private int gosto;
    private int Amnesia;
    
    
    public static void gerarBebidas(){
        Random gerador = new Random();
        
        String[] nome = {"51","3 pipa","Absinto neto costa","absolut","amarula","Bacardi","carta oro","balakov","brahma",
"catuaba selvagem","Cerveja Lassberg","Cerveja Saint Bier","corote","dreher","Jurupinga","Natasha","Nova Schin","Rajska","Remy Martin Louis XIII conhaque",
"Run Captain Morgan","Saquê Junmai","Skol Beats","Smirnoff","Smirnoff ice","Tequila José Cuervo Ouro","Terere Alcoólico","toddynho do mal premium",
"Tonturinha","Velho barreiro","Vinho Campo Largo Suave","Vodka Cîroc","Whisky Jack Daniels Honey","White horse"};
        Double[] teorAlcool = {39d, 37.5d, 53.5d, 40d, 17d, 38d, 38d, 4.8d, 14d, 4.8d, 5d, 39d, 38d, 10d, 38d, 4.8d, 37d, 40d, 35d, 16d, 7.9d, 37.5d, 5d, 38d, 55d, 4d, 36d, 39d, 10d, 40d, 35d, 40d};
        Double [] preco = {10d,4.99d,125d,119.9d,79d,39.9d,6.69d,3.5d,13.9d,10d,11d,3d,14.25d,23d,18.9d,6.55d,18d,40041.14d,65d,120d,5.49d,42d,5d,119.9d,2d,42000d,2d,75d,8d,10d,219.9d,199.9d,68.9d};
        Double[] custBene = {};
        int [] gosto = {};
        int [] amnesia ={};
    } 
}
