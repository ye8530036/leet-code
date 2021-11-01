import java.util.ArrayList;
import java.util.List;

/**
 * 题目：Z字变换
 * 时间：11.1
 * 思路：算法流程： 按顺序遍历字符串 s；
 * res[i] += c： 把每个字符 c 填入对应行 s_i；
 * i += flag： 更新当前字符 c 对应的行索引；
 * flag = - flag： 在达到 Z 字形转折点时，执行反向。
 *
 *
 */
public class Z_Change {
    public String convert(String s, int numRows) {
        if (numRows<2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i=0;i<numRows;i++){
            //按照行数循环创建新的列表
            rows.add(new StringBuilder());
        }
        int i=0,flag=-1;
        for (char c:s.toCharArray()){
            //遍历字符，进行拼接
            rows.get(i).append(c);
            if (i==0 || i==numRows-1){
                //翻转索引
                flag=-flag;
            }
            i=i+flag;
        }
        StringBuilder res = new StringBuilder();
        //循环拼接数据放入row这个新的空间内
        for (StringBuilder row:rows){
            //连接字符串
            res.append(row);
        }
        return res.toString();
    }
}
