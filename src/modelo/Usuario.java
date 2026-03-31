package modelo;

// Clase modelo que representa a un usuario dentro del sistema.
// Contiene los datos principales que se registran, consultan, actualizan y eliminan.
// Aquí se aplica encapsulamiento mediante atributos privados y métodos de acceso.
public class Usuario {
    
    private int id;
    private String usuario;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correoElectronico;
    private String contrasena;

    // Constructor vacío necesario para crear objetos Usuario y asignar sus datos posteriormente.
    public Usuario() {
    }

    // Constructor con parámetros para inicializar un usuario con todos sus atributos.
    public Usuario(int id, String usuario, String nombre, String apellido, String telefono, String correoElectronico, String contrasena) {
        this.id = id;
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }
    
    // Métodos getters y setters para acceder y modificar los atributos del usuario de forma controlada.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
