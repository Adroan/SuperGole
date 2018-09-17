/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperGole.control;

import SuperGole.model.Bebidas;
import java.util.ArrayList;

/**
 *
 * @author vinny
 */
public class MecanicaPC {
    protected ArrayList<Bebidas> maoPc = new ArrayList<Bebidas>();
    protected static double mediaPreco = 46.11d; // Menor
    protected static double mediaTeorAlcoolico = 27.86d; // Maior
    protected static double mediaAmnesia = 57.17d; // Maior
    protected static double mediaGosto = 39.35d; // Maior
    protected static double mediaCustoBeneficio = 48.5d; // Maior

    protected static int atributoSelecionado = 0;

    public MecanicaPC() {
    }
    
    
    
   

    public ArrayList<Bebidas> getMaoPc() {
        return maoPc;
    }

    public static double getMediaPreco() {
        return mediaPreco;
    }

    public static double getMediaTeorAlcoolico() {
        return mediaTeorAlcoolico;
    }

    public static double getMediaAmnesia() {
        return mediaAmnesia;
    }

    public static double getMediaGosto() {
        return mediaGosto;
    }

    public static double getMediaCustoBeneficio() {
        return mediaCustoBeneficio;
    }



    
    public static int  verificarAtributo(Bebidas carta){
        double maiorDiferenca = 0;
        
        if((carta.getPreco() < mediaPreco) && ((mediaPreco - carta.getPreco()) > maiorDiferenca )){
            maiorDiferenca = mediaPreco - carta.getPreco();
            atributoSelecionado = 1;
        }
        if((carta.getGosto() > mediaGosto) && ((carta.getGosto() - mediaGosto) > maiorDiferenca)){
            maiorDiferenca = carta.getGosto() - mediaGosto;
            atributoSelecionado = 2;
        }
        if((carta.getTeorAlco() > mediaTeorAlcoolico) && ((carta.getTeorAlco() - mediaTeorAlcoolico) > maiorDiferenca)){
            maiorDiferenca = carta.getTeorAlco() - mediaTeorAlcoolico;
            atributoSelecionado = 3;
        }
        if((carta.getAmnesia()> mediaAmnesia) && ((carta.getAmnesia()- mediaAmnesia) > maiorDiferenca)){
            maiorDiferenca = carta.getAmnesia()- mediaAmnesia;
            atributoSelecionado = 4;
        }
        if((carta.getCustBene()> mediaCustoBeneficio) && ((carta.getCustBene()- mediaCustoBeneficio) > maiorDiferenca)){
            maiorDiferenca = carta.getCustBene()- mediaCustoBeneficio;
            atributoSelecionado = 5;
        }
        return atributoSelecionado;
    }

}
