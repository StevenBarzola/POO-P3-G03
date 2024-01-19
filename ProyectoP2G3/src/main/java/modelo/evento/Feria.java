package modelo.evento;
import java.io.Serializable;
import java.time.LocalDate;
import modelo.participante.*;
import java.util.ArrayList;
import java.util.Objects;


public class Feria implements Serializable{
    private String codigo;
    private String nombre;
    private LocalDate fechaI;
    private LocalDate fechaF;
    private String lugar;
    private String descripcion;
    private String horario;
    private ArrayList<AuspicianteEnFeria> auspiciantesEnFeria; 
    private SeccionStand[] seccionesStand;
    private int contadorAus=1;
    private int contadorEmp=1;
    
    
    //Constructor
    public Feria(String c, String n, LocalDate fi, LocalDate ff, String l, String d, String h){
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
    
    public LocalDate getFechaI(){return fechaI;}
    
    public LocalDate getFechaF(){return fechaF;}
    
    public String getLugar(){return lugar;}
    
    public String getDescripcion(){return descripcion;}
    
    public String getHorario(){return horario;}
    
    public ArrayList<AuspicianteEnFeria> getAuspiciantesEnFeria(){
        return auspiciantesEnFeria;
    }
    
    public SeccionStand[] getSeccionesStand(){
        return seccionesStand;
    }
    
    public void setCodigo(String c) {codigo=c;}
    
    public void setNombre(String n){nombre=n;}
    
    public void setFechaI(LocalDate fi){fechaI=fi;}
    
    public void setFechaF(LocalDate ff){fechaF=ff;}
    
    public void setLugar(String l){lugar=l;}
    
    public void setDescripcion(String d){descripcion=d;}
    
    public void setHorario(String h){horario=h;}
    
    public void setSeccionesStand(int can1, int can2, int can3, int can4){
        AsignarSeccionesStand(can1,can2,can3,can4);
    }
    
    //Metodo toString 
    @Override
    public String toString(){  
        String aus= getStringAuspiciantes();
        String emp= getStringEmprendedores();
        return "Nombre: "+nombre+"\nDescripcion: "+descripcion+"\nLugar: "+lugar
        +"\nFecha de inicio: "+fechaI+"\nFecha de fin: "+fechaF+"\nHorario: "
        +horario+"\nAuspiciantes: "+aus+"\nEmprendedores: "+emp+"\nSeccion#1: "+seccionesStand[0].getCanStand()
        +" stand(s)"+"\nSeccion#2: "+seccionesStand[1].getCanStand()+" stand(s)"
        +"\nSeccion#3: "+seccionesStand[2].getCanStand()+" stand(s)"
        +"\nSeccion#4: "+seccionesStand[3].getCanStand()+" stand(s)";
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
    
    //editar seccion 1
    public void editarSeccion1(int can){
        seccionesStand[0]= new SeccionStand(can);
        seccionesStand[0].crearStands(0);
    }
    //editar seccion 2
    public void editarSeccion2(int can){
        seccionesStand[1]= new SeccionStand(can);
        seccionesStand[1].crearStands(1);
    }
    //editar seccion 3
    public void editarSeccion3(int can){
        seccionesStand[2]= new SeccionStand(can);
        seccionesStand[2].crearStands(2);
    }
    //editar seccion 4
    public void editarSeccion4(int can){
        seccionesStand[3]= new SeccionStand(can);
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
    public String consultarEmprendedores(){
        String emp= "";
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
                    emp+=contadorEmp+". "+"Emprendedor: "+nomPerRes+" / Nombre del emprendimiento: "
                    +nombre+" / Descripcion de servicios: "+descrip+" / Seccion: "+sec
                    +" / Stand asignado: "+s.getCodigoSt()+"\n";
                    contadorEmp++;
                }
            }
        }
        contadorEmp=1;
        return emp;
    }
    
    //Consultar auspiciantes en feria
    public String consultarAuspiciantesEnFeria(){
        String aus="";
        for(AuspicianteEnFeria aef:auspiciantesEnFeria){
            String tieneStand= "";
            ArrayList<Stand> stAsignados= new ArrayList<>();
            String codigoStand="No tiene stand asignado";
            if(aef.getTieneStand()==true && encontrarStandAEF(aef).size()!=0){
                tieneStand="SI";
                stAsignados=encontrarStandAEF(aef);
                if(stAsignados.size()==2){
                    codigoStand= stAsignados.get(0).getCodigoSt()+", "+stAsignados.get(1).getCodigoSt();
                }else if(stAsignados.size()==1){
                    codigoStand= stAsignados.get(0).getCodigoSt();
                }
            }else if(aef.getTieneStand()==true && encontrarStandAEF(aef).size()==0){
                tieneStand="SI";
                codigoStand="Aun no tiene stand(s) asignado(s)";
            }else{ 
                tieneStand="NO";
            }
            
            if(tieneStand.equals("SI")){
                aus+=contadorAus+". "+"Auspiciante: "+aef.getAuspiciante().getNombre()+
                " / Descripcion del auspicio: "+aef.getDescripcion()+" / Tiene stand: "+tieneStand+
                " / Stand(s) asignado(s): "+codigoStand+"\n";
                contadorAus++;
            }else{
                aus+=contadorAus+". "+"Auspiciante: "+aef.getAuspiciante().getNombre()+
                " / Descripcion del auspicio: "+aef.getDescripcion()+" / Tiene stand: "+tieneStand+"\n";
                contadorAus++;
            }
            
        }
        contadorAus=1;
        return aus;
    }
    
    //Buscar stand por AuspicianteEnFeria
    public ArrayList<Stand> encontrarStandAEF(AuspicianteEnFeria aef){
        ArrayList<Stand> stands= new ArrayList<>();
        if(aef.getTieneStand()==true){
            for(SeccionStand ss: seccionesStand){
                for(Stand s: ss.getSeccion()){
                    if(s.getPersona() instanceof Auspiciante && s.getPersona().getNumId().equals(aef.getAuspiciante().getNumId())){
                        stands.add(s);
                    }
                }
            }
        }
        return stands;
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
    // Verificar que ya no esté el mismo auspiciante en Feria
    public static boolean verificarAuspiciante(ArrayList<AuspicianteEnFeria> lista, Auspiciante a){
        for (AuspicianteEnFeria l:lista){
            if(l.getAuspiciante().equals(a)){
                return true;
            }
        }
        return false;
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
                    s.setFechaAsig(LocalDate.now());
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
                        s.setFechaAsig(LocalDate.now());
                        s.setcodigoSt(s.getCodigoSt()+"*");
                        System.out.println("Stand asignado con exito");
                    }else System.out.println("El auspiciante no debe tener stand, así él/ella lo decidió");
                }else System.out.println("El auspiciante ya tiene 2 stands asignado, solo puede tener max 2 stands");
            }else System.out.println("Esa persona no ha sido registrado o no existe");
        }else  System.out.println("El stand se encuentra ocupado");
        
    }
    
    //Metodo que devuelve el numero de emprendedores de cada feria
    public int getNumeroEmprendedores(){
        int contador=0;
        for(SeccionStand ss: seccionesStand){
            for(Stand s: ss.getSeccion()){
                 if(s.getPersona()!=null && s.getPersona() instanceof Emprendedor){
                     contador++;
                 }
            }
        }
        return contador;
    }
    
    //Metodo para devolver un String con los Auspiciantes
    public String getStringAuspiciantes(){
        String aus="["; //String para presentar los auspiciantes
        for(int j=0;j<auspiciantesEnFeria.size();j++){
            String n= auspiciantesEnFeria.get(j).getAuspiciante().getNombre();
            aus+=n;
            if(j<(auspiciantesEnFeria.size()-1)) aus+="-";
        }
        aus+="]";
        return aus;
    }
    
    //Metodo para devolver un Strin con los Emprendedores
    public String getStringEmprendedores(){
        String emp="["; //String para presentar los emprendedores
        for(int j=0;j<seccionesStand.length;j++){
            SeccionStand ss= seccionesStand[j];
            for(int i=0;i<ss.getSeccion().size();i++){
                if(ss.getSeccion().get(i).getPersona() instanceof Emprendedor){
                    String n= ss.getSeccion().get(i).getPersona().getNomPerRes();
                    emp+=n+"-";
                }
            }
        }
        emp+="]";
        if(!emp.equals("[]")){
            String m = emp.substring(0,emp.length()-2);
            emp= m+"]";
            return emp;
        } 
        return emp;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Feria other = (Feria) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

   

    

    
}   
   
