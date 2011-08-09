/*
 * Luokka käyttöliittymälle
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
    public Timer ajastin;
    
    public UI(final GameOfLife peli) {
        aloita = new JButton("Aloita");
        lopeta = new JButton("Pysäytä");
        poistu = new JButton("Sulje");
        
        
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
        
        setLayout(new GridLayout(3,1));
        add(aloita);
        add(lopeta);
        add(poistu);
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
