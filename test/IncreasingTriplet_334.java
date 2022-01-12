/**
 * 题目：334. 递增的三元子序列
 * 时间：1-12
 * 思路和算法：贪心
 * 我们可以对 f 数组进行优化：使用有限变量进行替换（将 f 数组的长度压缩为 2），数组含义不变，
 * f[1] = x 代表长度为 1 的上升子序列最小结尾元素为 x，f[2] = y 代表长度为 2 的上升子序列的最小结尾元素为 y。
 * 从前往后扫描每个 nums[i]nums[i]，每次将 nums[i]
 * 分别与 f[1] 和 f[2] 进行比较，如果能够满足 nums[i] > f[2]，代表 nums[i] 能够接在长度为 2 的上升子序列的后面，
 * 直接返回 True，否则尝试使用 nums[i] 来更新 f[1] 和 f[2]。
 */
class IncreasingTriplet_334 {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        long[] f = new long[3];
        //unsigned __int64的最大值：18446744073709551615  1e19
        f[1] = f[2] = (int)1e19;
        for (int t : nums) {
            if (f[2] < t) {
                return true;
            } else if (f[1] < t && t < f[2]) {
                f[2] = t;
            } else if (f[1] > t) {
                f[1] = t;
            }
        }
        return false;
    }
}
