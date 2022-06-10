import java.util.ArrayDeque;
import java.util.Arrays;

public class count {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[][] field1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 1, -1, 1, 0}};

        System.out.println(Arrays.deepToString(click(field1, 3, 5, 2, 2)));


        // [[0, 0, 0, 0, 0],
        //  [0, 1, 1, 1, 0],
        //  [0, 1, -1, 1, 0]]

        System.out.println(Arrays.deepToString(click(field1, 3, 5, 1, 4)));
        // [[-2, -2, -2, -2, -2],
        //  [-2, 1, 1, 1, -2],
        //  [-2, 1, -1, 1, -2]]

        int[][] field2 = {{-1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, -1}};

        System.out.println(Arrays.deepToString(click(field2, 4, 4, 0, 1)));
        // [[-1, 1, 0, 0],
        //  [1, 1, 0, 0],
        //  [0, 0, 1, 1],
        //  [0, 0, 1, -1]]

        System.out.println(Arrays.deepToString(click(field2, 4, 4, 1, 3)));
        // [[-1, 1, -2, -2],
        //  [1, 1, -2, -2],
        //  [-2, -2, 1, 1],
        //  [-2, -2, 1, -1]]
    }

    // Implement your solution below.
    public static int[][] click(int[][] field, int numRows, int numCols, int givenI, int givenJ) {

        ArrayDeque<int[]> toCheck = new ArrayDeque<int[]>();

        if(field[givenI][givenJ] == 0){
            field[givenI][givenJ] = -2;
            int[] coord = {givenI, givenJ};
            toCheck.add(coord);
        }else{
            return field;
        }

        while(!toCheck.isEmpty()){
            int[] currentCoord = toCheck.remove();
            int currentI = currentCoord[0];
            int currentJ = currentCoord[1];

            for(int i = currentI - 1; i < currentI + 2; i++){
                for(int j = currentJ - 1; j < currentJ + 2; j++){
                    if(i >= 0 && i < numRows && j >= 0 && j < numCols && field[i][j] == 0){
                        field[i][j] = -2;
                        int[] coord = {i, j};
                        toCheck.add(coord);
                    }
                }
            }
        }
        return field;
    }
}


