import java.util.Arrays;
import java.util.HashMap;

/**
 * 题目：954. 二倍数对数组
 * 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足
 * “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；
 * 否则，返回 false。
 * 时间：2022-4-1
 *
 */
class CanReorderDoubled_954 {
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        //将arr放入map中
        for (int i:arr){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        //重组arr
        Arrays.sort(arr);
        for (int i:arr){
            if (map.get(i)==0){
                continue;
            }
            //对于每个0 <= i < len(arr) / 2符合条件的i
            //换算即得0<=i*2<len(arr)
            //尝试寻找 2 * i
            //containsKey()	检查 hashMap 中是否存在指定的 key 对应的映射关系。
            if (i>0 && map.containsKey(i*2)&& map.get(i*2)!=0){
                //找到即加入
                map.put(i*2,map.get(i*2)-1);
            }
            //奇数必须找2*i
            else if ((i & 1)==0 &&map.containsKey(i/2)&&map.get(i/2)!=0){
                //找到即加入
                map.put(i/2,map.get(i/2)-1);
            }
            //寻找满足arr[2 * i + 1] = 2 * arr[2 * i]
            //找不到直接false
            else return false;
            map.put(i,map.get(i) -1);
        }
        return true;
    }
}
