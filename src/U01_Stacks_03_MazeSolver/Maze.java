package U01_Stacks_03_MazeSolver;

import java.io.*;
import java.util.*;

public class Maze {
    private Square[][] maze;
    private Square start;
    private Square end;

    public Square getStart() {
        return this.start;
    }

    public Square getEnd() {
        return this.end;
    }

    public void reset() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                maze[i][j].reset();
            }
        }
    }

    public Maze() {

    }

    public boolean loadMaze(String fileName) {
        Scanner sc;
        try {
            sc = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println(e + "; File does not exist at specified location.");
            return false;
        }
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        maze = new Square[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                maze[r][c] = new Square(r, c, sc.nextInt());
                if (maze[r][c].getType() == 2) {
                    start = maze[r][c];
                } else if (maze[r][c].getType() == 3) {
                    end = maze[r][c];
                }
            }
        }
        return true;
    }

    public List<Square> getNeighbors(Square s) {
        ArrayList<Square> neighbors = new ArrayList<Square>();
        if (s.getRow() > 0) {
            if (maze[s.getRow() - 1][s.getCol()] != null) {
                neighbors.add(maze[s.getRow() - 1][s.getCol()]);
            }
        }

        if (s.getRow() < maze.length - 1) {
            if (maze[s.getRow() + 1][s.getCol()] != null) {
                neighbors.add(maze[s.getRow() + 1][s.getCol()]);
            }
        }

        if (s.getCol() < maze[s.getRow()].length - 1) {
            if (maze[s.getRow()][s.getCol() + 1] != null) {
                neighbors.add(maze[s.getRow()][s.getCol() + 1]);
            }
        }

        if (s.getCol() > 0) {
            if (maze[s.getRow()][s.getCol() - 1] != null) {
                neighbors.add(maze[s.getRow()][s.getCol() - 1]);
            }
        }

        return neighbors;
    }

    public String toString() {
        String gridString = "";
        for (Square[] row : maze) {
            for (Square sq : row) {
                gridString += sq.toString();
            }
            gridString += "\n";
        }
        return gridString;
    }

}