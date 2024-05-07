package es.ieslavereda.springbootclass2324.repository;

import es.ieslavereda.springbootclass2324.repository.model.Usuario;

import java.util.List;

public interface IUsuarioRepository {
    Usuario getById(int id);
    List<Usuario> getAll();
    Usuario deleteById(int id);
    Usuario updateUser(Usuario usuario);
    Usuario addUser(Usuario usuario);
}
