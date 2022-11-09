package U01_Stacks_03_MazeSolver;

abstract class MazeSolver {
    private Maze maze;
    private boolean isSolved;

    MazeSolver(Maze maze) {
        this.maze = maze;
        makeEmpty();
        add(maze.getStart());
    }

    abstract void makeEmpty();

    abstract boolean isEmpty();

    abstract void add(Square s);

    abstract Square next();

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

        now.setStatus(Square.EXPLORED);
    }

    public String getPath() {
        if (isEmpty()) {
            return "Maze is unsolvable.";
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
