public class QuickSort {
    public static void main(String args[]){
        int [] testArray = {435,465,324,964,752,444,854,213,974,564,333};
        quickSort(0,testArray.length - 1,testArray);
        for(int i:testArray){
            System.out.println(i);
        }
    }

    public static void quickSort(int begin,int end,int [] array){
        //执行递归的时候需要有一个条件来判断是否继续递归下去，这里就是(begin<end)
        if(begin<end){
            int goal = getGoal(begin,end,array);
            //此时goal的位置左边比它小，右边比它大，所以不再需要进行比较，进行另外两列的比较
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
