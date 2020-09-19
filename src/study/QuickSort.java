package study;

import java.lang.reflect.Array;

public class QuickSort {
    public static void main(String args[]){
        int [] testArray = {435,465,324,964,752,444,854,213,974,564,333};
        quickSort(0,testArray.length - 1,testArray);
        for(int i:testArray){
            System.out.println(i + "");
        }
    }

    public static void quickSort(int begin,int end,int [] array){
        //执行递归的时候需要有一个条件来判断是否继续执行下去，这立就是(begin<end)
        if(begin<end){
            int goal = getGoal(begin,end,array);
            quickSort(begin,goal-1,array);
            quickSort(goal+1,end,array);
        }
    }


    public static int getGoal(int begin,int end,int [] array){
        int tempNum = array[begin];
        while (begin<end){
            while (begin<end && array[end]>tempNum){
                end--;
            }
            array[begin] = array[end];
            while(begin<end && array[begin]<tempNum){
                begin++;
            }
            array[end] = array[begin];
        }
        array[begin] = tempNum;
        return begin;
    }
}
