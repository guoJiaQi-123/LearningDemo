package com.itbaizhan;

import java.util.Arrays;
//二分法查找
public class TestBinarySearch {

    public static void main(String[] args) {
        int object[]={12,52,20,62,1,78,52,31,19};
        Arrays.sort(object);//二分法查找之前，一定要对数组元素排序
        System.out.println(Arrays.toString(object));
        int SearchWord =31;//所要查的数
        int mubiaosuoying=BinarySearch(object,SearchWord);
        System.out.println("31的索引为："+BinarySearch(object,SearchWord));
    }

    public static int BinarySearch(int[] array,int value){
        int low=0;//第一个索引下标
        int high=array.length-1;//最后一个索引下标
        while (low<high){
            int middle=(low+high)/2;//二分（中间的索引）
            if (array[middle]<value){
                low=middle+1;
            }
            else if (array[middle]>value){
                high=middle-1;
            }
            else{
                return middle;  //返回查询到的索引位置
            }
        }
        return -1;//上面循环完毕，说明未找到，返回-1
    }
}