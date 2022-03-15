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
            return curValue ==max ? 1:0;
        }
        return dfs(curIndex+1,nums,curValue | nums[curIndex],max)+dfs(curIndex+1,nums,curValue,max);
    }
}
