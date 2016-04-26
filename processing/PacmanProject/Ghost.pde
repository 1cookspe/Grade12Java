class Ghost extends PacmanCharacter {

  private String name;
  
  // Primary Constructor
  public Ghost() {
    super();
  }

  // Constructor
  public Ghost(int xLoc, int yLoc, int direction) {
    super(xLoc, yLoc, direction);
  }
  
  

  public void display() {
    noStroke();
    fill(color(random(1, 255), random(1, 255), random(1, 255)));
    ellipse(this.xLoc, this.yLoc, 70, 70);
    fill(color(255, 255, 255));
    ellipse(this.xLoc - 10, this.yLoc - 10, 20, 20);
    ellipse(this.xLoc + 12, this.yLoc - 10, 20, 20);
    fill(color(0, 0, 0));
    switch (this.direction) {
    case DIR_RIGHT:
      ellipse(this.xLoc - 4, this.yLoc - 10, 8, 8); 
      ellipse(this.xLoc + 16, this.yLoc - 10, 8, 8);
      break;
    case DIR_LEFT:
      ellipse(this.xLoc - 16, this.yLoc - 10, 8, 8);
      ellipse(this.xLoc + 4, this.yLoc - 10, 8, 8);
      break;
    case DIR_UP:
      ellipse(this.xLoc - 10, this.yLoc - 18, 8, 8);
      ellipse(this.xLoc + 10, this.yLoc - 18, 8, 8);
      break;
    case DIR_DOWN:
      ellipse(this.xLoc - 10, this.yLoc - 4, 8, 8);
      ellipse(this.xLoc + 10, this.yLoc - 4, 8, 8);
      break;
    default:
      break;
    }
  }
  
  public String toString() {
    return "The Ghost is at (" + this.xLoc + ", " + this.yLoc + ") and is moving in the " + getDirectionString() + " direction";
  }
}