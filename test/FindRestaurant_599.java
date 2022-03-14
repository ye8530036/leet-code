import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目：599. 两个列表的最小索引总和
 * 假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。
 * 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
 * 时间：2022-3-14
 */

class FindRestaurant_599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int n = list1.length, m = list2.length;
        Map<String,Integer> map = new HashMap<>();
        for (int i=0;i<n;i++){
            map.put(list1[i],i);
        }
        List<String> ans = new ArrayList<>();
        int min=3000;
        for (int j=0;j<m;j++){
            String s = list2[j];
            if (!map.containsKey(s)){
                continue;
            }
            if (j+map.get(s)<min){
                ans.clear();
                min = j+map.get(s);
                ans.add(s);
            }else if (j+ map.get(s)==min){
                ans.add(s);
            }
        }
        return ans.toArray(new String[0]);
    }
}
