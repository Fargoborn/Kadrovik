package kadr.v1.fxapp.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Button orders_comm;
    private Button file_choose_ord_k;
    public void click_orders_comm() {
        orders_comm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String fxmlFile = "/fxml/orders_comm.fxml";
                FXMLLoader loader = new FXMLLoader();
                Parent root = null;
                try {
                    root = loader.load(getClass().getResourceAsStream(fxmlFile));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage Window_orders_comm = new Stage();
                Window_orders_comm.setTitle("Приказы на командировки");
                Window_orders_comm.setScene(new Scene(root));
                Window_orders_comm.show();
            }
        });
    }

    @FXML
    private Button time_corr;
    public void click_time_corr() {
        time_corr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String fxmlFile = "/fxml/time_corr.fxml";
                FXMLLoader loader = new FXMLLoader();
                Parent root = null;
                try {
                    root = loader.load(getClass().getResourceAsStream(fxmlFile));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage Window_time_corr = new Stage();
                Window_time_corr.setTitle("Коррекция времени");
                Window_time_corr.setScene(new Scene(root));
                Window_time_corr.show();
            }
        });
    }

    @FXML
    private Button orders_prise;
    public void click_orders_prise() {
        orders_prise.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String fxmlFile = "/fxml/orders_prise.fxml";
                FXMLLoader loader = new FXMLLoader();
                Parent root = null;
                try {
                    root = loader.load(getClass().getResourceAsStream(fxmlFile));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage Window_orders_prise = new Stage();
                Window_orders_prise.setTitle("Приказ на изменение оклада");
                Window_orders_prise.setScene(new Scene(root));
                Window_orders_prise.show();
            }
        });
    }

    @FXML
    private Button orders_status;
    public void click_orders_status() {
        orders_status.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String fxmlFile = "/fxml/orders_status.fxml";
                FXMLLoader loader = new FXMLLoader();
                Parent root = null;
                try {
                    root = loader.load(getClass().getResourceAsStream(fxmlFile));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage Window_orders_status = new Stage();
                Window_orders_status.setTitle("Приказ на изменение должности");
                Window_orders_status.setScene(new Scene(root));
                Window_orders_status.show();
            }
        });
    }

}
