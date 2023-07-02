import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MensajeDAO {

    public static void crearMensajeDB(Mensaje mensaje){
        conexion dbConnect = new conexion();

        try(Connection connexion = dbConnect.get_connetion()){
            PreparedStatement ps = null;
            try {
                String consulta = "insert into mensajes (mensaje,autor_mensaje) values (?,?)";
                ps = connexion.prepareStatement(consulta);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutorMensaje());
                ps.executeUpdate();
                System.out.println("mensaje creado");

            } catch (Exception ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    public static void leerMensajesDB(){

    }
    public static void borrarMensajeDB(int idMensaje){

    }
    public static void actualizarMensajeDB(Mensaje mensaje){

    }
}
