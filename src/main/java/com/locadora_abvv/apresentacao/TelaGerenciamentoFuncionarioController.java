package com.locadora_abvv.apresentacao;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaGerenciamentoFuncionarioController {
    FXMLLoader fxmlLoader = new FXMLLoader();

    @FXML
    private Button addButton;

    @FXML
    private Button attButton;

    @FXML
    private Button buscarBtn;

    @FXML
    private Button removerBtn;

    @FXML
    private Button voltarBtn;

    @FXML
    void addBtnClicked(ActionEvent event) {

    }

    @FXML
    void attBtnClicked(ActionEvent event) {

    }

    @FXML
    void buscarBtnClicked(ActionEvent event) {

    }

    @FXML
    void removerBtnClicked(ActionEvent event) {

    }

    @FXML
    void voltarBtnClicked(ActionEvent event) throws IOException {

        Parent tela = fxmlLoader.load(getClass().getResource("TelaAdm.fxml"));

        Stage novaJanela = (Stage) voltarBtn.getScene().getWindow();
        novaJanela.setScene(new Scene(tela));
    }

}
