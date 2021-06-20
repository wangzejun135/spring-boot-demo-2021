package study2021.leetcode;

/**
 * @Description 任意数组相加相减等于目标数的解法数
 * 解题思路:
 * 假设数组和为 sum，其中 要取负数的和 为 neg，则 正数和 为 (sum - neg)。那么，就能得出：
 * (sum - neg) - neg = target
 * 再次计算，可得：
 * neg = (sum + target) / 2
 * 由此，我们可以得出条件：
 * sum - target 必须是2的倍数，且 大于0
 *
 * 实现流程:
 * 根据上述推导继续筛选
 * 构造一个dp数组，dp[i][j]表示：前i个数字中，组成和为j的可能性，有 dp[i][j]种
 * 遍历nums数组：
 * 若 j < curNum，则 dp[i][j] 的个数为 dp[i - 1][j]的个数(当前数字不取负)
 * 若 j >= curNum，则 dp[i][j] 的个数为 dp[i - 1][j]的个数(当前数字不取负) 和 dp[i - 1][j - num]的个数(当前数字取负) 的和
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
        int[] nums = {1,1,1,1};
        int aa = findTargetSumWays(nums, 2);
        System.out.println("一共有多少种解法：" + aa);
    }
}
