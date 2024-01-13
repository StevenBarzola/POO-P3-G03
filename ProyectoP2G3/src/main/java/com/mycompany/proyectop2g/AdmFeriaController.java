package com.mycompany.proyectop2g;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.evento.*;
import modelo.participante.*;

public class AdmFeriaController implements Initializable {

    @FXML
    private Button btnAgregarFeria;
    @FXML
    private Button btnregresarFeria;
    @FXML
    private TableView<Feria> tblFerias;
    @FXML
    private TableColumn colCodigo;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colFechaInicio;
    @FXML
    private TableColumn colLugar;
    @FXML
    private TableColumn colNAuspiciantes;
    @FXML
    private TableColumn colNEmprendedores;
    
    private ObservableList<Feria> ferias;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ferias = FXCollections.observableArrayList();
        colCodigo.setCellValueFactory(new PropertyValueFactory("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        colLugar.setCellValueFactory(new PropertyValueFactory("lugar"));

    }    

    @FXML
    private void regresarFeria(ActionEvent event) {
    }

    @FXML
    private void mostrarVentanaDatosFeria(ActionEvent event) throws IOException {
        App.setRoot("datosFeria");
    }
    
}
