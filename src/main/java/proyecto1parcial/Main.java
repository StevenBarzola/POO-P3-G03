package proyecto1parcial;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    private static ArrayList<Auspiciante> auspiciantes;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
                System.out.println("Sectores cubiertos: (ALIMENTACION, EDUCACION, SALUD, VESTIMENTA) ");
                String seCu = sc.nextLine();
                SectorCubierto sec = null;
                while (sec == null){
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
            }
                
        }
    }
}
