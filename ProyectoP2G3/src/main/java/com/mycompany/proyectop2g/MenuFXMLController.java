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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void administrarFeria(MouseEvent event) throws IOException {
        App.setRoot("/com/mycompany/proyectop2g/admFeria");
    }

    @FXML
    private void administrarEmpr(MouseEvent event) {
    }

    @FXML
    private void administrarAusp() throws IOException {
        App.setRoot("/com/mycompany/proyectop2g/admAuspiciante");
    }

    @FXML
    private void administrarStand(MouseEvent event) {
    }

    @FXML
    private void salirMenu(MouseEvent event) {
    }
    
}
