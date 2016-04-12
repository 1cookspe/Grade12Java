class Ghost {
  
  
  // Instance variables
  private int xLoc;
  private int yLoc;
  private boolean alive;
  private int direction;
  
  // Constructor
  public Ghost(int xLoc, int yLoc, boolean alive, int direction) {
    this.xLoc = xLoc;
    this.yLoc = yLoc;
    this.alive = alive;
    this.direction = direction;
  }
  
  public void setXLoc(int xLoc) {
    this.xLoc = xLoc;
  }
  
  public void setYLoc(int yLoc) {
    this.yLoc = yLoc;
  }  
  
  public void move() {
    System.out.println(this.direction);
    if (this.direction == 1) { // MOVE RIGHT
      setXLoc(this.xLoc - 10);
    } else if (this.direction == 2) { // MOVE LEFT
      setXLoc(this.xLoc + 10);
    } else if (this.direction == 3) { // MOVE UP
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