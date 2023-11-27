package proyecto1parcial;
import java.util.ArrayList;

public abstract class Persona {
    protected String numId;
    protected String nombre;
    protected String nombrePerRes;
    protected String telefono;
    protected String email;
    protected String direccion;
    protected String sitioWeb;
    protected ArrayList<RedSocial> redesSociales;
    
    //Constructor 
    public Persona(String ni, String n, String npr, String t, String e, String d, String sw){
        numId=ni;
        nombre=n;
        nombrePerRes=npr;
        telefono=t;
        email=e;
        direccion=d;
        sitioWeb=sw;
        redesSociales=new ArrayList<>();
    }
    
    
}
