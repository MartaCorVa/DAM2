package cat.paucasesnovescifp.sppsp;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public class Executa extends Applet implements ActionListener {

    private Font font;
    public static long comptador1 = 0;
    public static long comptador2 = 0;
    private Button b1, b2;
    private boolean activa = false;
    private boolean activa2 = false;

    //L'init es el primer que s'inicia i s'encarrega d'asignar una font, un color de fons, inicialitzar el botons i la finestra.
    @Override
    public void init() {
        setBackground(Color.LIGHT_GRAY);
        font = new Font("Arial", Font.ITALIC, 32);
        setFont(font);
        setSize(new Dimension(1280, 720));
        add(b1 = new Button("Iniciar Fil 1"));
        b1.addActionListener((ActionListener) this);
        add(b2 = new Button("Iniciar Fil 2"));
        b2.addActionListener(this);

    }

    //Aquest mètode dibuixa les dues variables contador
    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, 400, 400);
        g.drawString(Long.toString(comptador1), 80, 100);
        g.drawString(Long.toString(comptador2), 80, 200);
    }

    //Aquest mètode permet executar totes les accions pertinents quan s'ha polsat algun botó
    @Override
    public void actionPerformed(ActionEvent e) {
        Hilo1 hilo1 = new Hilo1();
        Hilo2 hilo2 = new Hilo2();

        if (e.getSource() == b1) {
            if (activa) {
                b1.setLabel("Iniciar Fil 1");
                activa = !activa;
            } else {
                b1.setLabel("Finalizar Fil 1");
                if (comptador1 < 1) {
                    hilo1.start();
                }
                activa = !activa;
            }
        }
        
        if (e.getSource() == b2) {
            if (activa2) {
                b2.setLabel("Iniciar Fil 2");
                activa2 = !activa2;
            } else {
                b2.setLabel("Finalizar Fil 2");
                if (comptador2 < 1) {
                    hilo2.start();
                }
                activa2 = !activa2;
            }
        }

    }

    // Clase Hilo
    public class Hilo1 extends Thread {

        @Override
        public void run() {
            while (true) {
                if (activa) {
                    comptador1++;
                }
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Executa.class.getName()).log(Level.SEVERE, null, ex);
                }
                repaint();
            }
        }
    }

    public class Hilo2 extends Thread {

        @Override
        public void run() {
            while (true) {
                if (activa2) {
                    comptador2++;
                }
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Executa.class.getName()).log(Level.SEVERE, null, ex);
                }
                repaint();
            }

        }
    }

}
