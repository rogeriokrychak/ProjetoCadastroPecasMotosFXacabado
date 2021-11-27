module com.example.projetocadastropecasmotos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;



    opens com.example.projetocadastropecasmotos to javafx.fxml;
    exports com.example.projetocadastropecasmotos;
}