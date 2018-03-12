package activa.Expendio.vista.utils;

import javax.swing.*;
import utils.*;

public class CampoCombo<T> extends JComboBox<T> {

    private static final long serialVersionUID = 8418263158893218114L;

    @SafeVarargs
    public CampoCombo(T... valores) {
        super.setFont(Letra.fuenteCombo);
        super.setForeground(Letra.colorCombo);

        for (T valor : valores) {
            super.addItem(valor);
        }
        super.setSelectedIndex(-1);
    }

    public static String getComboValue(CampoCombo<String> combo) {
        int i = combo.getSelectedIndex();
        String resp = "";
        if (i != -1) {
            resp = combo.getItemAt(i);
        }
        return resp;
    }

    public Object getComboValue2() {
        int i = this.getSelectedIndex();
        Object resp = null;
        if (i != -1) {
            resp = this.getItemAt(i);
        }
        return resp;
    }

    public static String setValueCombo(CampoCombo<String> campo, String valor) {
        String resp = valor;
        if (resp != null && !resp.trim().isEmpty()) {
            campo.setSelectedItem(resp);
        }
        return resp;
    }
}
