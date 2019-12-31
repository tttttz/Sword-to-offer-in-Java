package SwordToOffer;

/**
 * 给你一根长度为n的绳子，
 * 请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
class Solution67 {
    //方法一：动态规划
    public int cutRope(int target) {
        if(target < 2){
            return 0;
        }
        if(target == 2 || target == 3){
            return target - 1;
        }
        int[] res = new int[target + 1];//记录target为索引值是的最大乘积值
        //此处res[2]=2和res[3] = 3的原因是他们自身的值要比任何切过后的最大值都要大。
        res[0] = 0;//这行可以不要
        res[1] = 1;
        res[2] = 2;
        res[3] = 3;
        for (int i = 4; i <= target ; i++) {
            int max = 0;
            for (int j = 1; j <= i/2 ; j++) {
                int temp = res[j] * res[i - j];
                if(temp > max){
                    max = temp;
                }
            }
            res[i] = max;
        }
        return res[target];
    }
    //方法2：贪心
   /* 下面是分析：
    首先判断k[0]到k[m]可能有哪些数字，实际上只可能是2或者3。
    当然也可能有4，但是4=2*2，我们就简单些不考虑了。
    5<2*3,6<3*3,比6更大的数字我们就更不用考虑了，肯定要继续分。
    次看2和3的数量，2的数量肯定小于3个，为什么呢？因为2*2*2<3*3，那么题目就简单了。
    直接用n除以3，根据得到的余数判断是一个2还是两个2还是没有2就行了。
    由于题目规定m>1，所以2只能是1*1，3只能是2*1，这两个特殊情况直接返回就行了。
    */
    public int cutRope2(int target){
        if(target < 2){
            return 0;
        }
        if(target == 2 || target == 3){
            return target - 1;
        }
        int numberOf3 = target / 3;
        if(target % 3 == 1){
            numberOf3--;
        }
        int numberOf2 = (target - numberOf3 * 3) / 2;
        return new Double(Math.pow(3, numberOf3) * Math.pow(2, numberOf2)).intValue();
    }
}