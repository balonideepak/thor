import java.util.Arrays;
import java.util.List;

public class ElementWithLeftSideSmallerAndRightGreater {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 2, 5, 7);
        int element = findElement(list);
        System.out.println(element);

    }

    public static int findElement(List<Integer> arr) {
        int n = arr.size();
        int result = -1;
        boolean matchFoundForRightSide = false;

        if(n==1){
            return result;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (!matchFoundForRightSide && arr.get(i) < arr.get(i + 1)) {
                result = arr.get(i);
                matchFoundForRightSide = true;
            } else if (result > arr.get(i)) {

                if (i == n - 1) {
                    return result;
                }
            } else {
                return -1;
            }
        }
        return result;
    }
}
