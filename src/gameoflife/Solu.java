/*
 * Luokka solulle, eli yhdelle ruudulle
 * 
 */
package gameoflife;
import java.util.ArrayList;

/**
 *
 * @author Juuso
 */
public class Solu {
    public boolean elossa;
    public ArrayList<Solu> naapurit = new ArrayList<Solu>();
    public boolean seuraavaTila;
    
    public Solu() {
        elossa = false;
    }
    
    public void lisaaNaapurit(Solu[] solut) {
        for(int i = 0; i < 8; i++) {
            naapurit.add(solut[i]);
        }
    }
    
    /**
     * Määrittää solun seuraavan tilan
     */
    public boolean seuraavaTila() {
        if(getNaapureitaElossa() == 3 || getNaapureitaElossa() == 2)
            seuraavaTila = true;
        return seuraavaTila;
    }
    
    /**
     * Muuttaa solun tilan
     */
    public void muutaTila() {
        elossa = seuraavaTila;
    }
    
    public void asetaTila(boolean tila) {
        elossa = tila;
    }

    public void getNaapureidenTila() {
        
        for(int i = 0; i < 8; i++)
            if(naapurit.get(i) != null)
                System.out.println(naapurit.get(i).elossa);
    }

    public int getNaapureitaElossa() {
        int naapureitaElossa = 0;
        for(int i = 0; i < 8; i++)
            if(naapurit.get(i) != null)
                if(naapurit.get(i).elossa == true)
                    naapureitaElossa++;
        return naapureitaElossa;
    }
}
