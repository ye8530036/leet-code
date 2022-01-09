/**
 * 题目：1629. 按键持续时间最长的键
 * 时间：1-9
 * 算法思路：一次遍历，模拟
 * 定义一个最长的按键时长，遍历数组找出持续时间最长的字符，将其赋值到初始值中
 */
class SlowestKey_1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int len = releaseTimes.length;
        char ans = keysPressed.charAt(0);
        //定义一个最大按键时长
        int maxTime = releaseTimes[0];
        for (int i=1;i<len;i++){
            //遍历数组字符，统计时长
            char key = keysPressed.charAt(i);
            //动态统计时间
            int time = releaseTimes[i] - releaseTimes[i-1];
            //找到时间最长的按键
            if (time > maxTime ||(time==maxTime && key >ans)){
                ans = key;
                maxTime = time;
            }
        }
        return ans;
    }
}
