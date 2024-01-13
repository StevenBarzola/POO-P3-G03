/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectop2g;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import modelo.participante.*;
/**
 * FXML Controller class
 *
 * @author USER
 */
public class AgregarAuspiController implements Initializable {
    @FXML
    ComboBox<SectorCubierto> sectoresCubiertos;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sectoresCubiertos.getItems().setAll(SectorCubierto.values());
    }    
    
    @FXML
    private void admAuspiciante() throws IOException{
        App.setRoot("/com/mycompany/proyectop2g/AdmAuspiciante");
    }
}
