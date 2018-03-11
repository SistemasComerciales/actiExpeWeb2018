package activa.Expendio.vista;

import java.awt.*;

import javax.swing.*;

import com.sun.awt.*;
import utils.*;
import utils.Animacion.*;

/**
 *
 * @author Avuuna la Luz del Alba
 */
public class GUISplashScreen extends JFrame {

    private static final long serialVersionUID = -2989535372465163724L;
    int ANCHO_PANTALLA;
    int ALTO_PANTALLA;

    public GUISplashScreen() {
        // obtiene la resolucion actual del monitor donde se ejecuta en frame
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double ancho = screenSize.getWidth();
        double altura = screenSize.getHeight();
        ANCHO_PANTALLA = (int) ancho;
        ALTO_PANTALLA = (int) altura - 35;
        this.setSize(ANCHO_PANTALLA / 100 * 40, ALTO_PANTALLA / 100 * 60);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setUndecorated(true);
        AWTUtilities.setWindowOpaque(this, false);

        ImageIcon carga = new ImageIcon(NombreImagenes.imInicio);
        JLabel a = new JLabel(carga);
        a.setSize(ANCHO_PANTALLA / 100 * 40, ALTO_PANTALLA / 100 * 60);
        this.add(a);

        this.setIconImage(Toolkit.getDefaultToolkit().getImage(NombreImagenes.imIcono));
        Fade.JFrameFadeIn(0f, 1f, 0.1f, 50, this);
        repaint();
        this.setVisible(true);

    }

    public class backImage extends JComponent {
        private static final long serialVersionUID = 1L;
        Image i;

        public backImage(Image i) {
            this.i = i;
        }

        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(i, 0, 0, null);
        }
    }

}
