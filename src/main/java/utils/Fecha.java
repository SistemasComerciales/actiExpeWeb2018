package utils;

import java.text.*;
import java.util.*;

import javax.swing.*;

public class Fecha {

    public static final String PATRON_FECHA_ddMMyyyy = "dd/MM/yyyy";
    public static final String PATRON_FECHA_ddMMyy = "dd/MM/yy";
    public static final String PATRON_FECHA_yyyyMMdd = "yyyy-MM-dd";

    public static final String fechaVacia = "  /  /    ";

    public Fecha() {
    }

    /**
     * @param formato DD/MM/YYYY en string
     * @param metodo que valida si una fecha es valida o invalida
     * @return un String con la informacion, si el a�o el mes o el dia son
     * invalidos
     */
    public static String validarFechaDDMMYYYY(String fecha) {

        if (fecha.replace("/", "").replace(" ", "").trim().length() != 8) {
            return "INVALIDO";
        } else {
            String cadena = fecha.replace("/", "");
            String dia = cadena.substring(0, 2);
            String mes = cadena.substring(2, 4);
            String paso = "";
            if (cadena.trim().length() < 8) {
                return "fecha";
            }

            String anio = cadena.substring(4);
            // System.out.println(anio);
            int numeromes = Integer.parseInt(mes);
            int numerodia = Integer.parseInt(dia);
            int numeroan = Integer.parseInt(anio);
            GregorianCalendar calendar = new GregorianCalendar();
            boolean bis = calendar.isLeapYear(numeroan);

            if (anio.charAt(0) == '0') {
                paso = "anio";
            }
            if (numerodia > 31) {
                paso = "dia";
            }
            if (numeromes > 12) {
                paso = "mes";
            } else if (mes.equals("04") || mes.equals("06") || mes.equals("09") || mes.equals("11")) {
                if (numerodia > 30) {
                    paso = "dia";
                }
            } else if (mes.equals("02")) {
                if (bis && numerodia > 29) {
                    paso = "dia";
                }
                if (!bis && numerodia > 28) {
                    paso = "dia";
                }
            }
            return paso;
        }
    }

    /**
     * devuelce el dia de la semana dada una fecha enero = 1, diciembre = 12 Y
     * ACa resta el mes
     *
     * @param ano
     * @param mes
     * @param dia
     * @return 1 = domingo , 7 = sabado;
     */
    public static int diaDeLaSemana(int ano, int mes, int dia) {
        Calendar ca = new GregorianCalendar(ano, mes - 1, dia);
        return ca.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * Metodo encargado de traer el dia de la semana en letras
     *
     * @param numero
     * @return ERROR, DOMINGO, LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO
     */
    public static String diaDeLaSemanaEnLetras(int numero) {
        String retorno = "ERROR";
        if (numero == 1) {
            retorno = "DOMINGO";
        } else if (numero == 2) {
            retorno = "LUNES";
        } else if (numero == 3) {
            retorno = "MARTES";
        } else if (numero == 4) {
            retorno = "MIERCOLES";
        } else if (numero == 5) {
            retorno = "JUEVES";
        } else if (numero == 6) {
            retorno = "VIERNES";
        } else if (numero == 7) {
            retorno = "SABADO";
        }
        return retorno;
    }

    /**
     * Metodo encargado de traer el dia de la fecha actual
     *
     * @return 1..31
     */
    public static int dia() {
        Calendar ca = new GregorianCalendar();
        System.out.println("Impresion del Dia:" + ca.get(Calendar.DAY_OF_MONTH));
        return ca.get(Calendar.DAY_OF_MONTH);

    }

    /**
     * Metodo encargado de traer el mes de la fecha actual
     *
     * @return 1..12
     */
    public static int mes() {
        Calendar ca = new GregorianCalendar();
        return ca.get(Calendar.MONTH) + 1;

    }

    /**
     * Metodo encargado de traer el a�o de la fecha actual
     *
     * @return 2016....2222
     */
    public static int anio() {
        Calendar ca = new GregorianCalendar();
        return ca.get(Calendar.YEAR);
    }

    /**
     * Metodo encargado de traer el dia de la semana en letras de la fecha
     * actual del sistema
     *
     * @return
     */
    public static String traerDiaSemanaEnLetrasFechaActual() {
        int dia = Fecha.dia();
        int mes = Fecha.mes();
        int anio = Fecha.anio();
        int diaSemana = Fecha.diaDeLaSemana(anio, mes, dia);
        String diaL = Fecha.diaDeLaSemanaEnLetras(diaSemana);
        return diaL;
    }

    /**
     * Metodo encargado de traer el dia de la semana de la fecha pasada por
     * parametro
     *
     * @return
     */
    public static String traerDiaSemanaEnLetras(String fecha) {
        int dia = Fecha.dia(fecha);
        System.out.println("dia:" + dia);
        int mes = Fecha.mes(fecha);
        System.out.println("mes:" + mes);
        int anio = Fecha.anio(fecha);
        System.out.println("anio" + anio);
        int diaSemana = Fecha.diaDeLaSemana(anio, mes, dia);
        System.out.println("diaSemana:" + diaSemana);
        String diaL = Fecha.diaDeLaSemanaEnLetras(diaSemana);
        System.out.println("diaL:" + diaL);
        return diaL;
    }

    /**
     * Metodo encargado de traer la fecha actual dd/mm/aaaa
     *
     * @return dd/mm/aaaa
     */
    public static String traerFechaActual() {
        int dia = Fecha.dia();
        int mes = Fecha.mes();
        System.out.println("dia2:" + dia);
        String diaB = "";
        if (dia <= 9) {
            diaB = "0" + dia;
        } else {
            diaB = String.valueOf(dia);
        }

        System.out.println("mes2:" + mes);
        String mesB = "";
        if (mes <= 9) {
            mesB = "0" + mes;
        } else {
            mesB = String.valueOf(mes);
        }
        int anio = Fecha.anio();
        System.out.println("anio2:" + anio);
        return diaB + "/" + mesB + "/" + anio;
    }

    /**
     * Metodo encargado de traer la fecha actual aaaa-mm-dd
     *
     * @return dd/mm/aaaa
     */
    public static String traerFechaActualAAAMMDD() {
        int dia = Fecha.dia();
        int mes = Fecha.mes();
        String mesB = "";
        if (mes <= 9) {
            mesB = "0" + mes;
        } else {
            mesB = String.valueOf(mes);
        }
        int anio = Fecha.anio();
        return anio + "-" + mesB + "-" + dia;
    }

    /**
     * Metodo encargado de convertir una fecha en formato dd/mm/yyyy a
     * yyyy-mm-dd
     *
     * @param fecha
     * @return
     */
    public static String convertirFormatoDDMMYYYaAAMMDD(String fecha) {
//		System.out.println("AAA: "+fecha);
        String dia = fecha.substring(0, 2);
        String mes = fecha.substring(3, 5);
        String anio = fecha.substring(6, 10);
        return anio + "-" + mes + "-" + dia;
    }

    /**
     * @param cajaFecha: JFormattedTextField con una fecha incompleta la cual se
     * va a completar en fomato DD/MM/YYYY
     * @param a�oContable: ingresa el a�o contable
     * @param metodo que completa una fecha incompleta
     */
    public static void completarFecha(JFormattedTextField cajaFecha, String anioContable){
		if (cajaFecha.getText().replace("/", "").trim().isEmpty()) {
        } else if (cajaFecha.getText().replace("/", "").trim().length() == 2) {
            Calendar fecha = new GregorianCalendar();
            String ano = anioContable.trim();
            int mes = fecha.get(Calendar.MONTH) + 1;
            String anoNuevo = ano;
            String mesNuevo;
            if (mes < 10) {
                mesNuevo = "0" + Integer.toString(mes);
            } else {
                mesNuevo = Integer.toString(mes);
            }
            cajaFecha.setText(cajaFecha.getText().replace("/", "").trim() + mesNuevo + anoNuevo);

        } else if (cajaFecha.getText().replace("/", "").trim().length() == 4) {
            String ano = anioContable.trim();
            String anoNuevo = ano;
            cajaFecha.setText(cajaFecha.getText().replace("/", "").trim() + anoNuevo);

        } else if (cajaFecha.getText().replace("/", "").trim().length() == 6) {
            String nuevoano = "20" + cajaFecha.getText().replace("/", "").trim().substring(4, 6);
            cajaFecha.setText(cajaFecha.getText().replace("/", "").trim().substring(0, 4) + nuevoano);
        } else if (cajaFecha.getText().replace("/", "").trim().length() != 8) {
            cajaFecha.setText("");
            cajaFecha.grabFocus();
        }
    }

    /**
     * Metodo encargado de validar la fecha
     *
     * @return String <br>MES, <br>DIA, <br>ANIO, <br>FECHA, <br>BIEN
     */
    public static String validarFecha(JFormattedTextField txt_fecha2) {
        if (!txt_fecha2.getText().replace("/", "").trim().isEmpty()) {
            String resultado = Fecha.validarFechaDDMMYYYY(txt_fecha2.getText().trim());
            if (resultado.equals("mes")) {
                return "MES";
            } else if (resultado.equals("dia")) {
                return "DIA";
            } else if (resultado.equals("anio")) {
                return "ANIO";
            } else if (resultado.equals("fecha")) {
                return "FECHA";
            } else {
                return "BIEN";
            }
        } else {
            return "BIEN";
        }
    }

    /**
     * metodo que trae los registros de un empleado en el rago de fechas
     * selecionado
     */
    public static ArrayList<String> traerRegistroEntreFechas(String fechaDesde, String fechaHasta) {
        ArrayList<String> fechas = new ArrayList<String>();
        if (!fechaDesde.replace("/", "").replace("/", "").isEmpty() && !fechaHasta.replace("/", "").replace("/", "").isEmpty()) {
            int ano = Integer.parseInt(fechaDesde.substring(6, 10));
            int mes = Integer.parseInt(fechaDesde.substring(3, 5)) - 1;
            int dia = Integer.parseInt(fechaDesde.substring(0, 2));
            Calendar fecha = GregorianCalendar.getInstance();
            SimpleDateFormat formato = new SimpleDateFormat(PATRON_FECHA_ddMMyyyy);
            fecha.set(ano, mes, dia);
            fecha.add(Calendar.DAY_OF_MONTH, -1);
            while (!fechaHasta.equals(formato.format(fecha.getTime()).toString())) {
                fecha.add(Calendar.DAY_OF_MONTH, 1);
//				System.out.println(formato.format(fecha.getTime()));
                fechas.add(formato.format(fecha.getTime()));

            }
        }
        return fechas;
    }

    /**
     * Metodo encargado de traer el dia en int de la fecha pasada por parametro
     *
     * @return
     */
    public static int dia(String fecha) {
        String diaS = fecha.substring(0, 2);
        if (diaS.trim().equalsIgnoreCase("01")) {
            return 1;
        } else if (diaS.trim().equalsIgnoreCase("02")) {
            return 2;
        } else if (diaS.trim().equalsIgnoreCase("03")) {
            return 3;
        } else if (diaS.trim().equalsIgnoreCase("04")) {
            return 4;
        } else if (diaS.trim().equalsIgnoreCase("05")) {
            return 5;
        } else if (diaS.trim().equalsIgnoreCase("06")) {
            return 6;
        } else if (diaS.trim().equalsIgnoreCase("07")) {
            return 7;
        } else if (diaS.trim().equalsIgnoreCase("08")) {
            return 8;
        } else if (diaS.trim().equalsIgnoreCase("09")) {
            return 9;
        } else {
            return Integer.valueOf(diaS);
        }
    }

    /**
     * Metodo encargado de traer el mes de la fecha pasada por parametro
     *
     * @return
     */
    public static int mes(String fecha) {
        String mesS = fecha.substring(3, 5);
        if (mesS.trim().equalsIgnoreCase("01")) {
            return 1;
        } else if (mesS.trim().equalsIgnoreCase("02")) {
            return 2;
        } else if (mesS.trim().equalsIgnoreCase("03")) {
            return 3;
        } else if (mesS.trim().equalsIgnoreCase("04")) {
            return 4;
        } else if (mesS.trim().equalsIgnoreCase("05")) {
            return 5;
        } else if (mesS.trim().equalsIgnoreCase("06")) {
            return 6;
        } else if (mesS.trim().equalsIgnoreCase("07")) {
            return 7;
        } else if (mesS.trim().equalsIgnoreCase("08")) {
            return 8;
        } else if (mesS.trim().equalsIgnoreCase("09")) {
            return 9;
        } else {
            return Integer.valueOf(mesS);
        }
    }

    /**
     * Metodo encargado de traer el anio de la fecha pasada por parametro
     *
     * @return
     */
    public static int anio(String fecha) {
        String anio = fecha.substring(6, 10);
        return Integer.valueOf(anio);
    }

    /**
     * @param fechaInicial: ingresa un string equivalente a una fecha valida en
     * formato DD/MM/YYYY
     * @param fechaFinal: ingresa un string equivalente a una fecha valida en
     * formato DD/MM/YYYY
     * @param metodo que comprueba que la primnera fecha no sea mayor a la
     * segunda
     * @return un boolean en true si la fecha inicial es menor que la final o
     * false si la final es menor que la inicial
     */
    ///////////////////////////////////////////////////metodo que comprueba que la primnera fecha no sea mayor a la segunda/////////////
    public static boolean comparadorFechasInicialMenorFinal(String fechaInicial, String fechaFinal) {
        boolean validador = true;
        int mesIni = 0;
        int mesFin = 0;
        int diaIni = 0;
        int diaFin = 0;
        int yearIni = 0;
        int yearFin = 0;

        String diaInic = fechaInicial.substring(0, 2);
        String mesInic = fechaInicial.substring(3, 5);
        String yearInic = fechaInicial.substring(6, 10);

        String diaFina = fechaFinal.substring(0, 2);
        String mesFina = fechaFinal.substring(3, 5);
        String yearFina = fechaFinal.substring(6, 10);

        diaIni = Integer.parseInt(diaInic);
        mesIni = Integer.parseInt(mesInic);
        yearIni = Integer.parseInt(yearInic);
        diaFin = Integer.parseInt(diaFina);
        mesFin = Integer.parseInt(mesFina);
        yearFin = Integer.parseInt(yearFina);

        if (yearIni > yearFin) {

            validador = false;
        } else if (yearIni == yearFin) {

            if (mesIni > mesFin) {

                validador = false;
            } else if (mesIni == mesFin) {

                if (diaIni > diaFin) {

                    validador = false;
                }
            }
        }
        return validador;
    }

    /**
     * @param metodo que trae la fecha actual del sistema
     * @return un string con la fecha actual del sistema
     */
    public String fechaActual() {
        Calendar fecha = new GregorianCalendar();
        int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH) + 1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);

        return String.format("%02d/%02d/%02d", dia, mes, anio);

    }

    /**
     * @param metodo que trae la fecha actual del sistema, en formato YYYY-MM-DD
     * @return un string con la fecha actual del sistema
     */
    public String fechaActualYYYYMMDD() {
        Calendar fecha = new GregorianCalendar();
        int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH) + 1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);

        return String.format("%02d-%02d-%02d", anio, mes, dia);

    }

    /**
     * Metodo que trae la fecha y hora actual del sistema, en formato 'dd/MM/YY
     * - HH:mm:ss (AM/PM)'.
     *
     * @return Un string con la fecha y hora actual del sistema.
     */
    public static String fechaHoraActual() {
        Calendar fechaHora = new GregorianCalendar();

        int anio = fechaHora.get(Calendar.YEAR);
        int mes = fechaHora.get(Calendar.MONTH) + 1;
        int dia = fechaHora.get(Calendar.DAY_OF_MONTH);
        int hora = fechaHora.get(Calendar.HOUR);
        int minutos = fechaHora.get(Calendar.MINUTE);
        int segundos = fechaHora.get(Calendar.SECOND);
        int ampm = fechaHora.get(Calendar.AM_PM);

        String hour = "", date = "", moment = "";
        String resp = "";

        switch (ampm) {
            case Calendar.AM: {
                moment = "AM";
            }
            break;
            case Calendar.PM: {
                moment = "PM";
            }
            break;
        }
        if (hora == 0) {
            hora = 12;
        }

        hour = String.format("%02d:%02d:%02d", hora, minutos, segundos);
        date = String.format("%02d/%02d/%02d", dia, mes, anio);
        resp = date + " - " + hour + " " + moment;

        return resp;
    }

    /**
     * @param cajaFecha: JFormattedTextField con una fecha incompleta la cual se
     * va a completar en fomato DD/MM/YYYY
     * @param a�oContable: ingresa el a�o contable
     * @param metodo que completa una fecha incompleta
     */
    public static void completarFechaStatic(JFormattedTextField cajaFecha, String anioContable){
		if (cajaFecha.getText().replace("/", "").trim().isEmpty()) {
        } else if (cajaFecha.getText().replace("/", "").trim().length() == 2) {
            Calendar fecha = new GregorianCalendar();
//			int ano = fecha.get(Calendar.YEAR);
            String ano = anioContable.trim();
            int mes = fecha.get(Calendar.MONTH) + 1;
            String anoNuevo = ano;
            String mesNuevo;
            if (mes < 10) {
                mesNuevo = "0" + Integer.toString(mes);
            } else {
                mesNuevo = Integer.toString(mes);
            }
            cajaFecha.setText(cajaFecha.getText().replace("/", "").trim() + mesNuevo + anoNuevo);

        } else if (cajaFecha.getText().replace("/", "").trim().length() == 4) {
            //	Calendar fecha = new GregorianCalendar();
            //int ano = fecha.get(Calendar.YEAR);
            String ano = anioContable.trim();
            //String anoNuevo=Integer.toString(ano);
            String anoNuevo = ano;
            cajaFecha.setText(cajaFecha.getText().replace("/", "").trim() + anoNuevo);

        } else if (cajaFecha.getText().replace("/", "").trim().length() == 6) {
            String nuevoano = "20" + cajaFecha.getText().replace("/", "").trim().substring(4, 6);
            cajaFecha.setText(cajaFecha.getText().replace("/", "").trim().substring(0, 4) + nuevoano);
        } else if (cajaFecha.getText().replace("/", "").trim().length() != 8) {

            cajaFecha.setValue("");
            cajaFecha.grabFocus();
        }
    }

    /**
     * @param formato DD/MM/YYYY en string
     * @param metodo que valida si una fecha es valida o invalida
     * @return un String con la informacion, si el a�o el mes o el dia son
     * invalidos
     */
    public static String validarFechaDDMMYYYYStatic(String fecha) {

        if (fecha.replace("/", "").replace(" ", "").trim().length() != 8) {
            return "INVALIDO";
        } else {
            String cadena = fecha.replace("/", "");
            String dia = cadena.substring(0, 2);
            String mes = cadena.substring(2, 4);
            String paso = "";
            if (cadena.trim().length() < 8) {
                return "fecha";
            }

            String anio = cadena.substring(4);
            // System.out.println(anio);
            int numeromes = Integer.parseInt(mes);
            int numerodia = Integer.parseInt(dia);
            int numeroan = Integer.parseInt(anio);
            GregorianCalendar calendar = new GregorianCalendar();
            boolean bis = calendar.isLeapYear(numeroan);

            if (anio.charAt(0) == '0') {
                paso = "anio";
            }
            if (numerodia > 31) {
                paso = "dia";
            }
            if (numeromes > 12) {
                paso = "mes";
            } else if (mes.equals("04") || mes.equals("06") || mes.equals("09") || mes.equals("11")) {
                if (numerodia > 30) {
                    paso = "dia";
                }
            } else if (mes.equals("02")) {
                if (bis && numerodia > 29) {
                    paso = "dia";
                }
                if (!bis && numerodia > 28) {
                    paso = "dia";
                }
            }
            return paso;
        }
    }

    /**
     * @param metodo que trae la fecha actual del sistema
     * @return un string con la fecha actual del sistema
     */
    public static String fechaActualStatic() {
        Calendar fecha = new GregorianCalendar();
        int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH) + 1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);

        return String.format("%02d/%02d/%02d", dia, mes, anio);

    }

    /**
     * M�todo encargado de retornar la fecha inicial de un periodo contable
     *
     * @param periodoContable
     * @return
     */
    public static String fechaInicialStatic(String periodoContable) {
        return "01" + "01" + periodoContable;
    }

    /**
     * M�todo encargado de retornar la fecha Final de un periodo contable
     *
     * @param periodoContable
     * @return
     */
    public static String fechaFinalStatic(String periodoContable) {
        return "31" + "12" + periodoContable;
    }

    public static Date getDate(String date) {
        try {
            DateFormat format = new SimpleDateFormat(PATRON_FECHA_ddMMyy, Locale.ENGLISH);
            return format.parse(date);
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }

    public static String getToday() {
        return fechaActualStatic().replace("/", "");
    }

    /**
     * @param metodo que trae el a�o actual del sistema
     * @return un int con el a�o actual del sistema
     */
    public int traerAnioActualEntero() {
        Calendar fecha = new GregorianCalendar();
        int ano = fecha.get(Calendar.YEAR);
        return ano;
    }

    /**
     * @param metodo que trae el mes actual del sistema
     * @return un int con el mes actual del sistema
     */
    public int traerMesActualEntero() {
        Calendar fecha = new GregorianCalendar();
        int mes = fecha.get(Calendar.MONTH) + 1;
        return mes;
    }

    /**
     * @param metodo que trae el dia actual del sistema
     * @return un int con el dia actual del sistema
     */
    public int traerDiaActualEntero() {
        Calendar fecha = new GregorianCalendar();
        int mes = fecha.get(Calendar.DAY_OF_MONTH);
        return mes;
    }

    /**
     * Formatea la fecha con el formato ingresado.
     *
     * @param formatoOriginal Formato de la fecha (por ejemplo <b>yyyy-MM-dd</b>
     * o <b>dd/MM/yy</b>).
     * @param formatoDeseado Formato de la fecha (por ejemplo <b>yyyy-MM-dd</b>
     * o <b>dd/MM/yy</b>).
     * @param fecha
     * @return
     */
    public static String formatearFecha(String formatoOriginal, String formatoDeseado, String fecha) {
        DateFormat df = new SimpleDateFormat(formatoDeseado, Locale.ENGLISH);
        Date resp = Fecha.getDate(fecha, formatoOriginal);
        return df.format(resp);
    }

    public static Date getDate(String date, String formato) {
        try {
            DateFormat format = new SimpleDateFormat(formato, Locale.ENGLISH);
            return format.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Obtiene la fecha en formato MMM dd/YYYY.
     *
     * @param fecha
     * @return
     */
    public static String getFechaCortaLetrasMayus(String fecha) {

        String dia = fecha.substring(0, 2);
        String mesNum = fecha.substring(3, 5);
        String anio = fecha.substring(6);

        String mesLet = "";
        if (mesNum.equals("01")) {
            mesLet = "ENE";
        } else if (mesNum.equals("02")) {
            mesLet = "FEB";
        } else if (mesNum.equals("03")) {
            mesLet = "MAR";
        } else if (mesNum.equals("04")) {
            mesLet = "ABR";
        } else if (mesNum.equals("05")) {
            mesLet = "MAY";
        } else if (mesNum.equals("06")) {
            mesLet = "JUN";
        } else if (mesNum.equals("07")) {
            mesLet = "JUL";
        } else if (mesNum.equals("08")) {
            mesLet = "AGO";
        } else if (mesNum.equals("09")) {
            mesLet = "SEP";
        } else if (mesNum.equals("10")) {
            mesLet = "OCT";
        } else if (mesNum.equals("11")) {
            mesLet = "NOV";
        } else if (mesNum.equals("12")) {
            mesLet = "DIC";
        }

        String resp = mesLet + "/" + dia + "/" + anio;
        return resp;
    }

    public static String getNombreCompletoMes(int mes) {
        String nombre = "";

        switch (mes) {
            case 0:
                nombre = "Inicio";
                break;
            case 1:
                nombre = "Enero";
                break;
            case 2:
                nombre = "Febrero";
                break;
            case 3:
                nombre = "Marzo";
                break;
            case 4:
                nombre = "Abril";
                break;
            case 5:
                nombre = "Mayo";
                break;
            case 6:
                nombre = "Junio";
                break;
            case 7:
                nombre = "Julio";
                break;
            case 8:
                nombre = "Agosto";
                break;
            case 9:
                nombre = "Septiembre";
                break;
            case 10:
                nombre = "Octubre";
                break;
            case 11:
                nombre = "Noviembre";
                break;
            case 12:
                nombre = "Diciembre";
                break;
        }

        return nombre;
    }

}
