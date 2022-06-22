package biljard.grbk.elnes.rating.ui;

import javafx.scene.control.Alert;

public class Dialogs {

  /**
   * Method that opens an error alert.
   *
   * @param errorText The text of the error alert.
   */
  public void errorAlert(String errorText) {
    Alert alert = new Alert(Alert.AlertType.ERROR, errorText);
    alert.setTitle("ERROR");
    alert.showAndWait();
  }

  /**
   * Method that opens an information alert.
   *
   * @param informationText The text to be displayed.
   */
  public void informationAlert(String informationText) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION, informationText);
    alert.setTitle("Information");
    alert.showAndWait();
  }
}
