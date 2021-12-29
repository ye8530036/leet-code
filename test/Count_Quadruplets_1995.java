/**
 * 题目：1995. 统计特殊四元组
 * 时间：12-29
 * 算法思路：直接循环遍历，枚举所有方法来寻找满足条件的组合
 */

class Count_Quadruplets_1995 {
    public int countQuadruplets(int[] nums) {
        int n = nums.length,ans = 0;
        //直接枚举，嵌套多重循环来遍历找到符合的组合
        for (int a=0;a<n;a++){
            for (int b=a+1;b<n;b++){
                for (int c=b+1;c<n;c++){
                    for (int d=c+1;d<n;d++){
                        if (nums[a]+nums[b]+nums[c] ==nums[d]){
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
