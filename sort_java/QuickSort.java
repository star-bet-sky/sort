import java.util.Arrays;
/*
先从数列中取出一个数，作为基准数（简单取第一个数作为基准数）
分区过程：将比基准数大的数字全放在其右边、小于等于它的数放在其左边
再对左右区间重复第一步、第二步，直到各个区间只有一个数（递归）
 */

public class QuickSort {
/*   public static void main(String[] args) {
        //给出无序数组
        int arr[] = {4,3,8,6,0,9,1,2,5,7};
        //输出无序数组
        System.out.println(Arrays.toString(arr));
        //快速排序
        quickSort(arr);
        //partition(arr,0,arr.length-1);
        //输出有序数组
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr){
        int low = 0;
        int high = arr.length-1;
        quickSort(arr,low,high);
    }

    private static void quickSort(int[] arr, int low, int high) {//递归何时结束？
        if(low<high) {
            //分区操作，将一个数组分成两个分区，返回分区界限的索引
            int index = partition(arr, low, high);
            //对左分区进行快排
            quickSort(arr, low, index - 1);
            //对右分区进行快排
            quickSort(arr, index + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        //指定左指针i和右指针j
        int i = low;
        int j = high;
        //将第一个数作为基准值。挖坑
        int x = arr[low];
        //使用循环实现分区操作
        while (i<j){//
            //1.从右向左移动j，找到第一个小于基准值的值arr[j]
            while(arr[j]>=x&&i<j){
                j--;
            }
            //2.将右侧找到的小于基准数的值加入到左边的（坑）位置，左指针向中间移动一个位置i++
            if(i<j){
                arr[i] = arr[j];
                i++;
            }
            //3.从左向右移动i，找到第一个大于等于基准值的值arr[i]
            while(arr[i]<x&&i<j){
                i++;
            }
            //4.将左侧找到的大于等于基准数的值加入到右边的（坑）位置，右指针向中间移动一个位置j--
            if(i<j){
                arr[j] = arr[i];
                j--;
            }
        }
        //使用基准值填坑，这就是基准值的最终位置
        arr[i]=x;   //arr[j]=y;
        //返回基准值位置索引
        return i;   //return j;
    }
}*/
    //  寻找pivot
    //  L为最右位置，F为最左位置；
    public static int Findpivot(int [] array,int L,int F) {
        int pivot = array[L]; //将第一个作为pivot；
        while(L<F) {
            while(array[F]>=pivot&&F>L) {
                F--;//大于pivot的位置右移一位
            }
            array[L] = array[F];//最左最左位置重合
            while(array[L]<=pivot&&F>L) {
                L++;//小大于pivot的位置左移一位
            }
            array[F] = array[L];//最左最左位置重合
        }
        array[F]= pivot; //记录pivot位置
        return F;//返回pivot位置
    }

    //快速排序核心部分，递归实现快速排序
    public static void QuickSort(int []array,int L,int F) {
        if(L>F) {
            return;
        }
        int index = Findpivot(array, L, F);//记录中间位置，将数组分为3部分
        QuickSort(array, L, F - 1);//将pivot右边的进行递归排序
        QuickSort(array, index+1, F);//将pivot左边的进行递归排序
    }

    //打印函数
     public static void printArr(int[] numbers)
    {
        for(int i = 0 ; i < numbers.length ; i ++ )
        {
        System.out.print(numbers[i] + ",");
        }
        System.out.println("");
    }

     //测试函数
    public static void main(String[] args) {
        int [] number = {1,9,3,12,7,8,3,4,65,22,-1};
        System.out.print("排序前的数据是：");
        printArr(number);
        QuickSort(number, 0, number.length-1);
        System.out.print("经过快排后得到的数据是：");
        printArr(number); 
    }
}

