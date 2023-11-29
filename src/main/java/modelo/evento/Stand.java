package modelo.evento;
import modelo.participante.*;

public class Stand {
    private String codigoSt;
    private Persona persona;
    private String fechaAsig;
    
    //Constructor
    public Stand(String cs){
        codigoSt=cs;
    }
    
    //Getters y Setters
    public String getCodigoSt(){
        return codigoSt;
    }
    
    public Persona getPersona(){
        return persona;
    }
    
    public String getFechaAsig(){
        return fechaAsig;
    }
    
    public void setcodigoSt(String co){
        codigoSt=co;
    }
    
    public void setPersona(Persona p){
        persona=p;
    }
    
    public void setFechaAsig(String f){
        fechaAsig=f;
    }
}
