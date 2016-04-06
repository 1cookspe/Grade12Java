public class Pacman {
  // Instance variables
  int xLoc;
  int yLoc;
  boolean alive;
  int score;
  char direction;
  boolean openMouth;
  
  // Constructor
  public Pacman(int xLoc, int yLoc, boolean alive, int score, char direction, boolean openMouth) {
    this.xLoc = xLoc;
    this.yLoc = yLoc;
    this.alive = alive;
    this.score = score;
    this.direction = direction;
    this.openMouth = openMouth;
  }
}