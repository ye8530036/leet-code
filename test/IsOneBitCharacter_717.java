/**
 * 题目：717. 1比特与2比特字符
 * 将10，11捆绑；
 * 遇到1时跳2格遇到0时向下跳一格
 * 再比对长度，由于末尾是0所以当倒数第二位是1时则会多进一位，即false
 * 否则即为true
 */

class IsOneBitCharacter_717 {
    public boolean isOneBitCharacter(int[] bits) {
        int start=0;
        while (start < bits.length-1){
            if (bits[start]==0){
                start++;
            }else {
                start+=2;
            }
        }
        return start== bits.length-1;
    }
}
