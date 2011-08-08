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

    public void lataa(String t) {
        tiedostonNimi = t;
        System.out.println("Ladataan tiedostosta");
        BufferedReader tiedosto;

        try {
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
            y = Integer.parseInt(tiedosto.readLine());
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
                if(merkki == 42) { //Elossa
                    //System.out.print("*");
                    alkusolut.add(new tiedostosolu(soluX, soluY, true));
                }
//                if(merkki == 32) //Kuollut
//                    System.out.print("_");
                if(merkki == 10) { //Rivinvaihto
                    soluX = 0;
                    soluY++;
                }
                soluX++;
                //System.out.print(merkki + " ");
            }
        }
        catch (IOException e) {
            System.out.println("Lukuvirhe");
            return;
        }

    }
}
