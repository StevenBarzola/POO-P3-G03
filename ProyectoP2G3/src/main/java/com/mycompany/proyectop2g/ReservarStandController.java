package com.mycompany.proyectop2g;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.evento.*;
import modelo.participante.*;
/**
 * FXML Controller class
 *
 * @author Steven
 */
public class ReservarStandController implements Initializable {


    @FXML
    private TextField txtIDPersona;
    
    private Feria feria;
    private Stand stand;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void iniAtributos(Feria fe, Stand st){
        feria=fe;
        stand=st;
    }
    
    @FXML
    private void reservar(ActionEvent event) {
        Persona per= Sistema.encontrarPersona(txtIDPersona.getText());
        int cont=0;
        if(per!=null && per instanceof Emprendedor){
            Emprendedor emp=(Emprendedor)per;
            cont= feria.limiteStand(emp.getNumId());
            if(cont==0){
                stand.setPersona(emp);
                stand.setFechaAsig(LocalDate.now());
                Alert alerta= new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Aviso");
                alerta.setHeaderText("Stand "+stand.getCodigoSt());
                alerta.setContentText("El stand ha sido reservado con exito");
                alerta.showAndWait();
                feria=null;
                stand=null;
                Stage stage= (Stage) txtIDPersona.getScene().getWindow();
                stage.close();
            }else{
                Alert alerta= new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Aviso");
                alerta.setHeaderText("El emprendedor ya tiene un stand asignado");
                alerta.setContentText("Un emprendedor no puede tener mas de un stand asignado por feria");
                alerta.showAndWait();
            } 
        }else if(per!=null && per instanceof Auspiciante){
            Auspiciante aus=(Auspiciante)per;
            AuspicianteEnFeria anf= feria.encontrarAuspicianteEnFeria(aus);
            cont= feria.limiteStand(anf.getAuspiciante().getNumId());
            if(cont<2){
                    if(anf.getTieneStand()==true){
                        stand.setPersona(aus);
                        stand.setFechaAsig(LocalDate.now());
                        Alert alerta= new Alert(Alert.AlertType.INFORMATION);
                        alerta.setTitle("Aviso");
                        alerta.setHeaderText("Stand "+stand.getCodigoSt());
                        alerta.setContentText("El stand ha sido reservado con exito");
                        alerta.showAndWait();
                        feria=null;
                        stand=null;
                        Stage stage= (Stage) txtIDPersona.getScene().getWindow();
                        stage.close();
                    }else{
                        Alert alerta= new Alert(Alert.AlertType.WARNING);
                        alerta.setTitle("Aviso");
                        alerta.setHeaderText("El auspiciante no debe tener stand");
                        alerta.setContentText("El auspiciante que ingreso no va a requerir el uso de un stand");
                        alerta.showAndWait();
                    } 
            }else{
                Alert alerta= new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Aviso");
                alerta.setHeaderText("El auspiciante ya tiene 2 stands asignados");
                alerta.setContentText("Un auspiciante solo puede tener max 2 stands por feria");
                alerta.showAndWait();
            }
        }else{
            Alert alerta= new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Aviso");
            alerta.setHeaderText("Emprendedor o Auspiciante no encontrado");
            alerta.setContentText("Asegurese que la persona se haya registrado y que el numero de identificacion este escrito correctamente");
            alerta.showAndWait();
        }
    }
    
    
    @FXML
    private void regresar(MouseEvent event) throws IOException{
        feria=null;
        stand=null;
        Stage stage= (Stage) txtIDPersona.getScene().getWindow();
        stage.close();
        //App.setRoot("/com/mycompany/proyectop2g/admStand");
    }

    
    

}
