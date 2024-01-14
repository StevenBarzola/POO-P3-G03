/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectop2g;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import java.io.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import modelo.participante.*;
import modelo.evento.*;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class EditarAuspiController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField cedula;
    @FXML
    private VBox editarAuspiciante;
    @FXML
    private ComboBox<String> campos;
    @FXML
    private GridPane NombrePanel;
    @FXML
    private GridPane NombreRespoPanel;
    @FXML
    private GridPane TelefonoPanel;
    @FXML
    private GridPane EmailPanel;
    @FXML
    private GridPane DireccionPanel;
    @FXML
    private GridPane SitioWebPanel;
    @FXML
    private GridPane SectorCubiertoPanel;
    @FXML
    private GridPane RedSocialPanel;
    @FXML
    private StackPane ventanaPrincipal;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        campos.getItems().add("Nombre");
        campos.getItems().add("Nombre P.Responsable");
        campos.getItems().add("Telefono");
        campos.getItems().add("Email");
        campos.getItems().add("Direccion");
        campos.getItems().add("Sitio Web");
        campos.getItems().add("Sector Cubierto");
        campos.getItems().add("Red Social");
        editarAuspiciante.setVisible(false);
    }   
    
    @FXML
    private void admAuspiciante() throws IOException{
        App.setRoot("/com/mycompany/proyectop2g/admAuspiciante");
    }
    
    @FXML
    private void verificarAuspiciante(){
        if(Auspiciante.verificarCedula(cedula.getText())){
            Persona perEdit = Sistema.encontrarPersona(cedula.getText());
            if(perEdit!=null && perEdit instanceof Auspiciante){
                     Auspiciante auspiEditar=(Auspiciante)perEdit;
            }
            editarAuspiciante.setVisible(true);
            campos.setOnAction(
                     e -> {
                        NombrePanel.setVisible(false);
                        NombreRespoPanel.setVisible(false);
                        TelefonoPanel.setVisible(false);
                        EmailPanel.setVisible(false);
                        DireccionPanel.setVisible(false);
                        SitioWebPanel.setVisible(false);
                        SectorCubiertoPanel.setVisible(false);
                        RedSocialPanel.setVisible(false);
                        String casos = campos.getValue();
                        switch(casos){
                             case "Nombre" :
                                NombrePanel.setVisible(true);
                                break;
                            case "Nombre P.Responsable":
                                NombreRespoPanel.setVisible(true);
                                break;
                            case "Telefono":
                                TelefonoPanel.setVisible(true);
                                break;
                            case "Email":
                                EmailPanel.setVisible(true);
                                break;
                            case "Direccion":
                                DireccionPanel.setVisible(true);
                                break;
                            case "Sitio Web":
                                SitioWebPanel.setVisible(true);
                                break;
                            case "Sector Cubierto":
                                SectorCubiertoPanel.setVisible(true);
                                break;
                            case "Red Social":
                                RedSocialPanel.setVisible(true);
                                break;
                        }
                     }
            );
        }else{
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Usuario no Encontrado");
            alert.setContentText("No se encontrado un auspiciante con la cedula ingresada.");
            alert.showAndWait();
        }
    }
    

}
