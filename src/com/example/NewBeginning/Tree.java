package com.example.NewBeginning;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

class TreeNode{
    int key;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
        key = x;
    }
}

public class Tree {
    private static TreeNode InsertInBST(TreeNode root, int x){
        TreeNode temp = new TreeNode(x);
        TreeNode parent = null, curr = root;
        while(curr != null){
            parent = curr;
            if(curr.key > x)
                curr = curr.left;
            else if(curr.key < x)
                curr = curr.right;
            else
                return root;
        }
        if(parent == null)
            return temp;
        if(parent.key > x)
            parent.left = temp;
        else
            parent.right = temp;
        return root;
    }

    public static Boolean SearchInBST(TreeNode root, int x){
        while(root != null){
            if(root.key == x)
                return true;
            else if(root.key < x)
                root = root.right;
            else
                root = root.left;
        }
        return false;
    }

    public static TreeNode getSuccessor(TreeNode curr){
        curr=curr.right;
        while(curr!=null && curr.left!=null)
            curr=curr.left;
        return curr;
    }

    public static TreeNode DeleteInBST(TreeNode root, int x){
        if(root == null)
            return null;
        if(root.key > x)
            root.left = DeleteInBST(root.left,x);
        else if(root.key < x)
            root.right = DeleteInBST(root.right,x);
        else{
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                TreeNode successor = getSuccessor(root);
                root.key = successor.key;
                root.right = DeleteInBST(root.right,successor.key);
            }
        }
        return root;
    }

    public static void PrintTree(TreeNode root){
        if (root == null){
            return;
        }
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            System.out.print(cur.key+" ");
            if (cur.left != null){
                q.offer(cur.left);
            }
            if (cur.right != null){
                q.offer(cur.right);
            }
        }
    }

    public static TreeNode InsertInBT(TreeNode root, int x, int p, String c){
        if(root == null){
            System.out.println("Tree is Empty. Making it the root node");
            root = new TreeNode(x);
        }
        else {
            ArrayDeque<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            boolean flag = false;
            while (!q.isEmpty()){
                TreeNode temp = q.poll();

                if(temp.key == p){
                    if(c.equals("l") || c.equals("L")){
                        if(temp.left == null){
                            temp.left = new TreeNode(x);
                        }
                        else {
                            System.out.println("Left child is already present of parent node");
                        }
                        flag = true;
                        break;

                    }
                    if(c.equals("r") || c.equals("R")){
                        if(temp.right == null){
                            temp.right = new TreeNode(x);
                        }
                        else {
                            System.out.println("Right child is already present of parent node");
                        }
                        flag = true;
                        break;
                    }
                }
                else {
                    if(temp.left != null){
                        q.add(temp.left);
                    }
                    if(temp.right != null){
                        q.add(temp.right);
                    }
                }
            }

            if(!flag){
                System.out.println("Parent node not found");
            }
        }
        return root;
    }

    public static Boolean SearchInBT(TreeNode root, int x){
        if(root == null){
            return false;
        }
        else {
            ArrayDeque<TreeNode> q = new ArrayDeque<>();
            if(root.key == x){
                return true;
            }
            q.add(root);
            while (!q.isEmpty()){
                TreeNode temp = q.poll();
                if(temp.key == x){
                    return true;
                }
                if (temp.left != null){
                    q.add(temp.left);
                }
                if (temp.right != null){
                    q.add(temp.right);
                }
            }
        }
        return false;
    }

    public static TreeNode DeleteInBT(TreeNode root, int x){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            if(root.key == x){
                return null;
            }
        }

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        TreeNode DeleteNode = null, temp = null, last = null;
        q.add(root);

        while (!q.isEmpty()){
            temp = q.poll();

            if (temp.key == x){
                DeleteNode = temp;
            }
            if (temp.left != null){
                last = temp;
                q.add(temp.left);
            }
            if (temp.right != null){
                last = temp;
                q.offer(temp.right);
            }
        }

        if (DeleteNode != null){
            DeleteNode.key = temp.key;
            if (last.right == temp){
                last.right = null;
            }
            else {
                last.left = null;
            }
        }
        else {
            System.out.println("Node to be deleted Not Present");
        }

        return root;
    }

    public static void BuildHeap(int[] arr, int n){
        for (int i = n / 2 - 1; i >= 0; i--)
            Heapify(arr, n, i);
    }

    public static void Heapify(int[] arr, int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            Heapify(arr, n, largest);
        }
    }

    public static void HeapSort(int[] arr)
    {
        int n = arr.length;

        BuildHeap(arr,n);

        for (int i=n-1; i>0; i--)
        {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            Heapify(arr, i, 0);
        }
    }

    public static void printArray(int[] arr)
    {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    public static int [] ConvertTreeToArray(TreeNode root){
        ArrayList<Integer> arr = new ArrayList<>();
        if(root == null){
            return new int[0];
        }

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode temp = q.poll();
            arr.add(temp.key);
            if (temp.left != null){
                q.add(temp.left);
            }
            if (temp.right != null){
                q.add(temp.right);
            }
        }

        int [] intArr = new int[arr.size()];

        for (int i = arr.size() - 1; i >=0; i--){
            intArr[i] = arr.get(i);
        }

        return intArr;
    }

    public static void main(String[] args) {
        System.out.println("Tree ");
        System.out.println("Choose The Tree You want to create");
        System.out.println("1. Binary Tree");
        System.out.println("2. Binary Search Tree");
        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();

        if(ch == 1){
            TreeNode BT = null;
            while(true){
                System.out.println("Choose The Operation");
                System.out.println("1. Insert in Binary Tree");
                System.out.println("2. Delete in Binary Tree");
                System.out.println("3. Search in Binary Tree");
                System.out.println("4. Apply Heap Sort");
                System.out.println("5. Exit");
                ch = sc.nextInt();
                switch (ch){
                    case 1:
                        System.out.println("Enter value to be inserted");
                        int x = sc.nextInt();
                        System.out.println("Enter the parent value");
                        int p = sc.nextInt();
                        System.out.println("Enter the position. L to make left child or R to make right child");
                        String c = sc.next();
                        BT = InsertInBT(BT,x,p,c);
                        PrintTree(BT);
                        break;
                    case 2:
                        System.out.println("Enter value to be Deleted");
                        x = sc.nextInt();
                        BT = DeleteInBT(BT,x);
                        PrintTree(BT);
                        break;
                    case 3:
                        System.out.println("Enter value to be Searched");
                        x = sc.nextInt();
                        if(SearchInBT(BT,x)){
                            System.out.println(x + " is present");
                        }
                        else{
                            System.out.println(x + " is not present");
                        }
                        break;
                    case 4:
                        System.out.println("Do you want to perform heap sort on existing Binary Tree or Enter new Array?");
                        System.out.println("1. Existing Binary Tree");
                        System.out.println("2. Input new Array");
                        int op = sc.nextInt();
                        if(op == 1){
                            int [] arr = ConvertTreeToArray(BT);
                            if (arr.length == 0){
                                System.out.println("Tree is Empty");
                                break;
                            }
                            HeapSort(arr);
                            printArray(arr);
                        }
                        else{
                            System.out.println("Enter the size of array");
                            int n = sc.nextInt();
                            int [] heapArr = new int[n];
                            System.out.println("Enter the Elements");
                            for (int i = 0; i < n; i++){
                                heapArr[i] = sc.nextInt();
                            }
                            HeapSort(heapArr);
                            printArray(heapArr);
                        }
                        break;
                    case 5:
                        System.out.println("Exit");
                        break;

                    default:
                        System.out.println("Invalid Choice");
                }
                if(ch == 5){
                    break;
                }
            }
        }
        else if(ch == 2){
            TreeNode BST = null;
            while(true){
                System.out.println("Choose The Operation");
                System.out.println("1. Insert in Binary Search Tree");
                System.out.println("2. Delete in Binary Search Tree");
                System.out.println("3. Search in Binary Search Tree");
                System.out.println("4. Apply Heap Sort");
                System.out.println("5. Exit");
                ch = sc.nextInt();
                switch (ch){
                    case 1:
                        System.out.println("Enter value to be inserted");
                        int x = sc.nextInt();
                        BST = InsertInBST(BST,x);
                        PrintTree(BST);
                        break;
                    case 2:
                        System.out.println("Enter value to be deleted");
                        x = sc.nextInt();
                        BST = DeleteInBST(BST,x);
                        PrintTree(BST);
                        break;
                    case 3:
                        System.out.println("Enter value to be Searched");
                        x = sc.nextInt();
                        if(SearchInBST(BST,x)){
                            System.out.println(x + " is present");
                        }
                        else{
                            System.out.println(x + " is not present");
                        }
                        break;
                    case 4:
                        System.out.println("Do you want to perform heap sort on existing Binary Search Tree or Enter new Array?");
                        System.out.println("1. Existing Binary Tree");
                        System.out.println("2. Input new Array");
                        int op = sc.nextInt();
                        if(op == 1){
                            int [] arr = ConvertTreeToArray(BST);
                            if (arr.length == 0){
                                System.out.println("Tree is Empty");
                                break;
                            }
                            HeapSort(arr);
                            printArray(arr);
                        }
                        else{
                            System.out.println("Enter the size of array");
                            int n = sc.nextInt();
                            int [] heapArr = new int[n];
                            System.out.println("Enter the Elements");
                            for (int i = 0; i < n; i++){
                                heapArr[i] = sc.nextInt();
                            }
                            HeapSort(heapArr);
                            printArray(heapArr);
                        }
                        break;
                    case 5:
                        System.out.println("Exit");
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }
                if(ch == 5){
                    break;
                }
            }
        }
        else{
            System.out.println("Invalid Choice");
        }
    }
}