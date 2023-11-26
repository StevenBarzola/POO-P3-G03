package proyecto1parcial;
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
    
    
}
