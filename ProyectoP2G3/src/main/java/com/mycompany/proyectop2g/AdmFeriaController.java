package com.mycompany.proyectop2g;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.stage.StageStyle;
import modelo.evento.*;
import modelo.participante.*;

public class AdmFeriaController implements Initializable {
    
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
    private TableColumn<Feria, Integer> colNAuspiciantes;
    @FXML
    private TableColumn<Feria, Integer> colNEmprendedores;
    
    /**
     * Initializes the controller class.
     */
    
    //Inicializa la tabla con los datos de las ferias existentes
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colFechaInicio.setCellValueFactory(new PropertyValueFactory<>("fechaI"));
        colLugar.setCellValueFactory(new PropertyValueFactory<>("lugar"));
        colNAuspiciantes.setCellValueFactory(data -> 
            Bindings.createObjectBinding(() -> data.getValue().getAuspiciantesEnFeria().size())
        );
        colNEmprendedores.setCellValueFactory(data -> 
                Bindings.createObjectBinding(() -> data.getValue().getNumeroEmprendedores())
        );        
        if(Sistema.ferias.size()!=0) tblFerias.getItems().addAll(Sistema.ferias);
    }    
     
    @FXML
    private void regresarFeria(MouseEvent event)throws IOException {
        App.setRoot("/com/mycompany/proyectop2g/MenuFXML");
    }
    
    @FXML
    private void agregarFeria(ActionEvent event) throws IOException{
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/com/mycompany/proyectop2g/datosFeria.fxml"));
        Parent root= loader.load();
        DatosFeriaController controlador= loader.getController();
        controlador.cambiarTitulo("Nueva Feria");
        Scene scene= new Scene(root);
        Stage stage= new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        
}

    @FXML
    private void mostrarDetallesFeria(ActionEvent event) {
        Feria feriaSeleccionada= tblFerias.getSelectionModel().getSelectedItem();
        if (feriaSeleccionada != null){
            Alert alerta= new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Feria "+feriaSeleccionada.getCodigo());
            alerta.setHeaderText("Detalles sobre la Feria "+feriaSeleccionada.getCodigo());
            alerta.setContentText(feriaSeleccionada.toString());
            alerta.showAndWait();
        }else{
            Alert alerta= new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Aviso");
            alerta.setHeaderText("Feria no seleccionada");
            alerta.setContentText("Si desea ver los detalles de una feria, debe seleccionar la feria primero");
            alerta.showAndWait();
        }
        
    }

    @FXML
    private void mostrarDetallesEmprendedor(ActionEvent event) {
        Feria feriaSeleccionada= tblFerias.getSelectionModel().getSelectedItem();
        if(feriaSeleccionada!=null){
            Alert alerta= new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Feria "+feriaSeleccionada.getCodigo());
            alerta.setHeaderText("Detalles sobre los emprendedores de la Feria "+feriaSeleccionada.getCodigo());
            if(feriaSeleccionada.consultarEmprendedores().length()<5){
                alerta.setContentText("No hay emprendedores registrados en la feria");
            }else{
                TextArea textArea = new TextArea(feriaSeleccionada.consultarEmprendedores());
                textArea.setEditable(false);
                textArea.setWrapText(true);
                ScrollPane scrollPane = new ScrollPane(textArea);
                scrollPane.setFitToWidth(true);
                alerta.getDialogPane().setContent(scrollPane);
            }
            alerta.showAndWait();
        }else{
            Alert alerta= new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Aviso");
            alerta.setHeaderText("Feria no seleccionada");
            alerta.setContentText("Si desea ver los detalles de los emprendedores de una feria, debe seleccionar la feria primero");
            alerta.showAndWait();
        }
    }

    @FXML
    private void mostrarDetallesAuspiciante(ActionEvent event) {
        Feria feriaSeleccionada= tblFerias.getSelectionModel().getSelectedItem();
        if(feriaSeleccionada!=null){
            Alert alerta= new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Feria "+feriaSeleccionada.getCodigo());
            alerta.setHeaderText("Detalles sobre los auspiciantes de la Feria "+feriaSeleccionada.getCodigo());
            if(feriaSeleccionada.consultarAuspiciantesEnFeria().length()<5){
                alerta.setContentText("No hay auspiciantes registrados en la feria");
            }else{
                TextArea textArea = new TextArea(feriaSeleccionada.consultarAuspiciantesEnFeria());
                textArea.setEditable(false);
                textArea.setWrapText(true);
                ScrollPane scrollPane = new ScrollPane(textArea);
                scrollPane.setFitToWidth(true);
                alerta.getDialogPane().setContent(scrollPane);
            }
            alerta.showAndWait();
        }else{
            Alert alerta= new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Aviso");
            alerta.setHeaderText("Feria no seleccionada");
            alerta.setContentText("Si desea ver los detalles de los auspiciantes de una feria, debe seleccionar la feria primero");
            alerta.showAndWait();
        }
    }

    @FXML
    private void editarFeria(ActionEvent event) throws Exception{
        Feria feriaSeleccionada= tblFerias.getSelectionModel().getSelectedItem();
        if(feriaSeleccionada!=null){
            FXMLLoader loader= new FXMLLoader(getClass().getResource("/com/mycompany/proyectop2g/datosFeria.fxml"));
            Parent root= loader.load();
            DatosFeriaController controlador= loader.getController();
            boolean aceptar=controlador.initAtributos(feriaSeleccionada); //Recibe un boleano que verifica que se pueda editar la feria
            if(aceptar==true){
                controlador.cambiarTitulo("Editar Feria");
                Scene scene= new Scene(root);
                Stage stage= new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();
            }else{
                Alert alerta= new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Aviso");
                alerta.setHeaderText("La feria esta en progreso o ha finalizado");
                alerta.setContentText("No se pueden editar ferias en progresos o finalizados");
                alerta.showAndWait();
            }
            
        }else{
            Alert alerta= new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Aviso");
            alerta.setHeaderText("Feria no seleccionada");
            alerta.setContentText("Si desea editar los campos de una feria, debe seleccionar la feria primero");
            alerta.showAndWait();
        }
    }
    
    
    @FXML
    private void administrarStands(ActionEvent event) throws IOException {
        Feria feriaSeleccionada= tblFerias.getSelectionModel().getSelectedItem();
        if(feriaSeleccionada!=null){           
            FXMLLoader loader= new FXMLLoader(getClass().getResource("/com/mycompany/proyectop2g/admStand.fxml"));
            Parent root= loader.load();
            AdmStandController controlador= loader.getController();
            controlador.crearStands(feriaSeleccionada);
            Scene scene= new Scene(root);
            Stage stage= new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.showAndWait();
        }else{
            Alert alerta= new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Aviso");
            alerta.setHeaderText("Feria no seleccionada");
            alerta.setContentText("Si desea administrar los stands de una feria, debe seleccionar la feria primero");
            alerta.showAndWait();
        }
        
    }
    
    
}
