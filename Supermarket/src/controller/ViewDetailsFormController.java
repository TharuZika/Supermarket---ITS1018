package controller;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.octicons.OctIconView;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class ViewDetailsFormController {
    public AnchorPane detailsContext;
    public Text lblCustomers;
    public Text lblItems;
    public Text lblOrders;
    public FontAwesomeIconView btnCustomers;
    public FontAwesomeIconView btnOrders;
    public FontAwesomeIconView btnItems;

    public void backClicked(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/AdminDashboardForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.detailsContext.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }

    public void navigate(MouseEvent event) throws IOException {
        if (event.getSource() instanceof FontAwesomeIconView) {
            FontAwesomeIconView icon = (FontAwesomeIconView) event.getSource();

            Parent root = null;

            switch (icon.getId()) {
                case "btnCustomers":
                    root = FXMLLoader.load(this.getClass().getResource("/view/ManageReportsForm.fxml"));
                    break;
                case "btnItems":
                    root = FXMLLoader.load(this.getClass().getResource("/view/ViewDetailsForm.fxml"));
                    break;
                case "btnOrders":
                    root = FXMLLoader.load(this.getClass().getResource("/view/ManageItemsForm.fxml"));
                    break;
            }


            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.detailsContext.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition transition = new TranslateTransition(Duration.millis(150), subScene.getRoot());
                transition.setFromX(-subScene.getWidth());
                transition.setToX(0);
                transition.play();
            }
        }
    }

    public void onMouseAnimation(MouseEvent event) {
        if (event.getSource() instanceof FontAwesomeIconView){
            FontAwesomeIconView icon = (FontAwesomeIconView) event.getSource();


            switch (icon.getId()) {
                case "btnCustomers":
                    lblCustomers.setVisible(true);
                    break;
                case "btnItems":
                    lblItems.setVisible(true);
                    break;
                case "btnOrders":
                    lblOrders.setVisible(true);
                    break;
            }

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.INDIANRED);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
            lblCustomers.setEffect(glow);
            lblOrders.setEffect(glow);
            lblItems.setEffect(glow);
        }
    }

    public void offMouseAnimation(MouseEvent event) {
        if (event.getSource() instanceof FontAwesomeIconView) {
            FontAwesomeIconView icon = (FontAwesomeIconView) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);
            lblOrders.setVisible(false);
            lblItems.setVisible(false);
            lblCustomers.setVisible(false);

        }
    }
}
