/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.projetocadastropecasmotos;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Rogerio Krychak & Adelton Altair
 */
public class CadastroController implements Initializable {

    @FXML
    private TextField Id;
    @FXML
    private TextField Nome;
    @FXML
    private TextField Quantidade;
    @FXML
    private TextField Data;
    @FXML
    private TextField Descricao;
    @FXML
    private TextField Pesquisa;

    @FXML
    private TableView<Pecas> tvPecas;
    @FXML
    private TableColumn<Pecas, Integer> colId;
    @FXML
    private TableColumn<Pecas, String> colNome;
    @FXML
    private TableColumn<Pecas, String> colQuantidade;
    @FXML
    private TableColumn<Pecas, String> colData;
    @FXML
    private TableColumn<Pecas, String> colDescricao;

    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnSelect;

    @FXML
    private void handleButtonAction(ActionEvent event) {

        if(event.getSource() == btnInsert){
            insertRecord();
        }else if (event.getSource() == btnUpdate){
            updateRecord();
        }else if (event.getSource() == btnDelete){
            deleteButton();
        }else if (event.getSource() == btnSelect){
            selectButton();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showPecas();
    }

    public Connection getConnection(){
        Connection conn;
        try{
           //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/motos", "root","");
            //conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ADELTON\\Documents\\motos.db");
            conn = DriverManager.getConnection("jdbc:sqlite:/home/rogerio/Documentos/motos.db");
            return conn;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }

    }

    public ObservableList<Pecas> getPecasList(){
        ObservableList<Pecas> pecasList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM pecas";
        Statement st;
        ResultSet rs;

        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Pecas pecas;
            while(rs.next()){
                pecas = new Pecas(rs.getInt("id"), rs.getString("nome"), rs.getString("quantidade"), rs.getString("data"),rs.getString("descricao"));
                pecasList.add(pecas);
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return pecasList;
    }

    public void showPecas(){
        ObservableList<Pecas> list = getPecasList();

        colId.setCellValueFactory(new PropertyValueFactory<Pecas, Integer>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<Pecas, String>("nome"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory<Pecas, String>("quantidade"));
        colData.setCellValueFactory(new PropertyValueFactory<Pecas, String>("data"));
        colDescricao.setCellValueFactory(new PropertyValueFactory<Pecas, String>("descricao"));


        tvPecas.setItems(list);
    }
    private void insertRecord(){
        //"INSERT INTO FILMES (nome, autor, diretor, data_lancamento) VALUES (?, ?, ?, ?)";
        //String query = "INSERT INTO pecas (" + Nome.getText() + ",'" + Quantidade.getText() + "','" + Data.getText() + "',+ Descricao.getText() + ") VALUES (?, ?, ?, ?)";
        String query = "INSERT INTO pecas (id,nome,quantidade,data,descricao ) VALUES ('"+Id.getText()+"', '"+Nome.getText()+"', '"+Quantidade.getText()+"', '"+Data.getText()+"', '"+Descricao.getText()+"')";
        System.out.println(query);
        executeQuery(query);
        showPecas();
    }
    /*private void updateRecord(){
       String query = 'UPDATE pecas SET nome = ' + Nome.getText() + ', quantidade = ' + Quantidade.getText() + ', data =  +
            Data.getText() + ', descricao = ' + Descricao.getText() + ' WHERE id = ' + Id.getText() + "";
       executeQuery(query);
        showPecas();
        //String query = "UPDATE pecas SET (nome, quantidade, data, descricao) VALUES ('"+Id.getText()+"', '"+Nome.getText()+"', '"+Quantidade.getText()+"', '"+Data.getText()+"', '"+Descricao.getText()+"') WHERE id ('"+ Id.getText() + "")";

    }*/
    private void updateRecord(){
        String query = "UPDATE  pecas SET nome  = '" + Nome.getText() + "', quantidade = '" + Quantidade.getText() + "', data = '"+
                Data.getText() + "', descricao = '" + Descricao.getText() + "' WHERE id = " + Id.getText();
        System.out.println(query);
        executeQuery(query);
        showPecas();
    }

    private void deleteButton(){
        String query = "DELETE FROM pecas WHERE id = " + Id.getText() + "";
        System.out.println(query);
        executeQuery(query);
        showPecas();
    }

    private void selectButton(){
        String query = "SELECT * FROM pecas WHERE nome = " + Nome.getText() + "";
        System.out.println(query);
        executeQuery(query);
        showPecas();
    }


    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception var5){
            var5.printStackTrace();
        }
    }


}
