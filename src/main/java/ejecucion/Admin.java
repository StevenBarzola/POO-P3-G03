package ejecucion;
import modelo.evento.*;
import modelo.participante.*;
import java.util.*;

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
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
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
                            int tele = sc2.nextInt();
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
                            RedSocial.mostrarMenu();
                            int elegir =0;
                            ArrayList<RedSocial> redSocial = new ArrayList<>();
                            while (elegir!=8){
                                RedSocial.mostrarMenu();
                                elegir = sc2.nextInt();
                                System.out.println("Digite su usuario: ");
                                String usuario = sc2.nextLine();
                                switch(elegir){ 
                                    case 1 -> {
                                        RedSocial rs1 = new RedSocial(AppSocial.TWITTER, usuario);
                                        redSocial.add(rs1);
                                        break;
                                    }
                                    case 2 -> {
                                        RedSocial rs2 = new RedSocial(AppSocial.FACEBOOK, usuario);
                                        redSocial.add(rs2);
                                        break;
                                    }
                                    case 3 -> {
                                        RedSocial rs3 = new RedSocial(AppSocial.INSTAGRAM, usuario);
                                        redSocial.add(rs3);
                                        break;
                                    }
                                    case 4 -> {
                                        RedSocial rs4 = new RedSocial(AppSocial.YOUTUBE, usuario);
                                        redSocial.add(rs4);
                                        break;
                                    }
                                    case 5 -> {
                                        RedSocial rs5 = new RedSocial(AppSocial.TIKTOK, usuario);
                                        redSocial.add(rs5);
                                        break;
                                    }
                                    case 6 -> {
                                        RedSocial rs6 = new RedSocial(AppSocial.LINKEDIN, usuario);
                                        redSocial.add(rs6);
                                        break;
                                    }
                                    case 7 -> {
                                        RedSocial rs7 = new RedSocial(AppSocial.PINTEREST, usuario);
                                        redSocial.add(rs7);
                                        break;
                                    }
                                    case 8 -> {
                                        break;
                                    }
                                }
                                {
                                    System.out.println("Elija un número valido. ");
                                }   
                            }
                            Auspiciante a = new Auspiciante(cedula, nombre, nomper, tele, email, dir, sw, redSocial, sec);
                            break;
                        }
                        case 2 -> { 
                            System.out.println("Digite número de cedula o RUC:");
                            String cedula = sc2.nextLine();
                            Auspiciante auspiEditar = Auspiciante.encontrarAuspiciante(cedula);
                            auspiEditar.toString();
                            int campoEditar = 0;
                            while (campoEditar!=9){
                                System.out.println("Elija el campo que quiera editar: ");
                                System.out.println("1. Nombre");
                                System.out.println("2. Nombre persona responsable");
                                System.out.println("3. Teléfono ");
                                System.out.println("4. Email ");
                                System.out.println("5. Dirección");
                                System.out.println("6. Sitio web");
                                System.out.println("7. Sectores cubiertos");
                                System.out.println("8. Redes Sociales");
                                System.out.println("9. Salir");
                                campoEditar = sc2.nextInt();
                                if (campoEditar>0 && campoEditar<8){
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
                                            int tele = sc3.nextInt();
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
                                        case 8 -> {
                                            RedSocial.mostrarMenu();
                                            int elegir =0;
                                            ArrayList<RedSocial> redSocial = auspiEditar.getRedesSociales();
                                            while (elegir!=8){
                                                RedSocial.mostrarMenu();
                                                elegir = sc2.nextInt();
                                                System.out.println("Digite su usuario: ");
                                                String usuario = sc2.nextLine();
                                                switch(elegir){ 
                                                    case 1 -> {
                                                        RedSocial rs1 = new RedSocial(AppSocial.TWITTER, usuario);
                                                        redSocial.add(rs1);
                                                        break;
                                                    }
                                                    case 2 -> {
                                                        RedSocial rs2 = new RedSocial(AppSocial.FACEBOOK, usuario);
                                                        redSocial.add(rs2);
                                                        break;
                                                    }
                                                    case 3 -> {
                                                        RedSocial rs3 = new RedSocial(AppSocial.INSTAGRAM, usuario);
                                                        redSocial.add(rs3);
                                                        break;
                                                    }
                                                    case 4 -> {
                                                        RedSocial rs4 = new RedSocial(AppSocial.YOUTUBE, usuario);
                                                        redSocial.add(rs4);
                                                        break;
                                                    }
                                                    case 5 -> {
                                                        RedSocial rs5 = new RedSocial(AppSocial.TIKTOK, usuario);
                                                        redSocial.add(rs5);
                                                        break;
                                                    }
                                                    case 6 -> {
                                                        RedSocial rs6 = new RedSocial(AppSocial.LINKEDIN, usuario);
                                                        redSocial.add(rs6);
                                                        break;
                                                    }
                                                    case 7 -> {
                                                        RedSocial rs7 = new RedSocial(AppSocial.PINTEREST, usuario);
                                                        redSocial.add(rs7);
                                                        break;
                                                    }
                                                    case 8 -> {
                                                        break;
                                                    }
                                                }
                                                {
                                                    System.out.println("Elija un número valido. ");
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
                int op4=sc.nextInt(); 
                sc.nextLine();
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
