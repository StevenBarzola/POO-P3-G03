/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectop2g;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import java.io.*;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import modelo.evento.*;
import modelo.participante.*;
/**
 * FXML Controller class
 *
 * @author USER
 */
public class AsignarAuspiController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField codigo;
    @FXML
    private TextField cedula;
    @FXML
    private Button buscarFeria;
    @FXML
    private VBox segundaVentana;
    @FXML
    private Button asignarAuspiciante;
    @FXML
    private TextArea descripcion;
    @FXML
    private CheckBox incluyeStand;
    private Auspiciante auspiciante;
    private Feria feria;
    @Override   
    public void initialize(URL url, ResourceBundle rb) {
        buscarFeria.setOnAction(
                e -> {
                    if (codigo.getText()!=null && cedula.getText()!=null){
                        if(AuspicianteEnFeria.verificarAuspicianteFeria(codigo.getText(), cedula.getText())){
                            Persona p = Sistema.encontrarPersona(cedula.getText());
                            auspiciante = (Auspiciante)p;
                            feria = Sistema.encontrarFeria(codigo.getText());
                            segundaVentana.setVisible(true);
                        } else {
                            alertas_error();
                            cedula.setText(null);
                        }
                    }else {
                        alertas_warning();
                    }
                }
        );
        asignarAuspiciante.setOnAction(
                e -> {
                    if(descripcion.getText()!=null){
                        AuspicianteEnFeria a = new AuspicianteEnFeria(feria, auspiciante, descripcion.getText(), incluyeStand.isSelected());
                        feria.getAuspiciantesEnFeria().add(a);
                        alertas_informacion();
                        try {
                            App.setRoot("admAuspiciante");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }else {
                       alertas_warning();
                    }
                }
        );
        
    }    
    
    @FXML
    private void admAuspiciante() throws IOException{
        App.setRoot("/com/mycompany/proyectop2g/admAuspiciante");
    }
    
    private void alertas_warning(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText("Label Vacio");
        alert.setContentText("El label está vacio");
        alert.showAndWait();
    }
    
    private void alertas_error(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Feria o cedula no encontrada");
        alert.setContentText("Sus datos ingresados no fueron encontrados en nuestra base.");
        alert.showAndWait();
    }
    
    private void alertas_informacion(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Datos ingresados");
        alert.setContentText("El auspicio de "+ auspiciante.getNombre()+" fue ingresado a la feria "+ feria.getNombre());
        alert.showAndWait();
    }
}
