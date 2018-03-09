/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.persistencia.Interface;

import activa.Expendio.modelo.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public interface PersistenciaUsuarioInt {
    
    public Usuario adicionarUsuario(Usuario usuario);
    
    public Usuario modificar(Usuario usuario);
    
    public ArrayList<Usuario> getUsuarios();
    
    public Usuario getUsuarioLogin(Usuario usuario);
}
