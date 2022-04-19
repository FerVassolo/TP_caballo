import java.util.Objects;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Seleccionar una de las siguientes:\n" + "• 1: Realizar el siguiente salto.\n" +
                "• 2: Mostrar el contenido de las pilas.\n" +
                "• 3: Salir.");

        boolean repetir = true;
        while (repetir) {
            String userName = consola.nextLine();  // Read user input
            if (Objects.equals(userName, "1")) {
                System.out.println("Elegiste la 1");  // Output user input
                repetir = false;
            } else if (Objects.equals(userName, "2")) {
                System.out.println("Elegiste la 2");
                repetir = false;
            } else if (Objects.equals(userName, "3")) {
                System.out.println("Elegiste la 3");
                repetir = false;
            } else{
                System.out.println("Input no valido, vuelva a intentar");
                repetir = true;}
        }
    }
}
