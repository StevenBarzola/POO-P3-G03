package ejecucion;
import modelo.evento.*;
import modelo.participante.*;
import java.util.Scanner;

public class Admin {
    
    //Presentar menu principal
    public static void mostrarMenuPrincipal(){
        System.out.println("---Menu Principal---"+"\n1. Administracion de Ferias"+""
        +"\n2. Administracion de Emprendedores"+"\n3. Administracion de Auspiciantes"
        +"\n4. Administracion de Stands"+"\n5. Salir");
    }
    
    //Presentar menu feria
    public static void mostrarMenuFeria(){
        System.out.println("---Administracion de Ferias---"+"\n1. Ver informacion de feria"
        +"\n2. Registrar feria"+"\n3. Editar feria"+"\n4. Consultar emprendedores en feria"
        +"\n5. Regresar");
    }
    
    //Presentar menu emprendedor
    public static void mostrarMenuEmprendedor(){
        System.out.println("---Administracion de Emprendedores---"+"\n1. Registrar emprendedor"
        +"\n2. Editar emprendedor"+"\n3. Regresar");
    }
    
    //Presentar menu auspiciante
    public static void mostrarMenuAuspiciante(){
        System.out.println("---Administracion de Auspiciantes---"+"\n1. Registrar auspiciante"
        +"\n2. Editar Auspiciante"+"\n3. Asignar auspiciante a feria"+"\n4. Regresar");
    }
    
    //Presentar menu stand
    public static void mostrarMenuStand(){
        System.out.println("---Administracion de Stands---"+"\n1. Reservar un stand"
        +"\n2. Mostrar informacion del stand"+"\n3. Regresar");
    }
    
    //Presentar atributos de Feria
    public static void mostrarAtributosFeria(){
        System.out.println("---Edicion de Feria---"+"\n1. Nombre"+"\n2. Descripcion"+"\n3. Lugar"
        +"\n4. Fecha de inicio"+"\n5. Fecha de fin"+"\n6. Horario"+"\n7. Cantidad de stand por seccion"
        +"\n8. Regresar");
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int op=0;
        while(op!=5){
            mostrarMenuPrincipal();
            System.out.println("Elija una opcion: ");
            op=sc.nextInt();
            switch(op){
                case 1: //Administracion Feria
                int op1=0;
                while(op1!=5){
                    mostrarMenuFeria();
                    System.out.println("Elija una opcion: ");
                    op1=sc.nextInt();
                    sc.nextLine();
                    switch(op1){
                        case 1: //Ver informacion feria
                        System.out.println("Ingrese el codigo de una feria: ");
                        String cod1= sc.nextLine();
                        Feria feria1= Sistema.encontrarFeria(cod1);
                        if(feria1!=null) feria1.verInformacionFeria();
                        else System.out.println("Ese codigo de feria no existe o no hay ferias registradas");
                        break;
                        case 2: //Registrar feria
                        System.out.println("Ingrese nombre de la feria: ");
                        String n= sc.nextLine();
                        System.out.println("Ingrese fecha de inicio(Ej:09/12/23): ");
                        String fi= sc.nextLine();
                        System.out.println("Ingrese fecha de fin(Ej:09/12/23): ");
                        String ff= sc.nextLine();
                        System.out.println("Ingrese el lugar de la feria: ");
                        String l= sc.nextLine();
                        System.out.println("Ingrese una descripcion de la feria: ");
                        String d= sc.nextLine();
                        System.out.println("Ingrese el horario de la feria: ");
                        String h= sc.nextLine();
                        System.out.println("Cantidad de stand para la seccion 1: ");
                        int can1= sc.nextInt();
                        System.out.println("Cantidad de stand para la seccion 2: ");
                        int can2= sc.nextInt();
                        System.out.println("Cantidad de stand para la seccion 3: ");
                        int can3= sc.nextInt();
                        System.out.println("Cantidad de stand para la seccion 4: ");
                        int can4= sc.nextInt();
                        Sistema.registrarFeria(n, fi, ff, l, d, h, can1, can2, can3, can4);
                        sc.nextLine();
                        break;
                        case 3: //Editar feria
                        System.out.println("Ingrese el codigo de una feria: ");
                        String cod3= sc.nextLine();
                        System.out.println("Ingrese la fecha de hoy dia(Ej:09/12/23): )");
                        String fh= sc.nextLine();
                        Feria feria3= Sistema.encontrarFeria(cod3);
                        String[] hor= fh.split("/");
                        String[] horf= feria3.getFechaI().split("/");
                        if(feria3!=null && ((Integer.parseInt(hor[2])<Integer.parseInt(horf[2]))
                        || (Integer.parseInt(hor[2])==Integer.parseInt(horf[2]) 
                        && Integer.parseInt(hor[1])<Integer.parseInt(horf[1]))||
                        (Integer.parseInt(hor[2])==Integer.parseInt(horf[2]) &&
                        Integer.parseInt(hor[1])==Integer.parseInt(horf[1])&&
                        Integer.parseInt(hor[0])<Integer.parseInt(horf[0])))){ 
                            int op13=0;
                            while(op13!=8){
                                mostrarAtributosFeria();
                                System.out.println("Elija una opcion a editar");
                                op13= sc.nextInt();
                                sc.nextLine();
                                switch(op13){
                                    case 1: //Editar nombre de la feria
                                    System.out.println("Escriba un nuevo nombre: ");
                                    String n1= sc.nextLine();
                                    feria3.setNombre(n1);
                                    break;
                                    case 2: //Editar descripcion de la feria
                                    System.out.println("Escriba una nueva descripcion: ");
                                    String d1= sc.nextLine();
                                    feria3.setDescripcion(d1);
                                    break;
                                    case 3: //Editar lugar de la feria
                                    System.out.println("Escriba un nuevo lugar: ");
                                    String l1= sc.nextLine();
                                    feria3.setLugar(l1);
                                    break;
                                    case 4: //Editar fecha de inicio
                                    System.out.println("Escriba una nueva fecha de inicio(Ej:09/12/23): ");
                                    String fi1= sc.nextLine();
                                    feria3.setFechaI(fi1);
                                    break;
                                    case 5:
                                    System.out.println("Escriba una nueva fecha de fin(Ej:09/12/23): ");
                                    String ff1= sc.nextLine();
                                    feria3.setFechaF(ff1);    
                                    break;
                                    case 6:
                                    System.out.println("Escriba un nuevo horario: ");
                                    String h1= sc.nextLine();
                                    feria3.setHorario(h1);    
                                    break;
                                    case 7:
                                    System.out.println("Escriba la cantidad de stand para cada seccion(Ej:2/4/3/7) respectivamente: ");
                                    String cs1= sc.nextLine();
                                    String[] css= cs1.split("/");
                                    feria3.AsignarSeccionesStand(Integer.parseInt(css[0]),Integer.parseInt(css[1]), 
                                    Integer.parseInt(css[2]),Integer.parseInt(css[3]));
                                    break;
                                }
                            }
                        }else System.out.println("Ese codigo de feria no existe o ya es muy tarde para poder editarlo");
                        break;
                        case 4: //Consultar emprendedores en feria
                        System.out.println("Ingrese el codigo de una feria: ");
                        String cod4= sc.nextLine();
                        Feria feria4= Sistema.encontrarFeria(cod4); 
                        if(feria4!=null){
                        feria4.consultarEmprendedores();
                        }else System.out.println("Ese codigo de feria no existe");
                        break;
                    }
                }
                break;    
                case 2: //Administracion Emprendedor
                int op2=0;
                while(op2!=3){
                    mostrarMenuEmprendedor();
                    System.out.println("Elija una opcion: ");
                    op2=sc.nextInt();   
                }
                break;
                case 3: //Administracion Auspiciante
                int op3=0;
                while(op3!=4){
                    mostrarMenuAuspiciante();
                    System.out.println("Elija una opcion: ");
                    op3=sc.nextInt(); 
                }
                break;
                case 4: //Administracion Stand
                sc.nextLine();
                int op4=0;
                while(op4!=3){
                    System.out.println("Ingrese el codigo de una feria: ");
                    String cod= sc.nextLine();
                    Feria feria= Sistema.encontrarFeria(cod);
                    String pr="Continue";
                    while(pr!="exit"){
                        if(feria!=null){
                        feria.mostrarStands();
                        System.out.println("");
                        mostrarMenuStand();
                        System.out.println("Elija una opcion: ");
                        op4=sc.nextInt();
                        sc.nextLine();
                        switch(op4){
                            case 1: //Reservar stand
                            System.out.println("Ingrese un codigo del stand(Ej:A2): "); 
                            String cds= sc.nextLine();
                            System.out.println("Ingrese numero de identifiacion del emprendedor o auspiciante: "); 
                            String cp= sc.nextLine();
                            System.out.println("Ingrese la fecha de hoy dia(Ej:Ej:09/12/23): ");
                            String fah= sc.nextLine();
                            if(feria.encontrarStand(cds)!=null) feria.reservarStand(cds, cp, fah);
                            else System.out.println("El codigo de stand no existe");
                            break;
                            case 2: //Mostrar informacion del stand
                            System.out.println("Ingrese el codigo del stand(Ej:A2): ");
                            String cds1= sc.nextLine();
                            Stand ss= feria.encontrarStand(cds1);
                            if(ss!=null) ss.verInformacionStand();
                            else System.out.println("El codigo de stand no existe");
                            break;
                            case 3: 
                            pr="exit";
                            break;
                        }
                        }else {System.out.println("El codigo de feria no existe"); pr="exit"; op4=3;}
                        if(pr!="exit" && feria!=null){
                            System.out.println("Deseas seguir haciendo acciones en la misma feria?(si/no): ");
                            pr= sc.nextLine();
                            if(pr.equals("no")) pr="exit"; 
                        }
                    }
                }
                break;
            }
        }
        System.out.println("Gracias por usar nuestros servicios :)");

       
        
    }
}
