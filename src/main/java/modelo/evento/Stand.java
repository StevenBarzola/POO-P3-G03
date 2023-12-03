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
    
    //Metodo toString
    @Override
    public String toString(){
        return "Codigo: "+codigoSt+", fecha de asignacion: "+fechaAsig
        +"Ocupado por: "+persona.toString();
    }
    
    //Informacion del stand
    public void verInformacionStand(){
        if(persona!=null){
            System.out.println(this.toString());
        }else System.out.println("Este stand no tiene a nadie asignado");
    }
    
    //Validar si el stand esta disponible
    public boolean estaDisponible(){
        if(codigoSt.length()==3){ //Ya que con * serían 3 caracteres
            return false;
        }return true;
    }
    
}
