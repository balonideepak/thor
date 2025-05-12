package map;

import java.util.EnumMap;
import java.util.Map;

public class EnumMapDemo {
    public static void main(String[] args) {

        Map<Day, String> map =new EnumMap(Day.class);
        map.put(Day.MONDAY, "Walk");
        map.put(Day.TUESDAY, "Running");

        String s = map.get(Day.MONDAY);
        System.out.println(s);
    }


}

enum Day {
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
}


