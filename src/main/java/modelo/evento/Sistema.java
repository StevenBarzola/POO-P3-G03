package modelo.evento;
import modelo.participante.*;
import java.util.ArrayList;

public class Sistema{
  public static ArrayList<Feria> ferias=new ArrayList<>();
  public static ArrayList<Auspiciante> auspiciantes= new ArrayList<>();
  public static ArrayList<Emprendedor> emprendedores= new ArrayList<>();
  
  //Registrar feria
  public static void registrarFeria(String n, String fi, String ff, String l, String d, String h,
  int can1, int can2, int can3, int can4){
      String c= "F"+String.valueOf(ferias.size()+1);
      Feria feria= new Feria(c,n,fi,ff,l,d,h);
      ferias.add(feria);
      feria.AsignarSeccionesStand(can1, can2, can3, can4);
      System.out.println("Feria registrada con exito!");
      System.out.println("El codigo de la feria es "+c);
  }
  
  //Buscar feria por codigo
  public static Feria encontrarFeria(String c){
      if(ferias.size()!=0){
           for(Feria f: ferias){
                if(c.equals(f.getCodigo())) return f;
           }
      }
      return null;
  }
  
  //Buscar persona por numero de identificacion
  public static Persona encontrarPersona(String c){
      if(emprendedores.size()!=0 && auspiciantes.size()!=0){
          for(Emprendedor e: emprendedores){
              if(e.getNumId().equals(c)) return e;
          }
          for(Auspiciante a: auspiciantes){
              if(a.getNumId().equals(c)) return a;
          }
      } return null;
  }
  
  //Registra un emprendedor si no se encuentra allí.
  public static void registrarEmp(Persona p, String descripcionServicios) {
    Emprendedor emp=(Emprendedor)p;
    for (int e=0; e<Sistema.emprendedores.size(); e++) {
      if (emprendedores.get(e).getNumId().equals(emp.getNumId())) { 
        System.out.println("El Emprendedor ya se encontraba registrado");
        e=emprendedores.size();
        }
      else { 
        emp.setDescripcionServicios(descripcionServicios);
        emprendedores.add(emp);
        }
      
     }
    }
 
  
  
}