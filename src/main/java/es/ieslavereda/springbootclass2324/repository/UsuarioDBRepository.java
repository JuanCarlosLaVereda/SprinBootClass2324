package es.ieslavereda.springbootclass2324.repository;

import es.ieslavereda.springbootclass2324.repository.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Repository
public class UsuarioDBRepository implements IUsuarioDBRepository{

    @Autowired
    @Qualifier("mysqlDataSource")
    private DataSource dataSource;

    @Override
    public Usuario getById(int id) throws SQLException {
        Usuario usuario = null;
        String query = "select * from usuario where id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);

            ResultSet resultSet = ps.executeQuery();
            resultSet.next();

            usuario = Usuario.builder().id(resultSet.getInt(1)).nombre(resultSet.getString(2)).apellidos(resultSet.getString(3)).build();
        }
        return usuario;
    }

    @Override
    public List<Usuario> getAll() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuario";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)){

            while (rs.next()){
                usuarios.add(Usuario.builder().id(rs.getInt(1))
                        .nombre(rs.getString(2))
                        .apellidos(rs.getString(3)).build());
            }
        }
        return usuarios;
    }

    @Override
    public Usuario deleteById(int id) throws SQLException {
        Usuario usuario = getById(id);
        String query = "DELETE FROM usuario WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(query)){
            if (usuario != null){
                ps.setInt(1, usuario.getId());
                ps.executeUpdate();
            }
        }
        return usuario;
    }

    @Override
    public Usuario updateUser(Usuario usuario) throws SQLException {
        if (getById(usuario.getId()) != null){
            String query = "UPDATE usuario SET nombre = ?, " + "apellidos = ?" + " WHERE id = ?" + ";";
            try (Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){
                ps.setString(1, usuario.getNombre());
                ps.setString(2, usuario.getApellidos());
                ps.setInt(3, usuario.getId());

                ps.executeUpdate();
            }
        } else {
            usuario = null;
        }
        return usuario;
    }

    @Override
    public Usuario addUser(Usuario usuario) throws SQLException {
        String query = "{call addUsuario(?,?)}";
        try (Connection connection = dataSource.getConnection();
        CallableStatement cs = connection.prepareCall(query)){
            cs.setString(1, usuario.getNombre());
            cs.setString(2, usuario.getApellidos());
            cs.executeUpdate();
        }
        return usuario;
    }
}
