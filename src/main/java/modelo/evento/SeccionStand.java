package modelo.evento;
import java.util.ArrayList;

public class SeccionStand {
    private int canStand;
    private ArrayList<Stand> seccion;
    
    //Constructor
    public SeccionStand(int cs){
        canStand=cs;
        seccion=new ArrayList<>();
    }
    
    //Getters
    public int getCanStand(){
        return canStand;
    }
    
    public ArrayList<Stand> getSeccion(){
        return seccion;
    }
    
    //Crear stands
    public void crearStands(int n){
        int num=1;
        String[] letra= {"A","B","C","D"};
        while(num<=canStand){
            String co= letra[n]+(String.valueOf(num));
            seccion.add(new Stand(co));
            num++;   
        }
    }
    
   
}
