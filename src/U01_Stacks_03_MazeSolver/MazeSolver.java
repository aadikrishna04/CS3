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
            Square current = this.maze.getEnd();
            String result = "[" + current.getRow() + ", " + current.getCol() + "]";
            current.setStatus(Square.ON_EXIT_PATH);

            while (current.getPrevious() != null) {
                current = current.getPrevious();
                result += ", [" + current.getRow() + ", " + current.getCol() + "]";
                current.setStatus(Square.ON_EXIT_PATH);
            }

            return result;
        } else if (isSolved()) {
            return "Maze is solved.";
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
