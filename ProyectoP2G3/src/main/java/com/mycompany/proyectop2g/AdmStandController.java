package com.mycompany.proyectop2g;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import modelo.evento.*;
import modelo.participante.*;
/**
 * FXML Controller class
 *
 * @author Steven
 */
public class AdmStandController implements Initializable {


    @FXML
    private Label lblFeriaSeleccionada;
    @FXML
    private HBox hb1Seccion;
    @FXML
    private HBox hb2Seccion;
    @FXML
    private HBox hb3Seccion;
    @FXML
    private HBox hb4Seccion;
    
    private Feria feria;
    /**
     * Initializes the controller class.
     */
    
    public void inicAtributos(Feria fe){
        feria=fe;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    public void crearStands(Feria fe){
        inicAtributos(fe);
        int cont=0;
        for(SeccionStand ss: feria.getSeccionesStand()){
            for(Stand s: ss.getSeccion()){
               Label lbStand= new Label(s.getCodigoSt());
                DropShadow dropShadow = new DropShadow();
                dropShadow.setColor(javafx.scene.paint.Color.BLACK);  // Color de la sombra
                dropShadow.setOffsetX(3);  // Desplazamiento en el eje X
                dropShadow.setOffsetY(3);  // Desplazamiento en el eje Y
                dropShadow.setRadius(5);    // Radio de la sombra
                lbStand.setEffect(dropShadow);
               if(s.getPersona()!=null){
                   lbStand.setStyle("-fx-background-color: yellow; -fx-padding: 10px; -fx-text-fill: white; -fx-background-radius: 12;");
                   lbStand.setOnMouseClicked(e -> {
                       Alert alerta= new Alert(Alert.AlertType.INFORMATION);
                       alerta.setTitle("Informacion del stand");
                       LocalDate fechaActual= LocalDate.now();
                       Persona p= s.getPersona();
                       String pe="";
                       if(s.getPersona() instanceof Emprendedor) {
                           pe="Emprendedor";
                           alerta.setContentText("Nombre: "+p.getNomPerRes()+"\nTelefono: "+p.getTelefono()+"\nCorreo: "+p.getEmail());
                       }else if(s.getPersona() instanceof Auspiciante){
                           pe="Auspiciante";
                           alerta.setContentText("Nombre: "+p.getNombre()+"\nTelefono: "+p.getTelefono()+"\nCorreo: "+p.getEmail());
                       }
                       alerta.setHeaderText("Stand "+s.getCodigoSt()+" reservado el "+fechaActual+" por el "+pe+":");
                       alerta.showAndWait();
                   });
               }else{
                   lbStand.setStyle("-fx-background-color: green; -fx-padding: 10px; -fx-text-fill: white; -fx-background-radius: 12;");
               }
               if(cont==0) hb1Seccion.getChildren().add(lbStand);
               if(cont==1) hb2Seccion.getChildren().add(lbStand);
               if(cont==2) hb3Seccion.getChildren().add(lbStand);
               if(cont==3) hb4Seccion.getChildren().add(lbStand);
            }
            cont++;
        }
    }

    @FXML
    private void regresar(MouseEvent event) throws IOException{
        feria=null;
        Stage stage= (Stage) lblFeriaSeleccionada.getScene().getWindow();
        stage.close();
        App.setRoot("/com/mycompany/proyectop2g/admFeria");
    }
    
   
    
}
