package activa.Expendio.vista.utils;

import javax.swing.border.*;
import utils.*;

public class PanelBorde extends TitledBorder {

    private static final long serialVersionUID = 6757520387603583330L;

    public PanelBorde(String title) {
        super(title);
        super.setBorder(null);
        super.setTitleJustification(TitledBorder.LEFT);
        super.setTitlePosition(TitledBorder.DEFAULT_POSITION);
        super.setTitleFont(Letra.fuenteLabel);
        super.setTitleColor(Letra.colorLabel);
    }
}
