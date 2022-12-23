module com.example.guipractice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.GymCompanion to javafx.fxml;
    exports com.example.GymCompanion;
}