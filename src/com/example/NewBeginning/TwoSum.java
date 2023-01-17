package com.example.NewBeginning;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int indices[] = new int[2];
        //Naive solution
        for(int i = 0 ; i < nums.length; i++){
            for(int j = i + 1 ; j < nums.length ; j++){
                if(nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                }
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        int nums[] = {3,2,4};
        int target = 6;
        int indices[] = twoSum(nums,target);
        for(int i = 0 ; i < indices.length; i++) {
            System.out.println(indices[i]);
        }
    }
}