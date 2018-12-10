{
import java.util.*;
class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}
class Main{
	static Node head;
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			head=null;
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);
            for (int i=1;i<n;i++) {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
			}
			int k=sc.nextInt();
			GfG g=new GfG();
			g.rotate(head,k);
			System.out.println();
		}
	}
    public static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }
}
}

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}
*/
class GfG
{
	public void rotate(Node head,int k){
	    if(k==0)
	        return;
	    Node last = head;
	    Node curr = head;
	    while(last.next!=null){
	        last = last.next;
	    }
	    last.next = head;
	    for(int i=1;i<k;i++){
	        curr = curr.next;
	    }
	    
	    head = curr.next;
	    
	    curr.next = null;
	    
	    while(head != null){
	        System.out.print(head.data + " ");
	        head = head.next;
	    }
	}
}
