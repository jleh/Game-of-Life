/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

/**
 *
 * @author Juuso
 */
public class GameOfLife {

    public int ruudukkoX;
    public int ruudukkoY;
    public int simulointiNopeus;
    public Solu[][] ruudukko;
    
    /**
     * Alustaa pelin
     */
    
    public void alustaPeli(int x, int y) {
        ruudukkoX = x;
        ruudukkoY = y;
    }
    
    //Alustus toisella tavalla
    public GameOfLife(int x, int y) {
        ruudukkoX = x;
        ruudukkoY = y;
        
        ruudukko = new Solu[x][y]; //Ruudukon alustus
        
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                ruudukko[i][j] = new Solu();
            }
        }
    }
    
    public void setSolunTila(int x, int y, boolean tila) {
        //TODO virheenkäsittely
        ruudukko[x][y].asetaTila(tila);
    }
    
    
    /**
     * Simuloi yhden kierroksen
     */
    public void simuloiKierros() {
        //TODO Kierroksen simulointi
    }
    
    public boolean getSolunTila(int x, int y) {
        return ruudukko[x][y].elossa;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Testailua
        GameOfLife peli = new GameOfLife(10, 10);
        peli.setSolunTila(5, 5, true);
        System.out.println(peli.getSolunTila(5, 5));
        System.out.println(peli.getSolunTila(4, 5));
    }
}