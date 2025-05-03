package LLD.snakeandladdergame;

public class Ladder {

    private final int startPoint ;
    private final int endPoint ;

    public Ladder(int startPoint, int endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public int getEndPoint() {
        return endPoint;
    }
}
