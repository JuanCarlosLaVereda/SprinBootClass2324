package es.ieslavereda.springbootclass2324;

import es.ieslavereda.springbootclass2324.repository.model.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello/{nombre}")
    public String getHello(@PathVariable("nombre") String nombre){
        Usuario usuario = Usuario.builder().id(1).nombre("Juan Carlos").apellidos("Santamaria").build();
        return "33 " + nombre;
    }

}
