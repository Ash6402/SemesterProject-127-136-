package com.example.GymCompanion;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Homepage implements Initializable {
    public Label userName;
    public AnchorPane card1;
    public AnchorPane card3;
    public AnchorPane plansParent;
    public TextField heightField;
    public TextField weightField;
    public Label height;
    public Label weight;
    public Label bmi;
    public AnchorPane dashBoard;
    public Button plansBtn;
    public Button boardBtn;
    public TextField cardNumField;
    public AnchorPane cardDetailForm;
    public Label selectedPlanLabel;
    public Button formCloseBtn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        plansParent.setLayoutY(540);
        dashBoard.setOpacity(0);
        heightField.setVisible(false);
        weightField.setVisible(false);
        userName.setText("Ash");
    }

//    --------------------MEMBERSHIP CARD FUNCTIONS---------------------------

    public void activated(MouseEvent e){
        Rectangle tar = (Rectangle) e.getTarget();
        AnchorPane pane = (AnchorPane) tar.getParent();
        AnchorPane parent = (AnchorPane) pane.getParent();
        List<Node> siblings = parent.getChildren();
        if(!pane.getId().equals("activated")){
            pane.setId("activated");
            animationY(pane, -45, 0);
            pane.toFront();
        }

        for(Node i : siblings){
            if(i != pane){
                if(i.getId().equals("activated")) {
                    animationY(i, 0, -45);
                }
                i.setId("");
            }
        }
    }

    public void animationY(Node node, int to, int from){
        TranslateTransition t = new TranslateTransition();
        t.setNode(node);
        t.setDuration(Duration.millis(200));
        t.setFromY(from);
        t.setToY(to);
        t.play();
    }

    public void fadeAnimation(Node node){
        FadeTransition t = new FadeTransition();
        t.setNode(node);
        t.setFromValue(0);
        t.setToValue(1);
        t.play();
    }

    public void planDisplay(){
        if (dashBoard.getId().equals("displayed")) {
            dashBoard.setId("");
            dashBoard.setOpacity(0);
        }
        animationY(plansParent, -272, 0);
        plansParent.setId("displayed");
        plansParent.toFront();
        plansBtn.setId("on");
        boardBtn.setId("");
    }

    public void dashboardDisplay(){
        if (plansParent.getId().equals("displayed")) {
            animationY(plansParent, 0, -272);
            plansParent.setId("");
        }
        fadeAnimation(dashBoard);
        dashBoard.setId("displayed");
        dashBoard.toFront();
        boardBtn.setId("on");
        plansBtn.setId("");
    }

// ---------------------DASHBOARD FUNCTIONS----------------------
    
    public void setHeight() {
        if (!heightField.isVisible()) {
            heightField.setVisible(true);
            heightField.requestFocus();
            weightField.setVisible(false);
            weightField.setText("");
        }else{
            if(heightField.getText().length()>0)
                height.setText(heightField.getText());
            heightField.setText("");
            heightField.setVisible(false);
            calculateBMI();
        }
    }

    public void setWeight(){
        if (!weightField.isVisible()) {
            weightField.setVisible(true);
            weightField.requestFocus();
            heightField.setVisible(false);
            heightField.setText("");
        }else{
            if(weightField.getText().length()>0){
                weight.setText(weightField.getText());
            }
            weightField.setText("");
            weightField.setVisible(false);
            calculateBMI();
        }
    }

    public void calculateBMI(){
        if(height.getText().length() > 0 && weight.getText().length() > 0) {
            double val = Double.parseDouble(weight.getText()) / Math.pow(Double.parseDouble(height.getText()) / 100, 2);
            bmi.setText(String.format("%.2f", val));
        }
    }

    public void openCardForm(ActionEvent event){
        Button btn = (Button) event.getTarget();
        if(btn.getText().contains("Basic"))
            selectedPlanLabel.setText("Basic Plan: $6.99 /month");
        else{
            selectedPlanLabel.setText("Premium Plan: $14.99 /month");
        }
        cardDetailForm.setVisible(true);
        cardDetailForm.toFront();
    }

    public void closeCardForm(){
        cardDetailForm.setVisible(false);
    }
}