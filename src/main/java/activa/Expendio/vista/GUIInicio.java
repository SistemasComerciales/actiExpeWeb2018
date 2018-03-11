/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.vista;

import activa.Expendio.controllers.*;
import activa.Expendio.modelo.*;
import activa.Expendio.persistencia.Interface.*;
import activa.Expendio.vista.utils.*;
import java.awt.event.*;
import javax.swing.*;
import utils.*;

/**
 *
 * @author Avuuna la Luz del Alba
 */
public class GUIInicio extends ClaseGeneral {

    private CajaDeTexto txt_usuario;
    private JPasswordField txt_contrasena;
    private JButton btn_iniciarSesion;

    private int anchoBotonesPanel1, altoBotonesPanel1;

    public GUIInicio(Usuario usuario) {
        super(usuario);

        Imagenes.fondoInternalFrame(NombreImagenes.imFondo, this.getWidth(), this.getHeight(), this);
        anchoBotonesPanel1 = 2 * this.getWidth() / 7;
        altoBotonesPanel1 = 2 * this.getHeight() / 25;

        Elementos();
        Acciones();
        this.setLocation(0, 0);
        this.setResizable(false);
        this.setVisible(true);
        this.repaint();
        exitOnClose();
        actualizarFrame();

    }

    public void nombreClase() {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarFrame() {
        //To change body of generated methods, choose Tools | Templates.
        txt_usuario.grabFocus();
        txt_usuario.setText("");
        txt_contrasena.setText("");

    }

    @Override
    public void eliminarReferencia() {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarFoco() {
        txt_usuario.grabFocus();
    }

    public void inicializarDatos() {
        txt_usuario.setText("");
        txt_contrasena.setText("");
        txt_usuario.grabFocus();
    }

    @Override
    public void asignarPermisos() {
        //To change body of generated methods, choose Tools | Templates.
    }

    public void Elementos() {
        int anchoLabel = 40;
        int altoLabel = 40;
        int anchoTxt = this.getWidth() / 6;
        int altoTxt = 25;
        int anchoBoton = 50;
        int altoBoton = 50;
        int espacioParametrosVertical = 5;
        int espacioParametrosHorizontal = 5;
        int posicionX = this.getWidth() / 8;
        int anchoLogo = this.getWidth() / 5;
        int altoLogo = this.getHeight() / 3;
        int posicionXLogo = posicionX;
        int posicionYLogo = this.getHeight() / 15;
        int posicionY = posicionYLogo + altoLogo + altoLogo / 6;

        txt_usuario = new CajaDeTexto("G");
        txt_usuario.setLocation(((this.getWidth() / 4)), 2 * this.getHeight() / 3);
        txt_usuario.setSize(198, 25);
        this.add(txt_usuario);
        txt_usuario.setFont(Letra.fuenteTxt);
        txt_usuario.setForeground(Letra.colorTxt);
        txt_usuario.setDisabledTextColor(Letra.colorTxtDisable);
        TextPrompt placeholder = new TextPrompt("Usuario", txt_usuario);

        txt_contrasena = new JPasswordField();
        txt_contrasena.setLocation(((this.getWidth() / 4)), 3 * this.getHeight() / 4);
        txt_contrasena.setSize(198, 25);
        this.add(txt_contrasena);
        txt_contrasena.setFont(Letra.fuenteTxt);
        txt_contrasena.setForeground(Letra.colorTxt);
        txt_contrasena.setDisabledTextColor(Letra.colorTxtDisable);
        TextPrompt placeholder2 = new TextPrompt("Contraseña", txt_contrasena);

        btn_iniciarSesion = new Boton(NombreImagenes.imBIniciar1, NombreImagenes.imBIniciar2, "");
        btn_iniciarSesion.setOpaque(false);
        btn_iniciarSesion.setContentAreaFilled(false);
        btn_iniciarSesion.setBorderPainted(false);
        btn_iniciarSesion.setSize(anchoBoton, altoBoton);
        btn_iniciarSesion.setLocation(txt_contrasena.getX() + txt_contrasena.getWidth() + espacioParametrosHorizontal, txt_contrasena.getY() - ((altoBoton - altoTxt) / 2));
        btn_iniciarSesion.setToolTipText("Iniciar Sesión");
        this.add(btn_iniciarSesion);

    }

    private void Acciones() {
        btn_iniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersistenciaUsuarioInt repositorioUsuarios = Servicios.userController.userRepository;
                Usuario usuario = new Usuario();
                usuario.setLogin(txt_usuario.getText().trim());
                usuario.setPassword(String.valueOf(txt_contrasena.getPassword()));
                usuario = repositorioUsuarios.getUsuarioLogin(usuario);
                if (usuario == null) {
                    option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "Usuario/Password inválidos", "");
                    inicializarDatos();
                } else {
                    new GUIMenu(usuario);
                    frame.setVisible(false);
                }
//                System.out.println("Aca: " + repositorioUsuarios.getUsuarios().size());
            }
        });

        txt_usuario.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    txt_contrasena.grabFocus();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });

        txt_contrasena.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btn_iniciarSesion.grabFocus();
                    btn_iniciarSesion.doClick();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
    }
}
