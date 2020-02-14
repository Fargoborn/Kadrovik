package kadr.v1.fxapp.controller;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import kadr.v1.fxapp.comand_print.Mine;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class MainController {

    String work_file = "";

    private Task workTask;

    private Desktop desktop = Desktop.getDesktop();
    Stage Window_orders_comm = new Stage();

    private void openFile(File file) {
        try {
            this.desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String workfile() {
        return work_file;
    }

    @FXML
    private Button orders_comm;
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
                Window_orders_comm.setTitle("Приказы на командировки");
                Window_orders_comm.setScene(new Scene(root));
                Window_orders_comm.show();

            }
        });
    }

    @FXML
    private Button file_choose_ord_k;
    @FXML
    private TextField textField;
    public void click_file_choose() {
        final FileChooser fileChooser = new FileChooser();
        file_choose_ord_k.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File file = fileChooser.showOpenDialog(Window_orders_comm);
                textField.setText(file.getAbsolutePath());
                work_file = file.getAbsolutePath();
            }
        });
    }

    @FXML
    private Button start_work_button;
    @FXML
    private ProgressBar progressBar;
    public void click_start_work() {
        start_work_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Mine mine = new Mine();
                mine.setworkfile(work_file);
                workTask = new Task<Boolean>() {
                    @Override
                    protected Boolean call() throws Exception {
                        try {
                            mine.print_com();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                };
                progressBar.setProgress(0);
                progressBar.progressProperty().unbind();
                progressBar.progressProperty().bind(workTask.progressProperty());

                workTask.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, //
                        new EventHandler<WorkerStateEvent>() {

                            @Override
                            public void handle(WorkerStateEvent t) {
                                workTask.getValue();
                            }
                        });

                // Start the Task.
                new Thread(workTask).start();
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
