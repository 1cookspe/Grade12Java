color c = color(0);
float x = 0;
float y = 100;
float speed = 1;
Pacman p1 = new Pacman(50, 50, true, 0, Pacman.DIR_RIGHT, true);

void setup() {
  size(800,800);
}

void draw() {
  delay(100);
  background(255);
  
  if (keyCode == UP) {
    p1.direction = Pacman.DIR_UP;
    System.out.println("Up");
  }
  
  if (p1.openMouth) {
    p1.openMouth = false;
  } else {
    p1.openMouth = true;
  }
  
  p1.move();
}