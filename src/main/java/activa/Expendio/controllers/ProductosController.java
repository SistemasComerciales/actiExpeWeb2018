package activa.Expendio.controllers;

import activa.Expendio.persistencia.Interface.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Avuuna la Luz del Alba
 */
@RestController
@RequestMapping(value = "/activaExpendio/V1/productos")
public class ProductosController {

    @Autowired
    public PersistenciaProductoInt productosRepository;

}
