package es.ieslavereda.springbootclass2324.service;

import es.ieslavereda.springbootclass2324.repository.UsuarioDBRepository;
import es.ieslavereda.springbootclass2324.repository.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioDBService {

    @Autowired
    private UsuarioDBRepository usuarioDBRepository;

    public List<Usuario> getAll() throws SQLException {
        return usuarioDBRepository.getAll();
    }

    public Usuario getById(int id) throws SQLException {
        return usuarioDBRepository.getById(id);
    }

    public Usuario deleteById(int id) throws SQLException {
        return usuarioDBRepository.deleteById(id);
    }

    public Usuario updateUser(Usuario usuario) throws SQLException {
        return usuarioDBRepository.updateUser(usuario);
    }

    public Usuario addUser(Usuario usuario) throws SQLException{
        return usuarioDBRepository.addUser(usuario);
    }
}
