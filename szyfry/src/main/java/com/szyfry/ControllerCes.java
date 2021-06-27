package com.szyfry;

import java.io.IOException;
import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ControllerCes {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private int shift = 3;
    
    @FXML
    TextArea input;
    @FXML
    TextArea output;
    @FXML
    MenuBar menuBarCes;
    @FXML
    TextField shifter;

    

    
    public void Menu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("App.fxml"));
        stage = (Stage)menuBarCes.getScene().getWindow();
        stage.setTitle("Szyfry");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Vigenere(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("VigScene.fxml"));
        stage = (Stage)menuBarCes.getScene().getWindow();
        stage.setTitle("Szyfr Vigenere");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void Bacon(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BacScene.fxml"));
        stage = (Stage)menuBarCes.getScene().getWindow();
        stage.setTitle("Szyfr Bacona");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void CaesarEncrypt(ActionEvent e){
        Caesar cae = new Caesar();
        String reg_message = input.getText();
        try {
            shift = Integer.parseInt(shifter.getText());
            }   catch(Exception eCE) {
            eCE.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hej, przesunięcie musi być liczbą całkowitą!");
        }
        Pattern pattern = Pattern.compile("[-$%^&*()_+|~=`{}\\[\\]:;'\"<>@#%\\/0-9]");
        Matcher matcher = pattern.matcher(reg_message);
        boolean matchFound = matcher.find();
        if (matchFound){
             
            System.out.println("w");
        }
        else {
            char[] message = reg_message.toCharArray();
            String cryptogram = String.valueOf(cae.encrypt(message, shift));

            output.setText(cryptogram);
            System.out.println(cryptogram);

        }
    }


    public void CaesarDecrypt(ActionEvent e){
        Caesar cae = new Caesar();
        String reg_cryptogram = input.getText();

        try {
            shift = Integer.parseInt(shifter.getText());
            }  catch(Exception eCE) {
            eCE.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hej, przesunięcie musi być liczbą całkowitą!");
        }

        Pattern pattern = Pattern.compile("[-$%^&*()_+|~=`{}\\[\\]:;'\"<>@#%\\/0-9]");
        Matcher matcher = pattern.matcher(reg_cryptogram);
        boolean matchFound = matcher.find();
        if (matchFound){
            JOptionPane.showMessageDialog(null, "Hej, prowadziłeś znaki których nie szyfruję!"); 
        }
        else {
            char[] cryptogram = reg_cryptogram.toCharArray();
            String message = String.valueOf(cae.decrypt(cryptogram, shift));

            output.setText(message);
            System.out.println(message);

        }

    }

}
