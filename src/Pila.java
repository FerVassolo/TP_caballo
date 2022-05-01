public class Pila {

    private int tope; //peek
    private int tamaño = 100;
    private String[] pil = new String[tamaño]; //El caballo puede tener un max de 8 movimientos posibles en el mayor de los casos

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
        if (tope == tamaño){
            agrandarArray();
        }
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
            return "-1";
    }
    public void agrandarArray(){
        String[] auxArray = new String[tamaño + 10];
        for (int i = 0; i<tamaño; i++){
            auxArray[i] = pil[i];
        }
        tamaño = auxArray.length;
        pil = auxArray;
    }

}
