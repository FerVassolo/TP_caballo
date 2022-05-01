import java.util.Objects;
import java.util.Scanner;

public class Caballo{
    // bounds: a-h, 1-8. a1-b1 es un mov, b1-b2 es otro
    String[][] tablero;
    //poscicion actual donde está el caballo
    Pila[] pilasDeMovsPosibles;
    Pila[] proximo_movimiento;
    String posicion;
    int i;
    int j;
    int k;
    int cantidadDeNodos = 4;

    // al inicializar uno pasa la posicion de la que quiere hallar los proximos movimientos
    public Caballo(String posicion) {
        tablero = new String[8][8];
        crearTablero();
        pilasDeMovsPosibles = new Pila[100];
        i = -1;
        j = 0;
        k = 0;
        // proximo_movimiento es una pila que guarda todas las combinaciones validas posibles para la posicion
        proximo_movimiento = new Pila[1000];
        this.posicion = posicion;
        Backtracking(posicion, cantidadDeNodos, posicion);

    }

    private void crearTablero() {
        int col;
        int fila;
        String[] letras = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};
        for (fila = 0; fila < 8; fila++) { // tomo cada lista dentro de las listas
            for (col = 0; col < 8; col++) { // cada elemento dentro de las sublistas
                tablero[col][fila] = letras[fila] + String.valueOf(col + 1);
            }
        }
    }

    public String[][] getTablero() {
        return tablero;
    }

    // PGN llamamos a la notacion en ajedrez
    public int[] PGN_a_lista(String pos) {    //El usuario da una posicion y la convertimos a una lista de 2 elementos:
        // el 0 es la fila (a == 0) y el segundo la colimna
        int col;
        int fila;
        int[] pocision;
        for (fila = 0; fila < 8; fila++) {
            for (col = 0; col < 8; col++) {
                if (Objects.equals(pos, tablero[fila][col])) {

                    return pocision = new int[]{fila, col};

                }
            }
        }

        return pocision = new int[]{-1, -1};
    }


    //Para backtracking, la posisicon, n: cant de nodos a medir (tratamos irremediablemente con 4 al principio,
    // no supimos resolver para hacerlo con una cantidad definida por el usuario)
    public Pila Backtracking(String pos, int n, String pocicionAnterior) {
        if (n == 0) {
            nMaximo(n, pocicionAnterior);
        } else if (n > 0) {
            n -= 1;
            i++;
            j++;
            int fila = PGN_a_lista(pos)[0];
            int col = PGN_a_lista(pos)[1];
            Pila movs_posibles = new Pila();
            // Estos ifs chequean que el movimiento sea valido y apila el movimiento
            if (0 <= fila - 1 && fila - 1 < 8) {
                if (0 <= col + 2 && col + 2 < 8) {
                    if (!Objects.equals(tablero[fila - 1][col + 2], pocicionAnterior)) {
                        String mov_posible = tablero[fila - 1][col + 2];
                        movs_posibles.apilar(mov_posible);
                    }
                }
            }
            if (0 <= fila + 1 && fila + 1 < 8) {
                if (0 <= col + 2 && col + 2 < 8) {
                    if (!Objects.equals(tablero[fila + 1][col + 2], pocicionAnterior)) {
                        String mov_posible = tablero[fila + 1][col + 2];
                        movs_posibles.apilar(mov_posible);
                    }
                }
            }
            if (0 <= fila + 2 && fila + 2 < 8) {
                if (0 <= col + 1 && col + 1 < 8) {
                    if (!Objects.equals(tablero[fila + 2][col + 1], pocicionAnterior)) {
                        String mov_posible = tablero[fila + 2][col + 1];
                        movs_posibles.apilar(mov_posible);
                    }
                }
            }
            if (0 <= fila - 2 && fila - 2 < 8) {
                if (0 <= col + 1 && col + 1 < 8) {
                    if (!Objects.equals(tablero[fila - 2][col + 1], pocicionAnterior)) {
                        String mov_posible = tablero[fila - 2][col + 1];
                        movs_posibles.apilar(mov_posible);
                    }
                }
            }
            if (0 <= fila + 2 && fila + 2 < 8) {
                if (0 <= col - 1 && col - 1 < 8) {
                    if (!Objects.equals(tablero[fila + 2][col - 1], pocicionAnterior)) {
                        String mov_posible = tablero[fila + 2][col - 1];
                        movs_posibles.apilar(mov_posible);
                    }
                }
            }
            if (0 <= fila + 1 && fila + 1 < 8) {
                if (0 <= col - 2 && col - 2 < 8) {
                    if (!Objects.equals(tablero[fila + 1][col - 2], pocicionAnterior)) {

                        String mov_posible = tablero[fila + 1][col - 2];
                        movs_posibles.apilar(mov_posible);
                    }
                }
            }
            if (0 <= fila - 1 && fila - 1 < 8) {
                if (0 <= col - 2 && col - 2 < 8) {
                    if (!Objects.equals(tablero[fila - 1][col - 2], pocicionAnterior)) {
                        String mov_posible = tablero[fila - 1][col - 2];
                        movs_posibles.apilar(mov_posible);
                    }
                }
            }
            if (0 <= fila - 2 && fila - 2 < 8) {
                if (0 <= col - 1 && col - 1 < 8) {
                    if (!Objects.equals(tablero[fila - 2][col - 1], pocicionAnterior)) {
                        String mov_posible = tablero[fila - 2][col - 1];
                        movs_posibles.apilar(mov_posible);
                    }
                }
            }

            pilasDeMovsPosibles[i] = movs_posibles;
            return Backtracking(movs_posibles.verTope(), n, pos);
        }
        return null;
    }


    public Pila nMaximo(int n, String pos_ant) {
        if (n <= cantidadDeNodos) {
            pilasDeMovsPosibles[i].desapilar();
            if (pilasDeMovsPosibles[i].verTope() != "-1") {
                Pila secuencia = new Pila();
                for (j = 0; j <= i; j++) {
                    secuencia.apilar(pilasDeMovsPosibles[j].verTope());
                }
                proximo_movimiento[k] = secuencia;
                k++;
                return Backtracking(pilasDeMovsPosibles[i].verTope(), n, pos_ant);
            } else {
                n++;
                i--;
                pilasDeMovsPosibles[i].desapilar();
                if (pilasDeMovsPosibles[i].verTope() != "-1")
                    return Backtracking(pilasDeMovsPosibles[i].verTope(), n, pos_ant);
            }
            if (pilasDeMovsPosibles[1].verTope() != "-1") {
                n += 1;
                i -= 1;
                pilasDeMovsPosibles[i].desapilar();
                if (pilasDeMovsPosibles[1].verTope() != "-1") {
                    return Backtracking(pilasDeMovsPosibles[i].verTope(), n, pos_ant);
                }
            }
            if (pilasDeMovsPosibles[0].verTope() != "-1") {
                n += 1;
                i -= 1;
                pilasDeMovsPosibles[i].desapilar();
                if (pilasDeMovsPosibles[0].verTope() != "-1") {
                    return Backtracking(pilasDeMovsPosibles[i].verTope(), n, pos_ant);
                }
            }
            // voy a querer hacer esto con todos los movs posibles en n y guardarlos para luego
            // cuando el usuario los pida dar el ultimo

        }
        return null;
    }
    public void contenidoDeLasPilas(){
        //for (i = 0; i < caballo.proximo_movimiento.verTope().length(); i++)
        for (i = 0; i < proximo_movimiento.length; i++){
            if (proximo_movimiento[i] != null){
                String mov4 = proximo_movimiento[i].verTope();
                proximo_movimiento[i].desapilar();
                String mov3 = proximo_movimiento[i].verTope();
                proximo_movimiento[i].desapilar();
                String mov2 = proximo_movimiento[i].verTope();
                proximo_movimiento[i].desapilar();
                String mov1 = proximo_movimiento[i].verTope();
                proximo_movimiento[i].apilar(mov1);
                proximo_movimiento[i].apilar(mov2);
                proximo_movimiento[i].apilar(mov3);
                proximo_movimiento[i].apilar(mov4);
                System.out.println(this.posicion + " " + mov1 + " " + mov2 + " " + mov3 + " " + mov4);}
        }
    }
    public void mostrarProximoElemento(){
        int l = -1;
        for (i = 0; i < proximo_movimiento.length; i++){
            if (proximo_movimiento[i] != null){
                l++;
            }
        }
        String mov4 = proximo_movimiento[l].verTope();
        proximo_movimiento[l].desapilar();
        String mov3 = proximo_movimiento[l].verTope();
        proximo_movimiento[l].desapilar();
        String mov2 = proximo_movimiento[l].verTope();
        proximo_movimiento[l].desapilar();
        String mov1 = proximo_movimiento[l].verTope();
        proximo_movimiento[l] = null;
        System.out.println(this.posicion + " " + mov1 + " " + mov2 + " " + mov3 + " " + mov4);
    }

    public void inputs()
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
                mostrarProximoElemento();  // Output user input
            } else if (Objects.equals(userName, "2")) {
                contenidoDeLasPilas();
            } else if (Objects.equals(userName, "3")) {
                System.out.println("Finalizando el programa...");
                repeat = false;
            } else{
                System.out.println("Input no valido, vuelva a intentar");}
        }
    }
}
