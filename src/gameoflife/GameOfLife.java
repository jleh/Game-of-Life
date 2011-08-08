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
    public int sukupolvi = 0;
    
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
        
        //Asetetaan naapurit
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                Solu[] naapurit = new Solu[8];
                //TODO Naapureiden asettaminen
                //Lisätään solut, ellei ruudukon ulkopuolella
                if((i-1) <= 0) //Vasemmalla ei soluja
                    naapurit[3] = null;
                else
                    naapurit[3] = ruudukko[i-1][j];

                if((i+1) == x) //Oikealla ei soluja
                    naapurit[4] = null;
                else
                    naapurit[4] = ruudukko[i+1][j];

                if((i-1) < 0 || (j-1) < 0) //Oikeassa yläkulma
                    naapurit[0] = null;
                else
                    naapurit[0] = ruudukko[i-1][j-1];

                if((j-1) < 0) //Yläpuoli
                    naapurit[1] = null;
                else
                    naapurit[1] = ruudukko[i][j-1];

                if((i+1) >= x || (j-1) < 0) //Vasen yläkulma
                    naapurit[2] = null;
                else
                    naapurit[2] = ruudukko[i+1][j-1];

                if((j+1) >= y)//Alapuoli
                    naapurit[6] = null;
                else
                    naapurit[6] = ruudukko[i][j+1];

                if((i-1) < 0 || (j+1) >= y) //Oikeassa alakulma
                    naapurit[5] = null;
                else
                    naapurit[5] = ruudukko[i-1][j+1];

                if((i+1) >= x || (j+1) >= y) //Vasen alakulma
                    naapurit[7] = null;
                else
                    naapurit[7] = ruudukko[i+1][j+1];

                ruudukko[i][j].lisaaNaapurit(naapurit);
            }
        }
    }
    
    public void setSolunTila(int x, int y, boolean tila) {
        if(x < ruudukkoX && x > ruudukkoX && y < ruudukkoY && y > ruudukkoY)
            System.out.println("Virheelliset parametrit");
        else
            ruudukko[x][y].asetaTila(tila);
    }
    
    
    /**
     * Simuloi yhden kierroksen
     */
    public void simuloiKierros() {
        //Haetaan solujen seuraavat tilat
        for(int x = 0; x < ruudukkoX; x++){
            for(int y = 0; y < ruudukkoY; y++) {
                ruudukko[x][y].seuraavaTila();
            }
        }

        //Muutetaan tilat
        for(int x = 0; x < ruudukkoX; x++){
            for(int y = 0; y < ruudukkoY; y++) {
                ruudukko[x][y].muutaTila();
            }
        }

        sukupolvi++; //Tieto monesko kierros menossa
    }
    
    public boolean getSolunTila(int x, int y) {
        return ruudukko[x][y].elossa;
    }
    
    public void tulostaRuudukko() {
        //Tulostaa ruudukon
        for(int x = 0; x < ruudukkoX; x++){
            for(int y = 0; y < ruudukkoY; y++) { 
                if(ruudukko[y][x].elossa == true)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Testailua
        GameOfLife peli = new GameOfLife(10, 10);
        peli.setSolunTila(5, 5, true);
        peli.setSolunTila(6, 5, true);
        peli.setSolunTila(7, 5, true);
        //System.out.println(peli.getSolunTila(5, 5));
        //System.out.println(peli.getSolunTila(4, 5));
        //System.out.println(peli.ruudukko[5][5].seuraavaTila());
        peli.tulostaRuudukko();
        peli.simuloiKierros();
        peli.tulostaRuudukko();
    }
}
