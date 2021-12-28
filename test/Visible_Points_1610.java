/**
 * 题目：1610. 可见点的最大数目
 * 时间：12-16
 * 思路：算出每一个坐标相对于location位置与x轴的夹角（弧度制），扔到List中排序
 * 然后对于每一个点，使用二分或滑动窗口找出小于这个点+angle（转成弧度制）的最大坐标点
 * 两者之间的下标差就是从这个点出发，辐射angle角度的点数量
 * 注意，与location点相同的点的特殊处理
 *
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Visible_Points_1610 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int same = 0;
        List<Double> list = new ArrayList<>();
        int x = location.get(0),y = location.get(1);
        for (List<Integer> point:points){
            //a为横坐标，b为纵坐标
            int a =point.get(0),b = point.get(1);
            if (a==x && b==y){
                //与location同点的点，需要在最后加上一起处理
                same++;
            }
            else {
                //计算角度（弧度制）
                //利用的是atan2函数来计算点
                list.add(Math.atan2(b-y,a-x));
            }
        }
        //排序
        Collections.sort(list);
        int size = list.size();
        for (int i=0;i<size;i++){
            //为了处理 -180° 到 180° 的过度，我们可以把所有的坐标加上 360° 再加一遍到 list 中，然后范围相当于变成了 [-π, 3π]
            list.add(list.get(i) + 2*Math.PI);
        }
        double angleDegree = angle * Math.PI/180;
        int max = 0;
        int i=0,j=0;
        while (i<size){
            //滑动窗口，滑动比对条件
            while (j < 2*size && list.get(j) - list.get(i) <= angleDegree){
                j++;
            }
            max = Math.max(max,j-i);
            i++;
        }
        return max +same;
    }
}
