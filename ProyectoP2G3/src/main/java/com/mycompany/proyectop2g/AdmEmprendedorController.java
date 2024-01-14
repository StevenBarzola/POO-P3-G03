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
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AdmEmprendedorController implements Initializable {
    
    @FXML
    private ImageView regresar;
    @FXML
    private Button crearEmp;
    @FXML
    private Button editarEmp1;

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
    private void nuevoEmprendedor() throws IOException{
        App.setRoot("/com/mycompany/proyectop2g/AgregarEmp");
    }
    
    @FXML
    private void editarEmprendedor() throws IOException{
        App.setRoot("/com/mycompany/proyectop2g/EditarEmp");
    }
    
  
}

