/**
 * 题目：1518. 换酒问题
 * 时间：12-17
 * 作者：YeJiaYu
 */


class NumWaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int b=numBottles,sum=numBottles;
        //主要思路在于喝完定量的酒，能换了就直接先去换，换了再喝直到换不了
        while (b >= numExchange){
            //喝了能换酒喝的数量，把空瓶减掉
            b=b-numExchange;
            //能喝酒的数量+1
            ++sum;
            //酒的余量+1
            ++b;
       }
       return sum;
    }
}
