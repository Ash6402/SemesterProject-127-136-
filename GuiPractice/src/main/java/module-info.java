module com.example.guipractice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.guipractice to javafx.fxml;
    exports com.example.guipractice;
}