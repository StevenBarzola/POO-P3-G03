package proyecto1parcial;
import java.util.ArrayList;

public class Feria {
    private String codigo;
    private String nombre;
    private String fechaI;
    private String fechaF;
    private String lugar;
    private String descripcion;
    private String horario;
    private ArrayList<AuspicianteEnFeria> auspiciantesEnFeria; 
    private ArrayList<Emprendedor> emprendedores;
    private SeccionStand[] seccionesStand;
    
    //Constructor
    public Feria(String c, String n, String fi, String ff, String l, String d, String h){
        codigo=c;
        nombre=n;
        fechaI=fi;
        fechaF=ff;
        lugar=l;
        descripcion=d;
        horario=h;
        auspiciantesEnFeria=new ArrayList<>();
        emprendedores=new ArrayList<>();
        seccionesStand= new SeccionStand[4];
    }
    
    //Getters y Setters
    public String getCodigo(){
        return codigo;
    }
    public String getNombre(){
        return nombre;
    }
    
}
