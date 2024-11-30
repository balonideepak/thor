public class SearchInSortedMatrix {
    public static void main(String[] args) {

        int[][] mat={{1,2,3},{4,5,6},{7,8,9}};
        boolean b = matSearch(mat, 4);
        System.out.println(b);
    }

    public static boolean matSearch(int mat[][], int x) {
        // your code here
        int rows=mat.length;
        int cols=mat[0].length;
        int currRow=0;
        int currCol=cols-1;

        while(currRow < rows && currCol >= 0){

            if(mat[currRow][currCol] > x ){
                currCol--;
            }
            else if(mat[currRow][currCol] < x ){
                currRow++;
            }else if(x == mat[currRow][currCol] ){
                return true;
            }

        }

        return false;
    }
}
