#include <stdio.h>
int main(){
	int a[]={1,2,3,5,6,4,7,9,8,0};
	int lenth=10;
	int dir=0;
	BubbleSort(a,lenth,dir);
}

void BubbleSort(int* data, int lenth, int direction)
{
	int i, j;
 
	if(direction){//从小到大
		for (j = lenth - 1; j > 1; j--)//已排序数据放到最后面 遍历长度减-
		{
			for (i = 0; i < j; i++)//从前往后遍历 泡泡往后挤
			{
				if (data[i] > data[i + 1])//把大的数据往后移动 注意两数相等的情况是不交换的 算法相对稳定
				{
					DataSwap(data[i], data[i + 1]);//两数交换
				}
			}
		}
	}
	else{//从大到小
		for (j = 0; j < lenth - 1; j++)//已排序数据放到最前面
		{
			for (i = lenth - 1; i > j; i--)//从后往前遍历 泡泡往前挤
			{
				if (data[i] > data[i - 1])//把大的数据前移
				{
					DataSwap(data[i], data[i - 1]);
				}
			}
		}
	}
}
void DataSwap(int i ,int j){
	int temp = i;
	i = j;
	j = temp;
}