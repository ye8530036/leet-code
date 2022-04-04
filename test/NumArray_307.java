/**
 * 树状数组模板
 * 上来先把三个方法写出来
 * {
 *     int[] tree;
 *     int lowbit(int x) {
 *         return x & -x;
 *     }
 * 查询前缀和的方法
 *     int query(int x) {
 *         int ans = 0;
 *         for (int i = x; i > 0; i -= lowbit(i)) ans += tree[i];
 *         return ans;
 *     }
 * 在树状数组 x 位置中增加值 u
 *     void add(int x, int u) {
 *         for (int i = x; i <= n; i += lowbit(i)) tree[i] += u;
 *     }
 * }
 *
 * 初始化「树状数组」，要默认数组是从 1 开始
 * {
 *     for (int i = 0; i < n; i++) add(i + 1, nums[i]);
 * }
 *
 * 使用「树状数组」：
 * {
 *     void update(int i, int val) {
 * 原有的值是 nums[i]，要使得修改为 val，需要增加 val - nums[i]
 *         add(i + 1, val - nums[i]);
 *         nums[i] = val;
 *     }
 *
 *     int sumRange(int l, int r) {
 *         return query(r + 1) - query(l);
 *     }
 * }
 * 题目：307. 区域和检索 - 数组可修改
 * 给你一个数组 nums ，请你完成两类查询。
 *
 * 其中一类查询要求 更新 数组 nums 下标对应的值
 * 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 用整数数组 nums 初始化对象
 * void update(int index, int val) 将 nums[index] 的值 更新 为 val
 * int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和
 * （即，nums[left] + nums[left + 1], ..., nums[right]）
 *
 * 时间：2022-4-4
 */

class NumArray_307 {
    int[] tree;
    int lowbit(int x){
        return x & -x;
    }
    int query(int x){
        int ans = 0;
        for (int i=x;i>0;i-=lowbit(i)){
            ans += tree[i];
        }
        return ans;
    }
    void add(int x,int u){
        for (int i=x;i<=n;i+=lowbit(i)){
            tree[i] +=u;
        }
    }

    int[] nums;
    int n;
    public NumArray_307(int[] _nums) {
        nums = _nums;
        n = nums.length;
        tree = new int[n+1];
        for (int i=0;i<n;i++){
            add(i+1,nums[i]);
        }

    }
    public void update(int index, int val) {
        add(index+1,val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return query(right+1)-query(left);
    }

}
