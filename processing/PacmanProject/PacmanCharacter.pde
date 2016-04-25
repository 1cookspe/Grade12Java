public abstract class PacmanCharacter {
  // Class variables
  protected static final int DIR_RIGHT = 1;
  protected static final int DIR_LEFT = 2;
  protected static final int DIR_UP = 3;
  protected static final int DIR_DOWN = 4;
  
  // Instance variables
  protected int xLoc;
  protected int yLoc;
  protected boolean alive;
  protected int direction;

  public PacmanCharacter() {
   this.xLoc = Math.round(random(0, width));
   this.yLoc = Math.round(random(0, height));
  }

  public PacmanCharacter(int xLoc, int yLoc, int direction) {
   this.xLoc = xLoc;
   this.yLoc = yLoc;
   this.direction = direction;
  }

  public void setXLoc(int xLoc) {
    if (xLoc < width && xLoc > 0) {
      this.xLoc = xLoc;
    } else if (xLoc == width) {
      this.xLoc = 0;
    } else if (xLoc == 0) {
      this.xLoc = width;
    }
  }

  public void setYLoc(int yLoc) {
    if (yLoc < height && yLoc > 0) {
      this.yLoc = yLoc;
    } else if (yLoc == height) {
      this.yLoc = 0;
    } else if (yLoc == 0) {
      this.yLoc = height;
    }
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
      setXLoc(this.xLoc + 10);
      System.out.println("RIGHT");
      break;
    case DIR_LEFT:
      setXLoc(this.xLoc - 10);
      System.out.println("LEFT");
      break;
    case DIR_UP:
      setYLoc(this.yLoc - 10);
      System.out.println("UP");
      break;
    case DIR_DOWN:
      setYLoc(this.yLoc + 10);
      System.out.println("DOWN");
      break;
    default:
      break;
    }
    
    display();
  }
  
  public abstract void display();
  
}