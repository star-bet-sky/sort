public class BubbleSort {
/*
  思想：找到一个临界点，该临界点之后的元素全部都是有序的
  核心：
      拿着左边的数字和右边的数字比对，当左边〉右边的时候，交换位置。
*/
/*
 冒泡排序
    时间复杂度：O(N²)
    稳定性：稳定
    排序原理：
        从前往后依次比较相邻的两个数据
        根据排序方向，将最大（最小）值移到最后面，一次遍历浮出一个数据，
        N次遍历之后，就将所有数据排序完成了。
*/
    static int a[] = new int[100000];
    static{
        for (int i = 0; i < 100000; i++) {
            Random random = new Random(100000);
            a[i] = random.nextInt();
        }
    }
    public static void main(String[]args){
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j <a.length-1 ; j++) {
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }

    }
}



  /*    int flag = a.length-1;
        while(flag > 0){
            int num = flag;
            flag=0; // 每次初始化临界点
            for (int i = 0; i < num; i++) {
                if(a[i]>a[i+1]){
                    int tmp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = tmp;
                    flag = i;
                }
            }
        }*/
