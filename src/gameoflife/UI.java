/*
 * Luokka käyttöliittymälle
 * 
 */
package gameoflife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Juuso
 */
public class UI extends JFrame {
    
    private JButton aloita;
    private JButton lopeta;
    private JButton poistu;
    
    public UI(final GameOfLife peli) {
        aloita = new JButton("Aloita");
        lopeta = new JButton("Pysäytä");
        poistu = new JButton("Sulje");
        
        aloita.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tapahtuma) {
                        peli.ajaSimulaatiota(peli);
                    }
                });
        
        lopeta.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tapahtuma) {
                        peli.kaynnissa = false;
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
}
