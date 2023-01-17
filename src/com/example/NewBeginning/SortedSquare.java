package com.example.NewBeginning;

public class SortedSquare {
    public static int[] sortedSquares(int[] nums) {
      int temp[] = new int[nums.length];
      int i = 0, j = nums.length-1 , k =  nums.length-1 ;
      while(i <= j)
      {
          if((nums[i] * nums[i]) <  (nums[j] * nums[j])){
              temp[k] = (nums[j] * nums[j]);
              j--;
              k--;
          }
          else {
              temp[k] = (nums[i] * nums[i]);
              i++;
              k--;
          }
      }
      return temp;
    }

    public static void main(String[] args) {
        int nums[] = {-4,-1,0,3,10};
        int nums1[] = sortedSquares(nums);
        for(int i = 0; i < nums.length ; i++) {
            System.out.println(nums1[i]);
        }
    }
}
