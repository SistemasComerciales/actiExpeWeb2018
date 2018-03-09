/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.persistencia.Interface;

import activa.Expendio.modelo.DocumentoFuente;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public interface PersistenciaDocFuenteInt {
   
    public ArrayList<DocumentoFuente> getListaDocumentoFuente();
    
    public void setListaDocumentoFuente(ArrayList<DocumentoFuente> listaDocumentoFuente);
    
    public DocumentoFuente adicionar(DocumentoFuente documentoFuente);
    
    public DocumentoFuente modificar(DocumentoFuente documentoFuente);
    
    public DocumentoFuente borrar(DocumentoFuente documentoFuente);
    
    public boolean validarExiste(DocumentoFuente documentoFuente);
    
    public ArrayList<DocumentoFuente> consultarTodos();
    
    public DocumentoFuente colsultarPorId(String id);
    
    public DocumentoFuente colsultarPorCodigo(String codigo);
}
