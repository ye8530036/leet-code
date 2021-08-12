/**
 * 只出现一次的数字
 *
 * ８-12
 *
 * 算法:1.或与运算 ^
 *
 * 思路及算法:
 * a^a=0
 * a^b^a=b
 * 0^0 = 0
 * 1^0 = 1
 * 0^1 = 1
 * 1^1 = 0
 */
class SingleNumber {
    public int singleNumber(int[] nums) {
        int single=0;
        for (int num:nums)
        {
            single^=num;
        }
        return single;
    }
}
