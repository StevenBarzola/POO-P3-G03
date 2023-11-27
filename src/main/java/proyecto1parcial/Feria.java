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
    public Feria(String n, String fi, String ff, String l, String d, String h){
        codigo=generarCodigoFeria();
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
    
    //Getters 
    public String getCodigo(){
        return codigo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getFechaI(){
        return fechaI;
    }
    
    public String getFechaF(){
        return fechaF;
    }
    
    public String getLugar(){
        return lugar;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public String getHorario(){
        return horario;
    }
    
    public ArrayList<AuspicianteEnFeria> getAuspiciantesEnFeria(){
        return auspiciantesEnFeria;
    }
    
    public ArrayList<Emprendedor> getEmprendedores(){
        return emprendedores;
    }
    
    public SeccionStand[] getSeccionesStand(){
        return seccionesStand;
    }
    
    //Generar codigo
    public static String generarCodigoFeria(){
        String c= "F"+String.valueOf(Admin.cont);
        Admin.cont++;
        return c;
    }
    
    //Metodo toString 
    @Override
    public String toString(){  
        String aus="["; //String para presentar los auspiciantes
        for(int j=0;j<auspiciantesEnFeria.size();j++){
            String n= auspiciantesEnFeria.get(j).getAuspiciante().nombre;
            aus+=n;
            if(j<(auspiciantesEnFeria.size()-1)) aus+="-";
        }
        aus+="]";
        
        return "Nombre: "+nombre+", descripcion: "+descripcion+", lugar: "+lugar
        +", fecha de inicio: "+fechaI+", fecha de fin: "+fechaF+", horario: "
        +horario+", auspiciantes: "+aus+", [Seccion#1: "+seccionesStand[0].getCanStand()
        +" stand(s)"+" / Seccion#2: "+seccionesStand[1].getCanStand()+" stand(s)"
        +" / Seccion#3: "+seccionesStand[2].getCanStand()+" stand(s)"
        +" / Seccion#4: "+seccionesStand[3].getCanStand()+" stand(s)]";
    }
    
    //Mostrar informacion de la feria
    public void informacionFeria(String c){
        if(Admin.ferias!=null){
            for(Feria f: Admin.ferias){
                if(c.equals(f.codigo)){
                    System.out.println(f.toString());
                } 
            }
        }else System.out.println("No hay ferias registradas para mostrar");    
    }
    
    //Asignar las 4 secciones de stands
    public void AsignarSeccionesStand(int can1, int can2, int can3, int can4){
        seccionesStand[0]= new SeccionStand(can1);
        seccionesStand[1]= new SeccionStand(can2);
        seccionesStand[2]= new SeccionStand(can3);
        seccionesStand[3]= new SeccionStand(can4);
        seccionesStand[0].crearStands(0);
        seccionesStand[1].crearStands(1);
        seccionesStand[2].crearStands(2);
        seccionesStand[3].crearStands(3);
    }
    
    //Mostrar los stands
    public void mostrarStands(){
        System.out.println("---Distribucion de stands---");
        for(int i=0;i<4;i++){
            SeccionStand ss= seccionesStand[i];
            System.out.println("Seccion#"+(i+1)+":");
            for(int j=0;j<ss.getSeccion().size();j++){
                Stand s= ss.getSeccion().get(j);
                System.out.print("["+s.getCodigoSt()+"]");
            }
            System.out.println("");
        }
    }
    
    
}   
   
