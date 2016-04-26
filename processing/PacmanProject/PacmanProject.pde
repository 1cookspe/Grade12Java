Pacman p1 = new Pacman(50, 50, 67);
Ghost ghost1 = new Ghost(400, 400, 1);

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
  }
  counter++;
  ghost1.move();
  
  System.out.println(ghost1.toString());
  System.out.println(p1.toString());
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