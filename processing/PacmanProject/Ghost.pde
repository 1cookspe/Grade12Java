class Ghost {
  
  // Class variable
  private float directionGhost = 0;
  
  // Instance variables
  private int xLoc;
  private int yLoc;
  private boolean alive;
  
  // Constructor
  public Ghost(int xLoc, int yLoc, boolean alive) {
    this.xLoc = xLoc;
    this.yLoc = yLoc;
    this.alive = alive;
  }
  
  public void setXLoc(int xLoc) {
    this.xLoc = xLoc;
  }
  
  public void setYLoc(int yLoc) {
    this.yLoc = yLoc;
  }  
  
  public void move() {
    this.directionGhost = random(1 , 4);
    if (this.directionGhost == 1) { // MOVE RIGHT
      setXLoc(this.xLoc - 10);
    } else if (this.directionGhost == 2) { // MOVE LEFT
      setXLoc(this.xLoc + 10);
    } else if (this.directionGhost == 3) { // MOVE UP
      setYLoc(this.yLoc - 10);
    } else { // MOVE DOWN
      setYLoc(this.yLoc + 10);
    }  
    
    display();
  }
  
 public void display() {
    noStroke();
    fill(color(255, 255, 78));
    rect(this.xLoc, this.yLoc, 50, 50);
  }
  
  
}