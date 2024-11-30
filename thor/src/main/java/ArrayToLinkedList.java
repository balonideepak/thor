import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayToLinkedList {
    public static void main(String[] args) {
        int[] arr={1,2,3};

        List<Integer> list =Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(list);


    }
}
