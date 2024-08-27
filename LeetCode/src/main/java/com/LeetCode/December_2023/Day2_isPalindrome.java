package com.LeetCode.December_2023;

//回文数
public class Day2_isPalindrome {
    public static boolean isPalindrome(int x) {
        String t = x+"";
        int len = t.length();
        char[] arr = new char[len];
        char[] arr2 = new char[len];
        for(int i=0;i<len;i++){
            arr[i] = t.charAt(i);
            arr2[i] = t.charAt(len-1-i);
        }

        int j=0;
        for(int i =0;i<len;i++){
            if (arr[i]==arr2[i]) {
                j++;
            }
        }
        if(j==len){
            return true;
        }else{
            return false;
        }
    }

    //反转一半数字
    public static boolean isPalindrome2(int x) {
        //当x为负数和x的个位数为零时，该数不可能是回文数
        if((x % 10 == 0 && x != 0) || x < 0 ){
            return false;
        }
        //定义一个变量存储反转后的回文数
        int revertedNumber = 0;
        //当x大于该回文数，执行循环
        while (x > revertedNumber){
            revertedNumber = revertedNumber * 10 + x % 10;
            x = x / 10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x==revertedNumber||x==revertedNumber/10;

    }


}
