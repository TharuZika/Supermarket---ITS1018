package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {
    public AnchorPane loginContext;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/view/AdminDashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) loginContext.getScene().getWindow();
        window.setTitle("Point Of Sale System");
        window.setScene(new Scene(load));
    }
}
