/**
 * 是否是回文
 *
 * ８-11
 *
 * 算法:1.遍历 2.双指针判断
 *
 * 思路及算法:
 *
 * 首先对字符串 a 进行一次遍历，并将其中的字母和数字字符进行保留，放在另一个字符串 b 中。这样我们只需要判断 b 是否是一个普通的回文串即可
 *
 * 其次第二种是使用双指针。初始时，左右指针分别指向 b 的两侧，随后我们不断地将这两个指针相向移动，每次移动一步，并判断这两个指针指向的字符是否相同。当这两个指针相遇时，就说明 b 是回文串。
 *
 *
 */


class IsPalindrome {
    public boolean isPalindrome(String s) {
        //Stringbuffer其实是动态字符串数组
        StringBuffer b = new StringBuffer();
        int h = s.length();
        for (int i=0;i<h;i++)
        {
            //charAt()返回指定位置字符
            char c = s.charAt(i);
            //java.lang.Character.isLetterOrDigit(int codePoint) 确定指定字符(Unicode代码点)是一个字母或数字。
            if (Character.isLetterOrDigit(c))
            {
                //Stringbuffer的append()是往动态字符串数组添加，跟“xxxx”+“yyyy”相当那个‘+’号
                //toLowerCase() 方法用于将大写字符转换为小写
                b.append(Character.toLowerCase(c));
            }
        }
        int n=b.length();
        int left=0,right = n-1;
        while (left<right)
        {
            if (Character.toLowerCase(b.charAt(left)) !=Character.toLowerCase(b.charAt(right)))
            {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
