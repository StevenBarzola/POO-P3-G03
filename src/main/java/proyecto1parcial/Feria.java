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
    int i=1;
    public String generaCodigoFeria(){
        String c= "#F"+(String.valueOf(i));
        i++;
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
    
}
