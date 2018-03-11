package utils;

import activa.Expendio.modelo.*;
import activa.Expendio.vista.utils.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CampoDireccion extends JPanel {
	private static final long serialVersionUID = 7990765452637749338L;
	
	public CampoLabel lbl_direccion, lbl_no;
	public CajaDeTexto txt_direccion;
	public CajaDeTextoConFormatoNumerico txt_callevp, txt_callevs, txt_callevss;
	public CampoCombo<String> combo_tipocalle, combo_letravp, combo_letravs, combo_bis, combo_se, combo_se2;
	public CasillaVerificacion ch_bisuno, ch_dirnormal;
	
	// Utilitarios
	private boolean esDireccionCombo, esBis;
	private int ANCHO_PANTALLA, ALTO_PANTALLA;
	private Usuario usuario;
	private String texto;
	
	// Constantes varias
	private static final int longitudMaximaNumeroDireccion = 4;
	private static final int longitudMaximaDireccion = 200;
	private static final String labelEstatico = "E";
	private static final String textoLetras = "G";

	public CampoDireccion(String texto, Usuario usuario, int labelWidth) {
		this.usuario = usuario;
		this.texto = texto;
		
		prepareValores();
		prepareElementos(labelWidth);
			inicializarElementos();
			definaAcciones();
	}

	public CampoDireccion(String texto, Usuario usuario) {
		this(texto, usuario, -1);
	}
	
	private void prepareValores() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double ancho = screenSize.getWidth();
		double altura = screenSize.getHeight();
		ANCHO_PANTALLA = (int) ancho;
		ALTO_PANTALLA = (int) altura - 35;
		
		this.setLayout(null);
		this.setOpaque(false);
//		this.setBorder(new PanelBorde(""));
		this.setBorder(null);
	}
	
	private void prepareElementos(int labelWidth) {
		String[] letras = {"...", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", 
				"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		
		String[] se = {"...", "S", "E"};
		
		int var = 5, var2 = var * 2;
		int labelHeight = ALTO_PANTALLA / 30;
		int filas = (4 * (ALTO_PANTALLA / 18)) / 6;
		int columnas = (ANCHO_PANTALLA - 10) / 7;
		
		if (labelWidth == -1) {
			labelWidth = ANCHO_PANTALLA / 16;
		}
		
		lbl_direccion = new CampoLabel(texto, labelEstatico);
		lbl_direccion.setLocation(0, 0);
		lbl_direccion.setSize(labelWidth, labelHeight);
		this.add(lbl_direccion);
		
		combo_tipocalle = new CampoCombo<String>("...", "Cll", "Cr", "Dg", "Tr", "Av Cll", "Av Cr");
		combo_tipocalle.setLocation(lbl_direccion.getX() + lbl_direccion.getWidth() + var, lbl_direccion.getY());
		combo_tipocalle.setSize(columnas / 4, filas);
		combo_tipocalle.setSelectedIndex(0);
		this.add(combo_tipocalle);
		
		txt_callevp = new CajaDeTextoConFormatoNumerico(longitudMaximaNumeroDireccion, usuario);
		txt_callevp.setLocation(combo_tipocalle.getX() + combo_tipocalle.getWidth() + var, combo_tipocalle.getY());
		txt_callevp.setSize(combo_tipocalle.getWidth(), combo_tipocalle.getHeight());
		this.add(txt_callevp);
		
		combo_letravp = new CampoCombo<String>(letras);
		combo_letravp.setLocation(txt_callevp.getX() + txt_callevp.getWidth() + var, txt_callevp.getY());
		combo_letravp.setSize(txt_callevp.getWidth(), txt_callevp.getHeight());
		combo_letravp.setSelectedIndex(0);
		this.add(combo_letravp);
		
		ch_bisuno = new CasillaVerificacion("Bis");
		ch_bisuno.setLocation(combo_letravp.getX() + combo_letravp.getWidth() + var, combo_letravp.getY());
		ch_bisuno.setSize(combo_letravp.getWidth(), combo_letravp.getHeight());
		this.add(ch_bisuno);
		
		combo_bis = new CampoCombo<String>(letras);
		combo_bis.setLocation(ch_bisuno.getX() + ch_bisuno.getWidth() + var, ch_bisuno.getY());
		combo_bis.setSize(ch_bisuno.getWidth(), ch_bisuno.getHeight());
		combo_bis.setEnabled(false);
		combo_bis.setSelectedIndex(0);
		this.add(combo_bis);
		
		combo_se = new CampoCombo<String>(se);
		combo_se.setLocation(combo_bis.getX() + combo_bis.getWidth() + var, combo_bis.getY());
		combo_se.setSize(combo_bis.getWidth(), combo_bis.getHeight());
		combo_se.setSelectedIndex(0);
		this.add(combo_se);
		
		lbl_no = new CampoLabel("No.", labelEstatico);
		lbl_no.setLocation(lbl_direccion.getX(), lbl_direccion.getY() + lbl_direccion.getHeight() + var2);
		lbl_no.setSize(lbl_direccion.getWidth(), lbl_direccion.getHeight());
		lbl_no.alinearDerecha();
		this.add(lbl_no);
		
		txt_callevs = new CajaDeTextoConFormatoNumerico(longitudMaximaNumeroDireccion, usuario);
		txt_callevs.setLocation(combo_tipocalle.getX(), lbl_no.getY());
		txt_callevs.setSize(combo_tipocalle.getWidth(), combo_tipocalle.getHeight());
		this.add(txt_callevs);
		
		combo_letravs = new CampoCombo<String>(letras);
		combo_letravs.setLocation(txt_callevp.getX(), txt_callevs.getY());
		combo_letravs.setSize(txt_callevs.getWidth(), txt_callevs.getHeight());
		combo_letravs.setSelectedIndex(0);
		this.add(combo_letravs);
		
		txt_callevss = new CajaDeTextoConFormatoNumerico(longitudMaximaNumeroDireccion, usuario);
		txt_callevss.setLocation(combo_letravp.getX(), combo_letravs.getY());
		txt_callevss.setSize(combo_letravs.getWidth(), combo_letravs.getHeight());
		this.add(txt_callevss);
		
		combo_se2 = new CampoCombo<String>(se);
		combo_se2.setLocation(ch_bisuno.getX(), txt_callevss.getY());
		combo_se2.setSize(txt_callevss.getWidth(), txt_callevss.getHeight());
		combo_se2.setSelectedIndex(0);
		this.add(combo_se2);
		
		ch_dirnormal = new CasillaVerificacion("Editar");
		ch_dirnormal.setLocation(lbl_no.getX() + lbl_direccion.getWidth() / 3, lbl_no.getY() + lbl_no.getHeight() + var2);
		ch_dirnormal.setSize(lbl_no.getWidth() / 2, lbl_no.getHeight());
		this.add(ch_dirnormal);
		
		txt_direccion = new CajaDeTexto(textoLetras, 60);
		txt_direccion.setLocation(txt_callevs.getX(), ch_dirnormal.getY());
		txt_direccion.setSize(columnas + columnas / 2, txt_callevs.getHeight());
		txt_direccion.setEnabled(false);
		this.add(txt_direccion);
	}
	
	private void definaAcciones() {
		ch_dirnormal.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				dirnormalAccion();
			}
		});
		ch_dirnormal.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					if (esDireccionCombo) {
						combo_tipocalle.grabFocus();
					} else {
						txt_direccion.grabFocus();
					}
				}
			}
		});
		
		ch_bisuno.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(esBis){
					noEsDireccionConBis();
				}
				else{
					esDireccionConBis();
				}
				
				crearDireccion();
			}
		});
		ch_bisuno.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					if (esBis) {
						combo_bis.grabFocus();
					} else {
						combo_se.grabFocus();
					}
				}
			}
		});
		
		combo_tipocalle.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				crearDireccion();
			}
		});
		combo_tipocalle.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
					txt_callevp.grabFocus();
				}
			}
		});
		
		txt_callevp.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				ValidacionCampos.bloquearTxtSoloNumero(e);
				ValidacionCampos.limitarLongitudString(txt_callevp.getText().trim(), longitudMaximaNumeroDireccion, e);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
					combo_letravp.grabFocus();
				} else {
					crearDireccion();
				}
			}
		});
		
		combo_letravp.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
					ch_bisuno.grabFocus();
				}
			}
		});
		combo_letravp.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				crearDireccion();
			}
		});
		
		combo_bis.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
					combo_se.grabFocus();
				}
			}
		});
		combo_bis.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				crearDireccion();
			}
		});
		
		combo_se.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
					txt_callevs.grabFocus();
				}
			}
		});
		combo_se.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				crearDireccion();
			}
		});
		
		txt_callevs.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				ValidacionCampos.bloquearTxtSoloNumero(e);
				ValidacionCampos.limitarLongitudString(txt_callevs.getText().trim(), longitudMaximaNumeroDireccion, e);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
					combo_letravs.grabFocus();
				} else {
					crearDireccion();
				}
			}
		});
		
		combo_letravs.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
					txt_callevss.grabFocus();
				}
			}
		});
		combo_letravs.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				crearDireccion();
			}
		});
		
		txt_callevss.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				ValidacionCampos.bloquearTxtSoloNumero(e);
				ValidacionCampos.limitarLongitudString(txt_callevss.getText().trim(), longitudMaximaNumeroDireccion, e);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
					combo_se2.grabFocus();
				} else {
					crearDireccion();
				}
			}
		});
		
		combo_se2.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
					/*if (esTipoUnico) {
						txt_regimen.grabFocus();
					} else {
						combo_principalsucursal.grabFocus();
					}*/
				}
			}
		});
		combo_se2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				crearDireccion();
			}
		});
		
		txt_direccion.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				char KeyChar = e.getKeyChar();
				if (Character.isLowerCase(KeyChar)){
					e.setKeyChar(Character.toUpperCase(KeyChar));
				}
				ValidacionCampos.limitarLongitudString(txt_direccion.getText().trim(), longitudMaximaDireccion, e);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
					/*if (esTipoUnico) {
						txt_regimen.grabFocus();
					} else {
						combo_principalsucursal.grabFocus();
					}*/
				}
			}
		});
	}
	
	public void inicializarElementos() {
		esDireccionCombo = true;
		esBis = false;
		
		inicializarDireccionCombo();
		
		txt_direccion.setText("");
		ch_dirnormal.setSelected(false);
		
		dirnormalAccion();
	}
	
	private void dirnormalAccion() {
		esDireccionCombo = !ch_dirnormal.isSelected();
		if(!esDireccionCombo){
			direccionNormal();
		}
		else{
			direccionCombo();
		}
	}
	
	public void direccionNormal() {
		deshabilitarDireccionCombo();
		esDireccionCombo = false;
		txt_direccion.setEnabled(true);
		inicializarDireccionCombo();
	}
	
	public void direccionCombo() {
		habilitarDireccionCombo();
		txt_direccion.setEnabled(false);
		esDireccionCombo = true;
	}
	
	private void esDireccionConBis() {
		esBis = true;
		combo_bis.setEnabled(true);
	}
	
	private void noEsDireccionConBis() {
		esBis = false;
		combo_bis.setEnabled(false);
		combo_bis.setSelectedIndex(0);
	}
	
	private void inicializarDireccionCombo() {
		combo_tipocalle.setSelectedIndex(0);
		combo_bis.setSelectedIndex(0);
		combo_letravp.setSelectedIndex(0);
		combo_letravs.setSelectedIndex(0);
		combo_se.setSelectedIndex(0);
		combo_se2.setSelectedIndex(0);
		
		txt_callevp.setText("");
		txt_callevs.setText("");
		txt_callevss.setText("");
		ch_bisuno.setSelected(false);
		esBis = false;
	}
	
	private void deshabilitarDireccionCombo() {
		combo_tipocalle.setEnabled(false);
		combo_bis.setEnabled(false);
		combo_letravp.setEnabled(false);
		combo_letravs.setEnabled(false);
		combo_se.setEnabled(false);
		combo_se2.setEnabled(false);
		
		txt_callevp.setEnabled(false);
		txt_callevs.setEnabled(false);
		txt_callevss.setEnabled(false);
		ch_bisuno.setEnabled(false);
	}
	
	private void habilitarDireccionCombo() {
		combo_tipocalle.setEnabled(true);
		combo_bis.setEnabled(true);
		combo_letravp.setEnabled(true);
		combo_letravs.setEnabled(true);
		combo_se.setEnabled(true);
		combo_se2.setEnabled(true);
		
		txt_callevp.setEnabled(true);
		txt_callevs.setEnabled(true);
		txt_callevss.setEnabled(true);
		ch_bisuno.setEnabled(true);
		if(esBis){
			esDireccionConBis();
		}
		else{
			noEsDireccionConBis();
		}
	}
	
	private void crearDireccion() {
		String direccion = "";
		String tipoCalle = combo_tipocalle.getSelectedItem().toString().trim();
		if (tipoCalle.trim().equals("...")) {
			tipoCalle = "";
		} else if (!tipoCalle.trim().isEmpty()) {
			tipoCalle = tipoCalle + " ";
		}
		String calle = txt_callevp.getText().trim();
		if (!calle.trim().isEmpty()) {
			calle = calle + " ";
		}
		String letraCalle = combo_letravp.getSelectedItem().toString().trim();
		if (letraCalle.trim().equals("...")) {
			letraCalle = "";
		} else if (!letraCalle.trim().isEmpty()) {
			letraCalle = letraCalle + " ";
		}
		String bis = "";
		String letraBis = combo_bis.getSelectedItem().toString().trim();
		if (esBis) {
			bis = "BIS ";
			if (letraBis.trim().equals("...")) {
				letraBis = "";
			} else if (!letraBis.trim().isEmpty()) {
				letraBis = letraBis + " ";
			}
		} else {
			letraBis = "";
		}
		String letraSE = combo_se.getSelectedItem().toString().trim();
		if (letraSE.trim().equals("...")) {
			letraSE = "";
		} else if (!letraSE.trim().isEmpty()) {
			letraSE = letraSE + " ";
		}

		String numero = txt_callevs.getText().trim();
		if (!numero.trim().isEmpty()) {
			numero = "# " + numero + " ";
		}

		String letraNumero = combo_letravs.getSelectedItem().toString().trim();
		if (letraNumero.trim().equals("...")) {
			letraNumero = "";
		} else if (!letraNumero.trim().isEmpty()) {
			letraNumero = letraNumero + " ";
		}

		String complementoNumero = txt_callevss.getText().trim();
		if (!complementoNumero.trim().isEmpty()) {
			complementoNumero = complementoNumero + " ";
		}

		String letraComplementoNumero = combo_se2.getSelectedItem().toString()
				.trim();
		if (letraComplementoNumero.trim().equals("...")) {
			letraComplementoNumero = "";
		} else if (!letraComplementoNumero.trim().isEmpty()) {
			letraComplementoNumero = letraComplementoNumero + " ";
		}

		direccion = tipoCalle + calle + letraCalle + bis + letraBis + letraSE
				+ numero + letraNumero + complementoNumero
				+ letraComplementoNumero;
		txt_direccion.setText(direccion);
	}
	
	@Override
	public void setEnabled(boolean enabled) {
		if (enabled) {
			if (esDireccionCombo) {
				direccionCombo();
			} else {
				direccionNormal();
			}
			ch_dirnormal.setEnabled(true);
		} else {
			deshabilitarDireccionCombo();
			txt_direccion.setEnabled(false);
			ch_dirnormal.setEnabled(false);
		}
	}
	
	@Override
	public boolean isEnabled() {
		return ch_dirnormal.isEnabled();
	}
	
	public boolean estaEditandoDireccion() {
		return !esDireccionCombo;
	}
	
	public void editarDireccion(boolean esDireccionCombo) {
		this.esDireccionCombo = esDireccionCombo;
		ch_dirnormal.setSelected(esDireccionCombo);
		dirnormalAccion();
	}
	
	@Override
	public void grabFocus() {
		ch_dirnormal.grabFocus();
	}
	
	public static void setValorDireccion(CampoDireccion campo, String valor, boolean enabled) {
		campo.editarDireccion(true);
		campo.direccionNormal();
		campo.txt_direccion.setText(valor);
		campo.setEnabled(enabled);
	}
	
	@Override
	public synchronized void addFocusListener(FocusListener l) {
		txt_direccion.addFocusListener(l);
		txt_callevp.addFocusListener(l);
		txt_callevs.addFocusListener(l);
		txt_callevss.addFocusListener(l);
		combo_tipocalle.addFocusListener(l);
		combo_letravp.addFocusListener(l);
		combo_letravs.addFocusListener(l);
		combo_bis.addFocusListener(l);
		combo_se.addFocusListener(l);
		combo_se2.addFocusListener(l);
		ch_bisuno.addFocusListener(l);
		ch_dirnormal.addFocusListener(l);
	}
}
