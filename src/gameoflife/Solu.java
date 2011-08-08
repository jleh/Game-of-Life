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
    public void seuraavaTila() {
        
    }
    
    /**
     * Muuttaa solun tilan
     */
    public void muutaTila() {
        
    }
    
    public void asetaTila(boolean tila) {
        elossa = tila;
    }
}
