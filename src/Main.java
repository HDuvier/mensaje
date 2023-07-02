import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //creamos variables de lectura por consola
        Scanner sc = new Scanner(System.in);
        int option= 0 ;
        // se definen funciones de variables
        do {
            System.out.println("---------------");
            System.out.println("Aplicacion de mensajes platzi");
            System.out.println("1. Crear mensaje");
            System.out.println("2. Listar mensajes");
            System.out.println("3. Editar mensaje");
            System.out.println("4. Elimimar mensaje");
            System.out.println("5. Salir");
//se lee la entrada por consola y lo definimos como Int
            option = sc.nextInt();

            switch (option){
                case 1:
                    MensajeService.crearMensaje();
                    break;
                case 2:
                    MensajeService.listarMensaje();
                    break;
                case 3:
                    MensajeService.editarMensaje();
                    break;
                case 4:
                    MensajeService.borrarMensaje();
                    break;
                default:
                    break;
            }

        }while (option != 5);


/*
        conexion connexion = new conexion();
        try(Connection cnx = connexion.get_connetion()) {

        } catch (SQLException e) {
            System.out.println(e);
        }*/
    }
}