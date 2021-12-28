/**
 * 题目：1013. 将数组分成和相等的三个部分
 * 时间：12-28
 * 算法：暴力破解，找规律再把满足的等分值次数计数进行判定
 */

class Can_ThreeParts_EqualSum_1013 {
    public boolean canThreePartsEqualSum(int[] arr) {
        int ans = 0,center = 0,sum = 0;
        //首先统计总和
        for (int k : arr) {
            ans += k;
        }
        //根据题意能分成三分，即能
        if (ans%3!=0){
            return false;
        }
        //获取等分值
        ans = ans / 3;
        for (int k : arr) {
            center += k;
            //循环相加，每次等于等分值就清除重加
            if (center==ans){
                sum++;
                center=0;
            }
        }
        //若次数在3次以上即满足
     return sum>=3;
    }
}
