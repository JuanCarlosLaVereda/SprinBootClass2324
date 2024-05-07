package es.ieslavereda.springbootclass2324.controller;

import es.ieslavereda.springbootclass2324.repository.model.Usuario;
import es.ieslavereda.springbootclass2324.service.UsuarioDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/apidb")
public class UsuarioDBController {

    @Autowired
    UsuarioDBService DBService;

    @GetMapping("/usuarios/")
    public ResponseEntity<?> getAll(){
        try {
            return new ResponseEntity<>(DBService.getAll(), HttpStatus.OK);
        } catch (SQLException e){
            return new ResponseEntity<>(e.getErrorCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        try {
            Usuario usuario = DBService.getById(id);
            if (usuario!=null){
                return new ResponseEntity<>(usuario, HttpStatus.OK);
            }
        } catch (SQLException e){
            return new ResponseEntity<>(e.getErrorCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/usuarios/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id){
        try {
            Usuario usuario = DBService.deleteById(id);
            if (usuario!=null){
                return new ResponseEntity<>(usuario, HttpStatus.OK);
            }
        } catch (SQLException e){
            return new ResponseEntity<>(e.getErrorCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("El usuario no existe", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/usuarios/put/")
    public ResponseEntity<?> putUser(@RequestBody Usuario usuario){
        try {
            Usuario usuario1 = DBService.updateUser(usuario);
            if (usuario1!=null){
                return new ResponseEntity<>(usuario1, HttpStatus.OK);
            }
        } catch (SQLException e){
            return new ResponseEntity<>(e.getErrorCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("El usuario no existe", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/usuarios/post/")
    public ResponseEntity<?> postUser(@RequestBody Usuario usuario){
        try {
            Usuario usuario1 = DBService.addUser(usuario);
            if (usuario1!=null){
                return new ResponseEntity<>(usuario1, HttpStatus.OK);
            }
        } catch (SQLException e){
            return new ResponseEntity<>(e.getErrorCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("No se ha podido añadir el usuario", HttpStatus.NOT_FOUND);
    }
}
