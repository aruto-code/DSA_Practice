package com.example.NewBeginning;

public class InfiniteLoop {
    public static void main(String[] args) throws InterruptedException {
            boolean flag = false;
            while (true) {
                if (flag == false) {
                    System.out.println("Abhinav");
                    Thread.sleep(4000);
                    flag = true;
                }
                System.out.println("Arushee");
            }
        }
    }
