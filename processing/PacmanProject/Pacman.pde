class Pacman extends PacmanCharacter {

  // CLASS CONSTANTS
  static final char DIR_RIGHT = 'r';
  static final char DIR_LEFT = 'l';
  static final char DIR_UP = 'u';
  static final char DIR_DOWN = 'd';

  // Instance variables
  private int score;
  private boolean openMouth;

  // Primary Constructor 
  public Pacman() {
    super();
  }

  // Secondary key Constructor
  public Pacman(int xLoc, int yLoc, int direction) {
    super(xLoc, yLoc, direction);
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
      this.yLoc = yLoc - 10;
      break;
    case DIR_DOWN:
      this.yLoc = yLoc + 10;
      break;
    default:
      break;
    }
  }

  //public void move() {
  //  switch (this.direction) {
  //  case DIR_RIGHT:
  //    if (this.xLoc < width) {
  //      setXLoc(this.xLoc);
  //    } else {
  //      noLoop();
  //    }  
  //    break;
  //  case DIR_LEFT:
  //    if (this.xLoc > 0) {
  //      setXLoc(this.xLoc);
  //    } else {
  //      noLoop();
  //    } 
  //    break;
  //  case DIR_UP:
  //    if (this.yLoc > 0) {
  //      setYLoc(this.yLoc);
  //    } else {
  //      noLoop();
  //    } 
  //    break;
  //  case DIR_DOWN:
  //    if (this.yLoc < height) {
  //      setYLoc(this.yLoc);
  //    } else {
  //      noLoop();
  //    } 
  //    break;
  //  default:
  //    break;
  //  }
  //  display();
  //} 

  public void display() {
    noStroke();
    fill(color(255, 255, 0));
    openOrClosed();
  }

  public void openOrClosed() {
    if (this.openMouth) {
      switch (this.direction) {
      case DIR_RIGHT:
        arc(this.xLoc, this.yLoc, 60, 60, radians(30), radians(330));
        break;
      case DIR_LEFT:
        arc(this.xLoc, this.yLoc, 60, 60, radians(210), radians(510));
        break;
      case DIR_UP:
        arc(this.xLoc, this.yLoc, 60, 60, radians(300), radians(600));
        break;
      case DIR_DOWN:
        arc(this.xLoc, this.yLoc, 60, 60, radians(120), radians(420));
        break;
      default:
        break;
      }
    } else {
      ellipse(this.xLoc, this.yLoc, 60, 60);
    }
  }
}