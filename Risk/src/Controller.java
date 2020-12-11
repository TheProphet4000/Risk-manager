import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Controller {

    @FXML
    Button open = new Button();
    @FXML
    Button close = new Button();
    /* Start page */
    @FXML
    void openLog() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ViewRisk.fxml"));
        Stage stage = (Stage) open.getScene().getWindow();
        stage.setScene(new Scene(root));

        try {
            stage.show();
        } catch (Exception e) {
            stage.close();
        }
    }

    /* Close button */
    @FXML
    void close() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ViewRisk.fxml"));
        Stage stage = (Stage) close.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.close();
    }

    /* Delete window */
    @FXML
    void deleteOption() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DeleteRisk.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    /* Create risk window */
    @FXML
    void openCreate() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateRisk.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    /* Open risk window */
    @FXML
    void openView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OpenRisk.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    /* Go from view risk to edit risk */
    @FXML
    void openEditcloseView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EditRisk.fxml"));
        Stage stage = (Stage) open.getScene().getWindow();
        stage.setScene(new Scene(root));

        try {
            stage.show();
        } catch (Exception e) {
            stage.close();
        }
    }

    /* Create risk */
    @FXML
    Button create = new Button();
    @FXML
    VBox vBox = new VBox();
    @FXML
    void createRisk() {
        EventHandler<ActionEvent> open = actionEvent1 -> {
            try {
                openView();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        EventHandler<ActionEvent> Risk = actionEvent1 -> {
            Button risk = new Button("New risk");
            risk.setPrefHeight(27.0);
            risk.setPrefWidth(500.0);
            risk.setLayoutY(62.0);
            risk.setMnemonicParsing(false);
            risk.setStyle("-fx-background-color: whitesmoke;");
            vBox.getChildren().add(risk);
            risk.setOnAction(open);
        };
        create.setOnAction(Risk);
    }
    /* Edit risk */

    /* Delete risk */
    @FXML
    TextField riskname;
    @FXML
    TextArea riskdisc;
    @FXML
    TextField risksev;
    @FXML
    void saverisk() throws IOException {
       // String name = riskname.getText();
        //String disc = riskdisc.getText();
        //int sev = Integer.parseInt(risksev.getText());
        Risk risk = new Risk();
        risk.name = riskname.getText();
        risk.discibtion = riskdisc.getText();
        risk.severity = Integer.parseInt(risksev.getText());
        savetofile(risk);

    }


    void savetofile(Risk risk) throws IOException {
        FileWriter fw = new FileWriter("log.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter output = new PrintWriter(bw);
        output.println(risk.getName());
        output.print(risk.getDiscibtion());
        output.print(risk.getSeverity());
        output.close();
    }

}
