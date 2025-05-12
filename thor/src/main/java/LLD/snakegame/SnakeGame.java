package LLD.snakegame;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeGame {

    int currentRow;
    int currentCol;
    int rows;
    int cols;
    int index;
    int score;
    int[][] foods;
    Queue<int[]> snake;


    public static void main(String[] args) {
        SnakeGame snakeGame = new SnakeGame(3, 2, new int[][]{{1, 2}, {0, 1}});
        String moves ="R,D,R,U,L,U";

        Arrays.stream(moves.split(",")).forEach(s -> {

            int move = snakeGame.move(s);
            if(move== -1){
                System.out.println("Game Over");
                return;
            }
            else{
                System.out.println("Score: " + move);
            };

        });

    }



    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        currentRow = 0;
        currentCol = 0;
        index = 0;
        score = 0;
        rows = height;
        cols = width;
        foods = food;
        snake = new LinkedList<int[]>();
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        switch (direction) {
            case "U":
                currentRow--;
                break;
            case "D":
                currentRow++;
                break;
            case "L":
                currentCol--;
                break;
            case "R":
                currentCol++;
                break;
        }
        if (!isValid(currentRow, currentCol))
            return -1;
        return process(currentRow, currentCol);
    }

    private boolean isValid(int x, int y) {
        return (0 <= x && x < rows && 0 <= y && y < cols);
    }

    private int process(int r , int c){
        if(index == foods.length){
            snake.poll();
        }
        else if(r==foods[index][0] && c==foods[index][1]){
            index++;
            score++;
        }
        else{
            snake.poll();
        }

        for(int[] s : snake){
            if(r == s[0] && c==s[1]){
                return -1;
            }
        }

        snake.add(new int[]{r,c});
        return score;
    }
}
