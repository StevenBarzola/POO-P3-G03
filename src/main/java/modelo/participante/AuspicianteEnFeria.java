package modelo.participante;

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
    
    
    
    
}
