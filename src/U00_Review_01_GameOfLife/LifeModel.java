package U00_Review_01_GameOfLife;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.Timer;

public class LifeModel implements ActionListener {

    /*
     * This is the Model component.
     */

    private static int SIZE = 60;
    private LifeCell[][] grid;

    LifeView myView;
    private String fileName;
    Timer timer;

    /** Construct a new model using a particular file */
    public LifeModel(LifeView view, String fileName) throws IOException {
        this.myView = view;
        this.fileName = fileName;
        newModel(myView, this.fileName);
    }

    /** Constructor a randomized model */
    public LifeModel(LifeView view) throws IOException {
        this(view, null);
    }

    /** pause the simulation (the pause button in the GUI */
    public void pause() {
        timer.stop();
    }

    /** resume the simulation (the resume button in the GUI */
    public void resume() {
        timer.restart();
    }

    /** run the simulation (the run button in the GUI */
    public void run() {
        timer = new Timer(50, this);
        timer.setCoalesce(true);
        timer.start();
    }

    public void reset() throws IOException {
        newModel(this.myView, this.fileName);
        run();
    }

    public boolean isColorRandom() {
        return this.myView.isColorRandom();
    }

    public void randomizeColor() {
        this.myView.toggleRandCol();
    }

    /** called each time timer fires */
    public void actionPerformed(ActionEvent e) {
        oneGeneration();
        myView.updateView(grid);
    }

    /** main logic method for updating the state of the grid / simulation */
    private void oneGeneration() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j].isAliveNow()) {
                    if (getNeighbors(i, j) != 2 && getNeighbors(i, j) != 3) {
                        grid[i][j].setAliveNext(false);
                    } else {
                        grid[i][j].setAliveNext(true);
                    }
                } else {
                    if (getNeighbors(i, j) == 3) {
                        grid[i][j].setAliveNext(true);
                    }
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j].isAliveNext()) {
                    grid[i][j].setAliveNow(true);
                } else {
                    grid[i][j].setAliveNow(false);
                }
            }
        }
    }

    private int getNeighbors(int r, int c) {
        int count = 0;

        for (int i = r - 1; i <= r + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {
                if (isInGrid(i, j)) {
                    if (grid[i][j].isAliveNow()) {
                        count++;
                    }
                }
            }
        }

        if (grid[r][c].isAliveNow()) {
            count--;
        }
        return count;
    }

    private boolean isInGrid(int r, int c) {
        return (r >= 0 && r < SIZE && c >= 0 && c < SIZE);
    }

    private void newModel(LifeView view, String fileName) throws IOException {
        int r, c;
        grid = new LifeCell[SIZE][SIZE];
        for (r = 0; r < SIZE; r++)
            for (c = 0; c < SIZE; c++)
                grid[r][c] = new LifeCell();

        if (fileName == null) // use random population
        {
            for (r = 0; r < SIZE; r++) {
                for (c = 0; c < SIZE; c++) {
                    if (Math.random() > 0.85) // 15% chance of a cell starting alive
                        grid[r][c].setAliveNow(true);
                }
            }
        } else {
            Scanner input = new Scanner(new File(fileName));
            int numInitialCells = input.nextInt();
            for (int count = 0; count < numInitialCells; count++) {
                r = input.nextInt();
                c = input.nextInt();
                grid[r][c].setAliveNow(true);
            }
            input.close();
        }

        myView = view;
        myView.updateView(grid);

    }
}
