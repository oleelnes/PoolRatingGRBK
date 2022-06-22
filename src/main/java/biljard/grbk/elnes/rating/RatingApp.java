package biljard.grbk.elnes.rating;

import biljard.grbk.elnes.rating.ui.Facade;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class RatingApp extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    Facade.getInstance().setStage(stage);

    //stage.initStyle(StageStyle.UTILITY);
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-files/mainPage.fxml")));
    Scene scene = new Scene(root);
    //scene.getStylesheets().add(Objects.requireNonNull(getClass().getClassLoader().getResource("darkmode.css")).toExternalForm());
    stage.setMinHeight(650);
    stage.setMinWidth(820);
    stage.setTitle("Rating");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}