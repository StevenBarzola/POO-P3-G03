package modelo.participante;

public class Emprendedor extends Persona {
	private String descripcionServicios;

            //Getters y Setters
	public String getDescripcionServicios() {
		return descripcionServicios;
	}

	public void setDescripcionServicios(String descripcionServicios) {
		this.descripcionServicios = descripcionServicios;
	}

  public Emprendedor(String numld, String nombrePer, int telefono, String email) {
    super(numld, nombrePer, telefono, email);
    //Constructor con los atributos heredados de Persona.
  }
  
  
}
