package activa.Expendio;

import activa.Expendio.modelo.Establecimiento;
import activa.Expendio.modelo.Usuario;
import activa.Expendio.vista.GUICatalogoBodegas;
import activa.Expendio.vista.GUIInicio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpendioApplication {

    public static void main(String[] args) {
        Establecimiento establecimiento = new Establecimiento();
        establecimiento.setCodigo("530");
        establecimiento.setNombre("QUIBDÓ");
        establecimiento.setNit("");
        establecimiento.setTipo("P");
        
        Usuario usuario = new Usuario();
        usuario.setPeriodoContable("2018");
        usuario.setLogin("SUPERVISOR");
        usuario.setNombres("Supervisor");
        new GUIInicio(usuario, establecimiento);
        SpringApplication.run(ExpendioApplication.class, args);

    }
}
