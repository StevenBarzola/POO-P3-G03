package modelo.participante;
import java.util.ArrayList;
import modelo.evento.*;


public class Auspiciante extends Persona{
    private SectorCubierto secCubierto;
    private static ArrayList<Feria> ferias = new ArrayList<>();
    private static ArrayList<Auspiciante> auspiciantes = new ArrayList<>();
    
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
    // validar cedula o ruc
    public static boolean verificarCedula(String cedu){
        boolean validar= false;
        for (Auspiciante auspican : auspiciantes){
            if (auspican.numId.contains(cedu)){
            validar = true;
            }
        }
        return validar;
    }
    // Encontrar auspiciante mediante cedula
    public static Auspiciante encontrarAuspiciante(String cedula){
        SectorCubierto tipo = SectorCubierto.ALIMENTACION;
        Auspiciante auspiEditar = new Auspiciante("x", "x", "x", "x", "x", "x", "x", tipo); // Crear un objeto que luego será reemplazado
        for (Auspiciante auspican : auspiciantes){
            if (auspican.numId.equals(cedula)){
                auspiEditar = auspican;
            }
        }
        return auspiEditar;
    }
    //3.2 Todos los metodos para editar el auspiciante
    @Override
    public String toString(){ // Para mostrar los campos actuales antes de editar
        return super.toString() + "\n Sector Cubierto: " + secCubierto;
    }
    public void editarNom(String nom){
        nombre = nom;
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
