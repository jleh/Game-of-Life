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
    
    /**
     * Luo uuden solun
     */
    public Solu() {
        elossa = false;
    }
    
    /**
     * Lisää solulle naapurit, jotka annetaan parametrina
     * @param solut 
     */
    public void lisaaNaapurit(Solu[] solut) {
        for(int i = 0; i < 8; i++) {
            naapurit.add(solut[i]);
        }
    }
    
    /**
     * Määrittää solun seuraavan tilan
     * @return 
     */
    public boolean seuraavaTila() {
        seuraavaTila = false;
        int elavatNaapurit = getNaapureitaElossa();
        if(elavatNaapurit == 3 || elavatNaapurit == 2 && elossa == true)
            seuraavaTila = true; //Pysyy hengissä
        if(elossa == false && elavatNaapurit == 3) //Syntyminen
            seuraavaTila = true;
        return seuraavaTila;
    }
    
    /**
     * Muuttaa solun tilan
     */
    public void muutaTila() {
        elossa = seuraavaTila;
    }
    
    /**
     * Asettaa solulle parametrina annetun tilan
     * @param tila 
     */
    public void asetaTila(boolean tila) {
        elossa = tila;
    }

    /**
     * Selvittää solun naapureiden tilan
     */
    public void getNaapureidenTila() {
        
        for(int i = 0; i < 8; i++)
            if(naapurit.get(i) != null)
                System.out.println(naapurit.get(i).elossa);
    }

    /**
     * Laskee montako elossa olevaa naapuria solulla on
     * @return 
     */
    public int getNaapureitaElossa() {
        int naapureitaElossa = 0;
        for(int i = 0; i < 8; i++)
            if(naapurit.get(i) != null)
                if(naapurit.get(i).elossa == true)
                    naapureitaElossa++;
        return naapureitaElossa;
    }
}
