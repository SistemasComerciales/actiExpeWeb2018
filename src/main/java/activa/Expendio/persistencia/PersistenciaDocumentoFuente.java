/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.persistencia;


import activa.Expendio.modelo.DocumentoFuente;
import activa.Expendio.persistencia.Interface.PersistenciaDocFuenteInt;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class PersistenciaDocumentoFuente implements PersistenciaDocFuenteInt{
    private ArrayList<DocumentoFuente> listaDocumentoFuente;
    
    public PersistenciaDocumentoFuente(){
        listaDocumentoFuente = new ArrayList<>();
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
     * @param documentoFuente
     * @return documentoFuente
     */
    @Override
    public DocumentoFuente adicionar(DocumentoFuente documentoFuente){
        documentoFuente.setId(getListaDocumentoFuente().size()+1);
        getListaDocumentoFuente().add(documentoFuente);
        return documentoFuente;
    } 
    
        /**
     * metodo que modifica una bodega
     * @param documentoFuente
     * @return documentoFuente
     */
    @Override
    public DocumentoFuente modificar(DocumentoFuente documentoFuente){
        Long id = documentoFuente.getId();
        for (int i = 0; i <= listaDocumentoFuente.size(); i++) {
            if (id == listaDocumentoFuente.get(i).getId()) {
               listaDocumentoFuente.set(i, documentoFuente);
            return documentoFuente;
            }
        }
        return  null;
    }
   
        /**
     * metodo que cambia el estado a borrado true de un documento fuente 
     * @param documentoFuente
     * @return documentoFuente borrada o null
     */
    @Override
    public DocumentoFuente borrar(DocumentoFuente documentoFuente){
        Long id = documentoFuente.getId();
        for (int i = 0; i < listaDocumentoFuente.size(); i++) {
            if (id.equals(listaDocumentoFuente.get(i).getId())) {
                listaDocumentoFuente.get(i).setEliminado(true);
                return documentoFuente;
            }
        }
        return null;
    }
    
        /**
     * metodo que valida si existe o no por codigo
     * @param documentoFuente
     * @return true: existe , false: no existe
     */
    @Override
    public boolean validarExiste(DocumentoFuente documentoFuente){
        for (int i = 0; i < listaDocumentoFuente.size(); i++) {
            if (documentoFuente.getCodigo().equals(listaDocumentoFuente.get(i).getCodigo())) {
                if (!listaDocumentoFuente.get(i).isEliminado()) {
                    return true;
                }
            }
        }
        return false;
    }
    
        /**
     * metodo que consulta todas los documentos fuente que no esten eliminadas
     * @return documentos fuente que no esten eliminados
     */
    @Override
    public ArrayList<DocumentoFuente> consultarTodos(){
        ArrayList<DocumentoFuente> documentosFuente = new ArrayList<>();
        for (int i = 0; i < listaDocumentoFuente.size(); i++) {
            if (!listaDocumentoFuente.get(i).isEliminado()) {
                documentosFuente.add(listaDocumentoFuente.get(i));
            }
        }
        return documentosFuente;
    }
    
       /**
     * metodo que consulta una documentoFuente por id
     * @param id
     * @return null si no hay conincidencia o la documentoFuente encontrada
     */
    @Override
    public DocumentoFuente colsultarPorId(String id){
        for (int i = 0; i < listaDocumentoFuente.size() ; i++) {
            if (!listaDocumentoFuente.get(i).isEliminado()) {
                if (id.equals( listaDocumentoFuente.get(i).getId() ) ) {
                    return listaDocumentoFuente.get(i);
                }
            }
        }
        return null;
    }
    
         /**
     * metodo que consulta una Documento fuente por codigo
     * @param codigo
     * @return null si no hay conincidencia o la Documento fuente encontrada
     */
    @Override
    public DocumentoFuente colsultarPorCodigo(String codigo){
        for (int i = 0; i < listaDocumentoFuente.size() ; i++) {
            if (!listaDocumentoFuente.get(i).isEliminado()) {
                if (codigo.equals( listaDocumentoFuente.get(i).getCodigo() ) ) {
                    return listaDocumentoFuente.get(i);
                }
            }
        }
        return null;
    }
    
}
