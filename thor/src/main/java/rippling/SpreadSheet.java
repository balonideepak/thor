package work.rippling;

import java.util.*;

public class SpreadSheet {

    private static Map<String, Integer> map = new HashMap<>();
    private static int total_rows;

    public static void main(String[] args) {
        new SpreadSheet(3);
        setCell("A1",10);
        resetCell("A1");
    }


    public SpreadSheet(int rows) {
        total_rows=rows+1;
    }

    public static void setCell(String cell, int value) {
        map.put(cell, value);

    }

    public static void resetCell(String cell) {
        map.put(cell, 0);
    }

    public int getValue(String formula) {
       int sum=0;
       for(String s:formula.substring(1).split("\\+")) {
           sum += mapToValue(s);
       }

       return sum;

    }

    private int mapToValue(String s) {
        return Character.isLetter(s.charAt(0)) ? map.getOrDefault(s, 0) : Integer.parseInt(s);
    }

}
