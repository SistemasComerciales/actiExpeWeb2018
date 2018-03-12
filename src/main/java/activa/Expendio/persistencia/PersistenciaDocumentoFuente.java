package activa.Expendio.persistencia;

import activa.Expendio.modelo.*;
import activa.Expendio.persistencia.Interface.*;
import java.sql.Timestamp;
import java.util.*;
import org.springframework.stereotype.*;

/**
 *
 * @author Usuario
 */
@Service
public class PersistenciaDocumentoFuente implements PersistenciaDocFuenteInt {

    private ArrayList<DocumentoFuente> listaDocumentoFuente;

    public PersistenciaDocumentoFuente() {
        listaDocumentoFuente = new ArrayList<>();
        crearMock();
    }

    
    public void crearMock(){
        DocumentoFuente docFuente = new DocumentoFuente();
        docFuente.setAccion("S");
        docFuente.setAccionUsuario("I");
        docFuente.setAplica("C");
        docFuente.setCodigo("RI");
        docFuente.setControlExistencia(false);
        docFuente.setCosteoInventario(false);
        docFuente.setCreacion(new Timestamp(System.currentTimeMillis()));
        docFuente.setDocBase(false);
        docFuente.setEliminado(false);
        docFuente.setEstado(true);
        docFuente.setListaPrecio(false);
        docFuente.setModificacion(new Timestamp(System.currentTimeMillis()));
        docFuente.setNombre("RECARGA IVR");
        docFuente.setNumera(true);
        docFuente.setNumero("");
        listaDocumentoFuente.add(docFuente);
    }
    
    /**
     * @return the listaDocumentoFuente
     */
    @Override
    public ArrayList<DocumentoFuente> getListaDocumentoFuente() {
        return listaDocumentoFuente;
    }

    /**
     * @param listaDocumentoFuente the listaDocumentoFuente to set
     */
    @Override
    public void setListaDocumentoFuente(ArrayList<DocumentoFuente> listaDocumentoFuente) {
        this.listaDocumentoFuente = listaDocumentoFuente;
    }

    /**
     * metodo que permite adicionar una docuemto fuente a la persistencia;
     *
     * @param documentoFuente
     * @return documentoFuente
     */
    @Override
    public DocumentoFuente adicionar(DocumentoFuente documentoFuente) {
        getListaDocumentoFuente().add(documentoFuente);
        return documentoFuente;
    }

    /**
     * metodo que modifica una bodega
     *
     * @param documentoFuente
     * @return documentoFuente
     */
    @Override
    public DocumentoFuente modificar(DocumentoFuente documentoFuente) {
        Long id = documentoFuente.getId();
        for (int i = 0; i <= listaDocumentoFuente.size(); i++) {
            if (Objects.equals(id, listaDocumentoFuente.get(i).getId())) {
                listaDocumentoFuente.set(i, documentoFuente);
                return documentoFuente;
            }
        }
        return null;
    }

    /**
     * metodo que cambia el estado a borrado true de un documento fuente
     *
     * @param documentoFuente
     * @return documentoFuente borrada o null
     */
    @Override
    public DocumentoFuente eliminar(DocumentoFuente documentoFuente) {
        for (int i = 0; i < listaDocumentoFuente.size(); i++) {
            if (Objects.equals(documentoFuente.getId(), listaDocumentoFuente.get(i).getId())) {
                listaDocumentoFuente.get(i).setEliminado(true);
                return documentoFuente;
            }
        }
        return null;
    }

    /**
     * metodo que valida si existe o no por codigo
     *
     * @param documentoFuente
     * @return true: existe , false: no existe
     */
    @Override
    public boolean validarExiste(DocumentoFuente documentoFuente) {
        for (int i = 0; i < listaDocumentoFuente.size(); i++) {
            if (documentoFuente.getCodigo().equalsIgnoreCase(listaDocumentoFuente.get(i).getCodigo())) {
                if (!listaDocumentoFuente.get(i).isEliminado()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * metodo que consulta todas los documentos fuente que no esten eliminadas
     *
     * @return documentos fuente que no esten eliminados
     */
    @Override
    public ArrayList<DocumentoFuente> consultarTodos() {
        ArrayList<DocumentoFuente> documentosFuente = new ArrayList<>();
        for (int i = 0; i < listaDocumentoFuente.size(); i++) {
            if (!listaDocumentoFuente.get(i).isEliminado()) {
                documentosFuente.add(listaDocumentoFuente.get(i));
            }
        }
        return documentosFuente;
    }

    /**
     * metodo que consulta todas los documentos fuente que no esten eliminadas
     *
     * @return documentos fuente que no esten eliminados
     */
    @Override
    public ArrayList<DocumentoFuente> consultarActivosNoEliminados() {
        ArrayList<DocumentoFuente> documentosFuente = new ArrayList<>();
        for (int i = 0; i < listaDocumentoFuente.size(); i++) {
            if (!listaDocumentoFuente.get(i).isEliminado() && listaDocumentoFuente.get(i).getEstado()) {
                documentosFuente.add(listaDocumentoFuente.get(i));
            }
        }
        return documentosFuente;
    }

    /**
     * metodo que consulta una documentoFuente por id
     *
     * @param id
     * @return null si no hay conincidencia o la documentoFuente encontrada
     */
    @Override
    public DocumentoFuente consultarPorId(String id) {
        for (int i = 0; i < listaDocumentoFuente.size(); i++) {
            if (!listaDocumentoFuente.get(i).isEliminado()) {
                Long idDoc = Long.parseLong(id);
                if (idDoc.equals(listaDocumentoFuente.get(i).getId())) {
                    return listaDocumentoFuente.get(i);
                }
            }
        }
        return null;
    }

    /**
     * metodo que consulta una Documento fuente por codigo
     *
     * @param codigo
     * @return null si no hay conincidencia o la Documento fuente encontrada
     */
    @Override
    public DocumentoFuente consultarPorCodigo(String codigo) {
        for (int i = 0; i < listaDocumentoFuente.size(); i++) {
            if (!listaDocumentoFuente.get(i).isEliminado()) {
                if (codigo.equals(listaDocumentoFuente.get(i).getCodigo())) {
                    return listaDocumentoFuente.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public boolean existeID(DocumentoFuente documentoFuente) {
        for (int i = 0; i < listaDocumentoFuente.size(); i++) {
            if (Objects.equals(documentoFuente.getId(), listaDocumentoFuente.get(i).getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public DocumentoFuente consultarPorNombre(String nombre) {
        for (int i = 0; i < listaDocumentoFuente.size(); i++) {
            if (!listaDocumentoFuente.get(i).isEliminado()) {
                if (nombre.equals(listaDocumentoFuente.get(i).getNombre())) {
                    return listaDocumentoFuente.get(i);
                }
            }
        }
        return null;
    }

}
