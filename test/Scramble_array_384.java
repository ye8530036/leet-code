/**
 * 题目：打乱数组（384）
 * 时间：11-22
 * 题解：暴力
 *
 */





class Scramble_array_384 {
    private int[] nums;
    private int[] origin;
    public Scramble_array_384(int[] nums) {
        this.origin = nums;
        this.nums = nums.clone();
    }

    public int[] reset(){
        return origin;
}

    public int[] shuffle() {
        for (int i=0;i< nums.length;i++){
            //定义随机位置进行调换
            int rand = (int) (Math.random() *(nums.length-i)+i);
            swap(nums,i,rand);
        }
        return nums;
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
