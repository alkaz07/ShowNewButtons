package com.example.shownewbuttons;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HelloController {
    @FXML
    TextField txtFileName;
    @FXML
    TextArea txtLines;
    @FXML
    Button btnLoad;
    @FXML
    Label info;

    @FXML
    VBox zooBox;


@FXML
    public void loadText()
    {
        String fname = txtFileName.getText();
        txtLines.clear();
        zooBox.getChildren().clear();
        try {
            List<String> lines = Files.readAllLines(Path.of(fname), StandardCharsets.UTF_8);
            for (String str:lines) {
                txtLines.setText(txtLines.getText()+"\n"+str);

                Button animalButton = new Button(str);
                zooBox.getChildren().add(animalButton);
                animalButton.setOnAction(actionEvent -> {
                    txtLines.setText("нажата кнопка "+str);
                });
                Button delButton = new Button("удалить "+str);
                zooBox.getChildren().add(delButton);
                delButton.setOnAction(actionEvent -> {
                    zooBox.getChildren().remove(animalButton);
                    zooBox.getChildren().remove(delButton);
                });
            }
        }
        catch (IOException e)
        {
            txtLines.setText("Файл не открылся!");
        }

    }
}