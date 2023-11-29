package modelo.participante;

public class Auspiciante extends Persona{
    private SectorCubierto secCubierto;
    
    //Constructor
    public Auspiciante(String ni, String n, String npr, String t, String e, String d, String sw, SectorCubierto sc){
        super(ni,n,npr,t,e,d,sw);
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
