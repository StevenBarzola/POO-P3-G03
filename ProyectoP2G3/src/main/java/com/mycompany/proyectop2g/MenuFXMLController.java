/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectop2g;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import com.mycompany.proyectop2g.*;
import com.mycompany.proyectop2g.App;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import modelo.evento.Sistema;
/**
 * FXML Controller class
 *
 * @author User
 */
public class MenuFXMLController implements Initializable {

    @FXML
    private VBox opcionesBox;
    @FXML
    private Button btnAdmFeria;
    @FXML
    private Button btnAdmEmprendedor;
    @FXML
    private Button btnAdmAusp;
    @FXML
    private Button btnAdmStand;
    @FXML
    private Button btnSalir;

    private static boolean soloUnaVez=true;
    /**
     * Initializes the controller class.
     */
    
    //Si existen datos guardados, estos se cargaran en la app
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(soloUnaVez==true) {
            Sistema.cargarDatos();
            soloUnaVez=false;
        }
    }    

    @FXML
    private void administrarFeria(MouseEvent event) throws IOException {
        App.setRoot("/com/mycompany/proyectop2g/admFeria");
    }

    @FXML
    private void administrarEmpr(MouseEvent event) throws IOException{
        App.setRoot("/com/mycompany/proyectop2g/admEmprendedor");
    }

    @FXML
    private void administrarAusp() throws IOException {
        App.setRoot("/com/mycompany/proyectop2g/admAuspiciante");
    }

    //Al salir de la app se valida si se desea guardar los datos o no
    @FXML
    private void salirMenu(MouseEvent event){
        Alert alerta= new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Aviso");
        alerta.setHeaderText("Guardar los datos de la administracion");
        alerta.setContentText("¿Desea guardar?");
        ButtonType botonSi = new ButtonType("Sí");
        ButtonType botonNo = new ButtonType("No");
        alerta.getButtonTypes().setAll(botonSi, botonNo);
        alerta.showAndWait().ifPresent(response -> {
            if (response == botonSi) {
                Sistema.guardarDatos();
                Stage stage= (Stage) btnSalir.getScene().getWindow();
                stage.close();
            }else if(response == botonNo){
                Stage stage= (Stage) btnSalir.getScene().getWindow();
                stage.close();
            }
         });
    }
    
}
