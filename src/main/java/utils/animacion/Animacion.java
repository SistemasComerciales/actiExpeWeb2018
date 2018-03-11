package utils.Animacion;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Animacion {

    public Animacion() {
    }

    public static void bajar(int inicio, final int fin, final long retardo, final int salto, JComponent componente) {
        new Thread() {
            public void run() {
                for (int i = inicio; i <= fin; i += salto) {
                    try {
                        Thread.sleep(retardo);
                        componente.setLocation(componente.getX(), i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public static void subir(int inicio, final int fin, final long retardo, final int salto, JComponent componente) {
        new Thread() {
            public void run() {
                for (int i = inicio; i >= fin; i -= salto) {
                    try {
                        Thread.sleep(retardo);
                        componente.setLocation(componente.getX(), i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public static void mover_derecha(int inicio, final int fin, final long retardo, final int salto, JComponent componente) {
        new Thread() {
            public void run() {
                for (int i = inicio; i <= fin; i += salto) {
                    try {
                        Thread.sleep(retardo);
                        componente.setLocation(i, componente.getY());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public static void mover_izquierda(int inicio, final int fin, final long retardo, final int salto, JComponent componente) {
        new Thread() {
            public void run() {
                for (int i = inicio; i >= fin; i -= salto) {
                    try {
                        Thread.sleep(retardo);
                        componente.setLocation(i, componente.getY());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public static void bajar(int inicio, final int fin, final long retardo, final int salto, JFrame frame) {
        new Thread() {
            public void run() {
                for (int i = inicio; i <= fin; i += salto) {
                    try {
                        Thread.sleep(retardo);
                        frame.setLocation(frame.getX(), i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public static void subir(int inicio, final int fin, final long retardo, final int salto, JFrame frame) {
        new Thread() {
            public void run() {
                for (int i = inicio; i >= fin; i -= salto) {
                    try {
                        Thread.sleep(retardo);
                        frame.setLocation(frame.getX(), i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public static void mover_derecha(int inicio, final int fin, final long retardo, final int salto, JFrame frame) {
        new Thread() {
            public void run() {
                for (int i = inicio; i <= fin; i += salto) {
                    try {
                        Thread.sleep(retardo);
                        frame.setLocation(i, frame.getY());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public static void mover_izquierda(int inicio, final int fin, final long retardo, final int salto, JFrame frame) {
        new Thread() {
            public void run() {
                for (int i = inicio; i >= fin; i -= salto) {
                    try {
                        Thread.sleep(retardo);
                        frame.setLocation(i, frame.getY());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public static void FrameFadeIn() {
    }
}
