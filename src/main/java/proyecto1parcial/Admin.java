package proyecto1parcial;
import java.util.Scanner;
import java.util.ArrayList;

public class Admin {
    public static ArrayList<Feria> ferias=new ArrayList<>(); //Lista de todas las ferias
    
    //Scanner
    Scanner sc=new Scanner(System.in);
    
    //Presentar menu principal
    public static void mostrarMenuPrincipal(){
        System.out.println("1. Administracion de Ferias"+""
        +"\n2. Administracion de Emprendedores"+"\n3. Administracion de Auspiciantes"
        +"\n4. Administracion"+"\n5. Salir");
    }
    
    //Presentar menu feria
    public static void mostrarMenuFeria(){
        System.out.println("1. Ver informacion de feria"+"\n2. Registrar feria"
        +"\n3. Editar feria"+"\n4. Consultar emprendedores en feria"
        +"\n5. Regresar");
    }
    
    //Presentar menu emprendedor
    public static void mostrarMenuEmprendedor(){
        System.out.println("1. Registrar emprendedor"+"\n2. Editar emprendedor"
        +"\n3. Regresar");
    }
    
    //Presentar menu auspiciante
    public static void mostrarMenuAuspiciante(){
        System.out.println("1. Registrar auspiciante"+"\n2. Editar Auspiciante"
        +"\n3. Asignar auspiciante a feria"+"\n4. Regresar");
    }
    
    //Presentar menu stand
    public static void mostrarMenuStand(){
        System.out.println("1. Reservar un stand"+"\n2. Mostrar informacion del stand"
        +"\n3. Regresar");
    }
    
    public static void main(String[] args) {
        mostrarMenuPrincipal();
        
        
    }
    
}
