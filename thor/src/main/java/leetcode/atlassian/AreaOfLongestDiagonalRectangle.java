package leetcode.atlassian;

public class AreaOfLongestDiagonalRectangle {
    public static void main(String[] args) {
        int[][] dimensions = {{9, 3}, {8, 6}};
        int result = areaOfMaxDiagonal(dimensions);
        System.out.println(result);

    }


    public static int areaOfMaxDiagonal(int[][] dimensions) {
        int totalRectangles = dimensions.length;

        int maxArea = Integer.MIN_VALUE;
        int currArea;
        double currDiagonalLength;
        double maxDiagonalLength = Double.MIN_VALUE;

        for (int i = 0; i < totalRectangles; i++) {

            currArea = dimensions[i][0] * dimensions[i][1];

            currDiagonalLength = Math.sqrt((dimensions[i][0] * dimensions[i][0]) +
                    (dimensions[i][1] * dimensions[i][1]));

            if (currDiagonalLength > maxDiagonalLength || (currDiagonalLength == maxDiagonalLength)
                    && (currArea > maxArea)) {
                maxDiagonalLength = currDiagonalLength;
                maxArea = currArea;

            }
        }

        return maxArea;
    }
}
