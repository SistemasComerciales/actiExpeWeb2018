package utils;

import java.awt.*;

import javax.swing.*;

public class Imagenes {

    /**
     * metodo que agrega fondo a un frame
     *
     * @param rutaImg
     * @param ANCHO_PANTALLA
     * @param ALTO_PANTALLA
     * @param internalFrame
     */
    public static void fondoInternalFrame(String rutaImg, int ANCHO_PANTALLA, int ALTO_PANTALLA, JFrame internalFrame) {
        Image scalar = CargaImagenes.getImg(rutaImg).getScaledInstance(ANCHO_PANTALLA, ALTO_PANTALLA, Image.SCALE_SMOOTH);
        internalFrame.setContentPane(new backImage(scalar));
    }

    /**
     * metodoque agregar un fondo a un Jdialog
     *
     * @param rutaImg
     * @param ANCHO_PANTALLA
     * @param ALTO_PANTALLA
     * @param dialogo
     */
    public static void fondoDialog(String rutaImg, int ANCHO_PANTALLA, int ALTO_PANTALLA, JDialog dialogo) {
        Image scalar = CargaImagenes.getImg(rutaImg).getScaledInstance(ANCHO_PANTALLA, ALTO_PANTALLA, Image.SCALE_SMOOTH);
        dialogo.setContentPane(new backImage(scalar));

    }

    /**
     * metodo que agrega la imagen a los botones
     *
     * @param rutaImg
     * @param boton
     */
    public static void imagenBoton(String rutaImg, JButton boton) {
        boton.setIcon(CargaImagenes.getImgBoton(rutaImg));
    }

    /**
     * metodo que agrega fondo a JLabel
     *
     * @param rutaImg
     * @param label
     */
    public static void fondoLabel(String rutaImg, JLabel label) {
        label.setIcon(CargaImagenes.getImgBoton(rutaImg));
    }

    private static class backImage extends JComponent {

        private static final long serialVersionUID = 6555359449036396917L;

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
