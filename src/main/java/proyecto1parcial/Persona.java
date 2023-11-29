package proyecto1parcial;
import java.util.ArrayList;

public abstract class Persona {
    protected String numId;
    protected String nombrePer;
    protected String nombrePerRes;
    protected String telefono;
    protected String email;
    protected String direccion;
    protected String sitioWeb;
    protected ArrayList<RedSocial> redesSociales;
    
    //Constructor 
    public Persona(String ni, String np, String npr, String t, String e, String d, String sw){
        numId=ni;
        nombrePer=np;
        nombrePerRes=npr;
        telefono=t;
        email=e;
        direccion=d;
        sitioWeb=sw;
        redesSociales=new ArrayList<>();
    }
    @Override
    public String toString(){
        return "Cedula: "+ numId+ "\n Nombre: " +nombrePer + "\n Telfono: "+ telefono + "\n Email: " + email + "\n Direccion: "+ sitioWeb + "\n Redes sociales"+ redesSociales;
    }
    
    
    
}
