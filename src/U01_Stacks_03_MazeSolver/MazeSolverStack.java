package U01_Stacks_03_MazeSolver;

public class MazeSolverStack extends MazeSolver {
    private MyStack squares;

    public MazeSolverStack(Maze maze) {
        super(maze);
    }

    @Override
    public void makeEmpty() {
        squares = new MyStack();
    }

    @Override
    public boolean isEmpty() {
        return (squares.size() == 0);
    }

    @Override
    public void add(Square s) {
        squares.push(s);
    }

    @Override
    public Square next() {
        return squares.pop();
    }
}
