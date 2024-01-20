                                                                                                                    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */                                                                                                                                                         
package com.mycompany.proyectop2g;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import java.util.Optional;
import modelo.participante.*;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import modelo.evento.*;
/**
 * FXML Controller class
 *
 * @author USER
 */
public class AgregarEmpController implements Initializable {


    @FXML
    private Button CrearEmprendedor;
    @FXML
    private TextField cedula;
    @FXML
    private TextField nombreRespo;
    @FXML
    private TextField telefono;
    @FXML
    private TextField nombre;
    @FXML
    private TextField direccion;
    @FXML
    private TextField sitioWeb;
    @FXML
    private TextField descripcion;
    @FXML
    private CheckBox twitter;
    @FXML
    private CheckBox instagram;
    @FXML
    private CheckBox facebook;
    @FXML
    private CheckBox tiktok;
    @FXML
    private TextField email;
    @FXML
    private CheckBox youtube;
    @FXML
    private CheckBox linkedln;
    @FXML
    private CheckBox pinterest;
    @FXML
    private BorderPane segundaVentana;
    @FXML
    private Label redSocial;
    @FXML
    private TextField cuenta;
    @FXML
    private Button guardar;
    @FXML
    private ImageView cerrarVentana;
    
     private String usuario="Ingrese el usuario de ";
    ArrayList<RedSocial> redesSociales = new ArrayList<>();
    @FXML
    private ImageView regresar;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        twitter.setOnAction(e -> handleCheckBoxSelection(twitter, "Twitter"));
        facebook.setOnAction(e -> handleCheckBoxSelection(facebook, "Facebook"));
        instagram.setOnAction(e -> handleCheckBoxSelection(instagram, "Instagram"));
        youtube.setOnAction(e -> handleCheckBoxSelection(youtube, "Youtube"));
        tiktok.setOnAction(e -> handleCheckBoxSelection(tiktok, "Tiktok"));
        pinterest.setOnAction(e -> handleCheckBoxSelection(pinterest, "Pinterest"));
        linkedln.setOnAction(e -> handleCheckBoxSelection(linkedln, "Linkedin"));
        cedula.setText(null);
        telefono.setText(null);
        nombre.setText(null);
        nombreRespo.setText(null);
        email.setText(null);
        direccion.setText(null);
        sitioWeb.setText(null);
        descripcion.setText(null);
        CrearEmprendedor.setOnAction(e -> {
            try {
                guardarEmprendedor();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }        
    @FXML
    private void admEmprendedor() throws IOException{
        App.setRoot("/com/mycompany/proyectop2g/admEmprendedor");
    }

    private void handleCheckBoxSelection(CheckBox checkbox, String c){
        if (checkbox.isSelected()) { infoRedSocial(checkbox,c); }
        else { 
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Eliminar una red Social");
            alert.setContentText("¿Estás seguro que quieres eliminar "+c+" ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                redesSociales.removeIf(rs -> rs.getAppSocial().equals(AppSocial.valueOf(c.toUpperCase())));
                alert.close();
                checkbox.setSelected(false);
            } else {
               checkbox.setSelected(true);
               alert.close();
            }
        }
    }
    private void infoRedSocial(CheckBox ch, String r){
        segundaVentana.setVisible(true);
        cuenta.setText(null);
        redSocial.setText(null);
        redSocial.setText(usuario+r+" :");
        guardar.setOnAction(
                e -> {
                    if(cuenta.getText()== null){
                        Alert alert = new Alert(AlertType.WARNING);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText("Label Vacio");
                        alert.setContentText("Debes escribir tu cuenta de usuario!");
                        alert.showAndWait();
                    } else{
                        String c = cuenta.getText();
                        RedSocial rs1 = new RedSocial(AppSocial.valueOf(r.toUpperCase() ), c);
                        redesSociales.add(rs1);
                        segundaVentana.setVisible(false);
                    }  
                }
        ); 
        cerrarVentana.setOnMouseClicked(e -> {segundaVentana.setVisible(false); ch.setSelected(false);});
    }
    
    @FXML
    private void guardarEmprendedor() throws IOException{
            if (!Sistema.verificarCedula(cedula.getText())){
            if(cedula.getText()!= null && telefono.getText()!= null && email.getText()!=null 
               && nombreRespo.getText()!=null && nombre.getText()!=null && descripcion.getText()!=null && !redesSociales.isEmpty()){
                try{
                    int telef = Integer.parseInt(telefono.getText());
                    Emprendedor e = new Emprendedor(cedula.getText(),nombre.getText(), telef,email.getText(),nombreRespo.getText(),
                        direccion.getText(), sitioWeb.getText(), redesSociales, descripcion.getText() );
                    Sistema.emprendedores.add(e);
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Emprendedor");
                    alert.setContentText("Hola "+nombre.getText()+" su emprendimiento fue registrado correctamente.");
                    alert.showAndWait();
                    admEmprendedor();
                }catch(Exception e){
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("Error en los datos");
                    alert.setContentText("Los datos ingresados son invalidos");
                    alert.showAndWait();
                }
            }else{
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Label vacio");
                alert.setContentText("Complete todos los label requeridos");
                alert.showAndWait();
            }
        }else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Label Cedula");
            alert.setContentText("Cedula ya existente");
            alert.showAndWait();
        }
    }


}
