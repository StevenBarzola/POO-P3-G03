package com.mycompany.proyectop2g;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.*;
import javafx.scene.image.ImageView;
import java.io.*;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelo.evento.Sistema;
import modelo.participante.*;

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
    @FXML
    private TableView<Emprendedor> tblEmp;
    @FXML
    private TableColumn<Emprendedor, String> colCedula;
    @FXML
    private TableColumn<Emprendedor, String> colNombre;
    @FXML
    private TableColumn<Emprendedor, Integer> colTelefono;
    @FXML
    private TableColumn<Emprendedor, String> colEmail;
    
    private ArrayList<Emprendedor> emprendedores;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
         emprendedores = Sistema.emprendedores;
         colCedula.setCellValueFactory( data -> {
             String value = data.getValue().getNumId();
             return new SimpleStringProperty(value);
         });
         colNombre.setCellValueFactory( data -> {
             String value = data.getValue().getNombre();
             return new SimpleStringProperty(value);
         });
         colTelefono.setCellValueFactory(data -> {
        int value = data.getValue().getTelefono();
        return new SimpleIntegerProperty(value).asObject();
        });
         colEmail.setCellValueFactory( data -> {
             String value = data.getValue().getEmail();
             return new SimpleStringProperty(value);
         });
         if(!Sistema.emprendedores.isEmpty() ){
                 tblEmp.getItems().addAll(emprendedores);
           
            }
         }
        // TODO
      
    
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

