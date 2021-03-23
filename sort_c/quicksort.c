#include<stdio.h>
void quicksort(int a[],int n){
	int i,j;
	int pivot = a[0];	//设置基准值 
	i = 0;
	j = n - 1;
	while(i < j){
		//大于基准值者保持在原位置 
		while(i < j && a[j] > pivot){	j--;} 
		if(i < j){
			a[i] = a[j];
			i++;
		}
		//不大于基准值者保持在原位置 
		while(i < j && a[i] <= pivot){ 	i++;} 
		if(i < j){
			a[j] = a[i];
			j--;
		}
	} 
	a[i] = pivot;	//基准元素归位 
		if(i > 1){
			//递归地对左子序列 进行快速排序
			quicksort(a,i); 
		}
		if(n-i-1 > 1){
			quicksort(a+i+1,n-i-1);
		}
} 
 
int main(){
	int i,arr[] = {23,56,9,75,18,42,11,67};
	quicksort(arr,8);
	for(i = 0;i < sizeof(arr)/sizeof(int);i++)
		printf("%d\t",arr[i]);
	return 0;
}