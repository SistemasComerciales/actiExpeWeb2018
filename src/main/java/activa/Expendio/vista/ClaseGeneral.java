package activa.expendio.vista;


import activa.Expendio.modelo.Usuario;
import java.awt.*;
import javax.swing.*;
import utils.*;

/**
 *
 * @author Avuuna la Luz del Alba
 */
public abstract class ClaseGeneral extends JFrame {
    
    public Cursor cursorEspera = new Cursor(Cursor.WAIT_CURSOR);
    
    protected GUIJOption option;
    protected Usuario usuario;
    protected JFrame frame;
    
    public ClaseGeneral(Usuario usuario) {
        option = new GUIJOption(this);
        this.usuario = usuario;
        frame = this;
        
        this.setLocation(0, 0);
        this.setSize(CargaImagenes.ANCHO_PANTALLA, CargaImagenes.ALTO_PANTALLA);
        
        this.setLayout(null);
        this.setResizable(false);
        
        this.setVisible(true);
        this.repaint();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        actualizarFrame();
    }
    
    public abstract void actualizarFrame();

    /**
     * Metodo encargado de poner todos los objetos en null
     */
    public abstract void eliminarReferencia();

    /**
     * Metodo encargado de asignar el foco al lugar necesario cuando se este
     * devolviendo
     */
    public abstract void asignarFoco();

    /**
     * Metodo encargado de crear el titulo en los Frame
     *
     * @param posicionX
     * @param posicionY
     * @param titulo
     * @param letra
     * @param ANCHOPANTALLA
     * @param altoLabel
     */
    public void tituloFrame(int posicionX, int posicionY, String titulo, int ANCHOPANTALLA, int altoLabel) {
        JLabel lbl_titulo;
        lbl_titulo = new JLabel(titulo, JLabel.CENTER);
        lbl_titulo.setForeground(new Color(0, 120, 135));
        lbl_titulo.setFont(new Fuente().MyFont(0, ANCHOPANTALLA / 27f));
        lbl_titulo.setBounds(posicionX, posicionY, ANCHOPANTALLA, altoLabel);
        this.add(lbl_titulo);
    }
    
    public void tituloFrameMini(int posicionX, int posicionY, String titulo, int ANCHOPANTALLA, int altoLabel) {
        JLabel lbl_titulo;
        lbl_titulo = new JLabel(titulo, JLabel.CENTER);
        lbl_titulo.setForeground(new Color(0, 120, 135));
        lbl_titulo.setFont(new Fuente().MyFont(0, ANCHOPANTALLA / 40f));
        lbl_titulo.setBounds(posicionX, posicionY, ANCHOPANTALLA, altoLabel);
        this.add(lbl_titulo);
    }

    /**
     * Metodo encargado de crear el titulo en los Jdialog
     *
     * @param posicionX
     * @param posicionY
     * @param titulo
     * @param letra
     * @param ANCHOPANTALLA
     * @param altoLabel
     * @param Jdialog
     */
    public void tituloDialog(int posicionX, int posicionY, String titulo, int ANCHOPANTALLA, int altoLabel, JDialog componente, int ANCHOPANTALLA2) {
        JLabel lbl_titulo;
        lbl_titulo = new JLabel(titulo, JLabel.CENTER);
        lbl_titulo.setForeground(new Color(0, 120, 135));
        lbl_titulo.setFont(new Fuente().MyFont(0, ANCHOPANTALLA2 / 50f));
        lbl_titulo.setBounds(posicionX, posicionY, ANCHOPANTALLA, altoLabel);
        componente.add(lbl_titulo);
    }

    /**
     * Metodo encargado de asignar los permisos a los usuarios
     */
    public abstract void asignarPermisos();
    
}
