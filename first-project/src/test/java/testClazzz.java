import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class testClazzz {

    int array1[] = new int [] {4,3,5,7,11,10,1,2,6};
    int length = array1.length;
    int[][] table = new int[][]{
        { 4,3,5,7,13,10,1,2,6 },
        { 4,1,5,7,6,10,1,2,0 },
        { 16,13,5,7,11,10,20,2,6 }
    };

    @Test
    public void test (){
        largest(array1);
        largestInTable(table);
    }

    public int largest(int array[]){

        int max = array [0];
        int index = 0;
        for (int i=0; i<length; i++) {
         if (array[i] > max){
             max = array [i];
             index = i;
            }
        }
        return index;
    }
    public int [] largestInTable(int[][] table) {
        int maxVal = table [0][0];
       // int indexOfColWithMaxVal = 0;
        int[] theIndOfMaxValColRow = new int[2];
        for (int row=0; row<table.length; row++) {
            for (int col=0; col<table[row].length; col++){
                if(table[row][col] > maxVal)
                {
                    maxVal = table[row][col];
                   // indexOfColWithMaxVal = col;
                    theIndOfMaxValColRow[1] = col;
                }
            }theIndOfMaxValColRow[0] = row;
        }

        return theIndOfMaxValColRow;
    }


}
