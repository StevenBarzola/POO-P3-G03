/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectop2g;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import modelo.participante.*;
import modelo.evento.*;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class EditarEmpController implements Initializable {

    @FXML
    private TextField cedula;
    @FXML
    private VBox editarEmprendedor;
    @FXML
    private ComboBox<String> campos;
    @FXML
    private GridPane NombrePanel;
    @FXML
    private TextField nombre;
    @FXML
    private GridPane EmailPanel;
    @FXML
    private TextField email;
    @FXML
    private GridPane TelefonoPanel;
    @FXML
    private TextField telefono;
    @FXML
    private GridPane DireccionPanel;
    @FXML
    private TextField direccion;
    @FXML
    private GridPane SitioWebPanel;
    @FXML
    private TextField sitioWeb;
   
    @FXML
    private GridPane NombreRespoPanel;
    @FXML
    private TextField nombreRespo;
    @FXML
    private GridPane RedSocialPanel;
    @FXML
    private CheckBox instagram;
    @FXML
    private CheckBox facebook;
    @FXML
    private CheckBox tiktok;
    @FXML
    private CheckBox twitter;
    @FXML
    private CheckBox youtube;
    @FXML
    private CheckBox linkedln;
    @FXML
    private CheckBox pinterest;
    @FXML
    private Button actualizar;
    @FXML
    private BorderPane segundaVentana;
    @FXML
    private Label redSocial;
    @FXML
    private TextField cuenta;
    @FXML
    private Button guardar;

    private String usuario="Ingrese el usuario de ";
    ArrayList<RedSocial> redesSociales = new ArrayList<>();
    
   
    @FXML
    private GridPane DescripcionPanel;
    
    @FXML
    private TextField descripcion;
    private Emprendedor empEditar;
    @FXML
    private StackPane ventanaPrincipal;
    @FXML
    private ImageView regresar;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        campos.getItems().add("Nombre");
        campos.getItems().add("Nombre P.Responsable");
        campos.getItems().add("Telefono");
        campos.getItems().add("Email");
        campos.getItems().add("Direccion");
        campos.getItems().add("Sitio Web");
        campos.getItems().add("Descripcion servicios");
        campos.getItems().add("Red Social");
        twitter.setOnAction(e -> handleCheckBoxSelection(twitter, "Twitter"));
        facebook.setOnAction(e -> handleCheckBoxSelection(facebook, "Facebook"));
        instagram.setOnAction(e -> handleCheckBoxSelection(instagram, "Instagram"));
        youtube.setOnAction(e -> handleCheckBoxSelection(youtube, "Youtube"));
        tiktok.setOnAction(e -> handleCheckBoxSelection(tiktok, "Tiktok"));
        pinterest.setOnAction(e -> handleCheckBoxSelection(pinterest, "Pinterest"));
        linkedln.setOnAction(e -> handleCheckBoxSelection(linkedln, "Linkedin"));
        cedula.setText(null);
        descripcion.setText(null);
        telefono.setText(null);
        nombre.setText(null);
        nombreRespo.setText(null);
        email.setText(null);
        direccion.setText(null);
        sitioWeb.setText(null);
    
       
    }  
    private void handleCheckBoxSelection(CheckBox checkbox, String c){
        if (checkbox.isSelected()) { infoRedSocial(c); }
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
    private void infoRedSocial(String r){
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
    }
    
    @FXML
    private void admEmprendedor() throws IOException{
        App.setRoot("/com/mycompany/proyectop2g/admEmprendedor");
    }

    @FXML
    private void verificarEmprendedor() {
        if(Emprendedor.verificarCedula(cedula.getText())){
            Persona perEdit = Sistema.encontrarPersona(cedula.getText());
            if(perEdit!=null && perEdit instanceof Emprendedor){
                     empEditar=(Emprendedor)perEdit;
            }
            redesSociales = empEditar.getRedesSociales();
            editarEmprendedor.setVisible(true);
            campos.setOnAction( e -> campoDatos() );
        }else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Usuario no Encontrado");
            alert.setContentText("No se ha encontrado un emprendedor con la cedula ingresada.");
            alert.showAndWait();
        }
    }
    private void campoDatos() {
        NombrePanel.setVisible(false);
        NombreRespoPanel.setVisible(false);
        TelefonoPanel.setVisible(false);
        EmailPanel.setVisible(false);
        DireccionPanel.setVisible(false);
        SitioWebPanel.setVisible(false);
        descripcion.setVisible(false);
        RedSocialPanel.setVisible(false);
        String c = campos.getValue();
        switch(c){
            case "Nombre" :
                NombrePanel.setVisible(true);
                nombre.setText(empEditar.getNombre());
                actualizar.setOnAction(
                        e -> {
                            if (nombre.getText()!=null ){ empEditar.setNombre(nombre.getText()); 
                            try {
                                alertas_informacion();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
}
                            else {  alertas_error(); }
                        }
                );
                break;
            case "Nombre P.Responsable":
                NombreRespoPanel.setVisible(true);
                nombreRespo.setText(empEditar.getNomPerRes());
                actualizar.setOnAction(
                        e -> {
                            if (nombreRespo.getText()!=null ){ empEditar.setNomPerRes(nombreRespo.getText());
                            try {
                                alertas_informacion();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
}
                            else {  alertas_error(); }
                        }
                );
                break;
            case "Telefono":
                TelefonoPanel.setVisible(true);
                telefono.setText(empEditar.getTelefono()+"");
                actualizar.setOnAction(
                        e -> {
                            if (telefono.getText()!=null ){ 
                                int telf = Integer.parseInt(telefono.getText()); empEditar.setTelefono(telf);
                                try {
                                    alertas_informacion();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
}
                            else {  alertas_error(); }
                        }
                );
                break;
            case "Email":
                EmailPanel.setVisible(true);
                email.setText(empEditar.getEmail());
                actualizar.setOnAction(
                        e -> {
                            if (email.getText()!=null ){ empEditar.setEmail(email.getText());
                            try {
                                alertas_informacion();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
}
                            else {  alertas_error(); }
                        }
                );
                break;
            case "Direccion":
                DireccionPanel.setVisible(true);
                direccion.setText(empEditar.getDireccion());
                actualizar.setOnAction(
                        e -> {
                            if (direccion.getText()!=null ){ empEditar.setDireccion(direccion.getText()); 
                            try {
                                alertas_informacion();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
}
                            else {  alertas_error(); }
                        }
                );
                break;
            case "Sitio Web":
                SitioWebPanel.setVisible(true);
                sitioWeb.setText(empEditar.getSitioWeb());
                actualizar.setOnAction(
                        e -> {
                            if (sitioWeb.getText()!=null ){ empEditar.setSitioWeb(sitioWeb.getText()); 
                            try {
                                alertas_informacion();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
}
                            else {  alertas_error(); }
                        }
                );
                break;
            case "Descripcion Servicios":
                DireccionPanel.setVisible(true);
                direccion.setText(empEditar.getDireccion());
                actualizar.setOnAction(
                        e -> {
                            if (direccion.getText()!=null ){ empEditar.setDireccion(direccion.getText()); 
                            try {
                                alertas_informacion();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
}
                            else {  alertas_error(); }
                        }
                );
                break;
            case "Red Social":
                RedSocialPanel.setVisible(true);
                for(RedSocial r:redesSociales){
                    if(r.getAppSocial().equals(AppSocial.FACEBOOK)){ facebook.setSelected(true); }
                    if(r.getAppSocial().equals(AppSocial.TWITTER)) { twitter.setSelected(true);}
                    if(r.getAppSocial().equals(AppSocial.PINTEREST)) { pinterest.setSelected(true); }
                    if(r.getAppSocial().equals(AppSocial.LINKEDIN)) { linkedln.setSelected(true);}
                    if(r.getAppSocial().equals(AppSocial.YOUTUBE)) { youtube.setSelected(true);}
                    if(r.getAppSocial().equals(AppSocial.INSTAGRAM)) { instagram.setSelected(true);}
                    if(r.getAppSocial().equals(AppSocial.TIKTOK)) { tiktok.setSelected(true);}
                }
                actualizar.setOnAction(
                        e -> {
                            if (!redesSociales.isEmpty()){ empEditar.setRedesSociales(redesSociales); 
                                try {
                                alertas_informacion();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
}
                            else {  alertas_error(); } 
                        }
                );
                break;
        }
    }
    private void alertas_error(){
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText("Label Vacio");
        alert.setContentText("El label está vacio");
        alert.showAndWait();
    }
    private void alertas_informacion() throws IOException{
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Datos Actualizados");
        alert.setContentText("Sus datos fueron actualizados correctamente. ¿Deseas seguir editando");
        alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.NO){
                App.setRoot("admEmprendedor");
            } else {
               alert.close();
            }
    } 
}
