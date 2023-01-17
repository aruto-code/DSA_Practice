package com.example.NewBeginning;

public class maximum69number {
   public static int reverse(int num){
        int rem, rvr = 0 ;
        while(num != 0) {
            rem = num % 10;
            rvr = rvr * 10 + rem;
            num = num / 10;
        }
        return rvr;
    }
    public static int max_69_num(int num){
        int rem , count = 0 ;
        int temp = reverse(num);
        while(temp != 0) {
            count++;
            temp = temp/10;
        }
        int n = count;
        int arr[] = new int[n];
        temp = reverse(num);

        for(int i = 0; i < n  ;i++)
        {
            rem = temp % 10;
            arr[i] = rem;
            temp = temp/10;
        }

        for(int i = 0; i < n ;i++)
        {
           if(arr[i] == 6) {
               arr[i] = 9;
               break;
           }
        }
        temp = 0;
        for(int i = 0; i < n ;i++) {
            temp = temp * 10 + arr[i];
        }
        return temp;
    }
    public static void main(String[] args) {
         int num = 9999;
        System.out.println("  " +max_69_num(num));
    }
}
