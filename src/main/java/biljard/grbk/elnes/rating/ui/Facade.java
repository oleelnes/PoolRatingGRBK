package biljard.grbk.elnes.rating.ui;

public class Facade {
  private static volatile Facade instance;

  private Facade() {

  }

  public static Facade getInstance(){
    if(instance == null) {
      synchronized (Facade.class) {
        instance = new Facade();
      }
    }
    return instance;
  }


}
