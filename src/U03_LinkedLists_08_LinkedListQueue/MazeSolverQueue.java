package U03_LinkedLists_08_LinkedListQueue;

import U01_Stacks_03_MazeSolver.Maze;
import U01_Stacks_03_MazeSolver.MazeSolver;
import U01_Stacks_03_MazeSolver.Square;;

public class MazeSolverQueue<T> extends MazeSolver {
    private MyQueue<Square> squares;

    public MazeSolverQueue(Maze maze) {
        super(maze);
    }

    @Override
    public Square next() {
        return squares.poll();
    }

    @Override
    public void makeEmpty() {
        squares = new MyQueue<Square>();
        
    }

    @Override
    public boolean isEmpty() {
        return squares.size() == 0;
    }

    @Override
    public void add(Square s) {
        squares.offer(s);
    }

}
