package study2021.suanfa;

import java.util.Arrays;

/**
 * @Describe 冒泡排序时间复杂度为O(n)
 * @Author wangzejun
 * @Date 2021/3/31 20:33
 */
public class MaoPaoSortTest {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 3, 4};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 普通int数组从小到大排序
     * @param arr
     */
    public static int[] sort(int[] arr) {
        int length = arr.length;
        boolean sorted;
        // 循环次数, 每完成一次, 沉入底部一个数
        for(int j=0;j<length-1;j++) {
            // 每一次开始, 默认已经排好序
            sorted = true;
            for(int i=0;i<length-1-j;i++) {
                if(arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    // 还没有排好序
                    sorted = false;
                }
            }
            // 确实已经排好序了
            if(sorted) {
                // 不再继续循环
                break;
            }
        }
        return arr;
    }
}
