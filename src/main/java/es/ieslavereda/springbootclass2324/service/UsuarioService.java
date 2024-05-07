package es.ieslavereda.springbootclass2324.service;

import es.ieslavereda.springbootclass2324.repository.model.Usuario;
import es.ieslavereda.springbootclass2324.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    public UsuarioRepository usuarioRepository;

    public Usuario getById(int id){
        return usuarioRepository.getById(id);
    }

    public List<Usuario> getAll(){
        return usuarioRepository.getAll();
    }

    public Usuario deleteById(int id){
        return usuarioRepository.deleteById(id);
    }

    public Usuario updateUser(Usuario usuario){
        return usuarioRepository.updateUser(usuario);
    }

    public Usuario addUser(Usuario usuario){
        return usuarioRepository.addUser(usuario);
    }
}
