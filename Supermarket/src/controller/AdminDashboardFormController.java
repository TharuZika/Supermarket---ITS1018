package controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;

public class AdminDashboardFormController {

    public JFXButton btnReports;
    public JFXButton btnDetails;
    public JFXButton btnItems;
    public AnchorPane adminContext;

    public void navigateUi (MouseEvent event) throws IOException{
        if (event.getSource() instanceof JFXButton){
            JFXButton button = (JFXButton) event.getSource();

            Parent root = null;

            switch (button.getId()){
                case "btnReports" :
                    root = FXMLLoader.load(this.getClass().getResource("/view/ManageReportsForm.fxml"));
                    break;
                case "btnDetails" :
                    root = FXMLLoader.load(this.getClass().getResource("/view/ViewDetailsForm.fxml"));
                    break;
                case "btnItems" :
                    root = FXMLLoader.load(this.getClass().getResource("/view/ManageItemsForm.fxml"));
                    break;
            }


            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.adminContext.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition transition = new TranslateTransition(Duration.millis(150), subScene.getRoot());
                transition.setFromX(-subScene.getWidth());
                transition.setToX(0);
                transition.play();
            }
        }
    }

    public void logoutClicked(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/LoginForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.adminContext.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }
}
