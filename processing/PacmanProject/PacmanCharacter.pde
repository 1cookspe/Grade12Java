class PacmanCharacter {
  // Class variables
  private static final int DIR_RIGHT = 1;
  private static final int DIR_LEFT = 2;
  private static final int DIR_UP = 3;
  private static final int DIR_DOWN = 4;
  
  // Instance variables
  protected int xLoc;
  protected int yLoc;
  protected boolean alive;
  protected int direction;

  public PacmanCharacter() {
    this.xLoc = Math.round(random(0, width));
    this.yLoc = Math.round(random(0, height));
    this.direction = Math.round(random(1, 5));
  }

  public PacmanCharacter(int xLoc, int yLoc, int direction) {
    this.xLoc = xLoc;
    this.yLoc = yLoc;
    this.direction = direction;
  }

  public void setXLoc(int xLoc) {
    this.xLoc = xLoc;
  }

  public void setYLoc(int yLoc) {
    this.yLoc = yLoc;
  }

  public void setDirection(int direction) {
    this.direction = direction;
  }

  public void setAlive(boolean alive) {
    this.alive = alive;
  }

  public int getXLoc() {
    return this.xLoc;
  }

  public int getYLoc() {
    return this.yLoc;
  }

  public int getDirection() {
    return this.direction;
  }

  public boolean getAlive() {
    return this.alive;
  }

  public void move() {
    switch (this.direction) {
    case DIR_RIGHT:
      setXLoc(this.xLoc - 10);
      break;
    case DIR_LEFT:
      setXLoc(this.xLoc + 10);
      break;
    case DIR_UP:
      setYLoc(this.yLoc - 10);
      break;
    case DIR_DOWN:
      setYLoc(this.yLoc + 10);
      break;
    default:
      break;
    }
  }
}