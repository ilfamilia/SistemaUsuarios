package principal;

import modelo.Usuario;
import modelo.UsuarioDAO;

public class PruebaRegistroUsuario {

    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        usuario.setUsuario("admin");
        usuario.setNombre("Israel");
        usuario.setApellido("Liranzo");
        usuario.setTelefono("8090000000");
        usuario.setCorreoElectronico("admin@correo.com");
        usuario.setContrasena("1234");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean registrado = usuarioDAO.registrarUsuario(usuario);

        if (registrado) {
            System.out.println("Usuario registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el usuario.");
        }
    }
}