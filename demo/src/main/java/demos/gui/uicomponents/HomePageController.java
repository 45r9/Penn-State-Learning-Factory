/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demos.gui.uicomponents;

import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javax.annotation.PostConstruct;

/**
 * FXML Controller class
 *
 * @author prate
 */
@ViewController(value = "/fxml/ui/HomePage.fxml", title = "Material Design Example")
public class HomePageController {

    @FXML
    private LineChart<String,Number> graphview;
    /**
     * Initializes the controller class.
     */
    private void loadgraph() {

        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        graphview.getData().clear();
        series.setName("RFID DATA");
        series.getData().add(new XYChart.Data<String,Number>("11-9", 11));
        series.getData().add(new XYChart.Data<String,Number>("11-12", 22));
        series.getData().add(new XYChart.Data<String,Number>("11-13", 18));
        series.getData().add(new XYChart.Data<String,Number>("11-14", 7));
        graphview.getData().add(series);

     }
    @PostConstruct
    public void init() {
        loadgraph();
    }
}
