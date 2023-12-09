package modelo.participante;
import java.util.ArrayList;
import modelo.evento.*;


public class Auspiciante extends Persona{
    private SectorCubierto secCubierto;
    
    //Constructor

    public Auspiciante(String ni, String np, String npr, int t, String e, String d, String sw, ArrayList<RedSocial> rs, SectorCubierto sc){
        super(ni,np,t,e);
        super.setOtherParams(npr, d, sw, rs );
        secCubierto=sc;
    }
    
    //Getters y Setters
    public SectorCubierto getSectorCubierto(){
        return secCubierto;
    }
    
    public void setSectorCubierto(SectorCubierto sc){
        secCubierto=sc;
    }
    // validar cedula o ruc
    public static boolean verificarCedula(String cedu){
        boolean validar= false;
        for (Auspiciante auspican : Sistema.auspiciantes){
            if (auspican.numId.contains(cedu)){
            validar = true;
            }
        }
        return validar;
    }
    
    // Mostrar nombres de los Auspiciante
    public static void mostrarAuspiciante(){
        for (Auspiciante auspi: Sistema.auspiciantes ){
            System.out.println(auspi.nombre);
        }
    }
    //3.2 Todos los metodos para editar el auspiciante
    @Override
    public String toString(){ // Para mostrar los campos actuales antes de editar
        return super.toString()+"\nSector Cubierto: "+secCubierto;
    }
  
}
