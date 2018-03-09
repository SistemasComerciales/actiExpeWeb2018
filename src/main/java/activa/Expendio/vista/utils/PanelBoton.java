package activa.Expendio.vista.utils;

import java.awt.*;

import javax.swing.*;

public class PanelBoton extends JPanel {

    private static final long serialVersionUID = -6285158690864821026L;

    public PanelBoton(JButton button) {
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());
        this.add(button);
    }
}
