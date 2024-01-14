module com.mycompany.proyectop2g {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.proyectop2g to javafx.fxml;
    exports com.mycompany.proyectop2g; 
    opens modelo.evento to javafx.base;
    opens modelo.participante to javafx.base;
}    
