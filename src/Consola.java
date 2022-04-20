import java.util.Objects;
import java.util.Scanner;

public class Consola {
    public static void inputs()
    {
        Scanner consola = new Scanner(System.in);  // Create a Scanner object
        System.out.println("""
                Seleccionar una de las siguientes:
                • 1: Realizar el siguiente salto.
                • 2: Mostrar el contenido de las pilas.
                • 3: Salir.""");

        //Nota parcial: no va a devolver  System.out.println("Elegiste la 1");
        // devolverá el método, aún no creado, nextMove(), o algo así.
        boolean repeat = true;
        while (repeat) {
            String userName = consola.nextLine();  // Read user input
            if (Objects.equals(userName, "1")) {
                System.out.println("Elegiste la 1");  // Output user input
                repeat = false;
            } else if (Objects.equals(userName, "2")) {
                System.out.println("Elegiste la 2");
                repeat = false;
            } else if (Objects.equals(userName, "3")) {
                System.out.println("Elegiste la 3");
                repeat = false;
            } else{
                System.out.println("Input no valido, vuelva a intentar");}
        }
    }
}
