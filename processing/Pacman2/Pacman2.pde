
class Pacman {
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
  
  // Set xLoc
  public void setXLoc(int xLoc) {
    this.xLoc = xLoc + 2;
  }
  
  public void move(char direction) {
    switch (direction) {
      case 'r':
        if (this.xLoc > width) {
          this.xLoc = 0;
        }      
  
      break;
      case 'l':
      break;
      case 'u':
      break;
      case 'd':
      break;
      default:
      break;
    }
    display();
  } 

public void display() {
  fill(123);
  rect(this.xLoc, this.yLoc, 20, 20);
}
}