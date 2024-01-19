package modelo.participante;
import java.io.Serializable;
import modelo.evento.*;

public class AuspicianteEnFeria implements Serializable{
    private Auspiciante auspiciante;
    private String descripcion; 
    private boolean tieneStand;
    private Feria feria;
    
    //Constructor
    public AuspicianteEnFeria(Feria f, Auspiciante a, String d, boolean ts){
        auspiciante=a;
        descripcion=d;
        tieneStand=ts;
        feria=f;
    }
    
    //Getters y Setters
    public Auspiciante getAuspiciante(){
        return auspiciante;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public boolean getTieneStand(){
        return tieneStand;
    }
    public Feria getFeria(){
        return feria;
    }
    public void setDescripcion(String d){
        descripcion=d;
    } 
    
    public void setTieneStand(boolean ts){
        tieneStand=ts;
    }
    public void setFeria(Feria f){
        feria=f;
    }
  // 3.3 Asignar Auspiciante en la Feria
    public static boolean verificarAuspicianteFeria(String c, String nc){
        Persona encPer = Sistema.encontrarPersona(nc);
        if(encPer!=null && encPer instanceof Auspiciante){
            Feria encFeria = Sistema.encontrarFeria(c);
            return encFeria != null;
        }
        return false;
    }   
 
}
