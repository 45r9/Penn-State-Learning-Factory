/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demos.gui.uicomponents;

import com.jfoenix.controls.JFXComboBox;
import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.util.StringConverter;
import javax.annotation.PostConstruct;

@ViewController(value = "/fxml/ui/Rfid.fxml", title = "Material Design Example")
public class RfidController {

    @FXML
    private JFXComboBox<Label> jfxComboBox;
    

    /**
     * init fxml when loaded.
     */
    @PostConstruct
    public void init() {

        jfxComboBox.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                jfxComboBox.validate();
            }
        });
    }

}