/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.persistencia;


import activa.Expendio.modelo.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class PersistenciaUsuario {
    private ArrayList<Usuario> usuarios;
    
    public PersistenciaUsuario(){
        usuarios = new ArrayList();
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setLogin("supervisor");
        usuario.setNombres("Supervisor");
        usuario.setPassword("nuevoActiva2016!");
        usuarios.add(usuario);
    }
    
    
    public Usuario adicionarUsuario(Usuario usuario){
        usuario.setId((usuarios.size()+1));
        usuarios.add(usuario);
        return usuario;
    }
    
    public Usuario modificar(Usuario usuario){
        for(int i=0; i<usuarios.size(); i++){
            if(usuario.getId()== usuarios.get(i).getId()){
                usuarios.set(i, usuario);
                return usuario;
            }
        }
        return null;
    }
    
    public ArrayList<Usuario> getUsuarios(){
        return usuarios;
    }
}
