package com.example.guipractice;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SceneController implements Initializable {
    public AnchorPane parent;
    public AnchorPane introPane;
    public Button loginBtn;
    public Button signUpBtn;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void switchToLoginPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSignUpPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signUp.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        introFade();
    }

    public void introFade(){
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(500));
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.setDelay(Duration.millis(4000));
        fade.setCycleCount(1);
        fade.setNode(introPane);
        fade.play();
        fade.setOnFinished(e-> remove());
    }

//    public void slideAndFadeIn(int offset, int duration, int delay,  Node node ){
//        FadeTransition fade = new FadeTransition();
//        TranslateTransition slide = new TranslateTransition();
//        slide.setByX(offset);
//        fade.setDuration(Duration.millis(duration));
//        fade.setFromValue(0);
//        fade.setToValue(1);
//        slide.setDelay(Duration.millis(delay));
//        fade.setDelay(Duration.millis(delay));
//        slide.setNode(node);
//        fade.setNode(node);
//        slide.play();
//        fade.play();
//    }
//
//    public void slideAndFadeOut(int offset, int duration, int delay, Node node){
//        FadeTransition fade = new FadeTransition();
//        TranslateTransition slide = new TranslateTransition();
//        fade.setFromValue(1);
//        fade.setToValue(0);
//        slide.setByX(offset);
//        fade.setDuration(Duration.millis(duration));
//        slide.setNode(node);
//        fade.setNode(node);
//        slide.setDelay(Duration.millis(delay));
//        fade.play();
//        slide.play();
//    }

    public void remove(){
        parent.getChildren().remove(introPane);
    }
}