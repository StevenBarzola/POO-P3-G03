package modelo.participante;
import java.util.ArrayList;

public class Persona {
    protected String numId;
    protected String nombre;
    protected String nomPerRes;
    protected int telefono;
    protected String email;
    protected String direccion;
    protected String sitioWeb;
    protected ArrayList<RedSocial> redesSociales;

    //Getters and setters
    public String getNumId() {
        return numId;
    }

    public String getNomPerRes() {
        return nomPerRes;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }
    
    public String getNombre(){
      return nombre;
  }

    public ArrayList<RedSocial> getRedesSociales() {
        return redesSociales;
    }
    
  public void setNomPerRes(String nomPerRes) {
    this.nomPerRes = nomPerRes;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public void setSitioWeb(String sitioWeb) {
    this.sitioWeb = sitioWeb;
  }

  public void setRedesSociales(ArrayList<RedSocial> redesSociales) {
    this.redesSociales = redesSociales;
  }

  public void setTelefono(int telefono) {
        this.telefono = telefono;
  }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 
  
  public Persona(String numId, String nombre, int telefono, String email) {
    //Se crea un constructor para la clase Persona con las variables que se consideran más importantes. 
    this.numId=numId;
    this.nombre=nombre;
    this.telefono=telefono;
    this.email=email;
  }

  public void setOtherParams(String nomPerRes, String direccion, String sitioWeb, ArrayList<RedSocial> redesSociales) {
     //Se crea un método para la clase Persona con las variables que faltaban en el constructor anterior.
    this.setNomPerRes(nomPerRes);
    this.setDireccion(direccion);
    this.setSitioWeb(sitioWeb);
    this.setRedesSociales(redesSociales);
    
  }
}