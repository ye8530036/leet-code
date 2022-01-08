import java.util.ArrayList;
import java.util.List;

/**
 * 题目：格雷代码-89
 * 时间：1-8
 * 算法思路：
 * 关键是搞清楚格雷编码的生成过程：
 *         G(i) = i ^ (i/2);
 *         如 n = 3;
 *         G(0) = 000,
 *         G(1) = 1 ^ 0 = 001 ^ 000 = 001
 *         G(2) = 2 ^ 1 = 010 ^ 001 = 011
 *         G(3) = 3 ^ 1 = 011 ^ 001 = 010
 *         G(4) = 4 ^ 2 = 100 ^ 010 = 110
 *         G(5) = 5 ^ 2 = 101 ^ 010 = 111
 *         G(6) = 6 ^ 3 = 110 ^ 011 = 101
 *         G(7) = 7 ^ 3 = 111 ^ 011 = 100
 */
class grayCode_89 {
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        for (int i=0;i<1<<n;++i){
            //异或运算符（^）
            //参加运算的两个数据，按二进制位进行“异或”运算。
            //运算规则：0^0=0；  0^1=1；  1^0=1；   1^1=0；
            ret.add(i ^ i>>1);
        }
        return ret;
    }
}
