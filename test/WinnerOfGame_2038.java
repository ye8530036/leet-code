/**
 * 题目：2038. 如果相邻两个颜色均相同则删除当前颜色
 * 总共有 n个颜色片段排成一列，每个颜色片段要么是'A'要么是'B'。给你一个长度为n的字符串colors，其中colors[i]表示第i个颜色片段的颜色。
 * Alice 和 Bob 在玩一个游戏，他们 轮流从这个字符串中删除颜色。Alice 先手。
 * 如果一个颜色片段为 'A'且 相邻两个颜色都是颜色 'A'，那么 Alice 可以删除该颜色片段。Alice不可以删除任何颜色'B'片段。
 * 如果一个颜色片段为 'B'且 相邻两个颜色都是颜色 'B'，那么 Bob 可以删除该颜色片段。Bob 不可以删除任何颜色 'A'片段。
 * Alice 和 Bob 不能从字符串两端删除颜色片段。
 * 如果其中一人无法继续操作，则该玩家 输掉游戏且另一玩家 获胜。
 * 假设 Alice 和 Bob 都采用最优策略，如果 Alice 获胜，请返回true，否则 Bob 获胜，返回false。
 * 时间：2022-3-22
 */



class WinnerOfGame_2038 {
    public boolean winnerOfGame(String colors) {
        int count = 0;
        for (int i=0;i<colors.length()-2;i++){
            //遍历，找到AAA的组合即Alice行动一次
            if (colors.substring(i,i+3).equals("AAA")){
                count++;
            }
            //找到BBB的组合即Bob行动一次
            if (colors.substring(i,i+3).equals("BBB")){
                count--;
            }
        }
        //统计行动点数为正即为Alice赢返回true否则则为false
        return count>0;
    }
}
