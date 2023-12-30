package modelo.participante;
import modelo.evento.*;

public class AuspicianteEnFeria {
    private Auspiciante auspiciante;
    private String descripcion; 
    private boolean tieneStand;
    
    //Constructor
    public AuspicianteEnFeria(Auspiciante a, String d, boolean ts){
        auspiciante=a;
        descripcion=d;
        tieneStand=ts;
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
    
    public void setDescripcion(String d){
        descripcion=d;
    } 
    
    public void setTieneStand(boolean ts){
        tieneStand=ts;
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
