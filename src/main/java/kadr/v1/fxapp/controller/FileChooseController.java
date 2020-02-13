package kadr.v1.fxapp.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Arrays;
import java.util.List;


public class FileChooseController {

    @FXML
    private Button file_choose;
    public void click_time_corr() {
        final FileChooser fileChooser = new FileChooser();
        file_choose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainController
                textArea.clear();
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    openFile(file);
                    List<File> files = Arrays.asList(file);
                    printLog(textArea, files);
            }
        });
    }
}
