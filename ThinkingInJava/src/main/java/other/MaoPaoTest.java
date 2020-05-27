package main.java.other;

/**
 * @author toutou
 * @date by 2020/05
 */
public class MaoPaoTest {
    public static void main(String[] args) {
        //冒泡排序算法
        int[] arr=new int[]{93,1,5,8,2,3,9,4};
        sort(arr);
        System.out.println("从小到大排序后的结果是:");
    }

    public static void sort(int[] arr){
        int i,j;
        for(i=0;i<arr.length-1;i++)
        {
            for(j=0;j<arr.length-1-i;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}

