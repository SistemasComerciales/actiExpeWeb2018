package utils;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.util.Date;

public class FechaHora {

    private Calendar calendario;
    private Timer timer;
    private int dia, mes, anio, hora, minutos, segundos, ampm;
    private String hour, date;

    public FechaHora(JLabel fechaYHora) {
        calendario = new GregorianCalendar();
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Date actual = new Date();
                calendario.setTime(actual);
                dia = calendario.get(Calendar.DAY_OF_MONTH);
                mes = (calendario.get(Calendar.MONTH) + 1);
                anio = calendario.get(Calendar.YEAR);
                hora = calendario.get(Calendar.HOUR);
                minutos = calendario.get(Calendar.MINUTE);
                segundos = calendario.get(Calendar.SECOND);
                ampm = calendario.get(Calendar.AM_PM);
                if (ampm == 0) {
                    if (hora == 0) {
                        hora = 12;

                    }
                    hour = String.format("%02d : %02d : %02d ", hora, minutos, segundos);
                    date = String.format("%02d / %02d / %02d", dia, mes, anio
                    );
                    fechaYHora.setText(date + "   -   " + hour + "A.M.");
                }
                if (ampm == 1) {
                    if (hora == 0) {
                        hora = 12;

                    }
                    hour = String.format("%02d : %02d : %02d ", hora, minutos, segundos);
                    date = String.format("%02d / %02d / %02d", dia, mes, anio
                    );
                    fechaYHora.setText(date + "   -   " + hour + "P.M.");
                }
            }
        });
        timer.start();
    }

}
