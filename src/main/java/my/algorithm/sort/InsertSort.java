package my.algorithm.sort;

import java.util.Arrays;

/**
 * Created by paul on 2015/7/7.
 */
public class InsertSort {
    public static void sort(int[] a){
        int length = a.length;
        for (int i = 0; i < length -1; i++){
            int j = i+1;
            int data = a[j];
            while (j > 0 && data < a[j-1]){
                a[j] = a[j-1];
                j--;
            }
            a[j] = data;
        }
    }

    public static void main(String[] args) {
        int[] a ={49,38,65,97,76,13,27,49};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
