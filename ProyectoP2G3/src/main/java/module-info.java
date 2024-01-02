module com.mycompany.proyectop2g3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.proyectop2g3 to javafx.fxml;
    exports com.mycompany.proyectop2g3;
}
