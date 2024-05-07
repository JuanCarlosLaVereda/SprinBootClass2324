package es.ieslavereda.springbootclass2324.repository;

import es.ieslavereda.springbootclass2324.repository.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface IUsuarioDBRepository {
    Usuario getById(int id) throws SQLException;
    List<Usuario> getAll() throws SQLException;
    Usuario deleteById(int id) throws SQLException;
    Usuario updateUser(Usuario usuario) throws SQLException;
    Usuario addUser(Usuario usuario) throws SQLException;
}
