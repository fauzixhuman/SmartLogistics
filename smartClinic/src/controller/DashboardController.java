package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import java.io.IOException;

public class DashboardController {

    @FXML
    private StackPane contentArea;

    @FXML
    public void initialize() {
        loadHome();
    }

    @FXML
    private void loadHome() {
        loadView("/view/home.fxml");
    }

    @FXML
    private void loadPrediksi() {
        loadView("/view/prediksi_paket.fxml");
    }

    private void loadView(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent view = loader.load();
            contentArea.getChildren().clear();
            contentArea.getChildren().add(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}