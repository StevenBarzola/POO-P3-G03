package proyecto1parcial;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("1. Registrar auspiciante");
        System.out.println("2. Editar auspiciante");
        System.out.println("3. Asignar auspiciante a feria");
        System.out.println("4. Regresar");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch(opcion){
            case 1:
                System.out.println("Número de cedula o ruc: ");
                String ced = sc.nextLine();
                System.out.println("Nombre: ");
                String nom = sc.nextLine();
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
                System.out.println("Sectores cubiertos: ");
                String sec = sc.nextLine();
                Auspiciante a = new Auspiciante(String ced, String nom, String nomper, String tele, String email, String dir, String sw, SectorCubierto sec);
                break;
        }
    }
}
