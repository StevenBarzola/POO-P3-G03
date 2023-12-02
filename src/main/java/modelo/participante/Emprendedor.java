package modelo.participante;

public class Emprendedor extends Persona{
    private String desServicio;
    
    //Constructor
    public Emprendedor(String ni, String n, String npr, int t, String e, String d, String sw, String ds){
        super(ni,n,t,e);
        desServicio=ds;
    }
    
    //Getters y Setters
    public String getDesServicio(){
        return desServicio;
    }
    
    public void setDesServicio(String ds){
        desServicio=ds;
    }
    
    
    
}
