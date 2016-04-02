/*
 * Name:            Spencer Cook
 * Date:            March, 2016
 */
package edu.hdsb.gwss.cook.u2;

/**
 */
public class LetMeOut {

    private static final char WALL = 'W';
    private static final char EXIT = 'X';
    private static final char OPEN = '.';
    private static final char TRIED = '-';
    private static final char GOOD_PATH = '+';
    boolean found = false;

    private char[][] maze = {
        {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
        {'W', '.', '.', '.', 'W', '.', '.', '.', '.', '.', '.', '.', 'W'},
        {'W', '.', 'W', '.', 'W', '.', 'W', 'W', 'W', '.', 'W', 'W', 'W'},
        {'W', '.', 'W', '.', '.', '.', 'W', 'W', '.', '.', '.', '.', 'W'},
        {'W', 'W', 'W', '.', 'W', '.', 'W', 'W', '.', 'W', 'W', 'W', 'W'},
        {'W', '.', 'W', 'W', 'W', 'W', 'W', '.', '.', '.', '.', '.', 'W'},
        {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'X', 'W', 'W', 'W'}
    };

    /**
     * Display the current maze.
     */
    public boolean findExitFrom(int row, int col) {
        boolean successful = false;
        displayMaze();

        // CHECK IF SPOT IS EXIT
        if (maze[row][col] == EXIT) {
            maze[row][col] = GOOD_PATH;
            successful = true;
            return successful;
        } else { // EXIT HAS NOT BEEN FOUND
            System.out.println("not found");

            // SET SPOT AS TRIED TO SHOW YOU HAVE ALREADY CHECKED THAT AREA
            maze[row][col] = TRIED;

            // IF CAN MOVE RIGHT
            if (maze[row][col + 1] == OPEN || maze[row][col + 1] == EXIT && !successful) {
                System.out.println("right");

                // SEE IF AN EXIT CAN BE FOUND FROM THE SPOT TO THE RIGHT
                successful = findExitFrom(row, col + 1);

                // CHECK IF EXIT CAN BE FOUND
                if (successful) {
                    // SET SPOT AS GOOD PATH TO SAVE THE PATH TO THE EXIT
                    maze[row][col] = GOOD_PATH;
                    return successful;
                }

            }

            // IF CAN MOVE DOWN
            if (maze[row][col - 1] == OPEN || maze[row][col - 1] == EXIT && !successful) {
                System.out.println("down");

                // SEE IF AN EXIT CAN BE FOUND FROM THE SPOT DOWN
                successful = findExitFrom(row, col - 1);

                // CHECK IF EXIT CAN BE FOUND
                if (successful) {
                    // SET SPOT AS GOOD PATH TO SAVE THE PATH TO THE EXIT
                    maze[row][col] = GOOD_PATH;
                    return successful;
                }

            }

            // IF CAN MOVE UP
            if (maze[row - 1][col] == OPEN || maze[row - 1][col] == EXIT && !successful) {
                System.out.println("up");

                // SEE IF AN EXIT CAN BE FOUND FROM THE SPOT UP
                successful = findExitFrom(row - 1, col);

                // CHECK IF EXIT CAN BE FOUND
                if (successful) {
                    // SET SPOT AS GOOD PATH TO SAVE THE PATH TO THE EXIT
                    maze[row][col] = GOOD_PATH;
                    return successful;
                }

            }

            // IF CAN MOVE LEFT
            if (maze[row + 1][col] == OPEN || maze[row + 1][col] == EXIT && !successful) {
                System.out.println("left");

                // SEE IF AN EXIT CAN BE FOUND FROM THE SPOT TO THE LEFT
                successful = findExitFrom(row + 1, col);

                // CHECK IF EXIT CAN BE FOUND
                if (successful) {
                    // SET SPOT AS GOOD PATH TO SAVE PATH TO EXIT
                    maze[row][col] = GOOD_PATH;
                    return successful;
                }

            }

        }

        // EXIT IS FOUND, SET AS GOOD PATH
        if (successful) {
            maze[row][col] = GOOD_PATH;
            System.out.println("found");
        }

        return successful;
    }

    /**
     * Display the current maze.
     */
    public void solve() {

        // FIND RANDOM START LOCATION
        int row;
        int col;
        do {
            row = (int) (Math.random() * maze.length);
            col = (int) (Math.random() * maze[0].length);
        } while (maze[row][col] != OPEN);

        // START!
        System.out.println("START LOCATION: (" + row + "," + col + ")");
        findExitFrom(row, col);

        // SHOW EXIT
        displayMaze();

    }

    /**
     * Display the current maze.
     */
    public void displayMaze() {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                System.out.print(maze[row][col]);
            }
            System.out.println();
        }
        System.out.println("-------------------------------");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LetMeOut lmo = new LetMeOut();
        lmo.displayMaze();
        lmo.solve();

    }

}
