package com.szyfry;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class ControllerApp {

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    MenuBar menuBarApp;
    

    
    public void Caesar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CesScene.fxml"));
        stage = (Stage)menuBarApp.getScene().getWindow();
        stage.setTitle("Szyfr Cezara");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Vigenere(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("VigScene.fxml"));
        stage = (Stage)menuBarApp.getScene().getWindow();
        stage.setTitle("Szyfr Vigenere");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void Bacon(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BacScene.fxml"));
        stage = (Stage)menuBarApp.getScene().getWindow();
        stage.setTitle("Szyfr Bacona");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
