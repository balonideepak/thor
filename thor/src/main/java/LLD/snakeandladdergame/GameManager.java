package LLD.snakeandladdergame;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private static GameManager instance=null;
    private final List<SnakeAndLadderGame> games;

    private GameManager() {
        games = new ArrayList<>();
    }

    public static GameManager getInstance() {
        if(instance==null){
            instance=new GameManager();
        }
        return instance;

    }

    public void startNewGame(List<String> players){

        SnakeAndLadderGame game = new SnakeAndLadderGame(players);
        games.add(game);
        new Thread(() -> game.play()).start();

    }
}
