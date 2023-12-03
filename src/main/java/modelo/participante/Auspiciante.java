package modelo.participante;
import java.util.ArrayList;
import modelo.evento.*;


public class Auspiciante extends Persona{
    private SectorCubierto secCubierto;
    private static ArrayList<Feria> ferias = new ArrayList<>();
    private static ArrayList<Auspiciante> auspiciantes = new ArrayList<>();
    
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
        for (Auspiciante auspican : auspiciantes){
            if (auspican.numld.contains(cedu)){
            validar = true;
            }
        }
        return validar;
    }
    // Encontrar auspiciante mediante cedula
    public static Auspiciante encontrarAuspiciante(String cedula){
        ArrayList<RedSocial> redSocial = new ArrayList<>();
        RedSocial rs = new RedSocial(AppSocial.FACEBOOK, "x");
        redSocial.add(rs);
        Auspiciante auspiEditar = new Auspiciante("x", "x", "x", 0, "x", "x", "x", redSocial, SectorCubierto.ALIMENTACION); // Crear un objeto que luego será reemplazado
        for (Auspiciante auspican : auspiciantes){
            if (auspican.numld.equals(cedula)){
                auspiEditar = auspican;
            }
        }
        return auspiEditar;
    }
    
    // Mostrar nombres de los Auspiciante
    public static void mostrarAuspiciante(){
        for (Auspiciante auspi: auspiciantes ){
            System.out.println(auspi.nombrePer);
        }
    }
    //3.2 Todos los metodos para editar el auspiciante
    @Override
    public String toString(){ // Para mostrar los campos actuales antes de editar
        return super.toString() + "\n Sector Cubierto: " + secCubierto;
    }
    public void editarNom(String nom){
        nombrePer = nom;
    }
    public void editarNomResp(String npr){
        nomPerRes = npr;
    }  
    public void editarTelef(int t){
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
    public void editarRedSocial(ArrayList<RedSocial> rs){
        redesSociales = rs;
    }
    public void editarSectorCubierto(SectorCubierto sc){
         secCubierto=sc;
    }
    // 3.3 Asignar Auspiciante en la Feria
    public static boolean verificarAuspicianteFeria(String c, String nc){
        boolean validar = false;
        boolean validar1 = false;
        for (Feria f: ferias){
            String cod = f.getCodigo();
            if (c.equals(cod)){
                validar = true;
            }
        }
        for (Auspiciante auspi : auspiciantes){
            String cedu = auspi.numld;
            if ( cedu.equals(nc)){
                validar1 = true;
            }
        }
        return validar && validar1;
    }

}
