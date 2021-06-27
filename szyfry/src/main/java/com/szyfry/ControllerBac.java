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
import javafx.stage.Stage;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ControllerBac {

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    TextArea input;
    @FXML
    TextArea output;
    @FXML
    MenuBar menuBarBac;

    
    public void Menu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("App.fxml"));
        stage = (Stage)menuBarBac.getScene().getWindow();
        stage.setTitle("Szyfry");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void Caesar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CesScene.fxml"));
        stage = (Stage)menuBarBac.getScene().getWindow();
        stage.setTitle("Szyfr Cezara");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Vigenere(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("VigScene.fxml"));
        stage = (Stage)menuBarBac.getScene().getWindow();
        stage.setTitle("Szyfr Vigenere");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



    public void BaconEncrypt(ActionEvent e){
        Bacon bac = new Bacon();
        String reg_message = input.getText();

        Pattern pattern = Pattern.compile("[-$%^&*()_+|~=`{}\\[\\]:;'\"<>@#%\\/0-9]");
        Matcher matcher = pattern.matcher(reg_message);
        boolean matchFound = matcher.find();
        if (matchFound){
            JOptionPane.showMessageDialog(null, "Hej, prowadziłeś znaki których nie szyfruję!"); 
        }
        else {
            char[] message = reg_message.toCharArray();
            String cryptogram = String.valueOf(bac.encrypt(message));

            output.setText(cryptogram);
            System.out.println(cryptogram);
        }
        //char[] message = input.toCharArray();
    }

    public void BaconDecrypt(ActionEvent e){ 
        Bacon bac = new Bacon();
        String reg_cryptogram = input.getText();

        Pattern pattern = Pattern.compile("[-$%^&*()_+|~=`{}\\[\\]:;'\"<>@#%\\/0-9]");
        Matcher matcher = pattern.matcher(reg_cryptogram);
        boolean matchFound = matcher.find();
        if (matchFound){
            JOptionPane.showMessageDialog(null, "Hej, prowadziłeś znaki których nie szyfruję!"); 
        }
        else {
            char[] cryptogram = reg_cryptogram.toCharArray();
            String message = String.valueOf(bac.decrypt(cryptogram));

            output.setText(message);
            System.out.println(message);

        }

    }

}
