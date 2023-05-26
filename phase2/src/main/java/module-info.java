module com.example.phase2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;


    opens com.example.phase2 to javafx.fxml;
    exports com.example.phase2;
}