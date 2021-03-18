#include <stdio.h>
//find string in string, return the first start location or -1 if can not find
int StringFind(const char *pSrc, const char *pDst)
{
	int i, j;
	for (i=0; pSrc[i]!='\0'; i++)
	{
		if(pSrc[i]!=pDst[0])
			continue;		
		j = 0;//遍历数组
		while(pDst[j]!='\0' && pSrc[i+j]!='\0')
		{
			j++;
			if(pDst[j]!=pSrc[i+j])
			break;//进行对比
		}
		if(pDst[j]=='\0')
			return i;
	}
	return -1;
}
int main(){
　　char* t = "ffdsssssssssddddddflowerdddddd";
　　printf("字符串第一次出现位置:%d\n",StringFind(t,"flower"));
　　getchar();
　　return 0;
}
