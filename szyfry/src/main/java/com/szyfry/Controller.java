package com.szyfry;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    TextArea input;
    
    public void Caesar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CesScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Vigenere(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("VigScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void Bacon(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BacScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void CaesarEncrypt(ActionEvent e){
        Caesar cae = new Caesar();
        String message = input.getText();
        System.out.println(message);
        //char[] message = input.toCharArray();
    }


    public void VigenereEncrypt(ActionEvent e){
        Vigenere vig = new Vigenere();
        String message = input.getText();
        System.out.println(message);

        //char[] message = input.toCharArray();
        //char[] key = "abc".toCharArray();
    }


    public void BaconEncrypt(ActionEvent e){
        Bacon bac = new Bacon();
        String message = input.getText();
        System.out.println(message);

        //char[] message = input.toCharArray();
    }


    public void CaesarDecrypt(ActionEvent e){
        Caesar cae = new Caesar();
        String cryptogram = input.getText();
        System.out.println(cryptogram);

        //char[] cryptogram = "qwerty".toCharArray();
    }

    
    public void VigenereDecrypt(ActionEvent e){
        Vigenere vig = new Vigenere();
        String cryptogram = input.getText();
        System.out.println(cryptogram);
        
        //char[] cryptogram = "qwerty".toCharArray();
        //char[] key = "abc".toCharArray();
    }


    public void BaconDecrypt(ActionEvent e){ 
        Bacon bac = new Bacon();
        String cryptogram = input.getText();
        System.out.println(cryptogram);

        //char[] cryptogram = "qwerty".toCharArray();
    }

}
