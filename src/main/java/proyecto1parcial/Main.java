package proyecto1parcial;
import java.util.Scanner;
import java.util.ArrayList;
import static proyecto1parcial.Auspiciante.asignarAuspicianteFeria;
public class Main {
    private static ArrayList<Auspiciante> auspiciantes;
    public static void main(String[] args) {
      boolean continuar = true;
      Scanner sc = new Scanner(System.in);
      while(continuar){  
        for (Auspiciante auspician : auspiciantes){
            System.out.println(auspician.nombrePer);
        }
        System.out.println("1. Registrar auspiciante");
        System.out.println("2. Editar auspiciante");
        System.out.println("3. Asignar auspiciante a feria");
        System.out.println("4. Regresar");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1 -> {
                System.out.println("Número de cedula o RUC: ");
                String cedula = sc.nextLine();
                boolean validar= false;
                for (Auspiciante auspican : auspiciantes){
                    if (auspican.numId.contains(cedula)){
                        validar = true;
                    }
                }
               while(validar==true){
                   validar = false;
                   System.out.println("Ya existe esta cedula.");
                   System.out.println("Número de cedula o RUC: ");
                    cedula = sc.nextLine();
                    for (Auspiciante auspican : auspiciantes){
                        if (auspican.numId.contains(cedula)){
                            validar = true;
                        }
                    }
                }
                System.out.println("Nombre: ");
                String nombre = sc.nextLine();
                System.out.println("Nombre persona responsable: ");
                String nomper = sc.nextLine();
                System.out.println("Teléfono: ");
                String tele = sc.nextLine();
                System.out.println("Email: ");
                String email = sc.nextLine();
                System.out.println("Dirección (opcional): ");
                String dir = sc.nextLine();
                System.out.println("Sitio web (opcional): ");
                String sw = sc.nextLine();
                SectorCubierto sec = null;
                while (sec == null){
                 System.out.println("Sectores cubiertos: (ALIMENTACION, EDUCACION, SALUD, VESTIMENTA) ");
                 String seCu = sc.nextLine();   
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
                SectorCubierto tipo = SectorCubierto.ALIMENTACION;
                Auspiciante auspiEditar = new Auspiciante("x", "x", "x", "x", "x", "x", "x", tipo); // Crear un objeto que luego será reemplazado
                String cedula = sc.nextLine();
                for (Auspiciante auspican : auspiciantes){
                    if (auspican.numId.equals(cedula)){
                        auspiEditar = auspican;
                    }
                }
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
                    campoEditar = sc.nextInt();
                    if (campoEditar==8){
                       campoEditar=8; 
                    } else if (campoEditar>0 && campoEditar<8){
                        switch(campoEditar){
                            case 1 -> {
                                System.out.println("Nombre: ");
                                String nombre = sc.nextLine();
                                auspiEditar.editarNom(nombre);
                                break;
                            }
                            case 2 -> {
                                System.out.println("Nombre persona responsable: ");
                                String nomper = sc.nextLine();
                                auspiEditar.editarNomResp(nomper);
                                break;
                            }
                            case 3 -> {
                                System.out.println("Teléfono: ");
                                String tele = sc.nextLine();
                                auspiEditar.editarTelef(tele);
                                break;
                            }
                            case 4 -> {
                                System.out.println("Email: ");
                                String email = sc.nextLine();
                                auspiEditar.editarNom(email);
                                break;
                            }
                            case 5 -> {
                                System.out.println("Dirección: ");
                                String dir = sc.nextLine();
                                auspiEditar.editarDireccion(dir);
                                break;
                            }
                            case 6 -> {
                                System.out.println("Sitio web: ");
                                String sw = sc.nextLine();
                                auspiEditar.editarSitioWeb(sw);
                                break;
                            }
                            case 7 -> {
                                SectorCubierto sec = null;
                                while (sec == null){
                                    System.out.println("Sectores cubiertos: (ALIMENTACION, EDUCACION, SALUD, VESTIMENTA) ");
                                    String seCu = sc.nextLine();
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
                String codigo = sc.nextLine();
                System.out.println("Ingrese número de cedula o RUC: ");
                String cedu = sc.nextLine();
                SectorCubierto tipo = SectorCubierto.ALIMENTACION;
                Auspiciante auspi = new Auspiciante("x", "x", "x", "x", "x", "x", "x", tipo); // Crear un objeto que luego será reemplazado
                boolean val1 = asignarAuspicianteFeria(codigo, cedu);
                /* boolean val2 = false;
                boolean incluirStand;
                for (Feria f: ferias){
                    String cod = f.getCodigo();
                    if (codigo.equals(cod)){
                        val1 = true;
                    }
                } */
                for (Auspiciante au: auspiciantes){
                    String cedula = au.numId;
                    if (cedula.equals(cedu)){
                        auspi = au;
                      //  val2 = true;
                            
                        }
                }
                if (val1){
                    System.out.println("Descripción de lo que cubre el auspicio: ");
                    String descri = sc.nextLine();
                    System.out.println("Incluye stand en la feria: (Si/No) ");
                    String incluye = sc.nextLine();
                    boolean incluirStand = "Si".equals(incluye);
                    AuspicianteEnFeria af = new AuspicianteEnFeria(auspi, descri, incluirStand);
                    
                } else {
                    System.out.println("Datos invalidos. ");
                }
                    
                    
                
            }
            case 4 -> {
                // Opcion para regresar
            }
                
            }   
    } }
}
