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
public class EditarAuspiController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private BorderPane segundaVentana; 
    @FXML
    private Label redSocial;
    @FXML
    private CheckBox twitter;
    @FXML
    private CheckBox facebook;
    @FXML
    private CheckBox instagram;
    @FXML
    private CheckBox youtube;
    @FXML
    private CheckBox tiktok;
    @FXML
    private CheckBox pinterest;
    @FXML
    private CheckBox linkedln;
    @FXML
    private TextField cuenta;
    @FXML
    private Button guardar;
    @FXML
    private TextField cedula;
    @FXML
    private VBox editarAuspiciante;
    @FXML
    private ComboBox<String> campos;
    @FXML
    private GridPane NombrePanel;
    @FXML
    private GridPane NombreRespoPanel;
    @FXML
    private GridPane TelefonoPanel;
    @FXML
    private GridPane EmailPanel;
    @FXML
    private GridPane DireccionPanel;
    @FXML
    private GridPane SitioWebPanel;
    @FXML
    private GridPane SectorCubiertoPanel;
    @FXML
    private GridPane RedSocialPanel;
    @FXML
    private Button actualizar;
    @FXML
    private TextField nombre;
    @FXML
    private TextField telefono;
    @FXML
    private TextField email;
    @FXML
    private TextField nombreRespo;
    @FXML
    private TextField direccion;
    @FXML
    private TextField sitioWeb;
    private Auspiciante auspiEditar;
    @FXML
    private ComboBox<SectorCubierto> sectoresCubiertos;
    private String usuario="Ingrese el usuario de ";
    ArrayList<RedSocial> redesSociales = new ArrayList<>();
   
    @FXML
    private StackPane ventanaPrincipal;
    @FXML
    private ImageView regresar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sectoresCubiertos.getItems().setAll(SectorCubierto.values());
        campos.getItems().add("Nombre");
        campos.getItems().add("Nombre P.Responsable");
        campos.getItems().add("Telefono");
        campos.getItems().add("Email");
        campos.getItems().add("Direccion");
        campos.getItems().add("Sitio Web");
        campos.getItems().add("Sector Cubierto");
        campos.getItems().add("Red Social");
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
    private void admAuspiciante() throws IOException{
        App.setRoot("/com/mycompany/proyectop2g/admAuspiciante");
    }
    
    @FXML
    private void verificarAuspiciante(){
        if(Auspiciante.verificarCedula(cedula.getText())){
            Persona perEdit = Sistema.encontrarPersona(cedula.getText());
            if(perEdit!=null && perEdit instanceof Auspiciante){
                     auspiEditar=(Auspiciante)perEdit;
            }
            redesSociales = auspiEditar.getRedesSociales();
            editarAuspiciante.setVisible(true);
            campos.setOnAction( e -> campoDatos() );
        }else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Usuario no Encontrado");
            alert.setContentText("No se ha encontrado un auspiciante con la cedula ingresada.");
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
        SectorCubiertoPanel.setVisible(false);
        RedSocialPanel.setVisible(false);
        String casos = campos.getValue();
        switch(casos){
            case "Nombre" :
                NombrePanel.setVisible(true);
                nombre.setText(auspiEditar.getNombre());
                actualizar.setOnAction(
                        e -> {
                            if (nombre.getText()!=null ){ auspiEditar.setNombre(nombre.getText()); 
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
                nombreRespo.setText(auspiEditar.getNomPerRes());
                actualizar.setOnAction(
                        e -> {
                            if (nombreRespo.getText()!=null ){ auspiEditar.setNomPerRes(nombreRespo.getText());
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
                telefono.setText(auspiEditar.getTelefono()+"");
                actualizar.setOnAction(
                        e -> {
                            if (telefono.getText()!=null ){ 
                                int telf = Integer.parseInt(telefono.getText()); auspiEditar.setTelefono(telf);
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
                email.setText(auspiEditar.getEmail());
                actualizar.setOnAction(
                        e -> {
                            if (email.getText()!=null ){ auspiEditar.setEmail(email.getText());
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
                direccion.setText(auspiEditar.getDireccion());
                actualizar.setOnAction(
                        e -> {
                            if (direccion.getText()!=null ){ auspiEditar.setDireccion(direccion.getText()); 
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
                sitioWeb.setText(auspiEditar.getSitioWeb());
                actualizar.setOnAction(
                        e -> {
                            if (sitioWeb.getText()!=null ){ auspiEditar.setSitioWeb(sitioWeb.getText()); 
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
            case "Sector Cubierto":
                SectorCubiertoPanel.setVisible(true);
                actualizar.setOnAction(
                        e -> {
                            if (sectoresCubiertos.getValue()!=null ){ auspiEditar.setSectorCubierto(sectoresCubiertos.getValue()); 
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
                            if (!redesSociales.isEmpty()){ auspiEditar.setRedesSociales(redesSociales); 
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
                App.setRoot("admAuspiciante");
            } else {
               alert.close();
            }
    }
}
