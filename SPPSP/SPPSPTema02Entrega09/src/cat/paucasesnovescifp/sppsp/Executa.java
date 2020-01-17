/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.paucasesnovescifp.sppsp;


import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jaumecampsfornari
 */

public class Executa extends Applet implements Runnable,ActionListener {
    private long comptador = 0;
    private long hor,min,seg = 0;
    private Thread fil = null;
    private boolean actiu;
    private Button b1,b2;
    private Font font;

    public void init() {
        setBackground(Color.cyan);
        font = new Font("Verdana",Font.BOLD,26);
        add(b1 = new Button("  Iniciar  "));
        b1.addActionListener(this);
        add(b2 = new Button("Aturar"));
        b2.addActionListener(this);
    }

    public void run() {

        try {
            while (actiu) {
                Thread.sleep(1000);
                seg = comptador++;
                if (seg >= 60) {
                    seg = 0;
                    comptador=0;
                    min++;
                }
                if (min >= 60) {
                    min = 0;
                    hor++;

                }
                repaint();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void actionPerformed (ActionEvent e) {
        if(e.getSource() == b1){
            actiu = true;
            fil = new Thread(this);
            fil.start();
        }
        if(e.getSource() == b2){
            actiu = false;
        }
    }

    public void paint(Graphics g) {
        g.clearRect(0, 0, 400, 400);
        g.setFont(font);

        if(seg >= 10){
            g.drawString("0"+hor+":0"+min+":"+seg, 80, 100);
        }else if(min >= 10){
            g.drawString("0"+hor+":"+min+":0"+seg, 80, 100);
        }else if(hor >= 10){
            g.drawString(hor+":0"+min+":0"+seg, 80, 100);
        } else{
            g.drawString("0"+hor+":0"+min+":0"+seg, 80, 100);
        }
    }

}