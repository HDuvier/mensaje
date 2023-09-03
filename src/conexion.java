import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    //creamos una variable de tipo Connection
    public Connection get_connetion(){
        Connection conection= null;
        //se usa un try para que se haga el requerimiento varias veces en caso de ser necesario
        try {
            //se crea la conexion con la base de datos pasandole los parametros necesarios
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensaje","root","");

//con el catch se toma la excepcion para saber si se genero la conexion o si presento algun error
        }catch (SQLException e) {
            System.out.println(e);
        }
        //se retorna la conexion a la base da datos
        return conection;
    }
}
