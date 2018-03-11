package activa.Expendio.persistencia.Interface;

import activa.Expendio.modelo.*;
import java.util.*;

/**
 *
 * @author Usuario
 */
public interface PersistenciaDocFuenteInt {

    public ArrayList<DocumentoFuente> getListaDocumentoFuente();

    public void setListaDocumentoFuente(ArrayList<DocumentoFuente> listaDocumentoFuente);

    public DocumentoFuente adicionar(DocumentoFuente documentoFuente);

    public DocumentoFuente modificar(DocumentoFuente documentoFuente);

    public DocumentoFuente eliminar(DocumentoFuente documentoFuente);

    public boolean validarExiste(DocumentoFuente documentoFuente);

    public ArrayList<DocumentoFuente> consultarTodos();

    public ArrayList<DocumentoFuente> consultarActivosNoEliminados();

    public DocumentoFuente consultarPorId(String id);

    public DocumentoFuente consultarPorCodigo(String codigo);

    public boolean existeID(DocumentoFuente documentoFuente);
}
