package activa.Expendio;

import activa.Expendio.modelo.Usuario;
import activa.expendio.vista.GUIMenu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpendioApplication {

    public static void main(String[] args) {
        new GUIMenu(new Usuario()).setVisible(true);
        SpringApplication.run(ExpendioApplication.class, args);

    }
}
