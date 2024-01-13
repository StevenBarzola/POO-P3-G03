package com.mycompany.proyectop2g;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import modelo.evento.*;

public class DatosFeriaController implements Initializable {

    
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
       //TODO
    }    
    
    @FXML
    private void guardarFeria(ActionEvent event) {
       
       try{
           String nombre= txtNombre.getText();
           String descripcion= txtDescripcion.getText();
           String lugar= txtLugar.getText();
           LocalDate fechaInicio= dateFechaInicio.getValue();
           LocalDate fechaFin= dateFechaFin.getValue();
           String horario= txtHorario.getText();
           int nStand1= Integer.parseInt(txtNStand1.getText());
           int nStand2= Integer.parseInt(txtNStand2.getText());
           int nStand3= Integer.parseInt(txtNStand3.getText());
           int nStand4= Integer.parseInt(txtNStand4.getText());
           Sistema.registrarFeria(nombre,fechaInicio,fechaFin,lugar,descripcion,horario,nStand1,nStand2,nStand3,nStand4);
           
           
           Alert alerta= new Alert(Alert.AlertType.INFORMATION);
           alerta.setTitle("Aviso");
           alerta.setHeaderText("Acerca de la feria");
           alerta.setContentText("La feria ha sido registrada exitosamente");
           alerta.showAndWait();
       }catch(Exception e){
           Alert alerta= new Alert(Alert.AlertType.ERROR);
           alerta.setTitle("Aviso");
           alerta.setHeaderText("Error en los datos ingresados");
           alerta.setContentText("Los datos ingresados son inválidos. Por favor, revise que todo este correcto");
           alerta.showAndWait();
       }
       /*    
       try{
           String nombre= txtNombre.getText();
           String descripcion= txtDescripcion.getText();
           String lugar= txtLugar.getText();
           LocalDate fechaInicio= dateFechaInicio.getValue();
           LocalDate fechaFin= dateFechaFin.getValue();
           String horario= txtHorario.getText();
           int nStand1= Integer.parseInt(txtNStand1.getText());
           int nStand2= Integer.parseInt(txtNStand2.getText());
           int nStand3= Integer.parseInt(txtNStand3.getText());
           int nStand4= Integer.parseInt(txtNStand4.getText());
           Sistema.registrarFeria(nombre,fechaInicio,fechaFin,lugar,descripcion,horario,nStand1,nStand2,nStand3,nStand4);
           
           
           Alert alerta= new Alert(Alert.AlertType.INFORMATION);
           alerta.setTitle("Aviso");
           alerta.setHeaderText("Acerca de la feria");
           alerta.setContentText("La feria ha sido registrada exitosamente");
           alerta.showAndWait();
       }catch(Exception e){
           Alert alerta= new Alert(Alert.AlertType.ERROR);
           alerta.setTitle("Aviso");
           alerta.setHeaderText("Error en los datos ingresados");
           alerta.setContentText("Los datos ingresados son inválidos. Por favor, revise que todo este correcto");
           alerta.showAndWait();
       }
       */
       
    }

    @FXML
    private void limpiar(ActionEvent event) {
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtLugar.setText("");
        dateFechaInicio.setValue(null);
        dateFechaFin.setValue(null);
        txtHorario.setText("");
        txtNStand1.setText("");
        txtNStand2.setText("");
        txtNStand3.setText("");
        txtNStand4.setText("");
    }

    @FXML
    private void regresar(ActionEvent event) throws Exception {
        App.setRoot("admFeria");
    }
    
}
