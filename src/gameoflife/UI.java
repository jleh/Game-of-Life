/*
 * Luokka graafiselle käyttöliittymälle
 * 
 */
package gameoflife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Juuso
 */
public class UI extends JFrame {
    
    private JButton aloita;
    private JButton lopeta;
    private JButton poistu;
    private JButton muutaAika;
    private JButton lataaTiedostosta;
    public Timer ajastin;
    private JLabel alue = new JLabel("");
    private JLabel sukupolvi = new JLabel("Sukupolvi: 0");
    
    public UI(final GameOfLife peli) {
        aloita = new JButton("Aloita");
        lopeta = new JButton("Pysäytä");
        poistu = new JButton("Sulje");
        muutaAika = new JButton("Muuta nopeutta");
        lataaTiedostosta = new JButton("Lataa tilanne tiedostosta");
        
        
        aloita.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tapahtuma) {
                        ajastin = new Timer();
                        ajastin.schedule(new simuloi(peli), peli.nopeus);
                    }
                });
        
        lopeta.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tapahtuma) {
                        ajastin.cancel();
                        ajastin.purge();
                    }
                });
        
        poistu.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tapahtuma) {
                        System.exit(0);
                    }
                });

        muutaAika.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tapahtuma) {
                        peli.asetaNopeus();
                    }
                });

        lataaTiedostosta.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tapahtuma) {
                        peli.lataaTiedostosta();
                        peli.piirraTilanne();
                    }
                });
             
        JPanel napit = new JPanel(new GridLayout(1,30));
        napit.add(aloita);
        napit.add(lopeta);
        napit.add(muutaAika);
        napit.add(lataaTiedostosta);
        napit.add(poistu);
        
        this.setLayout(new BorderLayout(20,20));
        this.add("North", napit);
        this.add(sukupolvi);
//        this.add("Center", alue);
    }
    
    /**
     * Piirtää tilanteen JLabeliin
     * Ei käytössä, mutta mukana jatkokehitystä varten
     * @param tilanne 
     */
    public void piirraTilanne(String tilanne) {
        alue.setText(tilanne);
    }
    
    /**
     * Vaihtaa käyttäjälle näkyvän tiedon sukupolvesta oikeaksi
     * @param s 
     */
    public void muutaSukupolvea(int s){
        sukupolvi.setText("Sukupolvi: " + s);
    }
    
    class simuloi extends TimerTask {
        GameOfLife game;
    
        public simuloi(GameOfLife peli) {
            game = peli;
        }
    
        public void run() {
            game.simuloiKierros();
            uusiKierros();
        }
        
        public void uusiKierros(){
            ajastin.schedule(new simuloi(game), game.nopeus);
        }
    }

}
