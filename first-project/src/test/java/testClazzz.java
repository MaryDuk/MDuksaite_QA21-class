import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class testClazzz {

    int array1[] = new int [] {4,3,5,7,11,10,1,2,6};
    int length = array1.length;
    List<Integer> list1 =  Arrays.asList(4,3,5,7,11,10,1,2,6);
    List<Integer> list2 =  Arrays.asList(4,8,5,7,13,10,1,2,0);
    List<Integer> list3 =  Arrays.asList(4,0,5,7,19,10,1,2,6);
    List<Integer> list4 =  Arrays.asList(1,3,0,7,19,10,1,7,6);
    List<List<Integer>> listTable = new ArrayList<>();
    int[][] table = new int[][]{
        { 4,3,5,7,13,10,1,2,6 },
        { 4,1,5,7,6,10,1,2,0 },
        { 16,13,5,7,11,10,20,2,6 }
    };

    @DataProvider
    public Object[] validListTableFromCsv() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/table.csv")));
        List<List<Integer>> listTable = new ArrayList<>();
        String line = reader.readLine();
        while (line!=null){
            List<Integer> list = new ArrayList<>();
            String[] values = line.split(",");
            for(String value : values){
                list.add(Integer.parseInt(value));
            }
            listTable.add(list);
            line = reader.readLine();
        }
        return listTable.toArray();
    }
    @Test(dataProvider = "validListTableFromCsv")
    public void test(List<List<Integer>> listTable) throws InterruptedException {
       Integer test = listTable.get(0).get(0);
    }

    @Test
    public void test () throws InterruptedException {
        largest(array1);
        int [] res = largestInTable(table);
        System.out.println(Arrays.toString(res));

    }

    public void getIndex(){
        listTable.add(list1);
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
        int[] theIndOfMaxValColRow = new int[2];
        for (int row=0; row<table.length; row++) {
            for (int col=0; col<table[row].length; col++){
                if(table[row][col] > maxVal)
                {
                    maxVal = table[row][col];
                    theIndOfMaxValColRow[0] = row;
                    theIndOfMaxValColRow[1] = col;
                }
            }
        }

        return theIndOfMaxValColRow;
    }


}
