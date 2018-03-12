package activa.Expendio.vista.utils;

import activa.Expendio.modelo.*;
import java.text.*;

import javax.swing.*;
import javax.swing.text.*;
import utils.*;

public class CajaDeTextoConFormatoNumerico extends JFormattedTextField {

    private static final long serialVersionUID = 2603424525231186727L;

    private int cifras;
    private Usuario usuario;

    public CajaDeTextoConFormatoNumerico(int cifras, Usuario usuario) {
        this.cifras = cifras;
        this.usuario = usuario;

        prepararCampo();
    }

    private void prepararCampo() {
        String mask = "";
        for (int i = 0; i < cifras; i++) {
            mask += "#";
        }

        MaskFormatter mascara = null;
        try {
            mascara = new MaskFormatter(mask);
        } catch (ParseException e) {
            String cod = "Error (4182)";
            String err = "Ha Ocurrido un error al Aplicar la mascara.";
            Log.adicionar(e, cod, usuario, err);
            JOptionPane.showOptionDialog(null, err, cod, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, "aceptar");
            e.printStackTrace();
        }
        mascara.install(this);

        this.setFocusLostBehavior(JFormattedTextField.PERSIST);
        this.setFont(Letra.fuenteTxt);
        this.setForeground(Letra.colorTxt);
        this.setDisabledTextColor(Letra.colorTxtDisable);
    }

    /**
     * Metodo encargado de inhabilitar los campos de hora
     */
    public void inhabilitar() {
        this.setEnabled(false);
    }

    /**
     * Metodo encargado de habilitar los campos de hora
     */
    public void habilitar() {
        this.setEnabled(true);
    }

    /**
     * Metodo encargado de inicializzar la informacion de la hora, txt y combo
     */
    public void inicializar() {
        this.setText("");
    }
}
