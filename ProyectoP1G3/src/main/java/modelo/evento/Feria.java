package modelo.evento;
import modelo.participante.*;
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
        seccionesStand= new SeccionStand[4];
    }
    
    //Getters y setters
    public String getCodigo(){return codigo;}
    
    public String getNombre(){return nombre;}
    
    public String getFechaI(){return fechaI;}
    
    public String getFechaF(){return fechaF;}
    
    public String getLugar(){return lugar;}
    
    public String getDescripcion(){return descripcion;}
    
    public String getHorario(){return horario;}
    
    public ArrayList<AuspicianteEnFeria> getAuspiciantesEnFeria(){
        return auspiciantesEnFeria;
    }
    
    public SeccionStand[] getSeccionesStand(){
        return seccionesStand;
    }
    
    public void setNombre(String n){nombre=n;}
    
    public void setFechaI(String fi){fechaI=fi;}
    
    public void setFechaF(String ff){fechaF=ff;}
    
    public void setLugar(String l){lugar=l;}
    
    public void setDescripcion(String d){descripcion=d;}
    
    public void setHorario(String h){horario=h;}
    
    public void setSeccionesStand(int can1, int can2, int can3, int can4){
        AsignarSeccionesStand(can1,can2,can3,can4);
    }
    
    //Metodo toString 
    @Override
    public String toString(){  
        String aus="["; //String para presentar los auspiciantes
        for(int j=0;j<auspiciantesEnFeria.size();j++){
            String n= auspiciantesEnFeria.get(j).getAuspiciante().getNombre();
            aus+=n;
            if(j<(auspiciantesEnFeria.size()-1)) aus+="-";
        }
        aus+="]";
        
        return "Nombre: "+nombre+"\ndescripcion: "+descripcion+"\nlugar: "+lugar
        +"\nfecha de inicio: "+fechaI+"\nfecha de fin: "+fechaF+"\nhorario: "
        +horario+"\nauspiciantes: "+aus+"\n[Seccion#1: "+seccionesStand[0].getCanStand()
        +" stand(s)"+" / Seccion#2: "+seccionesStand[1].getCanStand()+" stand(s)"
        +" / Seccion#3: "+seccionesStand[2].getCanStand()+" stand(s)"
        +" / Seccion#4: "+seccionesStand[3].getCanStand()+" stand(s)]";
    }
    
    //Mostrar informacion de la feria
    public void verInformacionFeria(){
          System.out.println(this.toString());;
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
    
    //Consultar emprendedores en feria
    public void consultarEmprendedores(){
        System.out.print("{");
        for(SeccionStand ss: seccionesStand){
            for(Stand s: ss.getSeccion()){
                if(s.getPersona()!=null && s.getPersona() instanceof Emprendedor){
                    Emprendedor e=(Emprendedor)s.getPersona();
                    String nomPerRes= e.getNomPerRes();
                    String nombre= e.getNombre();
                    String descrip= e.getDescripcionServicios();
                    String sec= "#";
                    char l=s.getCodigoSt().charAt(0);
                    if(l=='A'){sec+="1";}
                    if(l=='B'){sec+="2";}
                    if(l=='C'){sec+="3";}
                    if(l=='D'){sec+="4";}
                    System.out.print("["+"Emprendedor: "+nomPerRes+", Nombre del emprendimiento: "
                    +nombre+"Descripcion de servicios: "+descrip+", Seccion: "+sec
                    +", Stand asignado: "+s.getCodigoSt()+"]");
                }
            }
        }
        System.out.print("}");
        System.out.println("");
    }
    
    //Buscar stand por codigo
    public Stand encontrarStand(String cs){
        for(SeccionStand ss: seccionesStand){
            for(Stand s: ss.getSeccion()){
                if(s.getCodigoSt().equals(cs))return s;
                if(s.getCodigoSt().equals(cs+"*")) return s;
            }
        }
        return null;
    }
    
    //Verificar que la persona no sobrepase el limite de stands
    public int limiteStand(String numId){
        int cont=0;
        for(SeccionStand ss: seccionesStand){
            for(Stand s: ss.getSeccion()){
                if(s.getPersona()!=null){
                    if(s.getPersona().getNumId().equals(numId)) cont++;
                }
            }
        }
        return cont;
    }
    
    //Buscar auspicianteEnFeria por auspiciante
    public AuspicianteEnFeria encontrarAuspicianteEnFeria(Auspiciante a){
        if(auspiciantesEnFeria.size()!=0){ 
            for(AuspicianteEnFeria aef: auspiciantesEnFeria){
                if(aef.getAuspiciante().getNumId().equals(a.getNumId())){
                    return aef;
                }
            }
        }    
        return null;
    }
    
    //Reservar stand a emprendedor o auspiciante
    public void reservarStand(String cs, String cp, String fa){
        Stand s= encontrarStand(cs);
        if(s.estaDisponible()){
            Persona p= Sistema.encontrarPersona(cp);
            int cont=0;
            if(p!=null && p instanceof Emprendedor){
                Emprendedor e= (Emprendedor)p;
                cont= limiteStand(e.getNumId());
                if(cont==0){
                    s.setPersona(e);
                    s.setFechaAsig(fa);
                    s.setcodigoSt(s.getCodigoSt()+"*");
                    System.out.println("Stand asignado con exito");
                }else System.out.println("Ya tiene un stand asignado, solo puede tener un stand");
            }else if(p!=null && p instanceof Auspiciante){
                Auspiciante a= (Auspiciante)p;
                AuspicianteEnFeria anf= encontrarAuspicianteEnFeria(a);
                cont= limiteStand(anf.getAuspiciante().getNumId());
                if(cont<2){
                    if(anf.getTieneStand()==true){
                        s.setPersona(a);
                        s.setFechaAsig(fa);
                        s.setcodigoSt(s.getCodigoSt()+"*");
                        System.out.println("Stand asignado con exito");
                    }else System.out.println("El auspiciante no debe tener stand, así él/ella lo decidió");
                }else System.out.println("El auspiciante ya tiene 2 stands asignado, solo puede tener max 2 stands");
            }else System.out.println("Esa persona no ha sido registrado o no existe");
        }else  System.out.println("El stand se encuentra ocupado");
        
    }
    
}   
   
