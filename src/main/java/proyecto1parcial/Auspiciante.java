package proyecto1parcial;
import java.util.ArrayList;

public class Auspiciante extends Persona{
    private SectorCubierto secCubierto;
    private static ArrayList<Feria> ferias;
    private static ArrayList<Auspiciante> auspiciantes;
    
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

    // Todos los metodos para editar el auspiciante
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
    public void editarEmail(String e){
        email = e;
    }
    public void editarDireccion(String d){
        direccion = d;
    }
    public void editarSitioWeb(String sw){
        sitioWeb = sw;
    }
    public void editarSectorCubierto(SectorCubierto sc){
         secCubierto=sc;
    }
    // 3.3 Asignar Auspiciante en la Feria
    public static boolean asignarAuspicianteFeria(String c, String nc){
        boolean validar = false;
        boolean validar1 = false;
        for (Feria f: ferias){
            String cod = f.getCodigo();
            if (c.equals(cod)){
                validar = true;
            }
        }
        for (Auspiciante auspi : auspiciantes){
            String cedu = auspi.numId;
            if ( cedu.equals(nc)){
                validar1 = true;
            }
        }
        return validar && validar1;
    }

}
