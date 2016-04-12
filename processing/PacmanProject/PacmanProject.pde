Pacman p1 = new Pacman(50, 50, true, 0, Pacman.DIR_RIGHT, true);
Ghost ghost1 = new Ghost(200, 200, true, 1);

void setup() {
  size(800, 800);
}

int counter = 0;

void draw() {
  delay(100);
  background(0);

  if (p1.openMouth) {
    p1.openMouth = false;
  } else {
    p1.openMouth = true;
  }

  p1.move();
  // change direction every 10 loops
  if (counter % 10 == 0) {
    ghost1.direction = (int) random(1, 5);
  }
  counter++;
  ghost1.move();
}

void keyPressed() {
  if (keyCode == UP) {
    p1.direction = Pacman.DIR_UP;
  } else if (keyCode == DOWN) {
    p1.direction = Pacman.DIR_DOWN;
  } else if (keyCode == LEFT) {
    p1.direction = Pacman.DIR_LEFT;
  } else if (keyCode == RIGHT) {
    p1.direction = Pacman.DIR_RIGHT;
  }
}