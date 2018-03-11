package activa.Expendio.controllers;

import activa.Expendio.*;
import org.springframework.boot.*;
import org.springframework.context.*;

/**
 *
 * @author Avuuna la Luz del Alba
 */
public class Servicios {

    public static SaldosController saldosController;
    public static UserController userController;
    public static InternosController internosController;
    public static BodegasController bodegasController;

    /**
     * Inicia todos los servicios REST.
     *
     * @param args
     */
    public static void iniciarServicios(String[] args) {
        ConfigurableApplicationContext ac = SpringApplication.run(ExpendioApplication.class, args);
        saldosController = ac.getBean(SaldosController.class);
        userController = ac.getBean(UserController.class);
        internosController = ac.getBean(InternosController.class);
        bodegasController = ac.getBean(BodegasController.class);
    }
}
