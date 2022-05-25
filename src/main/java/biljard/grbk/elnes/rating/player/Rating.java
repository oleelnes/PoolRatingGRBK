package biljard.grbk.elnes.rating.player;

import java.time.LocalDate;

public class Rating {
  private int rating;
  private LocalDate date;


  public Rating(int rating, LocalDate date) {
    this.rating = rating;
    this.date = date;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }
}
