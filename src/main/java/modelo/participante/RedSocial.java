package modelo.participante;

public class RedSocial {
    private AppSocial appsocial;
    private String cuenta;
    
//Constructor
    public RedSocial(AppSocial a, String c){
        appsocial=a;
        cuenta=c;
    }
    
    //Getters y Setters
    public AppSocial getAppSocial(){
        return appsocial;
    }
    
    public String getCuenta(){
        return cuenta;
    }
    
    public void setAppsocial(AppSocial ap){
        appsocial=ap;
    }
    
    public void setCuenta(String c){
        cuenta=c;
    } 
    
     //mostar menu de redes sociales
    public static void mostrarMenu(){
        System.out.println("Redes Sociales que maneja (elegir): ");
        System.out.println("1. Twitter");
        System.out.println("2. Facebook");
        System.out.println("3. Instagram");
        System.out.println("4. Youtube");
        System.out.println("5. Tiktok");
        System.out.println("6. Linkedln");
        System.out.println("7. Pinterest");
        System.out.println("8. Salir");
        System.out.println("Elegir una opción: ");
        
    }

}
