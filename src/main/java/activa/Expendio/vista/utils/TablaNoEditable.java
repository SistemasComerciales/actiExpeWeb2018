package utils;

import javax.swing.table.*;

public class TablaNoEditable extends DefaultTableModel {

    private static final long serialVersionUID = 1L;

    public TablaNoEditable() {
    }

    public boolean isCellEditable(int row, int column) {
        return false;

    }
}
