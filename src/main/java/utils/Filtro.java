package utils;

import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

public class Filtro {

    /**
     * metodo que filtra una tabla por una columna
     *
     * @param filtro
     * @param trsfiltro
     * @param opcion1
     */
    public static void filtroUnaColumnaMoneda(String filtro, TableRowSorter<DefaultTableModel> trsfiltro, int opcion1, DefaultTableModel dtm, JTable tabla) {

        trsfiltro = new TableRowSorter<DefaultTableModel>(dtm);
        // Anadimos al Jtable el filtro trsfiltro
        tabla.setRowSorter(trsfiltro);
        LinkedList<RowFilter<Object, Object>> lista = new LinkedList<RowFilter<Object, Object>>();
        lista.add(RowFilter.regexFilter(filtro, opcion1));
        RowFilter<Object, Object> filtroOr = RowFilter.orFilter(lista);  // or de ambos filtros.
        trsfiltro.setRowFilter(filtroOr);
    }

    /**
     * metodo que filtra una tabla por una columna
     *
     * @param filtro
     * @param trsfiltro
     * @param opcion1
     */
    public static void filtroUnaColumna(String filtro, TableRowSorter<DefaultTableModel> trsfiltro, int opcion1, DefaultTableModel dtm, JTable tabla) {

        trsfiltro = new TableRowSorter<DefaultTableModel>(dtm);
        // Anadimos al Jtable el filtro trsfiltro
        tabla.setRowSorter(trsfiltro);
        LinkedList<RowFilter<Object, Object>> lista = new LinkedList<RowFilter<Object, Object>>();
        lista.add(RowFilter.regexFilter("^" + filtro, opcion1));
        RowFilter<Object, Object> filtroOr = RowFilter.orFilter(lista);  // or de ambos filtros.
        trsfiltro.setRowFilter(filtroOr);
    }

    /**
     * metodo que filtra una tabla por dos item de busqueda
     *
     * @param filtro
     * @param trsfiltro
     * @param opcion1
     * @param opcion2
     */
    public static void filtroDosColumnas(String filtro, TableRowSorter<DefaultTableModel> trsfiltro, int opcion1, int opcion2, DefaultTableModel dtm, JTable tabla) {
        trsfiltro = new TableRowSorter<DefaultTableModel>(dtm);
        // Anadimos al Jtable el filtro trsfiltro
        tabla.setRowSorter(trsfiltro);
        LinkedList<RowFilter<Object, Object>> lista = new LinkedList<RowFilter<Object, Object>>();
        lista.add(RowFilter.regexFilter("^" + filtro, opcion1));
        lista.add(RowFilter.regexFilter("^" + filtro, opcion2));

        RowFilter<Object, Object> filtroOr = RowFilter.orFilter(lista);  // or de ambos filtros.
        trsfiltro.setRowFilter(filtroOr);
    }

    /**
     * metodo que filtra una tabla por tres item de busqueda
     *
     * @param filtro
     * @param trsfiltro
     * @param opcion1
     * @param opcion2
     * @param opcion3
     */
    public static void filtroTresColumnas(String filtro, TableRowSorter<DefaultTableModel> trsfiltro, int opcion1, int opcion2, int opcion3, DefaultTableModel dtm, JTable tabla) {
        trsfiltro = new TableRowSorter<DefaultTableModel>(dtm);
        // Anadimos al Jtable el filtro trsfiltro
        tabla.setRowSorter(trsfiltro);
        LinkedList<RowFilter<Object, Object>> lista = new LinkedList<RowFilter<Object, Object>>();
        lista.add(RowFilter.regexFilter("^" + filtro, opcion1));
        lista.add(RowFilter.regexFilter("^" + filtro, opcion2));
        lista.add(RowFilter.regexFilter("^" + filtro, opcion3));
        RowFilter<Object, Object> filtroOr = RowFilter.orFilter(lista);  // or de ambos filtros.
        trsfiltro.setRowFilter(filtroOr);
    }

    /**
     * metodo que deshace el filtro de la tabla
     */
    public static void deshacerFiltro(TableRowSorter<DefaultTableModel> trsfiltroTabla, DefaultTableModel dtm_Tabla, JTable tabla) {
        trsfiltroTabla = new TableRowSorter<DefaultTableModel>(dtm_Tabla);
        // Anadimos al Jtable el filtro trsfiltro
        tabla.setRowSorter(trsfiltroTabla);
        String textoFiltro = "";
        trsfiltroTabla.setRowFilter(RowFilter.regexFilter(textoFiltro));
    }

    /**
     * metodo que filtra una tabla por dos item de busqueda sin necesariamente
     * empezar con lo escrito
     *
     * @param filtro
     * @param trsfiltro
     * @param opcion1
     * @param opcion2
     */
    public static void filtroDosColumnasQueContenga(String filtro, TableRowSorter<DefaultTableModel> trsfiltro, int opcion1, int opcion2, DefaultTableModel dtm, JTable tabla) {
        trsfiltro = new TableRowSorter<DefaultTableModel>(dtm);
        // Anadimos al Jtable el filtro trsfiltro
        tabla.setRowSorter(trsfiltro);
        LinkedList<RowFilter<Object, Object>> lista = new LinkedList<RowFilter<Object, Object>>();
        lista.add(RowFilter.regexFilter(filtro, opcion1));
        lista.add(RowFilter.regexFilter(filtro, opcion2));

        RowFilter<Object, Object> filtroOr = RowFilter.orFilter(lista);  // or de ambos filtros.
        trsfiltro.setRowFilter(filtroOr);
    }

    /**
     * metodo que filtra una tabla por tres item de busqueda sin necesariamente
     * empezar con lo escrito
     *
     * @param filtro
     * @param trsfiltro
     * @param opcion1
     * @param opcion2
     * @param opcion3
     */
    public static void filtroTresColumnasQueContenga(String filtro, TableRowSorter<DefaultTableModel> trsfiltro, int opcion1, int opcion2, int opcion3, DefaultTableModel dtm, JTable tabla) {
        trsfiltro = new TableRowSorter<DefaultTableModel>(dtm);
        // Anadimos al Jtable el filtro trsfiltro
        tabla.setRowSorter(trsfiltro);
        LinkedList<RowFilter<Object, Object>> lista = new LinkedList<RowFilter<Object, Object>>();
        lista.add(RowFilter.regexFilter(filtro, opcion1));
        lista.add(RowFilter.regexFilter(filtro, opcion2));
        lista.add(RowFilter.regexFilter(filtro, opcion3));
        RowFilter<Object, Object> filtroOr = RowFilter.orFilter(lista);  // or de ambos filtros.
        trsfiltro.setRowFilter(filtroOr);
    }

    /**
     * metodo que filtra una tabla por tres item de busqueda sin necesariamente
     * empezar con lo escrito
     *
     * @param filtro
     * @param trsfiltro
     * @param opcion1
     * @param opcion2
     * @param opcion3
     * @param opcion4
     */
    public static void filtroCuatroColumnasQueContenga(String filtro, TableRowSorter<DefaultTableModel> trsfiltro, int opcion1, int opcion2, int opcion3, int opcion4, DefaultTableModel dtm, JTable tabla) {
        trsfiltro = new TableRowSorter<DefaultTableModel>(dtm);
        // Anadimos al Jtable el filtro trsfiltro
        tabla.setRowSorter(trsfiltro);
        LinkedList<RowFilter<Object, Object>> lista = new LinkedList<RowFilter<Object, Object>>();
        lista.add(RowFilter.regexFilter(filtro, opcion1));
        lista.add(RowFilter.regexFilter(filtro, opcion2));
        lista.add(RowFilter.regexFilter(filtro, opcion3));
        lista.add(RowFilter.regexFilter(filtro, opcion4));
        RowFilter<Object, Object> filtroOr = RowFilter.orFilter(lista);  // or de ambos filtros.
        trsfiltro.setRowFilter(filtroOr);
    }

    /**
     * metodo que filtra una tabla por una columna sin necesariamente empezar
     * con lo escrito
     *
     * @param filtro
     * @param trsfiltro
     * @param opcion1
     */
    public static void filtroUnaColumnaQueContenga(String filtro, TableRowSorter<DefaultTableModel> trsfiltro, int opcion1, DefaultTableModel dtm, JTable tabla) {

        trsfiltro = new TableRowSorter<DefaultTableModel>(dtm);
        // Anadimos al Jtable el filtro trsfiltro
        tabla.setRowSorter(trsfiltro);
        LinkedList<RowFilter<Object, Object>> lista = new LinkedList<RowFilter<Object, Object>>();
        lista.add(RowFilter.regexFilter(filtro, opcion1));
        RowFilter<Object, Object> filtroOr = RowFilter.orFilter(lista);  // or de ambos filtros.
        trsfiltro.setRowFilter(filtroOr);
    }

    /**
     * metodo que filtra una tabla por dos item de busqueda el primer campo debe
     * empezar, el segundo que contenga
     *
     * @param filtro
     * @param trsfiltro
     * @param opcion1
     * @param opcion2
     */
    public static void filtroDosColumnasQueEmpiezeYContenga(String filtro, TableRowSorter<DefaultTableModel> trsfiltro, int opcion1, int opcion2, DefaultTableModel dtm, JTable tabla) {
        trsfiltro = new TableRowSorter<DefaultTableModel>(dtm);
        // Anadimos al Jtable el filtro trsfiltro
        tabla.setRowSorter(trsfiltro);
        LinkedList<RowFilter<Object, Object>> lista = new LinkedList<RowFilter<Object, Object>>();
        lista.add(RowFilter.regexFilter(filtro, opcion2));
        lista.add(RowFilter.regexFilter("^" + filtro, opcion1));

        RowFilter<Object, Object> filtroOr = RowFilter.orFilter(lista);  // or de ambos filtros.
        trsfiltro.setRowFilter(filtroOr);
    }

    /**
     * metodo que filtra una tabla por tres item de busqueda sin necesariamente
     * empezar con lo escrito
     *
     * @param filtro
     * @param trsfiltro
     * @param opcion1
     * @param opcion2
     * @param opcion3
     * @param opcion4
     * @param opcion5
     * @param opcion6
     * @param opcion7
     * @param opcion8
     * @param opcion9
     *
     */
    public static void filtroNueveColumnasQueContenga(String filtro, TableRowSorter<DefaultTableModel> trsfiltro, int opcion1, int opcion2, int opcion3, int opcion4, int opcion5, int opcion6, int opcion7, int opcion8, int opcion9, DefaultTableModel dtm, JTable tabla) {
        trsfiltro = new TableRowSorter<DefaultTableModel>(dtm);
        // Anadimos al Jtable el filtro trsfiltro
        tabla.setRowSorter(trsfiltro);
        LinkedList<RowFilter<Object, Object>> lista = new LinkedList<RowFilter<Object, Object>>();
        lista.add(RowFilter.regexFilter(filtro, opcion1));
        lista.add(RowFilter.regexFilter(filtro, opcion2));
        lista.add(RowFilter.regexFilter(filtro, opcion3));
        lista.add(RowFilter.regexFilter(filtro, opcion4));
        lista.add(RowFilter.regexFilter(filtro, opcion5));
        lista.add(RowFilter.regexFilter(filtro, opcion6));
        lista.add(RowFilter.regexFilter(filtro, opcion7));
        lista.add(RowFilter.regexFilter(filtro, opcion8));
        lista.add(RowFilter.regexFilter(filtro, opcion9));
        RowFilter<Object, Object> filtroOr = RowFilter.orFilter(lista);  // or de ambos filtros.
        trsfiltro.setRowFilter(filtroOr);
    }

}
