public class test{
    int [] aux;//归并时所需的辅助数组
    public void sort(int [] a)
    {
        aux=new int[a.length];//一次性分配空间
        sort_from_top_to_bottom(a,0,a.length-1);//
    }
    public void sort_from_top_to_bottom(int a [],int low,int high)//排序
    {
        for(int i=low;i<=high;i++)
            System.out.print(a[i]+" ");
        System.out.println();
     if(high<=low)//划分得每个子数组只有一个元素了
         return;
     int mid=low+(high-low)/2;//再次确定划分得界限
        sort_from_top_to_bottom(a,low,mid);//将左半部分排序
        sort_from_top_to_bottom(a,mid+1,high);//将右边部分排序
        merge(a,low,mid,high);//开始合并
        System.out.print("merge:");
        for(int i=low;i<=high;i++)
            System.out.print(""+a[i]+" ");
        System.out.println();
    }

   public void merge(int a[],int low,int mid,int high)//归并
   {
       int i=low;
       int j=mid+1;
       for(int k=low;k<=high;k++)
           aux[k]=a[k];
       for(int k=low;k<=high;k++)
       {
           if(i>mid) //左边已经用尽，开始取右半边元素
               a[k]=aux[j++];
           else if(j>high)//右边已经用尽，开始取左半边元素
               a[k]=aux[i++];
           else if(aux[j]<aux[i])//右半边元素小于左半边元素，取右半边元素---升序
               a[k]=aux[j++];
           else //左半边元素小于右半边元素，取左半边元素---升序
               a[k]=aux[i++];
       }
   }
   public void sort_from_bottom_to_top(int a[])//自底向上
   {
       int N=a.length;
       aux=new int[a.length];//一次性分配空间
       for(int sz=1;sz<N;sz=sz+sz)//sz为子数组的大小
           for(int lo=0;lo<N-sz;lo+=sz+sz)//lo为子数组索引
           {
               merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
               for(int k=lo;k<=Math.min(lo+sz+sz-1,N-1);k++)
                   System.out.print(a[k]+" ");
               System.out.println();
           }
   }
   public static void main(String [] args)
   {
       int [] a={16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
       test t=new test();
       System.out.println("初始数组：");
       for(int i=0;i<16;i++)
           System.out.print(a[i]+" ");
       System.out.println();
       System.out.println("自顶向下实现：");
       t.sort(a);
       System.out.println("自底向上实现：");
       t.sort_from_bottom_to_top(a);
       for(int i=0;i<16;i++)
           System.out.print(a[i]+" ");
   }
}
