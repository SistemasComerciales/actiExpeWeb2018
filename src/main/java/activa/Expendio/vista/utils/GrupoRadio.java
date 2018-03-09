package activa.Expendio.vista.utils;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import utils.*;

public class GrupoRadio extends JPanel {

    private static final long serialVersionUID = -3860094775260272592L;

    public ButtonGroup grupo;
    public List<JRadioButton> radios;

    public GrupoRadio(int x, int y, int width, int height, String... valores) {
        prepareElementos(x, y, width, height, valores);
        definaAcciones();
    }

    public void inicializarValores() {
        grupo.clearSelection();
    }

    private void prepareElementos(int x, int y, int width, int height, String... valores) {
        grupo = new ButtonGroup();
        radios = new ArrayList<JRadioButton>();
        int var = 5;

        this.setLayout(new GridLayout(0, 1));
        this.setOpaque(false);
        this.setBorder(new PanelBorde(""));

        if (valores.length > 0) {
            {
                String valor = valores[0];

                JRadioButton radio = new JRadioButton(valor);

                radio.setLocation(x, y);
                radio.setSize(width, height);

                radio.setForeground(Letra.colorLabel);
                radio.setFont(Letra.fuenteLabel);

                radio.setLayout(null);
                radio.setOpaque(false);
                radio.setBorder(null);

                radios.add(radio);
                grupo.add(radio);
                this.add(radio);
            }

            for (int i = 1; i < valores.length; i++) {
                String valor = valores[i];

                JRadioButton radio = new JRadioButton(valor);

                JRadioButton anterior = radios.get(i - 1);
                radio.setLocation(x, anterior.getY() + anterior.getHeight() + var);
                radio.setSize(width, height);

                radio.setForeground(Letra.colorLabel);
                radio.setFont(Letra.fuenteLabel);

                radio.setOpaque(false);
                radio.setBorder(null);

                radios.add(radio);
                grupo.add(radio);
                this.add(radio);
            }

            this.setLocation(x, y);
            this.setSize(width, height * radios.size());
        }
    }

    private void definaAcciones() {
        if (radios.size() > 0) {
            for (int i = 0; i < radios.size() - 1; i++) {
                JRadioButton radioActual = radios.get(i);
                JRadioButton radioSiguiente = radios.get(i + 1);
                asignarSiguiente(radioActual, radioSiguiente);
            }
        }
    }

    /**
     * Metodo encargado de asignar el siguiente foco.
     *
     * @param objetoPrincipal
     * @param objetoSiguiente
     */
    private static void asignarSiguiente(JComponent objetoPrincipal, JComponent objetoSiguiente) {
        objetoPrincipal.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case KeyEvent.VK_ENTER:
                        objetoSiguiente.grabFocus();
                        break;
                }
            }
        });
    }

    @Override
    public void grabFocus() {
        if (radios.size() > 0) {
            JRadioButton radioActual = radios.get(0);
            radioActual.grabFocus();
        }
    }

    /**
     * Obtiene el ultimo elemento del grupo.
     *
     * @return Retorna <b>null</b> si el grupo esta vacio.
     */
    public JRadioButton getLastItem() {
        if (radios.size() > 0) {
            JRadioButton radioActual = radios.get(radios.size() - 1);
            return radioActual;
        } else {
            return null;
        }
    }

    /**
     * Retorna el item seleccionado.
     *
     * @return Retorna <b>null</b> si no hay nada seleccionado.
     */
    public JRadioButton getSelectedItem() {
        for (JRadioButton radio : radios) {
            if (radio.isSelected()) {
                return radio;
            }
        }
        return null;
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        for (JRadioButton radio : radios) {
            radio.setEnabled(enabled);
        }
    }
}
