package modelo.evento;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import modelo.participante.*;
import java.util.ArrayList;

public class Sistema implements Serializable{
  public static ArrayList<Feria> ferias =new ArrayList<>(); 
  public static ArrayList<Auspiciante> auspiciantes= new ArrayList<>();
  public static ArrayList<Emprendedor> emprendedores= new ArrayList<>();
  
  //Registrar feria
  public static Feria registrarFeria(String n, LocalDate fi, LocalDate ff, String l, String d, String h,
  int can1, int can2, int can3, int can4){
      String c= "F"+String.valueOf(ferias.size()+1);
      Feria feria= new Feria(c,n,fi,ff,l,d,h);
      ferias.add(feria);
      feria.AsignarSeccionesStand(can1, can2, can3, can4);
      //System.out.println("Feria registrada con exito!");
      //System.out.println("El codigo de la feria es "+c);
      return feria;
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
      if(emprendedores.size()!=0){
          for(Emprendedor e: emprendedores){
              if(e.getNumId().equals(c)) return e;
          }
      }
      if(auspiciantes.size()!=0){
          for(Auspiciante a: auspiciantes){
              if(a.getNumId().equals(c)) return a;
          }
      }
      return null;
  }
  
  //Valida por ruc o ced, para que no se repita sin importar el tipo de persona
  public static boolean verificarCedula(String cedu){
      boolean validar= false;
        for(Auspiciante ausp : auspiciantes){
            if (ausp.getNumId().equals(cedu)){
                validar = true;
            }
        }
        for(Emprendedor emp : emprendedores){
            if (emp.getNumId().equals(cedu)){
                validar = true;
            }
        }
        return validar;
  }
  
  //Registra un emprendedor si no se encuentra allí.
  public static void registrarEmp(Persona p) {
    Emprendedor emp=(Emprendedor)p;
    if(Sistema.emprendedores.size()!=0){
        for (int e=0; e<Sistema.emprendedores.size(); e++) {
          if (emprendedores.get(e).getNumId().equals(emp.getNumId())) { 
            System.out.println("El Emprendedor ya se encuentra registrado");
            e=emprendedores.size();
            }
          else { 
            emprendedores.add(emp);
            System.out.println("Emprendedor registrado con exito");
            }
        }
    }else {
        emprendedores.add(emp);
        System.out.println("Emprendedor registrado con exito");
    }
  }
  
  //Guarda los datos ingresados al archivo "datos.ser"
  public static void guardarDatos(){
      try(ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream("src/main/java/archivos/datos.ser"))){
          out.writeObject(ferias);
          out.writeObject(emprendedores);
          out.writeObject(auspiciantes);
          out.flush();
      }catch(Exception e){
          System.out.println("Error al guardar datos: "+e.getMessage());
      }
  }
  
  //Carga los datos que estan en el archivo "datos.ser"
  public static void cargarDatos(){
      Object[] objetosDes= new Object[3];
      try(ObjectInputStream inp= new ObjectInputStream(new FileInputStream("src/main/java/archivos/datos.ser"))){
          for(int i=0;i<objetosDes.length;i++){
              objetosDes[i]= inp.readObject();
          }
          ferias=(ArrayList<Feria>) objetosDes[0];
          emprendedores=(ArrayList<Emprendedor>) objetosDes[1];
          auspiciantes=(ArrayList<Auspiciante>) objetosDes[2];
      }catch(Exception e){
          System.out.println("Error al cargar datos: "+e.getMessage());
      }
  }
 
  
  
}
