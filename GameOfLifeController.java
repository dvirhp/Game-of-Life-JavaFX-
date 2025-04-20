import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class GameOfLifeController {

    private static final int SIZE = 10; 
    private boolean[][] grid = new boolean[SIZE][SIZE]; 
    private boolean[][] nextGen = new boolean[SIZE][SIZE]; // math for the next gen

    @FXML
    private Canvas gameCanvas; 

    public void randomizeGrid() {
        Random rand = new Random();
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                grid[row][col] = rand.nextBoolean();
            }
        }
    }

    public void drawGrid() {
        GraphicsContext gc = gameCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, gameCanvas.getWidth(), gameCanvas.getHeight()); 
        double cellSize = gameCanvas.getWidth() / SIZE; 

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col]) {
                    gc.setFill(Color.BLACK);
                } else {
                    gc.setFill(Color.WHITE); 
                }
                gc.fillRect(col * cellSize, row * cellSize, cellSize, cellSize); 
                gc.setStroke(Color.GRAY);
                gc.strokeRect(col * cellSize, row * cellSize, cellSize, cellSize); 
            }
        }
    }

    public void updateGrid() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                int neighbors = countNeighbors(row, col);
                if (grid[row][col]) {
                    nextGen[row][col] = neighbors == 2 || neighbors == 3;
                } else {
                    nextGen[row][col] = neighbors == 3;
                }
            }
        }
        boolean[][] temp = grid;
        grid = nextGen;
        nextGen = temp;
    }

    // Checks all neighbors even those that are diagonal
    public int countNeighbors(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) 
                	continue; // ignores himself
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < SIZE && c >= 0 && c < SIZE) {
                    if (grid[r][c]) count++; // אם יש חיים בשכן
                }
            }
        }
        return count;
    }
   
    @FXML
    public void nextGeneration() {
        updateGrid(); 
        drawGrid(); 
    }

    @FXML
    public void initialize() {
        randomizeGrid();
        drawGrid();
    }
}
