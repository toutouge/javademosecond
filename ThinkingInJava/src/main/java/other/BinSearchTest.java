package main.java.other;

/**
 * @author toutou
 * @date by 2020/05
 */
public class BinSearchTest {
    public static void main(String[] args) {
        int[] array ={1,2,3,4,6,7,8,9,10};
        System.out.println( binSearch(array,3,0,array.length-1));
        System.out.println( binSearchWhile(array, 8));
    }

    public static int binSearch(int[] arr, int key, int l, int h){
        if(key < arr[l] || key > arr[h] || l > h){
            return -1;
        }
        int middle = (l + h) / 2;
        if(arr[middle] > key){
            return binSearch(arr, key, l, middle - 1);
        }else if(arr[middle] < key){
            return binSearch(arr, key, middle + 1, h);
        }else{
            return middle;
        }
    }
    public static int binSearchWhile(int[] arr, int key){
        int l = 0;
        int h = arr.length - 1;
        int middle;
        if(key < arr[l] || key > arr[h] || l > h){
            return -1;
        }
        while (l <= h){
            middle = (l + h) / 2;
            if(arr[middle] > key){
                h = middle - 1;
            }else if(arr[middle] < key){
                l = middle + 1;
            }else{
                return middle;
            }
        }
        return -1;
    }
}
