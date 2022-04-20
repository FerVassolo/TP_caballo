import java.util.Arrays;

public class main {
    public static void main(String[] args) {
    Caballo caballo = new Caballo("b1");
    caballo.movimientosPosibles();
    caballo.movimientosPosiblesDeLaPila();
    caballo.movimientosPosiblesDeLaPila();
    System.out.println(caballo.pilasDeMovsPosibles[4].verTope());
    }
}