/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.sistema;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

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
        // TODO
    }    

    @FXML
    private void administrarFeria(MouseEvent event) {
    }

    @FXML
    private void administrarEmpr(MouseEvent event) {
    }

    @FXML
    private void administrarAusp(MouseEvent event) {
    }

    @FXML
    private void administrarStand(MouseEvent event) {
    }

    @FXML
    private void salirMenu(MouseEvent event) {
    }
    
}
