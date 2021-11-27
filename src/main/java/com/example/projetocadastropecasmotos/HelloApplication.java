package com.example.projetocadastropecasmotos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class HelloApplication extends Application {

    /*
    #1d3557 - Blue dark
    #27436B - Blue lighter
    #ADD8E6 - LightBlue
    #00A8A8 - Other Blue
    #f1faee - white
    #e63946 - Red
    #9370DB - MediumPurple
    #F0FFFF - Azure
    #E6E6FA - Lavender
    #C0C0C0 - Silver
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("cadastro-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("CADASTRO DE PEÇAS DE MOTOS");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}