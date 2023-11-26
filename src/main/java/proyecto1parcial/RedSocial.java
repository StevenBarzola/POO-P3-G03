package proyecto1parcial;

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
    
    
    
}
