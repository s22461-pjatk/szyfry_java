package com.szyfry;

import java.io.IOException;
import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ControllerVig {

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    TextArea input;
    @FXML
    TextArea output;
    @FXML
    MenuBar menuBarVig;
    @FXML
    TextField keyfield;



    public void Menu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("App.fxml"));
        stage = (Stage)menuBarVig.getScene().getWindow();
        stage.setTitle("Szyfry");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }    
 
    public void Caesar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CesScene.fxml"));
        stage = (Stage)menuBarVig.getScene().getWindow();
        stage.setTitle("Szyfr Cezara");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Bacon(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BacScene.fxml"));
        stage = (Stage)menuBarVig.getScene().getWindow();
        stage.setTitle("Szyfr Bacona");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    public void VigenereEncrypt(ActionEvent e){
        Vigenere vig = new Vigenere();
        String reg_message = input.getText();
        String reg_key = keyfield.getText();
        
        try {
            Pattern pattern = Pattern.compile("[-$%^&*()_+|~=`{}\\[\\]:;'\"<>@#%\\/0-9]");
            Matcher matcher = pattern.matcher(reg_message);
            Matcher key_matcher = pattern.matcher(reg_key);
            boolean matchFound = matcher.find();
            boolean key_matchFound = key_matcher.find();

            if (matchFound | key_matchFound){
                JOptionPane.showMessageDialog(null, "Hej, prowadziłeś znaki których nie szyfruję!");
                return;  
            }
            else {
                char[] message = reg_message.toCharArray();
                char[] key = reg_key.toCharArray();
                String cryptogram = String.valueOf(vig.encrypt(message, key));

                output.setText(cryptogram);
            }
        } catch(Exception eCE) {
            JOptionPane.showMessageDialog(null, "Hej, nie podałeś klucza!");
        }

    }
    
    public void VigenereDecrypt(ActionEvent e){
        Vigenere vig = new Vigenere();
        String reg_cryptogram = input.getText();
        String reg_key = keyfield.getText();
        
        try {
            Pattern pattern = Pattern.compile("[-$%^&*()_+|~=`{}\\[\\]:;'\"<>@#%\\/0-9]");
            Matcher matcher = pattern.matcher(reg_cryptogram);
            Matcher key_matcher = pattern.matcher(reg_key);
            boolean matchFound = matcher.find();
            boolean key_matchFound = key_matcher.find();

            if (matchFound | key_matchFound){
                JOptionPane.showMessageDialog(null, "Hej, prowadziłeś znaki których nie szyfruję!"); 
            }
            else {
                char[] cryptogram = reg_cryptogram.toCharArray();
                char[] key = reg_key.toCharArray();
                String message = String.valueOf(vig.decrypt(cryptogram, key));

            output.setText(message);
            }
        } catch(Exception eCE) {
                JOptionPane.showMessageDialog(null, "Hej, nie podałeś klucza!");
            }
            
 
    }

}
