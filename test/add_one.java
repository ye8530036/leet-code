/**
 * 加一
 * 7-13
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 */
class add_one {
    public int[] plusOne(int[] digits) {
        int one = digits.length;
        for (int i=one-1;i>=0;i--) //循环查看每一位的值，i为末位
        {
            digits[i]++;
            digits[i] %=10;
            if (digits[i] !=0)   //是否进位
                return digits;
        }
        digits = new int[one +1]; //进位
        digits[0]=1;
        return digits;
    }
}
