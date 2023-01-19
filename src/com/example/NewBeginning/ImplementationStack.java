package com.example.NewBeginning;

import java.util.Scanner;


class node{
    int data;
    node next;
    node(int x) {
        data = x;
    }
}


class StackUsingLinkedlist{

    node top;
    StackUsingLinkedlist(){
        top = null;
    }

    public void push(int x){

        node tempnode = new node(x);
        if(top == null){
            top = tempnode;
        }
        else{
            tempnode.next = top;
            top = tempnode;
        }

    }

    public boolean isEmpty(){
           return top == null;
    }
    public void pop(){
        if(top == null){
            System.out.println("Stack Underflow");
        }
        else
        top = top.next;
    }
    public int peek(){
        if(top == null){
            return 0;
        }
        else
            return top.data;

    }
    public void display(){
        node ptr = top;
        if(top == null)
            System.out.println("Stack is Empty");
        else {
            while (ptr != null) {
                System.out.println( ptr.data + " ");
                ptr = ptr.next;
            }
        }
    }

}

public class ImplementationStack {
    public static void main(String[] args) {
        StackUsingLinkedlist st = new StackUsingLinkedlist();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter 1. Push");
            System.out.println("Enter 2. Pop");
            System.out.println("Enter 3. Peek");
            System.out.println("Enter 4. Check Empty Stack");
            System.out.println("Enter 5. Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter the value to be pushed into the stack");
                    int push_var = sc.nextInt();
                    st.push(push_var);
                    st.display();
                    break;

                case 2:
                    st.pop();
                    st.display();
                    break;

                case 3:
                    int p = st.peek();
                    System.out.println("The peek value pf the stack is" + p);
                    st.display();
                    break;

                case 4:
                    boolean flag = st.isEmpty();
                    if (flag == true)
                        System.out.println("Stack is Empty");
                    else
                        System.out.println("Stack contain some values");
                    st.display();
                    break;

                case 5:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Wrong value entered");
                    break;

            }
        }
    }
}
