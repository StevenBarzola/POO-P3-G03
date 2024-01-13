package com.mycompany.proyectop2g;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import modelo.evento.*;

public class DatosFeriaController implements Initializable {


    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtLugar;
    @FXML
    private DatePicker dateFechaInicio;
    @FXML
    private DatePicker dateFechaFin;
    @FXML
    private TextField txtHorario;
    @FXML
    private TextField txtNStand1;
    @FXML
    private TextField txtNStand2;
    @FXML
    private TextField txtNStand3;
    @FXML
    private TextField txtNStand4;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void guardarFeria(ActionEvent event) {
        String nombre= txtNombre.getText();
        String codigo= Sistema.generarCodigo();
        String lugar= txtLugar.getText();
        
    }

    @FXML
    private void cancelar(ActionEvent event) throws IOException {
        App.setRoot("admFeria");
    }

}
