package com.example.NewBeginning;

import java.util.Scanner;

class Node{
        int data;
        Node next;
        Node(int x) {
        data = x;
        }
 }
class StackUsingLinkedlistUsingReturn {

    public Node push(int x, Node top){

        Node tempnode = new Node(x);
        if(top == null){
            top = tempnode;
            return top;
        }
        else{
            tempnode.next = top;
            top = tempnode;
            return top;
        }

    }

    public boolean isEmpty(Node top){
        return top == null;
    }
    public Node pop(Node top){
        if(top == null){
            System.out.println("Stack Underflow");
            return null;
        }
        else {
            top = top.next;
            return top;
        }
    }
    public int peek(Node top){
        if(top == null){
            return 0;
        }
        else
            return top.data;

    }
    public void display(Node top){
        Node ptr = top;
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
public class ImplementationStackUsingReturnType {
    public static void main(String[] args) {
        Node top = null;
        StackUsingLinkedlistUsingReturn st = new StackUsingLinkedlistUsingReturn();
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
                    top = st.push(push_var,top);
                    st.display(top);
                    break;

                case 2:
                    top = st.pop(top);
                    st.display(top);
                    break;

                case 3:
                    int p = st.peek(top);
                    System.out.println("The peek value of the stack is " + p);
                    st.display(top);
                    break;

                case 4:
                    boolean flag = st.isEmpty(top);
                    if (flag == true)
                        System.out.println("Stack is Empty");
                    else
                        System.out.println("Stack contain some values");
                    st.display(top);
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

