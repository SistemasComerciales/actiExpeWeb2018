/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.persistencia;


import activa.Expendio.modelo.Usuario;
import activa.Expendio.persistencia.Interface.PersistenciaUsuarioInt;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service
public class PersistenciaUsuario implements PersistenciaUsuarioInt{
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
    
    
    @Override
    public Usuario adicionarUsuario(Usuario usuario){
        usuario.setId((usuarios.size()+1));
        usuarios.add(usuario);
        return usuario;
    }
    
    @Override
    public Usuario modificar(Usuario usuario){
        for(int i=0; i<usuarios.size(); i++){
            if(usuario.getId()== usuarios.get(i).getId()){
                usuarios.set(i, usuario);
                return usuario;
            }
        }
        return null;
    }
    
    @Override
    public ArrayList<Usuario> getUsuarios(){
        return usuarios;
    }

    @Override
    public Usuario getUsuarioLogin(Usuario usuario) {
        for(int i=0; i<usuarios.size(); i++){
            if(usuario.getLogin().trim().equalsIgnoreCase(usuarios.get(i).getLogin().trim()) &&  usuario.getPassword().trim().equalsIgnoreCase(usuarios.get(i).getPassword().trim())){
                return usuarios.get(i);
            }
        }
        return null;
    }
}
