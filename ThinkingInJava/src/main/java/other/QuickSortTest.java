package main.java.other;

/**
 * @author toutou
 * @date by 2020/05
 */
public class QuickSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{4,1,9,15,93,2,8,6};
        sort(arr, 0, arr.length - 1);
        System.out.println("OK");
    }

    public static void sort(int[] arr, int low, int high){
        int i,j,temp,t;
        if(arr == null || arr.length < 2 || low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];
        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基准位与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        sort(arr, low, j-1);
        //递归调用右半数组
        sort(arr, j+1, high);
    }
}
