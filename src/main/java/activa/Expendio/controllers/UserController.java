package activa.Expendio.controllers;

import activa.Expendio.modelo.Usuario;
import activa.Expendio.persistencia.Interface.PersistenciaUsuarioInt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by laura on 11/02/2018.
 */
@RestController
@RequestMapping(value = "/activaExpendio/V1/users")
public class UserController  {

    @Autowired
    public PersistenciaUsuarioInt userRepository;
    
    
    @RequestMapping( value = "/login", method = RequestMethod.POST )
    public ResponseEntity<?> login(@RequestBody Usuario usuario) throws ServletException {
        String jwtToken = "";
        if (usuario.getLogin() == null || usuario.getPassword() == null ){
            return new ResponseEntity<>("Please fill in users and password", HttpStatus.NOT_FOUND);
        }

       
        Usuario user = userRepository.getUsuarioLogin(usuario);

        if ( user == null ){
            return new ResponseEntity<>("Invalid User/Password", HttpStatus.UNAUTHORIZED);
        }

        jwtToken = Jwts.builder().setSubject(usuario.getLogin()).claim("roles", "user").setIssuedAt( new Date() ).signWith(SignatureAlgorithm.HS256, "4ct1V43Xp3nd10").compact();

        System.err.println("Token: "+ new Token( jwtToken ).getAccessToken());
        return new ResponseEntity<>(jwtToken, HttpStatus.OK);
    }

    
    
    @RequestMapping( value = "/login/{login}/{password}", method = RequestMethod.GET )
    public ResponseEntity<?> login(@PathVariable("login") String login, @PathVariable("password") String password) throws ServletException {
        String jwtToken = "";
        if (login == null || password == null ){
            return new ResponseEntity<>("Please fill in users and password", HttpStatus.NOT_FOUND);
        }

       Usuario usuario = new Usuario();
       usuario.setLogin(login);
       usuario.setPassword(password);
        Usuario user = userRepository.getUsuarioLogin(usuario);

        if ( user == null ){
            return new ResponseEntity<>("Invalid User/Password", HttpStatus.UNAUTHORIZED);
        }

        jwtToken = Jwts.builder().setSubject(usuario.getLogin()).claim("roles", "user").setIssuedAt( new Date() ).signWith(SignatureAlgorithm.HS256, "4ct1V43Xp3nd10").compact();

        System.err.println("Token: "+ new Token( jwtToken ).getAccessToken());
        return new ResponseEntity<>(jwtToken, HttpStatus.OK);
    }
    

    
    
    
    
    
    
    public class Token{
        String access_token;

        public Token( String access_token ){
            this.access_token = access_token;
        }

        public String getAccessToken(){
            return access_token;
        }

        public void setAccessToken( String access_token ){
            this.access_token = access_token;
        }
    }



}
