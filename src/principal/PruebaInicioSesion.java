package principal;

import modelo.Usuario;
import modelo.UsuarioDAO;

public class PruebaInicioSesion {

    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.iniciarSesion("admin", "1234");

        if (usuario != null) {
            System.out.println("Inicio de sesión correcto.");
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Apellido: " + usuario.getApellido());
            System.out.println("Usuario: " + usuario.getUsuario());
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }
}