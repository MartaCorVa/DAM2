package cat.paucasesnovescifp.sppsp;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author marta
 */
public class Executa extends Applet implements ActionListener {
    private Font font;
    public static long comptador1 = 0;
    public static long comptador2 = 0;
    private Button b1, b2;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
