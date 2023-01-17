package com.example.NewBeginning;

public class shuffleTheArray {
    public static int[] shuffle(int[] nums, int n){
        int temp[] = new int[nums.length];
        int x = 0,y = 1;
        for(int i = 0; i < nums.length ; i++)
        {
            if(i < n){
                temp[x] = nums[i];
                 x = x + 2;
            }
            else
            {
                temp[y] = nums[i];
                y = y + 2;
            }

        }
        return temp;
    }
    public static void main(String[] args) {

        int nums[] = {1,2,3,4,4,3,2,1};
        int n = 4;
        int res[] = shuffle(nums, n);
        for(int i = 0; i < nums.length; i++) {
            System.out.println(res[i]);
        }
    }
}

