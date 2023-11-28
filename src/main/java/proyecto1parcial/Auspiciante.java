package proyecto1parcial;
import java.util.ArrayList;

public class Auspiciante extends Persona{
    private SectorCubierto secCubierto;
    private ArrayList<Feria> ferias;
    
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
    // Tdodos los metodos para editar el auspiciante
    @Override
    public String toString(){ // Para mostrar los campos actuales antes de editar
        return super.toString() + "\n Sector Cubierto: " + secCubierto;
    }
    public void editarNom(String nom){
        nombrePer = nom;
    }
    public void editarNomResp(String npr){
        nombrePerRes = npr;
    }  
    public void editarTelef(String t){
        telefono = t;
    }
    public void email(String e){
        email = e;
    }
    public void direccion(String d){
        direccion = d;
    }
    public void sitioWeB(String sw){
        sitioWeb = sw;
    }
    public void sectorCubiertos(SectorCubierto sc){
         secCubierto=sc;
    }
    // 3.3 Asignar Auspiciante en la Feria
    public boolean asignarAuspicianteFeria(String c, String nc){
        for (Feria f: ferias){
            String cod = f.getCodigo();
            if (cod.equals(c) && numId.equals(nc)){
                return true;
            }
        }
        return false;
    }

}
