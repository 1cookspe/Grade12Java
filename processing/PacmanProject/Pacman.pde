class Pacman {

  // CLASS CONSTANTS
  static final char DIR_RIGHT = 'r';
  static final char DIR_LEFT = 'l';
  static final char DIR_UP = 'u';
  static final char DIR_DOWN = 'd';

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
    switch (this.direction) {
    case DIR_RIGHT:
      this.xLoc = xLoc + 10;
      break;
    case DIR_LEFT:
      this.xLoc = xLoc - 10;
      break;
    default:
      break;
    }
  }

  // Set yLoc
  public void setYLoc(int yLoc) {
    switch (this.direction) {    
    case DIR_UP:
      this.yLoc = yLoc + 10;
      break;
    case DIR_DOWN:
      this.yLoc = yLoc - 10;
      break;
    default:
      break;
    }
  }

  public void move() {
    switch (this.direction) {
    case 'r':
      if (this.xLoc < width) {
        setXLoc(this.xLoc);
      } else {
        noLoop();
      }  
      break;
    case DIR_LEFT:
      if (this.xLoc > 0) {
        setXLoc(this.xLoc);
      } else {
        noLoop();
      } 
      break;
    case DIR_UP:
      if (this.yLoc > 0) {
        setXLoc(this.xLoc);
      } else {
        noLoop();
      } 
      break;
    case DIR_DOWN:
      break;
    default:
      break;
    }
    display();
  } 

  public void display() {
    fill(color(255, 255, 0));
    if (this.openMouth) {
      arc(this.xLoc, this.yLoc, 60, 60, 0, (PI+HALF_PI) + (PI / 8), PIE);
    } else {
      ellipse(this.xLoc, this.yLoc, 60, 60);
    }
  }
}