public void setup() {
  // Set defaults
  size(600, 600);
  background(0);
  stroke(255);
  // Draw first upright line
  line(width / 2, height, width / 2, height / 2);
  // Draw design to right
  drawTree(width / 2, height / 2, height / 4, 0, 0);
  // Draw design to left
  drawTree(width / 2, height / 2, height / 4, 0, 1);
}

public void drawTree(int x1, int y1, int length, int angle, int direction) {
  // Create float to hold the decimal part of the radian angles
  float newX1;
  float newY1;
  if (direction % 2 == 0) { // Check if direction is odd or even
  // Direction is even
  // Draw to right
  newX1 = x1 + length * cos(angle / (180 / 3.14));
  newY1 = y1 + length * sin(angle / (180 / 3.14));
  } else {
    // Direction is odd
    // Draw to left
    newX1 = x1 - length * cos(angle / (180 / 3.14));
    newY1 = y1 - length * sin(angle / (180 / 3.14));
  }
  // Convert float back into int
  int newX1Int = round(newX1);
  int newY1Int = round(newY1);
  // Draw line with new dimensions
  line(x1, y1, newX1Int, newY1Int);
  // Recursively call until the length is 1 pixel
  if (length > 1) {
    // Move to the angle 45 degrees up
   drawTree(newX1Int, newY1Int, length - 20, angle + 45, direction + 1);
   // Move to the angle 45 degrees down
   drawTree(newX1Int, newY1Int, length - 20, angle - 45, direction + 1);
  }
}