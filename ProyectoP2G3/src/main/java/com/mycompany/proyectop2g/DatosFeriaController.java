package com.mycompany.proyectop2g;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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
    
    private Feria feria;

    @FXML
    private Label lblTituloFeria;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }    
    
    public boolean initAtributos(Feria fe) throws IOException{
        feria=fe;
        txtNombre.setText(feria.getNombre());
        txtDescripcion.setText(feria.getDescripcion());
        txtLugar.setText(feria.getLugar());
        dateFechaInicio.setValue(feria.getFechaI());
        dateFechaFin.setValue(feria.getFechaF());
        txtHorario.setText(feria.getHorario());
        txtNStand1.setText(String.valueOf(feria.getSeccionesStand()[0].getCanStand()));
        txtNStand2.setText(String.valueOf(feria.getSeccionesStand()[1].getCanStand()));
        txtNStand3.setText(String.valueOf(feria.getSeccionesStand()[2].getCanStand()));         
        txtNStand4.setText(String.valueOf(feria.getSeccionesStand()[3].getCanStand()));
        if(LocalDate.now().isAfter(feria.getFechaI())){ //Valida si la feria ha finalizado 
            feria=null;
            App.setRoot("/com/mycompany/proyectop2g/admFeria");
            return false;
        }
        return true;
    }
    
    @FXML
    private void guardarFeria(ActionEvent event) throws IOException {
        if(feria==null){ //Nueva feria
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
                App.setRoot("/com/mycompany/proyectop2g/admFeria");
                Stage stage= (Stage) txtNombre.getScene().getWindow();
                stage.close();
            }catch(Exception e){
                Alert alerta= new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Aviso");
                alerta.setHeaderText("Error en los datos ingresados");
                alerta.setContentText("Los datos ingresados son inválidos. Por favor, revise que todo este correcto");
                alerta.showAndWait();
            }
        }else{ //Edicion de feria
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
                
                if(nStand1!=feria.getSeccionesStand()[0].getCanStand() || nStand2!=feria.getSeccionesStand()[1].getCanStand()||
                nStand3!=feria.getSeccionesStand()[2].getCanStand() || nStand4!=feria.getSeccionesStand()[3].getCanStand()){
                    Alert alerta= new Alert(Alert.AlertType.CONFIRMATION.WARNING);
                    alerta.setTitle("Aviso");
                    alerta.setHeaderText("Va a cambiar el numero de stand de una o mas secciones");
                    alerta.setContentText("Se perderan las asignaciones de los stands en dichas secciones. ¿Desea continuar?");
                    ButtonType botonSi = new ButtonType("Sí");
                    ButtonType botonNo = new ButtonType("No");
                    alerta.getButtonTypes().setAll(botonSi, botonNo);
                    alerta.showAndWait().ifPresent(response -> {
                    if (response == botonSi) {
                        if(nStand1!=feria.getSeccionesStand()[0].getCanStand()){
                            feria.editarSeccion1(nStand1);
                        }
                        if(nStand2!=feria.getSeccionesStand()[1].getCanStand()){
                            feria.editarSeccion2(nStand2);
                        }
                        if(nStand3!=feria.getSeccionesStand()[2].getCanStand()){
                            feria.editarSeccion3(nStand3);
                        }
                        if(nStand4!=feria.getSeccionesStand()[3].getCanStand()){
                            feria.editarSeccion4(nStand4);
                        }
                        feria.setNombre(nombre);
                        feria.setDescripcion(descripcion);
                        feria.setLugar(lugar);
                        feria.setFechaI(fechaInicio);
                        feria.setFechaF(fechaFin);
                        feria.setHorario(horario);
                        Alert alerta2= new Alert(Alert.AlertType.INFORMATION);
                        alerta2.setTitle("Aviso");
                        alerta2.setHeaderText("Acerca de la feria");
                        alerta2.setContentText("La feria ha sido actualizada exitosamente");
                        alerta2.showAndWait();
                        try{
                            App.setRoot("/com/mycompany/proyectop2g/admFeria");
                            Stage stage= (Stage) txtNombre.getScene().getWindow();
                            stage.close();
                        }catch(IOException ex) {
                            System.out.println("Error al cambiar de ventana:");
                        }
                    }else if(response == botonNo) {
                        txtNStand1.setText(String.valueOf(feria.getSeccionesStand()[0].getCanStand()));
                        txtNStand2.setText(String.valueOf(feria.getSeccionesStand()[1].getCanStand()));
                        txtNStand3.setText(String.valueOf(feria.getSeccionesStand()[2].getCanStand()));         
                        txtNStand4.setText(String.valueOf(feria.getSeccionesStand()[3].getCanStand()));
                        alerta.close();
                    }
                    });
                }else{
                    feria.setNombre(nombre);
                    feria.setDescripcion(descripcion);
                    feria.setLugar(lugar);
                    feria.setFechaI(fechaInicio);
                    feria.setFechaF(fechaFin);
                    feria.setHorario(horario);
                    Alert alerta2= new Alert(Alert.AlertType.INFORMATION);
                    alerta2.setTitle("Aviso");
                    alerta2.setHeaderText("Acerca de la feria");
                    alerta2.setContentText("La feria ha sido actualizada exitosamente");
                    alerta2.showAndWait();
                    App.setRoot("/com/mycompany/proyectop2g/admFeria");
                    Stage stage= (Stage) txtNombre.getScene().getWindow();
                    stage.close();
                }
                
                
            }catch(Exception e){
                Alert alerta= new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Aviso");
                alerta.setHeaderText("Error en los datos ingresados");
                alerta.setContentText("Los datos ingresados son inválidos. Por favor, revise que todo este correcto");
                alerta.showAndWait();
            }
        }
       
       
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
    private void regresar(MouseEvent event) throws IOException{
        feria=null;
        App.setRoot("/com/mycompany/proyectop2g/admFeria");
        Stage stage= (Stage) txtNombre.getScene().getWindow();
        stage.close();
    }
    
    public Feria getFeria(){
        return feria;
    }
    
    public void cambiarTitulo(String texto){
        lblTituloFeria.setText(texto);
    }

   
    
}
