package com.mycompany.proyectop2g;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
    @FXML
    private HBox ventanaRegistrarStand;
    
     @FXML
    private TextField txtIDPersona;
    
    //private Feria feria;
    private Stand stand;
    private Label lb; //Para cerrar la escena de su ventana
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
                   lbStand.setStyle("-fx-background-color: yellow; -fx-padding: 10px; -fx-text-fill: white; -fx-background-radius: 12; -fx-font-weight: bold;");
                   lbStand.setOnMouseClicked(e -> {
                       Alert alerta= new Alert(Alert.AlertType.INFORMATION);
                       alerta.setTitle("Informacion del stand");
                       Persona p= s.getPersona();
                       String pe="";
                       if(s.getPersona() instanceof Emprendedor) {
                           pe="Emprendedor";
                           alerta.setContentText("Stand: "+s.getCodigoSt()+"\nAsignado el: "+s.getFechaAsig()+"\nTipo: "+pe+"\nNombre: "+
                           p.getNomPerRes()+"\nTelefono: "+p.getTelefono()+"\nCorreo: "+p.getEmail());
                       }else if(s.getPersona() instanceof Auspiciante){
                           pe="Auspiciante";
                           alerta.setContentText("Stand: "+s.getCodigoSt()+"\nAsignado el: "+s.getFechaAsig()+"\nTipo: "+pe+"\nNombre: "+
                           p.getNombre()+"\nTelefono: "+p.getTelefono()+"\nCorreo: "+p.getEmail());
                       }
                       alerta.setHeaderText("Stand reservado");
                       alerta.showAndWait();
                   });
               }else{
                   lbStand.setStyle("-fx-background-color: green; -fx-padding: 10px; -fx-text-fill: white; -fx-background-radius: 12; -fx-font-weight: bold;");
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
                           iniAtributos(feria,s,lblFeriaSeleccionada);
                           ventanaRegistrarStand.setVisible(true);
                           /*
                           try{                               
                               FXMLLoader loader= new FXMLLoader(getClass().getResource("/com/mycompany/proyectop2g/reservarStand.fxml"));
                               Parent root= loader.load();
                               ReservarStandController controlador= loader.getController();
                               controlador.iniAtributos(feria,s,lblFeriaSeleccionada);
                               Scene scene= new Scene(root);
                               Stage stage= new Stage();
                               stage.initModality(Modality.APPLICATION_MODAL);
                               stage.setScene(scene);
                               stage.showAndWait();
                                
                               
                           }catch(IOException io){
                                System.out.println("Error cambio de ventana: "+io.getMessage());
                           }
                            */
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
        stand=null;
        App.setRoot("/com/mycompany/proyectop2g/admFeria");
        Stage stage= (Stage) lblFeriaSeleccionada.getScene().getWindow();
        stage.close();
    }
    
    
    public void iniAtributos(Feria fe, Stand st, Label lbl){
        feria=fe;
        stand=st;
        lb=lbl;
    }
    
    @FXML
    private void reservar(ActionEvent event) throws IOException{
        Persona per= Sistema.encontrarPersona(txtIDPersona.getText());
        int cont=0;
        if(per!=null && per instanceof Emprendedor){
            Emprendedor emp=(Emprendedor)per;
            cont= feria.limiteStand(emp.getNumId());
            if(cont==0){
                stand.setPersona(emp);
                stand.setFechaAsig(LocalDate.now());
                Alert alerta= new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Aviso");
                alerta.setHeaderText("Stand "+stand.getCodigoSt());
                alerta.setContentText("El stand ha sido reservado con exito");
                alerta.showAndWait();
                //Stage stage= (Stage) txtIDPersona.getScene().getWindow();
                //stage.close();
                //abajo
                //Stage stage2= (Stage) lb.getScene().getWindow();
                //stage2.close();
                App.setRoot("/com/mycompany/proyectop2g/admFeria");
                
                FXMLLoader loader= new FXMLLoader(getClass().getResource("/com/mycompany/proyectop2g/admStand.fxml"));
                Parent root= loader.load();
                AdmStandController controlador= loader.getController();
                controlador.crearStands(feria);
                Scene scene= new Scene(root);
                Stage stage1= new Stage();
                stage1.initModality(Modality.APPLICATION_MODAL);
                stage1.setScene(scene);
                stage1.initStyle(StageStyle.UNDECORATED);
                feria=null;
                stand=null;
                ventanaRegistrarStand.setVisible(false);
                Stage stage= (Stage) lblFeriaSeleccionada.getScene().getWindow();
                stage.close();
                stage1.show();
                //arriba
            }else{
                Alert alerta= new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Aviso");
                alerta.setHeaderText("El emprendedor ya tiene un stand asignado");
                alerta.setContentText("Un emprendedor no puede tener mas de un stand asignado por feria");
                alerta.showAndWait();
            } 
        }else if(per!=null && per instanceof Auspiciante){
            Auspiciante aus=(Auspiciante)per;
            AuspicianteEnFeria anf= feria.encontrarAuspicianteEnFeria(aus);
            if(anf!=null){
                cont= feria.limiteStand(anf.getAuspiciante().getNumId());
                if(cont<2){
                    if(anf.getTieneStand()==true){
                        stand.setPersona(aus);
                        stand.setFechaAsig(LocalDate.now());
                        Alert alerta= new Alert(Alert.AlertType.INFORMATION);
                        alerta.setTitle("Aviso");
                        alerta.setHeaderText("Stand "+stand.getCodigoSt());
                        alerta.setContentText("El stand ha sido reservado con exito");
                        alerta.showAndWait();
                        //Stage stage= (Stage) txtIDPersona.getScene().getWindow();
                        //stage.close();
                        //abajo
                        //Stage stage2= (Stage) lb.getScene().getWindow();
                        //stage2.close();
                        App.setRoot("/com/mycompany/proyectop2g/admFeria");
                        
                        FXMLLoader loader= new FXMLLoader(getClass().getResource("/com/mycompany/proyectop2g/admStand.fxml"));
                        Parent root= loader.load();
                        AdmStandController controlador= loader.getController();
                        controlador.crearStands(feria);
                        Scene scene= new Scene(root);
                        Stage stage1= new Stage();
                        stage1.initModality(Modality.APPLICATION_MODAL);
                        stage1.setScene(scene);
                        stage1.initStyle(StageStyle.UNDECORATED);
                        
                        crearStands(feria);
                        feria=null;
                        stand=null;
                        ventanaRegistrarStand.setVisible(false);
                        Stage stage= (Stage) lblFeriaSeleccionada.getScene().getWindow();
                        stage.close();
                        stage1.show();
                        
                        //arriba
                    }else{
                        Alert alerta= new Alert(Alert.AlertType.WARNING);
                        alerta.setTitle("Aviso");
                        alerta.setHeaderText("El auspiciante no debe tener stand");
                        alerta.setContentText("El auspiciante que ingreso no va a requerir el uso de un stand");
                        alerta.showAndWait();
                    } 
                }else{
                    Alert alerta= new Alert(Alert.AlertType.WARNING);
                    alerta.setTitle("Aviso");
                    alerta.setHeaderText("El auspiciante ya tiene 2 stands asignados");
                    alerta.setContentText("Un auspiciante solo puede tener max 2 stands por feria");
                    alerta.showAndWait();
                }
            }else{
                Alert alerta= new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Aviso");
                alerta.setHeaderText("Emprendedor o Auspiciante no encontrado");
                alerta.setContentText("Asegurese que la persona se haya registrado y que el numero de identificacion este correctamente escrito");
                alerta.showAndWait();
            }    
        }else{
            Alert alerta= new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Aviso");
            alerta.setHeaderText("Emprendedor o Auspiciante no encontrado");
            alerta.setContentText("Asegurese que la persona se haya registrado y que el numero de identificacion este correctamente escrito");
            alerta.showAndWait();
        }
    }
    
    
    @FXML
    private void regresar2(MouseEvent event) throws IOException{
        feria=null;
        stand=null;
        Stage stage1= (Stage) txtIDPersona.getScene().getWindow();
        stage1.close();
    }
    
    
}
