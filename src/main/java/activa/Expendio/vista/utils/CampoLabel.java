package activa.Expendio.vista.utils;

import javax.swing.*;

import utils.*;

public class CampoLabel extends JLabel {

    private static final long serialVersionUID = -2387385028673910014L;

    public static final String labelEstatico = "E";
    public static final String labelVariable = "V";
    public static final String labelAviso = "A";
    public static final String labelAviso2 = "A2";

    /**
     *
     * @param texto
     * @param tipo:<br>
     * <b>V</b>: Variable<br>
     * <b>E</b>: Est�tico<br>
     * <b>A</b>: Aviso<br>
     * <b>A2</b>: Avisio2<br>
     */
    public CampoLabel(String texto, String tipo) {
        if (tipo.trim().equalsIgnoreCase(labelVariable)) {
            this.setForeground(Letra.colorLabelVariable);
            this.setFont(Letra.fuenteLabelVariable);
        } else if (tipo.trim().equalsIgnoreCase(labelEstatico)) {
            this.setForeground(Letra.colorLabel);
            this.setFont(Letra.fuenteLabel);
        } else if (tipo.trim().equalsIgnoreCase(labelAviso)) {
            this.setForeground(Letra.colorAvisos);
            this.setFont(Letra.fuenteAvisos);
        } else if (tipo.trim().equalsIgnoreCase(labelAviso2)) {
            this.setForeground(Letra.colorAvisos2);
            this.setFont(Letra.fuenteAvisos2);
        }
        this.setText(texto);
    }

    /**
     * Metodo encargado de centrar el label
     */
    public void alinearCentro() {
        this.setHorizontalAlignment(JLabel.CENTER);
    }

    /**
     * Metodo encargado de alinear a la izquierda el label
     */
    public void alinearIzquierda() {
        this.setHorizontalAlignment(JLabel.LEFT);
    }

    /**
     * Metodo encargado de alinear a la izquierda el label
     */
    public void alinearDerecha() {
        this.setHorizontalAlignment(JLabel.RIGHT);
    }
}
