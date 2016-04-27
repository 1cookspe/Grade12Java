class Ghost extends PacmanCharacter {

  private String name;
  private color ghostCol;
  
  // Default constructor
  public Ghost() {
    super();
    configureGhostSettings();
  }

  // Primary Constructor
  public Ghost(int xLoc, int yLoc, int direction, String name, color ghostCol) {
    super(xLoc, yLoc, direction);
    this.name = name;
    this.ghostCol = ghostCol;
  }
  
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setGhostCol(color ghostCol) {
    this.ghostCol = ghostCol;
  }
  
  public color getGhostCol() {
    return this.ghostCol;
  }
  

  public void display() {
    noStroke();
    fill(this.ghostCol);
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
  
  public void configureGhostSettings() {
    int style = (int) random(1,4);
    switch (style) {
      case 1:
        this.ghostCol = color(255, 192, 203);
        this.name = "Pinky";
      break;
      case 2:
        this.ghostCol = color(160, 32, 240);
        this.name = "Blinky";
      break;
      case 3:
        this.ghostCol = color(205, 92, 92);
        this.name = "Stinky";
      break;
      default:
      break;
    }
  }
  
  public String toString() {
    return this.name + " is at (" + this.xLoc + ", " + this.yLoc + ") and is moving in the " + getDirectionString() + " direction";
  }
}