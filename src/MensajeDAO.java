import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MensajeDAO {

    //el metodo crear mensaje lo que hace es agregar un mensaje a la base de datos cuando se haga el requerimiento
    public static void crearMensajeDB(Mensaje mensaje){
        //se crea una variable de tipo conexion
        conexion dbConnect = new conexion();
 //se genera la conexion con la base de datos
        try(Connection connexion = dbConnect.get_connetion()){
            //se crea una variable para precompilar SQL
            PreparedStatement ps = null;
            try {
                //la consulta se debe hacer usando los mismos terminos y variables usados en SQL
                String consulta = "insert into mensajes (mensaje,autor_mensaje,fecha_mensaje) values (?,?,current_timestamp())";
                //los ? mostrados antes son los datos que se van a incluir en la consulta a continuacion
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
    public static ArrayList leerMensajesDB(){
        conexion dbConnect = new conexion();
        ArrayList arrayMensajes = new ArrayList<>();

        try (Connection connexion = dbConnect.get_connetion()){
            PreparedStatement ps = null;
            ResultSet rs = null;

            String consulta = "select * from mensajes";
            ps = connexion.prepareStatement(consulta);
            rs  = ps.executeQuery();
            while (rs.next()){
                //ArrayList mensajes = new ArrayList<>();
                arrayMensajes.add(rs.getInt("id_mensaje"));
                arrayMensajes.add(rs.getString("mensaje"));
                arrayMensajes.add(rs.getString("autor_mensaje"));
                arrayMensajes.add(rs.getString("fecha_mensaje"));
                arrayMensajes.add("\n");
            };


        } catch (SQLException e) {
            System.out.println(e);
        }
        return arrayMensajes;
    }
    public static void borrarMensajeDB(int idMensaje){
        conexion dbConnexion = new conexion();
         try (Connection connexion = dbConnexion.get_connetion()) {
             PreparedStatement ps = null;
             try {
                 String consulta = "delete from mensajes where id_mensaje = ?";
                 ps = connexion.prepareStatement(consulta);
                 ps.setInt(1,idMensaje);
                 ps.executeUpdate();
                 System.out.println("fue borrado");
             } catch (SQLException ex) {
                 System.out.println(ex);
                 throw new RuntimeException(ex);
             }
         } catch (SQLException e) {
             System.out.println(e);
             throw new RuntimeException(e);
         }

    }
    public static void actualizarMensajeDB(Mensaje mensaje){
        conexion dbConexion = new conexion();
        try (Connection connection = dbConexion.get_connetion()){
            PreparedStatement ps = null;
            try {
                String consulta = "update mensajes set mensaje = ? where id_mensaje = ?";
                ps = connection.prepareStatement(consulta);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2,mensaje.getIdMensaje());
                ps.executeUpdate();
                System.out.println("actualizado");

            } catch (Exception ex) {
                System.out.println("no se actualizo");
                throw new RuntimeException(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }

    }
}
