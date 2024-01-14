package com.mycompany.proyectop2g;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
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
        lblFeriaSeleccionada.setText("Feria: "+fe.getCodigo());
        int cont=0;
        for(SeccionStand ss: feria.getSeccionesStand()){
            for(Stand s: ss.getSeccion()){
               Label lbStand= new Label(s.getCodigoSt());
                DropShadow dropShadow = new DropShadow();
                dropShadow.setColor(javafx.scene.paint.Color.BLACK); 
                dropShadow.setOffsetX(3);  
                dropShadow.setOffsetY(3);  
                dropShadow.setRadius(5);    
                lbStand.setEffect(dropShadow);
               if(s.getPersona()!=null){
                   lbStand.setStyle("-fx-background-color: yellow; -fx-padding: 10px; -fx-text-fill: white; -fx-background-radius: 12;");
                   lbStand.setOnMouseClicked(e -> {
                       Alert alerta= new Alert(Alert.AlertType.INFORMATION);
                       alerta.setTitle("Informacion del stand");
                       Persona p= s.getPersona();
                       String pe="";
                       if(s.getPersona() instanceof Emprendedor) {
                           pe="Emprendedor";
                           alerta.setContentText("Nombre: "+p.getNomPerRes()+"\nTelefono: "+p.getTelefono()+"\nCorreo: "+p.getEmail());
                       }else if(s.getPersona() instanceof Auspiciante){
                           pe="Auspiciante";
                           alerta.setContentText("Nombre: "+p.getNombre()+"\nTelefono: "+p.getTelefono()+"\nCorreo: "+p.getEmail());
                       }
                       alerta.setHeaderText("Stand "+s.getCodigoSt()+" reservado el "+s.getFechaAsig()+" por el "+pe+":");
                       alerta.showAndWait();
                   });
               }else{
                   lbStand.setStyle("-fx-background-color: green; -fx-padding: 10px; -fx-text-fill: white; -fx-background-radius: 12;");
                   lbStand.setOnMouseClicked(e ->{
                       Alert alerta= new Alert(Alert.AlertType.CONFIRMATION);
                       alerta.setTitle("Informacion del stand");
                       alerta.setHeaderText("El Stand "+s.getCodigoSt()+" se encuentra disponible");
                       alerta.setContentText("¿Desea reservarlo?");
                       ButtonType botonSi = new ButtonType("Sí");
                       ButtonType botonNo = new ButtonType("No");
                       alerta.getButtonTypes().setAll(botonSi, botonNo);
                       alerta.showAndWait().ifPresent(response -> {
                       if (response == botonSi) {
                           try{
                               FXMLLoader loader= new FXMLLoader(getClass().getResource("/com/mycompany/proyectop2g/reservarStand.fxml"));
                               Parent root= loader.load();
                               ReservarStandController controlador= loader.getController();
                               controlador.iniAtributos(feria,s);
                               Scene scene= new Scene(root);
                               Stage stage= new Stage();
                               stage.initModality(Modality.APPLICATION_MODAL);
                               stage.setScene(scene);
                               stage.showAndWait();
                           }catch(IOException io){
                                System.out.println("Error cambio de ventana: "+io.getMessage());
                           }
                       }else if(response == botonNo) {
                           alerta.close();
                       }
                       });
                   });
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
