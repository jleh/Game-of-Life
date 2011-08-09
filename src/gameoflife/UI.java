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
    private JLabel alue = new JLabel("");
    
    public UI(final GameOfLife peli) {
        aloita = new JButton("Aloita");
        lopeta = new JButton("Pysäytä");
        poistu = new JButton("Sulje");
        alue.setText("No voi lol");
        
        
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
        
        JPanel napit = new JPanel(new GridLayout(1,30));
        napit.add(aloita);
        napit.add(lopeta);
        napit.add(poistu);
        
        this.setLayout(new BorderLayout(200,200));
        this.add("North", napit);
        this.add("South", alue);
    }
    
    public void piirraTilanne(String tilanne) {
        alue.setText(tilanne);
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
