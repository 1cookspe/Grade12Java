
Pacman p1 = new Pacman(600, 600, 67);
Ghost ghost1 = new Ghost(400, 400, 1, "Pinky", color(255, 192, 203));
Ghost ghost2 = new Ghost();

void setup() {
  size(800, 800);
}

int counter = 0;

void draw() {
  delay(100);
  background(0);

  if (p1.getOpenMouth()) {
    p1.setOpenMouth(false);
  } else {
    p1.setOpenMouth(true);
  }

  p1.move();
  // change direction every 10 loops
  if (counter % 10 == 0) {
    ghost1.setDirection((int) random(1, 5));
    ghost2.setDirection((int) random(1, 5));
  }
  counter++;
  ghost1.move();
  ghost2.move();

  textSize(20);
  fill(255, 255, 255, 255);
  text("Lives: " + p1.getLives(), 700, 100);

  System.out.println(ghost1.toString());
  System.out.println(ghost2.toString());
  System.out.println(p1.toString());
  
  if (didCollide()) {
    p1.die();
  }
}


void keyPressed() {
  if (keyCode == UP) {
    p1.setDirection(PacmanCharacter.DIR_UP);
  } else if (keyCode == DOWN) {
    p1.setDirection(PacmanCharacter.DIR_DOWN);
  } else if (keyCode == LEFT) {
    p1.setDirection(PacmanCharacter.DIR_LEFT);
  } else if (keyCode == RIGHT) {
    p1.setDirection(PacmanCharacter.DIR_RIGHT);
  }
}

public boolean didCollide() {
  ellipse(p1.getXLoc(), p1.getYLoc(), 10, 10);
  ellipse(ghost1.xLoc, ghost1.yLoc, 10, 10);
  if ((abs(p1.getXLoc() - ghost1.getXLoc()) < 60 && abs(p1.getYLoc() - ghost1.getYLoc()) < 60) || (abs(p1.getXLoc() - ghost2.getXLoc()) < 60 && abs(p1.getYLoc() - ghost2.getYLoc()) < 60)) {
    return true;
  }
  return false;
}

public void endGame() {
  noLoop();
  background(0);
  textSize(60);
  fill(color(255, 255, 255));
  text("Game Over!", width / 2, height / 2);
}