package LLD.snakeandladdergame;

public class Snake {
    private final int startPoint ;
    private final int endPoint ;

    public Snake(int startPoint, int endPoint) {
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
