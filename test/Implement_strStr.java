/**
 * 实现 strStr()
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 * 7-7
 */
class Implement_strStr {
    public int strStr(String haystack, String needle) {
//        int n=haystack.length(), m=needle.length();
//        if (m==0)
//        {
//            return 0;
//        }
//        for (int i=0;i<=n-m;i++){
//            boolean flag = true;
//            for (int j=0;j<m;j++){
//                if (haystack.charAt(i+j) !=needle.charAt(j)){
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag){
//                return i;
//            }
//        }
//        return -1;
        char[] n = haystack.toCharArray(), m = needle.toCharArray();
        for (int i = 0; i <= n.length - m.length; i++) {
            int j;
            for (j = 0; j < m.length; j++)
                if (n[i + j] != m[j])
                    break;
            if (j == m.length)
                return i;
        }
        return -1;
    }
}
