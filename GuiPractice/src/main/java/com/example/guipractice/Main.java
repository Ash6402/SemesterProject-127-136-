package com.example.guipractice;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginSignUp.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

        Image img = new Image("D:\\Java\\GuiPractice\\okkk-removebg-preview.png");
        stage.getIcons().add(img);
    }

    public static void main(String[] args){
        launch();
    }
}