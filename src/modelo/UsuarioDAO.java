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
    
    public Usuario buscarUsuarioPorUsuario(String usuario) {
        String sql = "SELECT id, usuario, nombre, apellido, telefono, correo_electronico, contrasena FROM usuarios WHERE usuario = ?";

        try (Connection conexion = ConexionBD.obtenerConexion(); PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, usuario);

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
            System.out.println("Error al buscar usuario: " + e.getMessage());
        }

        return null;
    }
    
    public boolean actualizarUsuario(Usuario usuarioOriginal, Usuario usuarioActualizado) {
        String sql = "UPDATE usuarios SET usuario = ?, nombre = ?, apellido = ?, telefono = ?, correo_electronico = ?, contrasena = ? WHERE id = ?";

        try (Connection conexion = ConexionBD.obtenerConexion(); PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, usuarioActualizado.getUsuario());
            sentencia.setString(2, usuarioActualizado.getNombre());
            sentencia.setString(3, usuarioActualizado.getApellido());
            sentencia.setString(4, usuarioActualizado.getTelefono());
            sentencia.setString(5, usuarioActualizado.getCorreoElectronico());
            sentencia.setString(6, usuarioActualizado.getContrasena());
            sentencia.setInt(7, usuarioOriginal.getId());

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
            return false;
        }
    }
    
    public boolean existeUsuarioOCorreo(String usuario, String correoElectronico) {
        String sql = "SELECT id FROM usuarios WHERE usuario = ? OR correo_electronico = ?";

        try (Connection conexion = ConexionBD.obtenerConexion(); PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, usuario);
            sentencia.setString(2, correoElectronico);

            try (ResultSet resultado = sentencia.executeQuery()) {
                return resultado.next();
            }

        } catch (SQLException e) {
            System.out.println("Error al verificar usuario o correo existente: " + e.getMessage());
            return false;
        }
    }
}