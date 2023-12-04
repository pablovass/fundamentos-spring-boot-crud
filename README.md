# Fundamentos Spring Boot

Este repositorio contiene ejemplos y prototipos que ilustran los fundamentos de Spring Boot, incluyendo operaciones CRUD con MySQL y la integración de Spring Security.

## Contenido

1. **MySQL CRUD**: Ejemplos de operaciones CRUD (Crear, Leer, Actualizar, Eliminar) utilizando una base de datos MySQL. Los ejemplos proporcionan una base para el desarrollo de aplicaciones que requieren persistencia de datos.

2. **Spring Security**: Integración de Spring Security para la autenticación y autorización en una aplicación Spring Boot. Incluye ejemplos de configuración y uso básico de Spring Security para proteger recursos y endpoints.

## Requisitos

- Java 17 o superior
- Gradle 9
- MySQL

## Instrucciones de Uso

1. **Clonar el Repositorio**:

    ```bash
    git clone https://github.com/tu-usuario/fundamentos-spring-boot.git
    cd fundamentos-spring-boot
    ```

2. **Configurar la Base de Datos**:

    - Crea una base de datos MySQL llamada `fundamentos_spring_boot`.
    - Actualiza las credenciales de la base de datos en el archivo `application.properties`.

3. **Ejecutar la Aplicación**:

    ```bash
    mvn spring-boot:run
    ```

4. **Acceder a los Ejemplos**:

    - CRUD con MySQL: [http://localhost:8080/crud](http://localhost:8080/crud)
    - Spring Security: [http://localhost:8080/secured](http://localhost:8080/secured)

## Contribuciones

¡Las contribuciones son bienvenidas! Si encuentras problemas o mejoras, no dudes en abrir un problema o enviar una solicitud de extracción.

## Licencia

Este proyecto está bajo la Licencia MIT - consulta el archivo [LICENSE](LICENSE) para más detalles.
