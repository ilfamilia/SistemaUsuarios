# Sistema de Usuarios (Java + Swing + MySQL)

Aplicación de escritorio desarrollada en Java que permite la gestión de usuarios mediante un sistema completo de autenticación y administración.

## Funcionalidades

- Login de usuarios
- Registro de usuarios
- Listado de usuarios
- Actualización de usuarios
- Eliminación de usuarios
- Cierre de sesión

## Tecnologías utilizadas

- Java (JDK 21)
- Swing (Interfaz gráfica)
- MySQL (Base de datos)
- JDBC (MySQL Connector/J)
- NetBeans (IDE)

## Arquitectura

El proyecto sigue el patrón de arquitectura MVC:

- Modelo: Manejo de datos y conexión a base de datos
- Vista: Interfaces gráficas (Swing)
- Controlador: Lógica de la aplicación

## Base de datos

El sistema utiliza MySQL.

### Datos de conexión por defecto:

- Host: localhost
- Puerto: 3306
- Usuario: root
- Contraseña: (la configurada durante la instalación)

## Librerías

El proyecto incluye el driver:

- mysql-connector-j-9.6.0.jar

## Cómo ejecutar el proyecto

1. Abrir el proyecto en NetBeans
2. Verificar que el JDK 21 esté configurado
3. Asegurarse de que MySQL esté corriendo
4. Ejecutar el proyecto desde el IDE

## Notas

- La base de datos debe estar creada previamente
- Se recomienda revisar la configuración de conexión en el código