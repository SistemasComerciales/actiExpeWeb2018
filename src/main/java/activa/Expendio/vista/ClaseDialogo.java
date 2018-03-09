package activa.Expendio.vista;

import activa.Expendio.modelo.Usuario;
import java.awt.*;

import javax.swing.*;

import utils.*;

public abstract class ClaseDialogo extends JDialog {

    private static final long serialVersionUID = 3541987932659337481L;

    protected Usuario usuario;

    /**
     * Permite construir un dialogo con fondo y titulo.
     *
     * @param usuario
     */
    public ClaseDialogo(Usuario usuario) {
        this.usuario = usuario;

        super.setModal(true);
        super.setLayout(null);
        super.setUndecorated(true);
    }

    /**
     * Metodo encargado de crear el titulo en los Jdialog
     *
     * @param posicionX
     * @param posicionY
     * @param titulo
     * @param ANCHOPANTALLA
     * @param altoLabel
     */
    public static void tituloDialog(int posicionX, int posicionY, String titulo, int ANCHOPANTALLA, int altoLabel, JDialog componente, float tamano) {
        JLabel lbl_titulo;
        lbl_titulo = new JLabel(titulo, JLabel.CENTER);
        lbl_titulo.setForeground(new Color(28, 48, 76));
        lbl_titulo.setFont(new Fuente().MyFont(0, tamano));
        lbl_titulo.setBounds(posicionX, posicionY, ANCHOPANTALLA, altoLabel);
        componente.add(lbl_titulo);
    }

    public abstract void actualizarDialog();

    public abstract void asignarFoco();
}
