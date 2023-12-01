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
    

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        int op=0;
        while(op!=5){
            mostrarMenuPrincipal();
            System.out.println("Elija una opcion: ");
            op=sc.nextInt();
            if(op==1){
                int op1=0;
                while(op1!=5){
                    mostrarMenuFeria();
                    System.out.println("Elija una opcion: ");
                    op1=sc.nextInt();
                }  
            }
            if(op==2){
                int op2=0;
                while(op2!=3){
                    mostrarMenuEmprendedor();
                    System.out.println("Elija una opcion: ");
                    op2=sc.nextInt();
                }
            }
            if(op==3){
                int op3=0;
                while(op3!=4){
                    mostrarMenuAuspiciante();
                    System.out.println("Elija una opcion: ");
                    op3=sc.nextInt();
                    switch (op3) {
                        case 1 -> {
                            Auspiciante.mostrarAuspiciante();
                            System.out.println("Número de cedula o RUC: ");
                            String cedula = sc2.nextLine();
                            boolean validar= Auspiciante.verificarCedula(cedula);
                            while(validar==true){
                                validar = false;
                                System.out.println("Ya existe esta cedula.");
                                System.out.println("Número de cedula o RUC: ");
                                cedula = sc2.nextLine();
                                validar = Auspiciante.verificarCedula(cedula);
                            }
                            System.out.println("Nombre: ");
                            String nombre = sc2.nextLine();
                            System.out.println("Nombre persona responsable: ");
                            String nomper = sc2.nextLine();
                            System.out.println("Teléfono: ");
                            String tele = sc2.nextLine();
                            System.out.println("Email: ");
                            String email = sc2.nextLine();
                            System.out.println("Dirección (opcional): ");
                            String dir = sc2.nextLine();
                            System.out.println("Sitio web (opcional): ");
                            String sw = sc2.nextLine();
                            SectorCubierto sec = null;
                            while (sec == null){
                                System.out.println("Sectores cubiertos: (ALIMENTACION, EDUCACION, SALUD, VESTIMENTA) ");
                                String seCu = sc2.nextLine();   
                                switch (seCu){
                                   case "ALIMENTACION" -> {
                                       sec = SectorCubierto.ALIMENTACION;
                                       break;
                                   }    
                                   case "EDUCACION" -> {
                                       sec = SectorCubierto.EDUCACION;
                                       break;
                                   }
                                   case "SALUD" -> {
                                       sec = SectorCubierto.SALUD;
                                       break;
                                   }
                                   case "VESTIMENTA" -> {
                                       sec = SectorCubierto.VESTIMENTA;
                                       break;
                                   }
                                }
                            {
                            System.out.println("No está la opción");
                             }
                            }    
                            Persona a = new Auspiciante(cedula, nombre, nomper, tele, email, dir, sw, sec);
                            break;
                        }
                        case 2 -> { 
                            System.out.println("Digite número de cedula o RUC:");
                            String cedula = sc2.nextLine();
                            Auspiciante auspiEditar = Auspiciante.encontrarAuspiciante(cedula);
                            auspiEditar.toString();
                            int campoEditar = 0;
                            while (campoEditar!=8){
                                System.out.println("Elija el campo que quiera editar: ");
                                System.out.println("1. Nombre");
                                System.out.println("2. Nombre persona responsable");
                                System.out.println("3. Teléfono ");
                                System.out.println("4. Email ");
                                System.out.println("5. Dirección");
                                System.out.println("6. Sitio web");
                                System.out.println("7. Sectores cubiertos");
                                System.out.println("8. Salir");
                                campoEditar = sc2.nextInt();
                                if (campoEditar==8){
                                   campoEditar=8; 
                                } else if (campoEditar>0 && campoEditar<8){
                                    switch(campoEditar){
                                        case 1 -> {
                                            System.out.println("Nombre: ");
                                            String nombre = sc3.nextLine();
                                            auspiEditar.editarNom(nombre);
                                            break;
                                        }
                                        case 2 -> {
                                            System.out.println("Nombre persona responsable: ");
                                            String nomper = sc3.nextLine();
                                            auspiEditar.editarNomResp(nomper);
                                            break;
                                        }
                                        case 3 -> {
                                            System.out.println("Teléfono: ");
                                            String tele = sc3.nextLine();
                                            auspiEditar.editarTelef(tele);
                                            break;
                                        }
                                        case 4 -> {
                                            System.out.println("Email: ");
                                            String email = sc3.nextLine();
                                            auspiEditar.editarNom(email);
                                            break;
                                        }
                                        case 5 -> {
                                            System.out.println("Dirección: ");
                                            String dir = sc3.nextLine();
                                            auspiEditar.editarDireccion(dir);
                                            break;
                                        }
                                        case 6 -> {
                                            System.out.println("Sitio web: ");
                                            String sw = sc3.nextLine();
                                            auspiEditar.editarSitioWeb(sw);
                                            break;
                                        }
                                        case 7 -> {
                                            SectorCubierto sec = null;
                                            while (sec == null){
                                                System.out.println("Sectores cubiertos: (ALIMENTACION, EDUCACION, SALUD, VESTIMENTA) ");
                                                String seCu = sc3.nextLine();
                                                switch (seCu){
                                                    case "ALIMENTACION" -> {
                                                        sec = SectorCubierto.ALIMENTACION;
                                                        auspiEditar.editarSectorCubierto(sec);
                                                        break;
                                                    }    
                                                    case "EDUCACION" -> {
                                                        sec = SectorCubierto.EDUCACION;
                                                        auspiEditar.editarSectorCubierto(sec);
                                                        break;
                                                    }
                                                    case "SALUD" -> {
                                                        sec = SectorCubierto.SALUD;
                                                        auspiEditar.editarSectorCubierto(sec);
                                                        break;
                                                    }
                                                    case "VESTIMENTA" -> {
                                                        sec = SectorCubierto.VESTIMENTA;
                                                        auspiEditar.editarSectorCubierto(sec);
                                                        break;
                                                    }
                                                        }
                                                    {
                                                        System.out.println("No está la opción");

                                                    }
                                            }
                                        }
                                    }   
                                  } else{
                                    System.out.println("Número invalido: ");
                                    }    
                                } break; 
                            } 
                        case 3 -> {
                            System.out.println("Ingrese codigo de la feria: ");
                            String codigo = sc3.nextLine();
                            System.out.println("Ingrese número de cedula o RUC: ");
                            String cedu = sc3.nextLine();
                            boolean val1 = Auspiciante.verificarAuspicianteFeria(codigo, cedu);
                            if (val1){
                                Auspiciante auspi = Auspiciante.encontrarAuspiciante(cedu);
                                System.out.println("Descripción de lo que cubre el auspicio: ");
                                String descri = sc3.nextLine();
                                System.out.println("Incluye stand en la feria: (Si/No) ");
                                String incluye = sc3.nextLine();
                                boolean incluirStand = "Si".equals(incluye);
                                AuspicianteEnFeria af = new AuspicianteEnFeria(auspi, descri, incluirStand);

                            } else {
                                System.out.println("Datos invalidos. ");
                            }
                        }
                        }   
                            }
                        }
            if(op==4){
                int op4=0;
                while(op4!=3){
                    mostrarMenuStand();
                    System.out.println("Elija una opcion: ");
                    op4=sc.nextInt();
                }
            }
            System.out.println("Gracias por usar nuestros servicios :)");
        }
        
        
       
        
    }
}
