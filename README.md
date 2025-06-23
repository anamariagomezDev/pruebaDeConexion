-----

# Proyecto Java JDBC: Operaciones CRUD Básicas

Este proyecto Java demuestra cómo realizar operaciones **CRUD (Create, Read, Update, Delete)** básicas en una base de datos MySQL utilizando **JDBC (Java Database Connectivity)**. Se enfoca en el uso de `PreparedStatement` para prevenir inyecciones SQL y asegurar una interacción segura con la base de datos.

-----

## Contenido del Proyecto

El código provisto en `Main.java` incluye ejemplos comentados y activos para:

  * **Conexión a la Base de Datos:** Establecimiento de una conexión JDBC con una base de datos MySQL.
  * **DELETE (Eliminar):** Eliminación de registros de la tabla `employees`. (Actualmente activo)
  * **INSERT (Crear):** Inserción de nuevos registros en la tabla `employees`. (Comentado)
  * **UPDATE (Actualizar):** Modificación de registros existentes en la tabla `employees`. (Comentado)
  * **SELECT (Leer):** Recuperación y visualización de datos de la tabla `employees`. (Actualmente activo)

-----

## Requisitos

Antes de ejecutar este proyecto, asegúrate de tener lo siguiente:

  * **Java Development Kit (JDK):** Versión 8 o superior.

  * **MySQL Server:** Una instancia de MySQL ejecutándose localmente.

  * **Base de Datos `project`:** Una base de datos llamada `project` en tu servidor MySQL.

  * **Tabla `employees`:** Una tabla `employees` dentro de la base de datos `project` con al menos las columnas `first_name`, `pa_surname` y `email`.

  * **MySQL JDBC Driver:** Necesitarás el conector JDBC de MySQL. Puedes descargarlo de la [página oficial de MySQL](https://dev.mysql.com/downloads/connector/j/) o añadirlo como una dependencia si usas Maven o Gradle.

    Si no estás usando un gestor de dependencias, descarga el `.jar` y añádelo a tu `classpath` del proyecto.

-----

## Configuración de la Base de Datos

1.  **Crea la base de datos `project`:**
    ```sql
    CREATE DATABASE project;
    USE project;
    ```
2.  **Crea la tabla `employees`:**
    ```sql
    CREATE TABLE employees (
        id INT AUTO_INCREMENT PRIMARY KEY,
        first_name VARCHAR(50),
        pa_surname VARCHAR(50),
        email VARCHAR(100)
    );
    ```
3.  **Inserta algunos datos de prueba (opcional, pero recomendado):**
    ```sql
    INSERT INTO employees (first_name, pa_surname, email) VALUES
    ('Alice', 'Smith', 'alice@example.com'),
    ('Bob', 'Johnson', 'bob@example.com'),
    ('Charlie', 'Brown', 'charlie@example.com');
    ```
4.  **Actualiza las credenciales de conexión en `Main.java` si son diferentes:**
    Asegúrate de que `url`, `usuario`, y `password` en el código (`Main.java`) coincidan con tu configuración de MySQL.
    ```java
    String url = "jdbc:mysql://localhost:3306/project";
    String usuario = "root"; // Tu usuario de MySQL
    String password = "qwerty"; // Tu contraseña de MySQL
    ```

-----

## Cómo Ejecutar el Proyecto

1.  **Clona o descarga** este repositorio.
2.  **Abre el proyecto** en tu IDE Java preferido (IntelliJ IDEA, Eclipse, VS Code).
3.  **Asegúrate de que el driver JDBC de MySQL esté en tu classpath.** Si estás usando un proyecto Maven o Gradle, añádelo como dependencia en tu `pom.xml` o `build.gradle` respectivamente.
    **Ejemplo para Maven (`pom.xml`):**
    ```xml
    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.33</version> </dependency>
    </dependencies>
    ```
4.  **Ejecuta el archivo `Main.java`**. Puedes hacerlo directamente desde tu IDE.

-----

## Notas Adicionales

  * El código utiliza `PreparedStatement` para todas las operaciones, lo cual es una **buena práctica de seguridad** para prevenir ataques de inyección SQL.
  * Las operaciones de `INSERT` y `UPDATE` están actualmente **comentadas** en el código. Para probarlas, simplemente descomenta las líneas correspondientes.
  * El bloque `finally` asegura que los recursos de la base de datos (`Connection`, `PreparedStatement`, `ResultSet`) se **cierren correctamente** para evitar fugas de recursos, incluso si ocurren errores.
