package study2021.leetcode;

/**
 * @Description 任意数组相加相减等于目标数的解法数
 * @Author WangZeJun
 * @Date 2021/06/07 20:02
 **/
public class Test0607 {
    private static int count = 0;

    /**
     * 统计解法
     * @param nums
     * @param y
     * @return
     */
    public static int findTargetSumWays(int[] nums, int y) {
        dfs(nums, y, 0);
        return count;
    }

    /**
     * 递归计算
     * @param nums
     * @param y
     * @param i
     */
    public static void dfs(int[] nums, int y, int i) {
        int size = nums.length;
        if (i == size && y == 0) {
            count++;
            return;
        }
        if (i < size) {
            dfs(nums, y - nums[i], i + 1);
            dfs(nums, y + nums[i], i + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,1,1,1};
        int aa = findTargetSumWays(nums, 5);
        System.out.println("一共有多少种解法：" + aa);
    }
}
