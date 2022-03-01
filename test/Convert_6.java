import java.util.Arrays;

/**
 * 题目：Z字变换_6
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 其实就是进行Z字型重新排列字符
 * 得到之后重新从上往下组合字符输出
 * 时间：2022-3-1
 * 算法：首先我们按照题意将字符重新排列，放到一个矩阵中，之后我们在将其重新读取
 *
 */

class Convert_6 {
    static int N =1010;//定义一个够大的初始值
    static char[][] g = new char[N][N];//构建一个矩阵g来存放给定的字符串s
    static int[] idxs = new int[N];//idxs用来存放指定的下标
    public String convert(String s, int m) {
        if (m==1){
            return s;
        }
        int n = s.length();
        Arrays.fill(idxs,0);//先将下标填充成0
        for (int i = 0,j=0,k=1;i<n;i++){
            g[j][idxs[j]++] = s.charAt(i);//循环将字符串s填充进矩阵
            j +=k;
            if (j<0){
                j+=2;k=1;
            }else if (j==m){
                j-=2;k=-1;
            }
        }
        //提取z字的字符，将其赋值到sb
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<m;i++){
            for (int j=0;j<idxs[i];j++){
                sb.append(g[i][j]);
            }
        }
        return sb.toString();
    }
}
