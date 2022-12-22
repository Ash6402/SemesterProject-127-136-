package com.example.guipractice;

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
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class SignUpController implements Initializable {
    public TextField fName;
    public TextField lName;
    public TextField userName;
    public TextField email;
    public PasswordField confirmPass;
    public PasswordField pass;
    public Label fnameEL;
    public Label lNameEL;
    public Label emailEL;
    public Label userEL;
    public Label passEL;
    public Label cPassEL;
    public static User user = new User();
    public Label response;
    public Label signUpLabel;

    ArrayList<TextField> fields1 = new ArrayList<>();
    ArrayList<PasswordField> fields2 = new ArrayList<>();
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToLoginPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fields1.add(fName);
        fields1.add(lName);
        fields1.add(userName);
        fields1.add(email);
        fields2.add(pass);
        fields2.add(confirmPass);
        labelTranslation();
    }

    public void fnameValidate() {
        if (fName.getText().length() == 0)
            fnameEL.setText("Cannot be empty");
        else if (fName.getText().contains(" "))
            fnameEL.setText("Cannot contain space");
        else
            fnameEL.setText("");
    }

    public void lnameValidate() {
        if (lName.getText().length() == 0)
            lNameEL.setText("Cannot be empty");
        else if (lName.getText().contains(" "))
            lNameEL.setText("Cannot contain space");
        else
            lNameEL.setText("");
    }

    public void userValidate(){
        if (userName.getText().length() == 0) {
            userEL.setText("Cannot be empty");
            System.out.println("HEllo");
        }
        else if (userName.getText().contains(" ")) {
            userEL.setText("Cannot contain space");
            System.out.println("bye");
        }
        else {
            userEL.setText("");
        }
    }

    public void validateEmail() {
        String emailAddress = email.getText();
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if (!patternMatches(emailAddress, regexPattern)) {
            emailEL.setText("Invalid Email");
        }else{
            emailEL.setText("");
        }
    }

    public void validatePass(){
        if(pass.getText().length() < 8){
            passEL.setText("Password must be 8 characters long");
        }else{
            passEL.setText(" ");
        }
    }

    public void confirmPass(){
        String pass = this.pass.getText();
        if(!confirmPass.getText().equals(pass)){
            cPassEL.setText("Password doesn't match");
        }else{
            cPassEL.setText("");
        }
    }

    public void signUp(){
        int counter1 = 0;
        int counter2 = 0;

        ArrayList<Label> errors = new ArrayList<>();
        errors.add(fnameEL);
        errors.add(lNameEL);
        errors.add(emailEL);
        errors.add(userEL);
        errors.add(passEL);
        errors.add(cPassEL);

        for(Label err: errors) {
            if (err.getText().length() > 1) {
                counter1++;
            }
        }

        for(TextField text : fields1){
            if(text.getText().length() == 0){
                counter2++;
            }
        }

        for(PasswordField text : fields2){
            if(text.getText().length() == 0){
                counter2++;
            }
        }

        if(counter1>0 || counter2 >0){
//            System.out.println("cant signUp");
            response.setText("Invalid Credentials");
        }else{
            user.setfName(fName.getText());
            user.setlName(lName.getText());
            user.setUserName(userName.getText());
            user.setEmail(email.getText());
            user.setPassword(pass.getText());
            response.setText("Signed Up Successfully");
        }
    }


    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
            .matcher(emailAddress)
            .matches();
    }

    public void labelTranslation(){
        TranslateTransition t = new TranslateTransition();
        t.setNode(signUpLabel);
        t.setDuration(Duration.millis(300));
        t.setFromY(-130);
        t.setToY(15);
        t.play();
    }
}
