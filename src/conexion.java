import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    public Connection get_connetion(){
        Connection conection= null;
        try {
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensaje","root","Douvcka0622*");
            if (conection != null){
                System.out.println("conexion realizada");
            };
        }catch (SQLException e) {
            System.out.println(e);
        }
        return conection;
    }
}
