/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectop2g;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.io.*;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.evento.*;
import modelo.participante.*;


/**
 * FXML Controller class
 *
 * @author USER
 */
public class AdmAuspicianteController implements Initializable {
    
    @FXML
    private ImageView regresar;
    
    @FXML
    private TableView<AuspicianteEnFeria> tblAuspiEnFeria;
    
    @FXML
    private TableColumn<AuspicianteEnFeria, String> colFeria;
    
    @FXML
    private TableColumn<AuspicianteEnFeria, String> colAuspiciante;
        
    @FXML
    private TableColumn colDescripcion;
    
    @FXML
    private TableColumn<AuspicianteEnFeria, String> colStand;
    
    private ArrayList<AuspicianteEnFeria> auspicianteEnFeria;
    private ArrayList<Feria> ferias;
    private Auspiciante auspiciante;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {    
         ferias = Sistema.ferias;
         colFeria.setCellValueFactory( data -> {
             String value = data.getValue().getFeria().getNombre();
             return new SimpleStringProperty(value);
         });
         colAuspiciante.setCellValueFactory( data -> {
             String value = data.getValue().getAuspiciante().getNombre();
             return new SimpleStringProperty(value);
         });
         colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
         colStand.setCellValueFactory(data -> {
             Boolean value = data.getValue().getTieneStand();
             String string; if(value){ string = "SI"; } else { string= "NO";}
             return new SimpleStringProperty(string); 
         });
         if(ferias.size()!=0 && Sistema.auspiciantes.size()!=0 ){
            for (Feria f:ferias){
             if(f.getAuspiciantesEnFeria().size()!=0){
                 tblAuspiEnFeria.getItems().addAll(f.getAuspiciantesEnFeria());
             }
            }
         }
              
        
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

