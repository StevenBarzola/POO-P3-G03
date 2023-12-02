package modelo.participante;

public class Auspiciante extends Persona{
    private SectorCubierto secCubierto;
    
    //Constructor
    public Auspiciante(String ni, String n, String npr, int t, String e, String d, String sw, SectorCubierto sc){
        super(ni,n,t,e);
        secCubierto=sc;
    }
    
    //Getters y Setters
    public SectorCubierto getSectorCubierto(){
        return secCubierto;
    }
    
    public void setSectorCubierto(SectorCubierto sc){
        secCubierto=sc;
    }
    
    
    
}
