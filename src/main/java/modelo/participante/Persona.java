package modelo.participante;
import java.util.ArrayList;

public class Persona {
    protected String numld;
    protected String nombrePer;
    protected String nomPerRes;
    protected int telefono;
    protected String email;
    protected String direccion;
    protected String sitioWeb;
    protected ArrayList<RedSocial> redesSociales;

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
  
  public Persona(String numld, String nombrePer, int telefono, String email) {
    //Se crea un constructor para la clase Persona con las variables que se consideran más importantes. 
    this.numld=numld;
    this.nombrePer=nombrePer;
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