package my.algorithm;

import java.util.Arrays;

/**
 * Created by paul on 2015/7/6.
 */
public class SimpleSelection {
    public static void main(String[] args) {
        int[] a ={49,38,65,97,76,13,27,49};
        int length = a.length;
        for (int i = 0; i < length; i++){
            int min = i;
            for (int j = i+1; j < length; j++){
                if (a[j] < a[min])
                    min = j;
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        System.out.println(Arrays.toString(a));
    }
}
