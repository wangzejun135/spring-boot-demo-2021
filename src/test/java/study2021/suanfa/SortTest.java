package study2021.suanfa;

import java.util.Arrays;

/**
 * @Describe 冒泡排序时间复杂度为O(n2)
 * @Author wangzejun
 * @Date 2021/3/31 20:33
 */
public class SortTest {

    public static void main(String[] args) {
        int[] array = {5, 4, 1, 2, 3};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static int[] sort(int[] array) {
        boolean bool;
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            bool = true;
            for (int j = 0; j < len - 1 - i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    bool = false;
                }
            }
            if (bool) {
                break;
            }
        }
        return array;
    }
}
