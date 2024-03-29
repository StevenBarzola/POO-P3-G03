package modelo.evento;
import java.io.Serializable;
import java.time.LocalDate;
import modelo.participante.*;

public class Stand implements Serializable{
    private String codigoSt;
    private Persona persona;
    private LocalDate fechaAsig;
    
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
    
    public LocalDate getFechaAsig(){
        return fechaAsig;
    }
    
    public void setcodigoSt(String co){
        codigoSt=co;
    }
    
    public void setPersona(Persona p){
        persona=p;
    }
    
    public void setFechaAsig(LocalDate f){
        fechaAsig=f;
    }
    
    //Metodo toString
    @Override
    public String toString(){
        char cod1= codigoSt.charAt(0);
        char cod2= codigoSt.charAt(1);
        String pers="";
        if(persona instanceof Auspiciante){pers="(Auspiciante):";}
        if(persona instanceof Emprendedor){pers="(Emprendedor):";}
        return "Codigo: "+String.valueOf(cod1)+String.valueOf(cod2)+"\nfecha de asignacion: "+fechaAsig
        +"\nOcupado por "+pers+"\n"+persona.toString();
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
