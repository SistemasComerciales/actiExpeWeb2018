package utils;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

import javax.imageio.*;
import javax.swing.*;

public class CargaImagenes {

    public static int ANCHO_PANTALLA, ALTO_PANTALLA;

    public static BufferedImage FONDO_INICIOSESION;
    public static BufferedImage FONDO_GENERAL;
    public static BufferedImage FONDO_OPTION;
    public static BufferedImage FONDO_MENU;

    public static ImageIcon LBL_INFORMACION;
    public static ImageIcon LBL_ADVERTENCIA;
    public static ImageIcon LBL_ERROR;
    public static ImageIcon LBL_PREGUNTA;

    public static ImageIcon BTN_CONFIGURACION;
    public static ImageIcon BTN_CONFIGURACION2;
    public static ImageIcon BTN_INICIARSESION;
    public static ImageIcon BTN_INICIARSESION2;
    public static ImageIcon BTN_MASOPCIONES;
    public static ImageIcon BTN_MASOPCIONES2;
    public static ImageIcon BTN_ACTUALIZARBD;
    public static ImageIcon BTN_ACTUALIZARBD2;

    public static ImageIcon BTN_GENERAL;
    public static ImageIcon BTN_GENERAL2;
    public static ImageIcon BTN_GENERALROJO;

    public static ImageIcon BTN_GENERALMINI;
    public static ImageIcon BTN_GENERALMINI2;

    public static ImageIcon BTN_PESTANA;
    public static ImageIcon BTN_PESTANA2;
    public static ImageIcon BTN_PESTANA3;

    public static ImageIcon IMBPRINCIPALPORDEFECTOMENU;
    public static ImageIcon IMBPRINCIPALPORDEFECTOMENU2;
    public static ImageIcon IMBPRINCIPALPORDEFECTOMENU3;

    public static ImageIcon IMBPORDEFECTOMENU;
    public static ImageIcon IMBPORDEFECTOMENU2;
    public static ImageIcon IMBPORDEFECTOMENU3;

    public static ImageIcon IMB2NIVELMENU;
    public static ImageIcon IMB2NIVELMENU2;
    public static ImageIcon IMB2NIVELMENU3;

    public static ImageIcon BTN_MAIN_SALIR;
    public static ImageIcon BTN_MAIN_SALIR2;

    private static String imagenes = "imagenes/";

    // tamaño de los botones generales de todo el programa
    public static int anchoBotonGeneral;
    public static int altoBotonGeneral;
    // tamaño de los botones cuadrados de todo el programa
    public static int anchoBotonCuadrado;
    public static int altoBotonCuadrado;
    // tamaño de los label Inicio sesion de todo el programa
    public static int anchoLabelInicioSesion;
    public static int altoBotonInicioSesion;

    // tamaño LBL JOPTION
    public static int anchoOption;
    public static int altoOption;
    // tamaño Botones Catalogos
    public static int anchoBotonCatalogos;
    public static int altoBotonCatalogos;
    // tamaño BOtones Camra y ruta
    public static int anchoBotonMini;
    public static int altoBotonMini;
    // tamaño Botones Pestañas mini
    public static int anchoBotonPestanasMini;
    public static int altoBotonPestanasMini;
    // Tamaño botones SiNo Permisos
    public static int anchoBotonPermiso;
    public static int altoBotonPermiso;

    public static int altoBotonesPrincipalesMenu;
    public static int anchoBotonesPrincipalesMenu;

    // tamaño bogbotnes menu primer nivel
    public static int altoBotonPrimerNivelMenu;
    public static int anchoBotonPrimerNivelMenu;
    // tamaño bogbotnes menu segundo nivel
    public static int altoBotonSegundoNivelMenu;
    public static int anchoBotonSegundoNivelMenu;
    // tamaño bogbotnes menu tercer nivel
    public static int altoBotonTercerNivelMenu;
    public static int anchoBotonTercerNivelMenu;

    public static int anchoBotonesPanelSalirMenu;
    public static int altoBotonesPanelSalirMenu;

    public static HashMap<String, BufferedImage> listaFondos;
    public static HashMap<String, ImageIcon> listaImagenes2;

    static {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double ancho = screenSize.getWidth();
        double altura = screenSize.getHeight();
        CargaImagenes.ANCHO_PANTALLA = (int) ancho;
        CargaImagenes.ALTO_PANTALLA = (int) altura - 35;
        try {
            // tamaño de los botones generales de todo el programa
            anchoBotonGeneral = ANCHO_PANTALLA / 13;
            altoBotonGeneral = ALTO_PANTALLA / 24;
            // tamaño de los botones cuadrados de todo el programa
            anchoBotonCuadrado = 50;
            altoBotonCuadrado = 50;
            // tamaño de los label Inicio sesion de todo el programa
            anchoLabelInicioSesion = 40;
            altoBotonInicioSesion = 40;
            // tamaño LBL JOPTION
            anchoOption = (ANCHO_PANTALLA / 6) / 2 - 10;
            altoOption = (ALTO_PANTALLA / 3) / 2;
            // tamaño Botones Catalogos
            anchoBotonCatalogos = ANCHO_PANTALLA / 5 - 2;
            altoBotonCatalogos = (ALTO_PANTALLA / 21);
            // tamaño BOtones Camra y ruta
            anchoBotonMini = ANCHO_PANTALLA / 29;
            altoBotonMini = 35;
            // Tamaño Botones pestañas mini
            anchoBotonPestanasMini = ANCHO_PANTALLA / 8;
            altoBotonPestanasMini = ALTO_PANTALLA / 25;
            // Tamaño botones SiNo Permisos
            anchoBotonPermiso = ((3 * ANCHO_PANTALLA / 4) / 8) / 2;
            altoBotonPermiso = 35;
            // tamaño botones principales menu
            altoBotonesPrincipalesMenu = ALTO_PANTALLA / 17;
            anchoBotonesPrincipalesMenu = ANCHO_PANTALLA / 4;
            // tamaño botones primer nivel
            altoBotonPrimerNivelMenu = 2 * ALTO_PANTALLA / 25;
            anchoBotonPrimerNivelMenu = 2 * ANCHO_PANTALLA / 7;
            // tamaño botones segundo nivel
            altoBotonSegundoNivelMenu = 2 * altoBotonPrimerNivelMenu / 3;
            anchoBotonSegundoNivelMenu = 3 * anchoBotonPrimerNivelMenu / 5;
//			altoBotonSegundoNivelMenu = ALTO_PANTALLA / 18;
//			anchoBotonSegundoNivelMenu = ANCHO_PANTALLA / 6;
            // tamaño botones de tercer nivel
            altoBotonTercerNivelMenu = ALTO_PANTALLA / 18;
            anchoBotonTercerNivelMenu = 15 * ANCHO_PANTALLA / 96;

            // tamaño boton salir menu
            anchoBotonesPanelSalirMenu = 3 * ANCHO_PANTALLA / 27;
            altoBotonesPanelSalirMenu = ALTO_PANTALLA / 19;

            FONDO_INICIOSESION = ImageIO.read(new File(NombreImagenes.imFondo));
            FONDO_GENERAL = ImageIO.read(new File(NombreImagenes.imFondoG));
            FONDO_OPTION = ImageIO.read(new File(NombreImagenes.imFondoD));
            FONDO_MENU = ImageIO.read(new File(NombreImagenes.imFondoMenu));

            LBL_ADVERTENCIA = new ImageIcon(imagenes + "lbl_advertencia.png");
            LBL_ADVERTENCIA = new ImageIcon(
                    LBL_ADVERTENCIA.getImage().getScaledInstance(anchoOption, altoOption, Image.SCALE_SMOOTH));

            LBL_PREGUNTA = new ImageIcon(imagenes + "lbl_pregunta.png");
            LBL_PREGUNTA = new ImageIcon(
                    LBL_PREGUNTA.getImage().getScaledInstance(anchoOption, altoOption, Image.SCALE_SMOOTH));

            LBL_INFORMACION = new ImageIcon(imagenes + "lbl_informacion.png");
            LBL_INFORMACION = new ImageIcon(
                    LBL_INFORMACION.getImage().getScaledInstance(anchoOption, altoOption, Image.SCALE_SMOOTH));

            LBL_ERROR = new ImageIcon(imagenes + "lbl_error.png");
            LBL_ERROR = new ImageIcon(
                    LBL_ERROR.getImage().getScaledInstance(anchoOption, altoOption, Image.SCALE_SMOOTH));

            BTN_CONFIGURACION = new ImageIcon(imagenes + "btn_configuracion.png");
            BTN_CONFIGURACION = new ImageIcon(BTN_CONFIGURACION.getImage().getScaledInstance(anchoBotonCuadrado,
                    altoBotonCuadrado, Image.SCALE_SMOOTH));
            BTN_CONFIGURACION2 = new ImageIcon(imagenes + "btn_configuracion2.png");
            BTN_CONFIGURACION2 = new ImageIcon(BTN_CONFIGURACION2.getImage().getScaledInstance(anchoBotonCuadrado,
                    altoBotonCuadrado, Image.SCALE_SMOOTH));

            BTN_INICIARSESION = new ImageIcon(imagenes + "btn_iniciarSesion.png");
            BTN_INICIARSESION = new ImageIcon(BTN_INICIARSESION.getImage().getScaledInstance(anchoBotonCuadrado,
                    altoBotonCuadrado, Image.SCALE_SMOOTH));
            BTN_INICIARSESION2 = new ImageIcon(imagenes + "btn_iniciarSesion2.png");
            BTN_INICIARSESION2 = new ImageIcon(BTN_INICIARSESION2.getImage().getScaledInstance(anchoBotonCuadrado,
                    altoBotonCuadrado, Image.SCALE_SMOOTH));

            BTN_MASOPCIONES = new ImageIcon(imagenes + "btn_masOpciones.png");
            BTN_MASOPCIONES = new ImageIcon(BTN_MASOPCIONES.getImage().getScaledInstance(anchoBotonCuadrado,
                    altoBotonCuadrado, Image.SCALE_SMOOTH));
            BTN_MASOPCIONES2 = new ImageIcon(imagenes + "btn_masOpciones2.png");
            BTN_MASOPCIONES2 = new ImageIcon(BTN_MASOPCIONES2.getImage().getScaledInstance(anchoBotonCuadrado,
                    altoBotonCuadrado, Image.SCALE_SMOOTH));

            BTN_ACTUALIZARBD = new ImageIcon(imagenes + "btn_actualizarBD.png");
            BTN_ACTUALIZARBD = new ImageIcon(BTN_ACTUALIZARBD.getImage().getScaledInstance(anchoBotonCuadrado,
                    altoBotonCuadrado, Image.SCALE_SMOOTH));
            BTN_ACTUALIZARBD2 = new ImageIcon(imagenes + "btn_actualizarBD2.png");
            BTN_ACTUALIZARBD2 = new ImageIcon(BTN_ACTUALIZARBD2.getImage().getScaledInstance(anchoBotonCuadrado,
                    altoBotonCuadrado, Image.SCALE_SMOOTH));

            BTN_GENERAL = new ImageIcon(imagenes + "btn_general.png");
            BTN_GENERAL = new ImageIcon(
                    BTN_GENERAL.getImage().getScaledInstance(anchoBotonGeneral, altoBotonGeneral, Image.SCALE_SMOOTH));
            BTN_GENERAL2 = new ImageIcon(imagenes + "btn_general2.png");
            BTN_GENERAL2 = new ImageIcon(
                    BTN_GENERAL2.getImage().getScaledInstance(anchoBotonGeneral, altoBotonGeneral, Image.SCALE_SMOOTH));

            BTN_GENERALROJO = new ImageIcon(NombreImagenes.imBGeneralRojo);
            BTN_GENERALROJO = new ImageIcon(BTN_GENERALROJO.getImage().getScaledInstance(anchoBotonGeneral,
                    altoBotonGeneral, Image.SCALE_SMOOTH));

            BTN_GENERALMINI = new ImageIcon(imagenes + "btn_generalMini1.png");
            BTN_GENERALMINI = new ImageIcon(
                    BTN_GENERALMINI.getImage().getScaledInstance(anchoBotonMini, altoBotonMini, Image.SCALE_SMOOTH));
            BTN_GENERALMINI2 = new ImageIcon(imagenes + "btn_generalMini2.png");
            BTN_GENERALMINI2 = new ImageIcon(
                    BTN_GENERALMINI2.getImage().getScaledInstance(anchoBotonMini, altoBotonMini, Image.SCALE_SMOOTH));

            BTN_PESTANA = new ImageIcon(imagenes + "btn_pestana.png");
            BTN_PESTANA = new ImageIcon(BTN_PESTANA.getImage().getScaledInstance(anchoBotonPestanasMini,
                    altoBotonPestanasMini, Image.SCALE_SMOOTH));
            BTN_PESTANA2 = new ImageIcon(imagenes + "btn_pestana2.png");
            BTN_PESTANA2 = new ImageIcon(BTN_PESTANA2.getImage().getScaledInstance(anchoBotonPestanasMini,
                    altoBotonPestanasMini, Image.SCALE_SMOOTH));
            BTN_PESTANA3 = new ImageIcon(imagenes + "btn_pestana3.png");
            BTN_PESTANA3 = new ImageIcon(BTN_PESTANA3.getImage().getScaledInstance(anchoBotonPestanasMini,
                    altoBotonPestanasMini, Image.SCALE_SMOOTH));

            IMBPRINCIPALPORDEFECTOMENU = new ImageIcon(NombreImagenes.imBPrincipalPorDefectoMenu);
            IMBPRINCIPALPORDEFECTOMENU = new ImageIcon(IMBPRINCIPALPORDEFECTOMENU.getImage()
                    .getScaledInstance(anchoBotonesPrincipalesMenu, altoBotonesPrincipalesMenu, Image.SCALE_SMOOTH));

            IMBPRINCIPALPORDEFECTOMENU2 = new ImageIcon(NombreImagenes.imBPrincipalPorDefectoMenu2);
            IMBPRINCIPALPORDEFECTOMENU2 = new ImageIcon(IMBPRINCIPALPORDEFECTOMENU2.getImage()
                    .getScaledInstance(anchoBotonesPrincipalesMenu, altoBotonesPrincipalesMenu, Image.SCALE_SMOOTH));

            IMBPRINCIPALPORDEFECTOMENU3 = new ImageIcon(NombreImagenes.imBPrincipalPorDefectoMenu3);
            IMBPRINCIPALPORDEFECTOMENU3 = new ImageIcon(IMBPRINCIPALPORDEFECTOMENU3.getImage()
                    .getScaledInstance(anchoBotonesPrincipalesMenu, altoBotonesPrincipalesMenu, Image.SCALE_SMOOTH));

            IMBPORDEFECTOMENU = new ImageIcon(NombreImagenes.imBPorDefectoMenu);
            IMBPORDEFECTOMENU = new ImageIcon(IMBPORDEFECTOMENU.getImage().getScaledInstance(anchoBotonPrimerNivelMenu,
                    altoBotonPrimerNivelMenu, Image.SCALE_SMOOTH));

            IMBPORDEFECTOMENU2 = new ImageIcon(NombreImagenes.imBPorDefectoMenu2);
            IMBPORDEFECTOMENU2 = new ImageIcon(IMBPORDEFECTOMENU2.getImage()
                    .getScaledInstance(anchoBotonPrimerNivelMenu, altoBotonPrimerNivelMenu, Image.SCALE_SMOOTH));

            IMBPORDEFECTOMENU3 = new ImageIcon(NombreImagenes.imBPorDefectoMenu3);
            IMBPORDEFECTOMENU3 = new ImageIcon(IMBPORDEFECTOMENU3.getImage()
                    .getScaledInstance(anchoBotonPrimerNivelMenu, altoBotonPrimerNivelMenu, Image.SCALE_SMOOTH));

            IMB2NIVELMENU = new ImageIcon(NombreImagenes.imB2NivelMenu);
            IMB2NIVELMENU = new ImageIcon(IMB2NIVELMENU.getImage().getScaledInstance(anchoBotonSegundoNivelMenu,
                    altoBotonSegundoNivelMenu, Image.SCALE_SMOOTH));

            IMB2NIVELMENU2 = new ImageIcon(NombreImagenes.imB2NivelMenu2);
            IMB2NIVELMENU2 = new ImageIcon(IMB2NIVELMENU2.getImage().getScaledInstance(anchoBotonSegundoNivelMenu,
                    altoBotonSegundoNivelMenu, Image.SCALE_SMOOTH));

            IMB2NIVELMENU3 = new ImageIcon(NombreImagenes.imB2NivelMenu3);
            IMB2NIVELMENU3 = new ImageIcon(IMB2NIVELMENU3.getImage().getScaledInstance(anchoBotonSegundoNivelMenu,
                    altoBotonSegundoNivelMenu, Image.SCALE_SMOOTH));

            BTN_MAIN_SALIR = new ImageIcon(NombreImagenes.imBSalirMenu);
            BTN_MAIN_SALIR = new ImageIcon(BTN_MAIN_SALIR.getImage().getScaledInstance(anchoBotonesPanelSalirMenu,
                    altoBotonesPanelSalirMenu, Image.SCALE_SMOOTH));

            BTN_MAIN_SALIR2 = new ImageIcon(NombreImagenes.imBSalirMenu2);
            BTN_MAIN_SALIR2 = new ImageIcon(BTN_MAIN_SALIR2.getImage().getScaledInstance(anchoBotonesPanelSalirMenu,
                    altoBotonesPanelSalirMenu, Image.SCALE_SMOOTH));

        } catch (IOException e) {
            e.printStackTrace();
        }
        listaFondos = new HashMap<String, BufferedImage>();
        listaImagenes2 = new HashMap<String, ImageIcon>();
        almacenarHasmap();
    }

    /**
     * metodo que almacena los buferes y las rutas de las imagenes en un hashmap
     */
    public static void almacenarHasmap() {
        listaFondos.put(NombreImagenes.imFondo, FONDO_INICIOSESION);
        listaFondos.put(NombreImagenes.imFondoG, FONDO_GENERAL);
        listaFondos.put(NombreImagenes.imFondoD, FONDO_OPTION);
        listaFondos.put(NombreImagenes.imFondoMenu, FONDO_MENU);

        listaImagenes2.put(imagenes + "btn_configuracion.png", BTN_CONFIGURACION);
        listaImagenes2.put(imagenes + "btn_configuracion2.png", BTN_CONFIGURACION2);
        listaImagenes2.put(imagenes + "btn_iniciarSesion.png", BTN_INICIARSESION);
        listaImagenes2.put(imagenes + "btn_iniciarSesion2.png", BTN_INICIARSESION2);
        listaImagenes2.put(imagenes + "btn_masOpciones.png", BTN_MASOPCIONES);
        listaImagenes2.put(imagenes + "btn_masOpciones2.png", BTN_MASOPCIONES2);
        listaImagenes2.put(imagenes + "btn_actualizarBD.png", BTN_ACTUALIZARBD);
        listaImagenes2.put(imagenes + "btn_actualizarBD2.png", BTN_ACTUALIZARBD2);

        listaImagenes2.put(imagenes + "btn_general.png", BTN_GENERAL);
        listaImagenes2.put(imagenes + "btn_general2.png", BTN_GENERAL2);
        listaImagenes2.put(NombreImagenes.imBGeneralRojo, BTN_GENERALROJO);

        listaImagenes2.put(imagenes + "btn_generalMini1.png", BTN_GENERALMINI);
        listaImagenes2.put(imagenes + "btn_generalMini2.png", BTN_GENERALMINI2);

        listaImagenes2.put(imagenes + "btn_pestana.png", BTN_PESTANA);
        listaImagenes2.put(imagenes + "btn_pestana2.png", BTN_PESTANA2);
        listaImagenes2.put(imagenes + "btn_pestana3.png", BTN_PESTANA3);

        listaImagenes2.put(imagenes + "lbl_advertencia.png", LBL_ADVERTENCIA);
        listaImagenes2.put(imagenes + "lbl_pregunta.png", LBL_PREGUNTA);
        listaImagenes2.put(imagenes + "lbl_informacion.png", LBL_INFORMACION);
        listaImagenes2.put(imagenes + "lbl_error.png", LBL_ERROR);

        listaImagenes2.put(NombreImagenes.imBSalirMenu, BTN_MAIN_SALIR);
        listaImagenes2.put(NombreImagenes.imBSalirMenu2, BTN_MAIN_SALIR2);

        listaImagenes2.put(NombreImagenes.imBPrincipalPorDefectoMenu, IMBPRINCIPALPORDEFECTOMENU);
        listaImagenes2.put(NombreImagenes.imBPrincipalPorDefectoMenu2, IMBPRINCIPALPORDEFECTOMENU2);
        listaImagenes2.put(NombreImagenes.imBPrincipalPorDefectoMenu3, IMBPRINCIPALPORDEFECTOMENU3);

        listaImagenes2.put(NombreImagenes.imBPorDefectoMenu, IMBPORDEFECTOMENU);
        listaImagenes2.put(NombreImagenes.imBPorDefectoMenu2, IMBPORDEFECTOMENU2);
        listaImagenes2.put(NombreImagenes.imBPorDefectoMenu3, IMBPORDEFECTOMENU3);

        listaImagenes2.put(NombreImagenes.imB2NivelMenu, IMB2NIVELMENU);
        listaImagenes2.put(NombreImagenes.imB2NivelMenu2, IMB2NIVELMENU2);
        listaImagenes2.put(NombreImagenes.imB2NivelMenu3, IMB2NIVELMENU3);

    }

    public static BufferedImage getImg(String rutaImg) {

        if (listaFondos.containsKey(rutaImg)) {
            return listaFondos.get(rutaImg);
        }
        return null;

    }

    public static ImageIcon getImgBoton(String rutaImg) {
        if (listaImagenes2.containsKey(rutaImg)) {
            return listaImagenes2.get(rutaImg);
        }
        return null;

    }

}
