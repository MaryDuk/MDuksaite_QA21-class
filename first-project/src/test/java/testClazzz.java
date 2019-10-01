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
    List<List<Integer>> listTable = new ArrayList<>();
    List <Object[]> list = new ArrayList<>();
    int[][] table = new int[][]{
        { 4,3,5,7,13,10,1,2,6 },
        { 4,1,5,7,6,10,1,2,0 },
        { 16,13,5,7,11,10,20,2,6 }
    };

    public List<List<Integer>> getListTableFromCsv() throws IOException {
        List<List<Integer>> listTable = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/table.csv")));
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
        return listTable;
    }

    public Integer[][] getArrayFromList(List<List<Integer>> list){
        Integer[][] array = new Integer[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> row = list.get(i);
            array[i] = row.toArray(new Integer[row.size()]);
        }
        return array;
    }

    @DataProvider
    public Iterator<Object[]>validListTableFromCsv2() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/table.csv")));
        //List <Object[]> list = new ArrayList<>();
        String line = reader.readLine();
        while (line!=null){
            TestData1 testData = new TestData1();
            String[] values = line.split(",");
                list.add(new Object[]{
                        testData.setNum1(values[0]).setNum2(values[1]).setNum3(values[2]).setNum4(values[3]).setNum5(values[4]).setNum6(values[5]).setNum7(values[6])
                });
                line = reader.readLine();
        }
        return list.iterator();
    }
    @Test
    public void testTable() throws IOException {
      List<List<Integer>> table = getListTableFromCsv();
      Integer maxVal = table.get(0).get(0);
      Integer indexOfMaxValue = 0;
      for(int row = 0;row < table.size(); row++){
          for(int col = 0;col < table.get(row).size(); col++){
              if(table.get(row).get(col) > maxVal)
              {
                  maxVal = table.get(row).get(col);
                  indexOfMaxValue = col + (table.get(row).size()*row);
              }
      }
      } System.out.println("Total index of Max value : " + indexOfMaxValue);
    }

//    @Test(dataProvider = "validListTableFromCsv2")
//    public void testCsv () throws InterruptedException {
//
//
//    }

    @Test
    public void test () throws InterruptedException {
        int indOfMax= largest(array1);
        System.out.println(indOfMax);
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
