//最长公共前缀 6_30
class Longest_Common_Prefix {
        public String longestCommonPrefix(String[] strs) {
            if(strs.length == 0)
                return "";
            String ans = strs[0];
            for(int i =1;i<strs.length;i++) {
                int j=0;
                for(;j<ans.length() && j < strs[i].length();j++) {
                    if(ans.charAt(j) != strs[i].charAt(j))
                        break;
                }
                //substring截取字符串
                ans = ans.substring(0, j);
                if(ans.equals(""))
                    return ans;
            }
            return ans;
        }

}
