package com.example.GymCompanion;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public TextField userField;
    public Label userError;
    public PasswordField passField;
    public Label passError;
    public Label response;
    public Label loginLabel;
    private Stage stage;
    private Scene scene;
    private Parent root;

    private final User user = SignUpController.user;

    public void switchToSignUpPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signUp.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void login(ActionEvent event) throws IOException{
        if(userField.getText().equals("ash") && passField.getText().equals("11")){
            response.setText("Logged in Successfully");
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Homepage.fxml")));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            response.setText("Invalid Credentials");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelTranslation();
    }

    public void labelTranslation(){
        TranslateTransition t = new TranslateTransition();
        t.setNode(loginLabel);
        t.setDuration(Duration.millis(300));
        t.setFromY(-130);
        t.setToY(15);
        t.play();
    }

}
