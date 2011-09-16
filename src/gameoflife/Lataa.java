/*
 * Luokka aloitustilanteen lataamiseen tiedostosta
 * 
 */
package gameoflife;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Juuso
 */
public class Lataa {
    public int x;
    public int y;
    public ArrayList<tiedostosolu> alkusolut = new ArrayList<tiedostosolu>();
    private String tiedostonNimi;
    boolean virhe = false;

    /**
     * Lataa alkutilanteen tiedostosta
     * @param t 
     */
    public void lataa(String t) {
        if(t == null){ //Tiedoston nimeä ei anneta
            virhe = true;
            return;
        }
        
           System.out.println(t);
        
        tiedostonNimi = t;
        System.out.println("Ladataan tiedostosta");
        BufferedReader tiedosto;

        try { //Avataan tiedosto
            tiedosto = new BufferedReader(new FileReader(tiedostonNimi));
        }
        catch (FileNotFoundException e) {
            System.out.println("Tiedostoa ei löydy");
            virhe = true;
            return;
        }

        //Luetaan alueen koko tiedostosta
        try { //Alueen koko 1:llä ja 2:lla rivillä
            x = Integer.parseInt(tiedosto.readLine());
            y = x;
        }
        catch (IOException e) {
            return;
        }

        

        //Luetaan solut tiedostosta
        int soluX = 0;
        int soluY = 0;
        try {
            int merkki;
            while((merkki = tiedosto.read()) != -1){
                if(merkki == 42 && soluX < x && soluY < y) { //Elossa, karsitaan alueen
                    alkusolut.add(new tiedostosolu(soluX, soluY, true)); //ulkopuolella olevat pois
                }
                
                if(merkki == 10) { //Rivinvaihto
                    soluX = 0;
                    soluY++;
                }
                soluX++;
            }
        }
        catch (IOException e) {
            System.out.println("Lukuvirhe");
            return;
        }

    }
}
