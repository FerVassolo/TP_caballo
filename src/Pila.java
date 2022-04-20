public class Pila {

    private int tope; //peek
    private String[] pil = new String[100];
    public Pila()
    {
        tope=-1;// explico en apilar
    }

    public void desapilar()//Pop
    {
        tope--;
    }

    public void apilar(String x)//push
    {
        tope++; // en el primero, tope es 0
        pil[tope]=x;
    }

    public boolean esVacia()//IsEmpty
    {
        return tope == -1;
    }

    public String verTope() { //peek
        if (!esVacia()){
            String a = pil[tope];
            return a;
        } else
            return "No restan más posiciones.";
    }


}
