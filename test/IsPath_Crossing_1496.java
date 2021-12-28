import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 题目：1496. 判断路径是否相交
 * 时间：11-25
 * 算法思路：利用hashset保存坐标，并将坐标以字符串形式保存
 * 之后对比坐标是否在在hash存储中出现过
 * 如果有出现则返回true；否则添加坐标直到循环结束并返回false
 * 此处用hashset的好处是，HashSet 基于 HashMap 来实现的，是一个不允许有重复元素的集合。
 * HashSet 允许有 null 值。
 * HashSet 是无序的，即不会记录插入的顺序。
 * HashSet 不是线程安全的， 如果多个线程尝试同时修改 HashSet，则最终结果是不确定的。
 * 我们必须在多线程访问时显式同步对 HashSet 的并发访问。
 */
class IsPath_Crossing_1496 {
    public boolean isPathCrossing(String path) {
        int[] point = new int[]{0,0};
        //用字符串形式保存每个点的坐标
        Set<String> set = new HashSet<>();
        //设定一个坐标的初始值，即原点，注意逗号后面需空一格否则将报错
        set.add("[0, 0]");
        for (char c : path.toCharArray()){
            if (c=='N'){
                point[0] += 1;
            }
            else if (c=='S') {
                point[0] -= 1;
            }
            else if (c=='E'){
                point[1] +=1;
            }
            else if (c=='W'){
                point[1] -=1;
            }
            //如果已有坐标就表示已走过
            if (set.contains(Arrays.toString(point))){
                return true;
            }
            //否则添加坐标
            else {
                set.add(Arrays.toString(point));
            }
        }
        return false;
    }
}
