package activa.Expendio.vista.utils;

import javax.swing.*;
import utils.*;

public class CasillaVerificacion extends JCheckBox {

    private static final long serialVersionUID = -4247112370517248070L;

    public CasillaVerificacion(String nombre) {
        super.setText(nombre);
        super.setOpaque(false);
        super.setForeground(Letra.colorLabel);
        super.setFont(Letra.fuenteLabel);
    }
}
