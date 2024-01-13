/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectop2g;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.*;
import javafx.scene.image.ImageView;
import java.io.*;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AdmAuspicianteController implements Initializable {
    
    @FXML
    private ImageView regresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    private void menuPrincipal() throws IOException{
        App.setRoot("/com/mycompany/proyectop2g/MenuFXML");
    }
    
    @FXML
    private void nuevoAuspiciante() throws IOException{
        App.setRoot("/com/mycompany/proyectop2g/AgregarAuspi");
    }
    
    @FXML
    private void editarAuspiciante() throws IOException{
        App.setRoot("/com/mycompany/proyectop2g/EditarAuspi");
    }
    
    @FXML
    private void asignarAuspiciante() throws IOException{
        App.setRoot("/com/mycompany/proyectop2g/AsignarAuspi");
    }
    
}

