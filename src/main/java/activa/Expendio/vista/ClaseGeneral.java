package activa.Expendio.vista;

import activa.Expendio.*;
import activa.Expendio.modelo.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import utils.*;

/**
 *
 * @author Avuuna la Luz del Alba
 */
public abstract class ClaseGeneral extends JFrame {

    public static final Cursor cursorEspera = new Cursor(Cursor.WAIT_CURSOR);

    public static GUIJOption option;
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

        setIcono();
        doNothingOnClose();
    }

    public final void inicializar() {
        this.repaint();
        actualizarFrame();
        asignarFoco();
        asignarPermisos();
    }

    protected final void exitOnClose() {
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        for (int i = 0; i < frame.getWindowListeners().length; i++) {
            frame.removeWindowListener(frame.getWindowListeners()[i]);
        }
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent arg0) {
                ExpendioApplication.control.cerrarApp();
            }
        });
    }

    protected final void doNothingOnClose() {
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        for (int i = 0; i < frame.getWindowListeners().length; i++) {
            frame.removeWindowListener(frame.getWindowListeners()[i]);
        }
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent arg0) {
            }
        });
    }

    /**
     * Permite exportar a excel la informacion que se este mostrando.
     */
    protected static final void accionBotonExcel(JTable tablaGeneral, String nombre, JFrame frame, Usuario usuario) {
        frame.setCursor(cursorEspera);

        JTable tabla = null;
        String nombreTabla = "";

        if (tablaGeneral.getRowCount() > 0) {
            tabla = tablaGeneral;
            nombreTabla = nombre;
        }

        if (tabla != null && !nombreTabla.trim().isEmpty()) {
//            ExcelExporter excel = new ExcelExporter(usuario, nombreTabla);
//            excel.export(tabla, nombreTabla, frame);
        } else {
            JOptionPane.showMessageDialog(frame, "La tabla se encuentra vacia", "Error (27)", JOptionPane.WARNING_MESSAGE);
        }

        frame.setCursor(null);
    }

    protected final void accionBotonSalir() {// XXX Boton Salir
        frame.setCursor(cursorEspera);

        ClaseGeneral anterior = (ClaseGeneral) Configuracion.getFrameAnterior();
        anterior.setVisible(true);
        anterior.actualizarFrame();
        frame.setVisible(false);

        frame.setCursor(null);
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

    /**
     * Metodo encargado de asignar el icono
     */
    private void setIcono() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(NombreImagenes.imIcono));
    }

    /**
     * metodo encargado de obtener el foco activo de la ventana actual cuando la
     * ventana se desactiva o minimiza y lo vuelve a estabkecer cuando la
     * ventana se activa o maximiza
     */
    public final void accionJframe(JFrame frame) {
        frame.addWindowListener(new WindowListener() {
            JButton boton;
            JTextField texto;
            JComboBox combo;
            JCheckBox check;
            JRadioButton radio;
            TextArea textarea;

            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                if (KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner() != null) {
                    if (KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner() instanceof JButton) {
                        boton = (JButton) KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner();
                    } else if (KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner() instanceof JTextField) {
                        texto = (JTextField) KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner();
                    } else if (KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner() instanceof JComboBox) {
                        combo = (JComboBox) KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner();
                    } else if (KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner() instanceof JCheckBox) {
                        check = (JCheckBox) KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner();
                    } else if (KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner() instanceof JRadioButton) {
                        radio = (JRadioButton) KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner();
                    } else if (KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner() instanceof TextArea) {
                        textarea = (TextArea) KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner();
                    }
                }
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
                if (texto != null) {
                    texto.grabFocus();
                } else if (boton != null) {
                    boton.grabFocus();

                } else if (combo != null) {
                    combo.grabFocus();

                } else if (check != null) {
                    check.grabFocus();

                } else if (radio != null) {
                    radio.grabFocus();

                } else if (textarea != null) {
                    textarea.requestFocus();

                }
                texto = null;
                boton = null;
                combo = null;
                check = null;
                radio = null;
                textarea = null;
            }
        });
    }

}
