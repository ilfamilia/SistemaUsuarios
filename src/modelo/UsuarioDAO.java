package modelo;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public boolean registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (usuario, nombre, apellido, telefono, correo_electronico, contrasena) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, usuario.getUsuario());
            sentencia.setString(2, usuario.getNombre());
            sentencia.setString(3, usuario.getApellido());
            sentencia.setString(4, usuario.getTelefono());
            sentencia.setString(5, usuario.getCorreoElectronico());
            sentencia.setString(6, usuario.getContrasena());

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }

    public Usuario iniciarSesion(String usuario, String contrasena) {
        String sql = "SELECT id, usuario, nombre, apellido, telefono, correo_electronico, contrasena "
                   + "FROM usuarios WHERE usuario = ? AND contrasena = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, usuario);
            sentencia.setString(2, contrasena);

            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    Usuario usuarioEncontrado = new Usuario();
                    usuarioEncontrado.setId(resultado.getInt("id"));
                    usuarioEncontrado.setUsuario(resultado.getString("usuario"));
                    usuarioEncontrado.setNombre(resultado.getString("nombre"));
                    usuarioEncontrado.setApellido(resultado.getString("apellido"));
                    usuarioEncontrado.setTelefono(resultado.getString("telefono"));
                    usuarioEncontrado.setCorreoElectronico(resultado.getString("correo_electronico"));
                    usuarioEncontrado.setContrasena(resultado.getString("contrasena"));
                    return usuarioEncontrado;
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
        }

        return null;
    }
    
    public List<Usuario> listarUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>();

        String sql = "SELECT id, usuario, nombre, apellido, telefono, correo_electronico, contrasena FROM usuarios";

        try (Connection conexion = ConexionBD.obtenerConexion(); PreparedStatement sentencia = conexion.prepareStatement(sql); ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultado.getInt("id"));
                usuario.setUsuario(resultado.getString("usuario"));
                usuario.setNombre(resultado.getString("nombre"));
                usuario.setApellido(resultado.getString("apellido"));
                usuario.setTelefono(resultado.getString("telefono"));
                usuario.setCorreoElectronico(resultado.getString("correo_electronico"));
                usuario.setContrasena(resultado.getString("contrasena"));

                listaUsuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar usuarios: " + e.getMessage());
        }

        return listaUsuarios;
    }
    
    public boolean eliminarUsuarioPorUsuario(String usuario) {
        String sql = "DELETE FROM usuarios WHERE usuario = ?";

        try (Connection conexion = ConexionBD.obtenerConexion(); PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, usuario);

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
            return false;
        }
    }
}