import java.util.Objects;

public class Caballo {
    // bounds: a-h, 1-8. a1-b1 es un mov, b1-b2 es otro
    String[][] tablero;
    int[] posicion; //poscicion actual donde está el caballo
    Pila[] pilasDeMovsPosibles;
    int i;
    int j;


    public Caballo(String pos){
         tablero = new String[8][8];
         crearTablero();
         PGN_a_lista(pos);
         pilasDeMovsPosibles = new Pila[100];
         i = 0;
         j = 0;
    }

    private void crearTablero(){
        int col;
        int fila;
        String[] letras = new String[]{"a","b","c","d","e","f","g","h"};
        for (fila = 1; fila <=8; fila++){ // tomo cada lista dentro de las listas
            for (col = 1; col <= 8; col++){ // cada elemento dentro de las sublistas
                tablero[col - 1][fila - 1] = letras[fila - 1] + String.valueOf(col);
            }
        }
    }
    public String[][] getTablero(){
        return tablero;
    }

    // PGN llamamos a la notacion en ajedrez
    public void PGN_a_lista(String pos){    //El usuario da una posicion y la convertimos a una lista de 2 elementos:
                                            // el 0 es la fila (a == 0) y el segundo la colimna
        int col;
        int fila;
        for (fila = 1; fila <=8; fila++){
            for (col = 1; col <= 8; col++){
                if (Objects.equals(tablero[col - 1][fila - 1], pos)) {
                    this.posicion = new int[]{fila - 1, col - 1};

                }
            }
        }

    }

    public Pila movimientosPosibles(){
        int fila = this.posicion[0];
        int col = this.posicion[1];
        Pila movs_posibles = new Pila();

        try {
            String mov_posible = tablero[fila-1][col+2];
            movs_posibles.apilar(mov_posible);
        }
        catch (Exception ArrayIndexOutOfBoundsException) {

        }

        try {
            String mov_posible = tablero[fila+1][col+2];
            movs_posibles.apilar(mov_posible);
        }
        catch (Exception ArrayIndexOutOfBoundsException) {

        }

        try {
            String mov_posible = tablero[fila+2][col+1];
            movs_posibles.apilar(mov_posible);
        }
        catch (Exception ArrayIndexOutOfBoundsException) {

        }
        try {
            String mov_posible = tablero[fila-2][col+1];
            movs_posibles.apilar(mov_posible);
        }
        catch (Exception ArrayIndexOutOfBoundsException) {

        }
        try {
            String mov_posible = tablero[fila+2][col-1];
            movs_posibles.apilar(mov_posible);
        }
        catch (Exception ArrayIndexOutOfBoundsException) {

        }
        try {
            String mov_posible = tablero[fila+1][col-2];
            movs_posibles.apilar(mov_posible);
        }
        catch (Exception ArrayIndexOutOfBoundsException) {

        }
        try {
            String mov_posible = tablero[fila-1][col-2];
            movs_posibles.apilar(mov_posible);
        }
        catch (Exception ArrayIndexOutOfBoundsException) {

        }
        try {
            String mov_posible = tablero[fila-2][col-2];
            movs_posibles.apilar(mov_posible);
        }
        catch (Exception ArrayIndexOutOfBoundsException) {

        }

        pilasDeMovsPosibles[i] = movs_posibles;
        i+=1;
        return movs_posibles;

    }

    public void movimientosPosiblesDeLaPila(){

        while (pilasDeMovsPosibles[j].verTope() != "No restan más posiciones."){
            PGN_a_lista(pilasDeMovsPosibles[j].verTope());
            movimientosPosibles();
            pilasDeMovsPosibles[j].desapilar();
            System.out.println("Bien");
        }
        j = +1;
    }

}

