import java.util.Arrays;

public class FillMatrixWith1s {

    public static void main(String[] args) {
        int[][] matrix ={{1,0,0,1},
                         {0,0,1,0},
                         {0,0,0,0}
                        };
        int rows=matrix.length;
        int cols=matrix[0].length;
        boolean rowFlag=false;
        boolean colFlag=false;

        for(int i=0 ; i<rows ; i++){
            for(int j=0 ; j<cols ; j++){

                if(i==0 && matrix[0][j]==1){
                    colFlag=true;
                }

                if(j==0 && matrix[i][0]==1){
                    rowFlag=true;
                }


                if(matrix[i][j]==1){
                    matrix[i][0]=1;
                    matrix[0][j]=1;
                }
            }
        }


        for(int i=1 ; i<rows ; i++){
            for(int j=1 ; j<cols ; j++){

                if(matrix[i][0]==1 || matrix[0][j]==1){
                    matrix[i][j]=1;
                }
            }
        }

        if(rowFlag){
            for(int i=0 ; i<rows ; i++){
                matrix[i][0]=1;
            }
        }

        if(colFlag){
            for(int i=0 ; i<cols ; i++){
                matrix[0][i]=1;
            }
        }

        String s = Arrays.deepToString(matrix);
        System.out.println(s);

    }


}
