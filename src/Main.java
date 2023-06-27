import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        conexion connexion = new conexion();
        try(Connection cnx = connexion.get_connetion()) {

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}