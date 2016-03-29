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

//        if (moveRight(row, col) == '.') {
//            findExitFrom(row, col + 1);
//        } else if (moveLeft(row, col) == '.') {
//            findExitFrom(row, col - 1);
//        } else if (moveUp(row, col) == '.') {
//            findExitFrom(row + 1, col);
//        } else if (moveDown(row, col) == '.') {
//            findExitFrom(row - 1, col);
//        } 
        
        if (maze[row][col] == EXIT) {
            maze[row][col] = GOOD_PATH;
            successful = true;
        } 

        maze[row][col] = TRIED;
        
        if (maze[row][col + 1] == OPEN || maze[row][col + 1] == EXIT) {
            successful = findExitFrom(row, col + 1);
            System.out.println("right");
        } else if (maze[row + 1][col] == OPEN || maze[row + 1][col] == EXIT) {
            successful = findExitFrom(row + 1, col);
            System.out.println("down");
        } else if (maze[row - 1][col] == OPEN || maze[row - 1][col] == EXIT) {
            successful = findExitFrom(row - 1, col);
            System.out.println("up");
        } else if (maze[row][col - 1] == OPEN || maze[row][col - 1] == EXIT) {
            System.out.println("left");
            successful = findExitFrom(row, col - 1);
        } else { // Cannot move, except for going back to where it was
            // Recall last move
            int lastRow = 0;
            int lastCol = 0;
            if (maze[row][col + 1] == TRIED) {
                lastRow = row;
                lastCol = col;
            } else if (maze[row + 1][col] == TRIED) {
                lastRow = row;
                lastCol = col;
            } else if (maze[row - 1][col] == TRIED) {
                lastRow = row;
                lastCol = col;
            } else if (maze[row][col - 1] == TRIED) {
                lastRow = row;
                lastCol = col;
            }
            successful = findExitFrom(lastRow, lastCol);
        }
        
        // if exit
        if (successful) {
            maze[row][col] = GOOD_PATH;
        }
            
        
        return successful;
    }

//    public char moveRight(int row, int col) {
//        char beside = 0;
//
//        if (maze[row][col + 1] == '.') {
//            maze[row][col] = '-';
//            moveRight(row, col + 1);
//        }
//
//        beside = maze[row][col + 1];
//
//        return beside;
//    }
//
//    public char moveLeft(int row, int col) {
//        char beside = 0;
//
//        if (maze[row][col - 1] == '.') {
//            maze[row][col] = '-';
//            moveLeft(row, col - 1);
//        }
//
//        beside = maze[row][col - 1];
//
//        return beside;
//    }
//
//    public char moveUp(int row, int col) {
//        char beside = 0;
//
//        if (maze[row + 1][col] == '.') {
//            maze[row][col] = '-';
//            moveUp(row + 1, col);
//        }
//
//        beside = maze[row + 1][col];
//
//        return beside;
//    }
//
//    public char moveDown(int row, int col) {
//        char beside = 0;
//
//        if (maze[row - 1][col] == '.') {
//            maze[row][col] = '-';
//            moveDown(row - 1, col);
//        }
//
//        beside = maze[row - 1][col];
//
//        return beside;
//    }

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
        findExitFrom(5, 10);

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
