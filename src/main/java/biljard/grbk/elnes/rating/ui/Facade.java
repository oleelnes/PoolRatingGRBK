package biljard.grbk.elnes.rating.ui;

import javafx.stage.Stage;

public class Facade {
  private static volatile Facade instance;
  private final Scenes scenes;
  private final Dialogs dialogs;
  private Stage stage;



  private Facade() {
    this.scenes = new Scenes();
    this.dialogs = new Dialogs();
  }

  public static Facade getInstance(){
    if(instance == null) {
      synchronized (Facade.class) {
        instance = new Facade();
      }
    }
    return instance;
  }

  public void setStage(Stage stage) {
    this.stage = stage;
  }

  public Stage getStage(){
    try {
      return stage;
    } catch(NullPointerException e) {
      e.printStackTrace();
      return null;
    }
  }


}
