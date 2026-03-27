# Explicación del Proyecto - Sistema de Usuarios

## 1. Descripción general
Este proyecto es una aplicación de escritorio en Java desarrollada con Swing y MySQL.

Permite:
- iniciar sesión
- registrar usuarios
- listar usuarios
- actualizar usuarios
- eliminar usuarios
- cerrar sesión

El proyecto fue desarrollado siguiendo el patrón MVC:
- Modelo
- Vista
- Controlador

---

## 2. Tecnologías utilizadas
- Java
- Swing
- MySQL
- JDBC
- MySQL Connector/J
- NetBeans

---

## 3. Estructura del proyecto

### Paquete `modelo`
Contiene las clases relacionadas con los datos.

- `Usuario`: representa a un usuario del sistema
- `UsuarioDAO`: maneja las operaciones con la base de datos

### Paquete `vista`
Contiene las ventanas de la aplicación.

- `VentanaLogin`
- `VentanaRegistro`
- `VentanaPrincipal`
- `VentanaActualizarUsuario`

### Paquete `controlador`
Contiene la lógica y los eventos de cada ventana.

- `ControladorLogin`
- `ControladorRegistro`
- `ControladorPrincipal`
- `ControladorActualizarUsuario`

### Paquete `conexion`
- `ConexionBD`: permite obtener la conexión con MySQL

### Paquete `principal`
- `Main`: punto de inicio del sistema

---

## 4. Base de datos
La base de datos se llama:

`sistema_usuarios`

La tabla principal es:

`usuarios`

Campos:
- `id`
- `usuario`
- `nombre`
- `apellido`
- `telefono`
- `correo_electronico`
- `contrasena`

---

## 5. Cómo funciona el sistema

### Login
El usuario escribe su nombre de usuario y contraseña.
Si los datos son correctos, se abre la ventana principal.

### Registro
Si el usuario no existe, puede registrarse llenando:
- usuario
- nombre
- apellido
- teléfono
- correo electrónico
- contraseña
- confirmar contraseña

### Ventana principal
Muestra una tabla con los usuarios registrados y permite:
- crear
- actualizar
- eliminar
- cerrar sesión

### Actualización
Permite modificar los datos de un usuario seleccionado.

### Eliminación
Permite borrar el usuario seleccionado de la tabla.

### Cierre de sesión
Cierra la ventana principal y vuelve al login.

---

## 6. Conceptos de programación orientada a objetos aplicados

### Encapsulamiento
Se aplicó en la clase `Usuario`, usando atributos privados y métodos getters y setters.

### Abstracción
Se aplicó al separar responsabilidades entre:
- vistas
- controladores
- acceso a datos

### Herencia
Se aplica de forma natural en las vistas, ya que las ventanas heredan de `JFrame`.

### Polimorfismo
Se aplica en los controladores al implementar `ActionListener` y redefinir el método `actionPerformed`.
También aparece al usar `WindowAdapter` en el refresco de la tabla.

---

## 7. Patrón utilizado
Se utilizó MVC como arquitectura principal.

Además, la clase `ConexionBD` centraliza la conexión con la base de datos, lo que ayuda a mantener el código organizado.

---

## 8. Flujo principal del sistema
1. Se abre `VentanaLogin`
2. El usuario inicia sesión o abre la ventana de registro
3. Si se registra correctamente, vuelve al login
4. Si inicia sesión correctamente, entra a `VentanaPrincipal`
5. Desde la ventana principal puede crear, actualizar, eliminar usuarios o cerrar sesión