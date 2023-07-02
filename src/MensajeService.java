import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MensajeService {

    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribir mensaje");
        String mensaje = sc.nextLine();

        System.out.println("escribe tu nombre");
        String nombre = sc.nextLine();

        Mensaje registro = new Mensaje();
        registro.setMensaje(mensaje);
        registro.setAutorMensaje(nombre);
        MensajeDAO.crearMensajeDB(registro);
    }
    public static void listarMensaje(){

    }
    public static void borrarMensaje(){

    }
    public static void editarMensaje(){

    }
}
