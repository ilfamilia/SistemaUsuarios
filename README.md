```markdown
# Sistema de Usuarios

Aplicación de escritorio desarrollada en **Java** con interfaz gráfica **Swing** y base de datos **MySQL**.

El sistema permite:

- iniciar sesión
- registrar usuarios
- listar usuarios
- actualizar usuarios
- eliminar usuarios
- cerrar sesión

---

## Tecnologías utilizadas

- Java
- Swing
- MySQL
- JDBC
- MySQL Connector/J
- NetBeans

---

## Arquitectura del proyecto

El proyecto fue desarrollado siguiendo el patrón **MVC**:

- **Modelo**: clases de datos y acceso a base de datos
- **Vista**: formularios gráficos en Swing
- **Controlador**: lógica de eventos y comunicación entre vista y modelo

---

## Estructura del proyecto

```text
src
├── conexion
│   └── ConexionBD.java
├── controlador
│   ├── ControladorActualizarUsuario.java
│   ├── ControladorLogin.java
│   ├── ControladorPrincipal.java
│   └── ControladorRegistro.java
├── modelo
│   ├── Usuario.java
│   └── UsuarioDAO.java
├── principal
│   └── Main.java
└── vista
    ├── VentanaActualizarUsuario.java
    ├── VentanaLogin.java
    ├── VentanaPrincipal.java
    └── VentanaRegistro.java

```

---

## Base de datos

Nombre de la base de datos:

- sistema_usuarios

Tabla principal:

- usuarios

Campos:

- id
- usuario
- nombre
- apellido
- telefono
- correo_electronico
- contrasena

---

## Requisitos para ejecutar

Antes de ejecutar el proyecto debes tener instalado:

- JDK
- NetBeans
- MySQL Server
- MySQL Connector/J

También debes:

- ejecutar el archivo `database.sql`
- configurar correctamente el archivo `ConexionBD.java` con tu usuario y contraseña de MySQL

> Nota: por seguridad, el archivo `ConexionBD.java` contiene una contraseña de ejemplo.  
> Debe reemplazarse por la contraseña local de MySQL antes de ejecutar el proyecto.

---

## Ejecución del proyecto

1. Ejecutar el archivo `database.sql`
2. Abrir el proyecto en NetBeans
3. Verificar que el archivo `ConexionBD.java` tenga las credenciales correctas
4. Ejecutar la clase:

```text

principal.Main

```

---

## Funcionalidades principales

### Login

Permite iniciar sesión con usuario y contraseña.

### Registro

Permite registrar nuevos usuarios con validaciones.

### Listado de usuarios

Muestra los usuarios registrados en una tabla.

### Actualización

Permite modificar los datos de un usuario seleccionado.

### Eliminación

Permite eliminar un usuario seleccionado.

### Cierre de sesión

Permite salir de la ventana principal y volver al login.

---

## Autor

Proyecto académico individual de Programación 1.
```

---
