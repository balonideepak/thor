package LLD.snakeandladdergame;

import java.util.Arrays;
import java.util.List;

public class SnakeAndLadderApplication {
    public static void main(String[] args) {
        GameManager gameManager = GameManager.getInstance();

        // Start game 1
        System.out.println("***********************************************************");
        System.out.println("Starting game1");
        System.out.println("***********************************************************");
        List<String> players1 = Arrays.asList("Player 1", "Player 2", "Player 3");
        gameManager.startNewGame(players1);


        // Start game 2
        System.out.println("***********************************************************");
        System.out.println("Starting game2");
        System.out.println("***********************************************************");
        List<String> players2 = Arrays.asList("Player 4", "Player 5");
        gameManager.startNewGame(players2);
    }
}