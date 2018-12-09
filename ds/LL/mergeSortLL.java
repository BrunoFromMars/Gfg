///Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
  int data;
  Node next;
  Node(int key){
	  data = key;
	  next = null;
  }
}

class LinkedList{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			Node head = new  Node(sc.nextInt()),tail = head;
			while(n-->1){
				tail.next = new Node(sc.nextInt());
				tail = tail.next;
			}
			
			head = mergeSort(head);
			printList(head);
			System.out.println();
			
			
		}
	}
	
	public static void printList(Node head){
		if(head == null)
			return;
		
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	public static Node mergeSort(Node h){
		if(h == null || h.next == null)
			return h;
		GfG gfg = new GfG();
		Node middle = gfg.getMiddle(h);
		Node nexttomiddle = middle.next;
		
		middle.next = null;
		
		Node left = mergeSort(h);
		Node right = mergeSort(nexttomiddle);
		
		return gfg.sortedMerge(left,right);
	}
}




	

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

//User function Template for Java
class GfG
{
    
    
    public static Node sortedMerge(Node a, Node b)
    {
        Node result = null;
        
         if (a == null)
            return b;
        if (b == null)
            return a;
 
       
        if (a.data <= b.data) 
        {
            result = a;
            result.next = sortedMerge(a.next, b);
        } 
        else
        {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }
    
    public static Node getMiddle(Node h)
    {
        if (h == null)
            return h;
        Node fastptr = h.next;
        Node slowptr = h;
         
        
        while (fastptr != null)
        {
            fastptr = fastptr.next;
            if(fastptr!=null)
            {
                slowptr = slowptr.next;
                fastptr=fastptr.next;
            }
        }
        return slowptr;
    }
}
