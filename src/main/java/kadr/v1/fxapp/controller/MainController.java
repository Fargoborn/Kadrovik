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

    public void click(ActionEvent actionEvent) {
        orders_comm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String fxmlFile = "/fxml/orders_komm.fxml";
                FXMLLoader loader = new FXMLLoader();
                Parent root = null;
                try {
                    root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
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

    @FXML
    private Button order_prise;

    @FXML
    private Button order_status;


}
