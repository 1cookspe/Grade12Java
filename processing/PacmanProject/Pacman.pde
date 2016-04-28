import processing.sound.*;

class Pacman extends PacmanCharacter {
  // Instance variables
  private int score;
  private boolean openMouth;
  private int lives;

  // Primary Constructor 
  public Pacman() {
    super();
    this.lives = 3;
  }

  // Secondary key Constructor
  public Pacman(int xLoc, int yLoc, int direction) {
    super(xLoc, yLoc, direction);
    this.lives = 3;
  }

  public void setOpenMouth(boolean openMouth) {
    this.openMouth = openMouth;
  }

  public boolean getOpenMouth() {
    return this.openMouth;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public int getScore() {
    return this.score;
  }

  public int getLives() {
    return this.lives;
  }

  public void setLives(int lives) {
    this.lives = lives;
  }

  public void display() {
    noStroke();
    fill(color(255, 255, 0));
    openOrClosed();
  }

  public void openOrClosed() {
    if (this.openMouth) {
      switch (this.direction) {
      case DIR_RIGHT:
        arc(this.xLoc, this.yLoc, 80, 80, radians(30), radians(330));
        break;
      case DIR_LEFT:
        arc(this.xLoc, this.yLoc, 80, 80, radians(210), radians(510));
        break;
      case DIR_UP:
        arc(this.xLoc, this.yLoc, 80, 80, radians(300), radians(600));
        break;
      case DIR_DOWN:
        arc(this.xLoc, this.yLoc, 80, 80, radians(120), radians(420));
        break;
      default:
        break;
      }
    } else {
      ellipse(this.xLoc, this.yLoc, 80, 80);
    }
  }

  public void die() {
    this.lives--;
    if (this.lives == 0) {
      endGame();
      
    }
    this.xLoc = 50;
    this.yLoc = 50;
    delay(500);
    
  }

  public String toString() {
    return "Pacman is at (" + this.xLoc + ", " + this.yLoc + ") and is moving in the " + getDirectionString() + " direction";
  }
}