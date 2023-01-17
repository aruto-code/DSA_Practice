/* *****************************************************************************************
                             BUBBLE SORT IN JAVA
                             NAME - ARUSHEE TOMAR
                             ROLL NO - 21COB661
                             ENROLLMENT - GK9066
 ****************************************************************************************** */
package com.example.NewBeginning;
import java.util.* ;

import java.lang.Math;

public class Bubble_sort {

    //Methods to swap two numbers in array
    public void swap(int i, int j) {
        int temp;

        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    //Method to display the array
    public void display(int n) {

        for (int j = 0; j < n; j++) {
            System.out.print(" " + arr[j]);
        }
    }

    // Input array as Private member
    int[] arr;

    public static void main(String[] args) {
        int min = 0, max = 100;

        //Creating an object of the class Bubble_sort()
        Bubble_sort bs = new Bubble_sort();
        //taking the number of elements in the array
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array ");

        int n = sc.nextInt();
        bs.arr = new int[n];

        //taking input in the array through random() function
        System.out.println("Enter the array  ");
        for (int i = 0; i < n; i++) {
           // bs.arr[i] = (int) (Math.random() * (max - min + 1) + min);
            bs.arr[i] = sc.nextInt();
        }

        //Displaying the input to the user
        //System.out.println("The input arrayyyy is  ");
        //bs.display(n);

        //Applying the bubble sort
        for (int i = 1; i < n; i++) {
            if(i%2 == 0)
            {
                for (int j = 0; j < n - 1; j++)
                {
                    if (bs.arr[j] > bs.arr[j + 1])
                    {
                        bs.swap(j + 1, j);
                    }
                }
                System.out.println();
                bs.display(n);
            }
            else
            {
                for (int j = n-2 ; j >= 0 ; j--)
                {
                        if (bs.arr[j] > bs.arr[j+1])
                        {
                            bs.swap(j+1, j);
                        }
                }
                System.out.println();
                bs.display(n);
            }

        }

        //Displaying the output to the user
        System.out.println();
        System.out.println("The Sorted array is ");
        bs.display(n);
    }
}