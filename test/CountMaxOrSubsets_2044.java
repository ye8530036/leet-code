/**
 * 题目：2044. 统计按位或能得到最大值的子集数目
 * 给你一个整数数组 nums ，请你找出 nums 子集 按位或 可能得到的 最大值 ，并返回按位或能得到最大值的 不同非空子集的数目。
 * 如果数组 a 可以由数组 b 删除一些元素（或不删除）得到，则认为数组 a 是数组 b 的一个 子集。
 * 如果选中的元素下标位置不一样，则认为两个子集 不同 。
 * 对数组 a 执行 按位或，结果等于 a[0] OR a[1] OR ... OR a[a.length - 1]（下标从 0 开始）。
 * 时间：2022-3-15
 * 算法：dfs，暴力求解
 * a∣b≥a, a∣b≥b， 所以最终最大的或结果为全部数字的或（因为或操作是非递减的）
 * 我们知道最大的或结果，只需统计有多少种子集能构成这个结果即可
 */



class CountMaxOrSubsets_2044 {
    public int countMaxOrSubsets(int[] nums) {
        //dfs暴力求解
        //1.首先对nums所有元素或得到一个最大值
        int max = 0;
        for (int num :nums){
            max |= num;
        }
        return dfs(0,nums,0,max);
    }
    private int dfs(int curIndex,int[] nums,int curValue,int max){
        if (curIndex == nums.length){
            return curValue == max ? 1:0;
        }
        return dfs(curIndex+1,nums,curValue | nums[curIndex],max)+dfs(curIndex+1,nums,curValue,max);
    }
}
