package U01_Stacks_03_MazeSolver;

public abstract class MazeSolver {
    private Maze maze;
    private boolean isSolved;

    public MazeSolver(Maze maze) {
        this.maze = maze;
        makeEmpty();
        add(maze.getStart());
    }

    public abstract void makeEmpty();

    public abstract boolean isEmpty();

    public abstract void add(Square s);

    public abstract Square next();

    public boolean isSolved() {
        if (isSolved == true || isEmpty() == true) {
            return true;
        }

        return false;
    }

    public void step() {
        if (isEmpty() == true) {
            return;
        }

        Square now = next();
        if (now == maze.getEnd()) {
            isSolved = true;
            return;
        }

        for (Square neighbor : maze.getNeighbors(now)) {
            if (neighbor.getType() != Square.WALL && neighbor.getStatus() != Square.EXPLORED) {
                add(neighbor);
                neighbor.setStatus(Square.WORKING);
            }
        }

        if (now.getPrevious() != null) {
            now.setPrevious(now);
        }
        now.setStatus(Square.EXPLORED);
    }

    public String getPath() {
        if (isEmpty()) {
            return "Maze is unsolvable.";
        } else if (isSolved()) {
            Square curr = this.maze.getEnd();
            String path = "[" + curr.getRow() + ", " + curr.getCol() + "]";
            curr.setStatus(Square.ON_EXIT_PATH);

            while (curr.getPrevious() != null) {
                curr = curr.getPrevious();
                path += ", [" + curr.getRow() + ", " + curr.getCol() + "]";
                System.out.println(path);
                curr.setStatus(Square.ON_EXIT_PATH);
            }
            return path;
        } else {
            return "Maze not yet solved.";
        }
    }

    public void solve() {
        while (!isSolved()) {
            step();
        }
    }
}
