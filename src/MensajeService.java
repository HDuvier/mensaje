import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
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
        ArrayList leerMensajes = MensajeDAO.leerMensajesDB();
        for (int i = 0; i < leerMensajes.size(); i++) {
            System.out.println(leerMensajes.get(i));
        }


    }
    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Id del mensaje a borrar ");
        int id = sc.nextInt();

        MensajeDAO.borrarMensajeDB(id);

    }
    public static void editarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ingresa mensaje nuevo");
        String mensaj = sc.nextLine();
        System.out.println("ingresa el id del mensaje");
        int idMens = sc.nextInt();

        Mensaje editado = new Mensaje();
        editado.setMensaje(mensaj);
        editado.setIdMensaje(idMens);
        MensajeDAO.actualizarMensajeDB(editado);

    }
}
