/**
 * 移除元素
 * 7-6
 */
class Remove_Element {
    public int removeElement(int[] nums, int val) {
        int ans=0;
        for (int num :nums){
                if (num != val){
                    nums[ans] = num;
                    ans++;
                }
        }
        return ans;
    }
}
