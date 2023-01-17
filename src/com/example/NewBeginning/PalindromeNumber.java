package com.example.NewBeginning;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
       int temp = x, rvr = 0,rem ;
            while (temp > 0) {
                rem = temp % 10;
                rvr = rvr * 10 + rem;
                temp = temp / 10;
            }
        if (rvr == x) {
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        int x = 1010;
        boolean flag =  isPalindrome(x);
        System.out.println(flag);
    }
}
