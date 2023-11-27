package proyecto1parcial;

public class Stand {
    private String codigoSt;
    private Persona persona;
    private String fechaAsig;
    
    //Constructor
    public Stand(String cs, Persona p, String fa){
        codigoSt=cs;
        persona=p;
        fechaAsig= fa;
    }
    
    //Getters 
    public String getCodigoSt(){
        return codigoSt;
    }
    
    public Persona getPersona(){
        return persona;
    }
    
    public String getFechaAsig(){
        return fechaAsig;
    }
    
    //Generar codigo
    int i=1;
    public String generaCodigoStand(){
        String c= "#ST"+(String.valueOf(i));
        i++;
        return c;
    }
    
}
