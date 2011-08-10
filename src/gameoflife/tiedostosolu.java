/*
 * Luokkaa käytetään alkutilanteen tiedostosta lataamiseen
 * 
 */

package gameoflife;

/**
 *
 * @author juusoleh
 */
public class tiedostosolu {
    public int x;
    public int y;
    public boolean elossa;

    public tiedostosolu(int i, int j, boolean e){
        x = i;
        y = j;
        elossa = e;
    }
}
