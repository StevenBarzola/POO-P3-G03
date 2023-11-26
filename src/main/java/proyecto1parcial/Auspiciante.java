package proyecto1parcial;

public class Auspiciante extends Persona{
    private SectorCubierto secCubierto;
    
    //Constructor
    public Auspiciante(String ni, String np, String npr, String t, String e, String d, String sw, SectorCubierto sc){
        super(ni,np,npr,t,e,d,sw);
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
