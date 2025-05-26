import java.sql.*;

public class Main {
    public static void main(String[] args) {


        //JDBC CRUD
        
        /*
         Declaro las variables Connection, PrepareStatement y ResultSet.
        Utilizo PrepareStatement para evitar problemas con inyecciones SQL
        */
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        // Definimos las credenciales de conexión
        String url = "jdbc:mysql://localhost:3306/project";
        String usuario = "root";
        String password = "qwerty";

        try {
            // 1. Establecer la conexión
            System.out.println("Conectando a la base de datos...");
            myConn = DriverManager.getConnection(url, usuario, password);


            String sql = "DELETE FROM employees WHERE first_name = 'Juan'";
            myStmt = myConn.prepareStatement(sql);

            int rowsAffected = myStmt.executeUpdate();
            
            // 2. Verificar si la conexión fue exitosa
            if (myConn != null) {
                System.out.println("¡Conexión exitosa a la base de datos!");
            }

            /*Creo el objeto Statement y ejecuto la consulta SQL
            String sql = "INSERT INTO employees (first_name, pa_surname) VALUES (?,?)";
            PreparedStatement preparedStatement = myConn.prepareStatement(sql);
            preparedStatement.setString(1, "Juan");
            preparedStatement.setString(2, "Perez");
           // preparedStatement.executeUpdate();

            int rowAffected = myStmt.executeUpdate(
                    "UPDATE employees SET email = 'JuanP@example.es' WHERE first_name = 'Juan'"
            );*/

            myRs = myStmt.executeQuery("SELECT * FROM employees order by pa_surname");

            //Proceso los resultados con .next y el .getString
            while (myRs.next()) {
                String firstName = myRs.getString("first_name");
                String email = myRs.getString("email");
                System.out.println(firstName + ", " + email);
            }

        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos:");
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (myRs != null) myRs.close();
                if (myStmt != null) myStmt.close();
                if (myConn != null) myConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}