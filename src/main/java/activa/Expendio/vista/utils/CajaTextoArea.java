package activa.expendio.vista.utils;

import java.awt.event.*;

import javax.swing.*;

import utils.*;

public class CajaTextoArea extends JTextArea {
	private static final long serialVersionUID = -6697061001729853839L;

	/**
	 * N = Solo numero Entero D = Numero decimal y entero L = Solo letras G = Letras
	 * y Numeros F = Fecha M = Moneda P = Porcentaje
	 * 
	 */
	private String tipo;
	public static int longitudMaxima = 500;

	/**
	 * @param tipo
	 * @param longitu
	 *            maxima Contructor N = Solo numero Entero D = Numero decimal y
	 *            entero L = Solo letras G = Letras y Numeros F = Fecha M = Moneda P
	 *            = Porcentaje
	 */
	public CajaTextoArea(String tipo, int longitudMaxima) {
		this.tipo = tipo;
		CajaTextoArea.longitudMaxima = longitudMaxima;
		definaAcciones();
	}

	/**
	 * Contructor
	 * 
	 * @param tipo
	 *            Contructor N = Solo numero Entero D = Numero decimal y entero L =
	 *            Solo letras G = Letras y Numeros F = Fecha M = Moneda P =
	 *            Porcentaje
	 */
	public CajaTextoArea(String tipo) {
		definaAcciones();
		this.tipo = tipo;
	}

	/**
	 * Metodo encargado de definir las acciones
	 */
	public void definaAcciones() {
		this.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (tipo.trim().equalsIgnoreCase(CajaDeTexto.textoMoneda)) {
					setText(Formatos.formatearValorString(getText().trim()));
				} else if (tipo.trim().equalsIgnoreCase(CajaDeTexto.textoPorcentaje)) {
					setText(Formatos.formatearPorcentajeString(getText().trim(),
							CajaDeTexto.longitudDecimalPorcentaje));
				}
			}

			@Override
			public void focusGained(FocusEvent arg0) {
				if (tipo.trim().equalsIgnoreCase(CajaDeTexto.textoMoneda)) {
					setText(Formatos.quitarFormatoValorString(getText().trim()));
				} else if (tipo.trim().equalsIgnoreCase(CajaDeTexto.textoPorcentaje)) {
					setText(Formatos.quitarFormatoPorcentaje(getText().trim(), CajaDeTexto.longitudDecimalPorcentaje));
				}
				setSelectionStart(0);
				setSelectionEnd(getText().trim().length());

			}
		});
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char KeyChar = e.getKeyChar();
				if (Character.isLowerCase(KeyChar)) {
					e.setKeyChar(Character.toUpperCase(KeyChar));
				}

				if (tipo.trim().equalsIgnoreCase(CajaDeTexto.textoNumeroEntero)) {
					ValidacionCampos.bloquearTxtSoloNumero(e);
					ValidacionCampos.limitarLongitudString(getText(), longitudMaxima, e);
				} else if (tipo.trim().equalsIgnoreCase(CajaDeTexto.textoNumeroDecimal)) {
					ValidacionCampos.reemplazarComaPorPunto(e);
					ValidacionCampos.noPermitirIngresarMasDeUnPuntoDecimal(e, getText().trim());
					ValidacionCampos.permitirIngresarSoloNumerosYPunto(e);
					ValidacionCampos.validarParteDecimalConEvento(3, getText().trim(), getCaretPosition(), e);
					ValidacionCampos.validarParteEnteraConEvento(longitudMaxima, getText().trim(), getCaretPosition(),
							e);
				} else if (tipo.trim().equalsIgnoreCase(CajaDeTexto.textoSoloLetras)) {
					ValidacionCampos.limitarLongitudString(getText(), longitudMaxima, e);
					ValidacionCampos.bloquearTxtSoloLetrasYCaracteresEspeciales(e);
				} else if (tipo.trim().equalsIgnoreCase(CajaDeTexto.textoLetrasNumeros)) {
					ValidacionCampos.limitarLongitudString(getText(), longitudMaxima, e);
				} else if (tipo.trim().equalsIgnoreCase(CajaDeTexto.textoMoneda)) {
					// Reemplaza la coma por punto
					ValidacionCampos.reemplazarComaPorPunto(e);
					// No permite ingresas m�s de un punto
					ValidacionCampos.noPermitirIngresarMasDeUnPuntoDecimal(e, getText().trim());
					// Solo permite ingresar numeros y puntos
					ValidacionCampos.permitirIngresarSoloNumerosYPunto(e);
					// Valida la longitud decimal.
					ValidacionCampos.validarParteDecimalConEvento(CajaDeTexto.longitudDecimalMoneda, getText().trim(),
							getCaretPosition(), e);
				} else if (tipo.trim().equalsIgnoreCase(CajaDeTexto.textoPorcentaje)) {
					// Reemplaza la coma por punto
					ValidacionCampos.reemplazarComaPorPunto(e);
					// No permite ingresas m�s de un punto
					ValidacionCampos.noPermitirIngresarMasDeUnPuntoDecimal(e, getText().trim());
					// Solo permite ingresar numeros y puntos
					ValidacionCampos.permitirIngresarSoloNumerosYPunto(e);
					// Valida la longitud del decimal.
					ValidacionCampos.validarParteDecimalConEvento(CajaDeTexto.longitudDecimalPorcentaje,
							getText().trim(), getCaretPosition(), e);
					// Valida la longitud entera.
					ValidacionCampos.validarParteEnteraConEvento(3, getText().trim(), getCaretPosition(), e);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// ValidacionCampos.inicializarSiEstaSeleccionadoNumero(,e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
	}

}
