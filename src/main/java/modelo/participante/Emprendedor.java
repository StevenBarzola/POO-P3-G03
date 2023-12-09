package modelo.participante;

import java.util.ArrayList;


public class Emprendedor extends Persona {
	private String descripcionServicios;

            //Getters y Setters
	public String getDescripcionServicios() {
		return descripcionServicios;
	}

	public void setDescripcionServicios(String descripcionServicios) {
		this.descripcionServicios = descripcionServicios;
	}

  public Emprendedor(String numld, String nombrePer, int telefono, String email, String npr, String d, String sw, ArrayList<RedSocial> rd, String ds) {
    super(numld, nombrePer, telefono, email);
    setOtherParams(npr,d,sw,rd);
    descripcionServicios=ds;
    //Constructor con los atributos heredados de Persona.
  }
  
  @Override
  public String toString(){
      return super.toString()+"\nDescripcion de los servicios: "+descripcionServicios;
  }
  
  
}
