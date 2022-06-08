module biljard.grbk.elnes.rating {
  requires javafx.controls;
  requires javafx.fxml;
  requires json.simple;


  opens biljard.grbk.elnes.rating to javafx.fxml;
  exports biljard.grbk.elnes.rating;
}