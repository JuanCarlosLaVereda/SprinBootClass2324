package es.ieslavereda.springbootclass2324.controller;

import es.ieslavereda.springbootclass2324.repository.model.Usuario;
import es.ieslavereda.springbootclass2324.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        Usuario usuario = usuarioService.getById(id);
        if (usuario == null){
            return new ResponseEntity<>("El usuario no esxiste", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/usuarios/")
    public ResponseEntity<?> getAll(){
        List<Usuario> usuarios = usuarioService.getAll();

        if (usuarios == null){
            return new ResponseEntity<>("Usuarios no encontrados", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @DeleteMapping("/usuarios/delete/{id}/")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id){
        Usuario usuario = usuarioService.deleteById(id);
        if (usuario == null){
            return new ResponseEntity<>("El usuario no existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PutMapping("/usuarios/put/")
    public ResponseEntity<?> putUser(@RequestBody Usuario usuario){
        Usuario usuario1 = usuarioService.updateUser(usuario);
        if (usuario1 == null){
            return new ResponseEntity<>("El usuario no existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuario1, HttpStatus.OK);
    }

    @PostMapping("/usuarios/post/")
    public ResponseEntity<?> postUser(@RequestBody Usuario usuario){
        Usuario usuario1 = usuarioService.addUser(usuario);
        if (usuario1 == null){
            return new ResponseEntity<>("El usuario no existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuario1, HttpStatus.OK);
    }
}
