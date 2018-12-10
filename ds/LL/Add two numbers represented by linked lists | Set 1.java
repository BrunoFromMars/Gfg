{
import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(){}
        Node(int d) {data = d; next = null; }
    }
class Add_LinkedList
{
    Node head;
	
	 void printList(Node head) 
	 {
        while (head != null) 
		{
            System.out.print(head.data + " ");
            head = head.next;
        }
        //System.out.println("");
    }
	
	
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
   public static void main(String[] args)
    {
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      while(T>0)
      {
        int n1 = sc.nextInt();
        Add_LinkedList list1 = new Add_LinkedList();
        for (int i = 1; i <= n1; i++) 
		{
            int a = sc.nextInt();
            list1.push(a);
        }
		int n2 = sc.nextInt();
		Add_LinkedList list2 = new Add_LinkedList();
		for(int i = 0; i < n2; i++)
		{
			int b = sc.nextInt();
			list2.push(b);
		}
		Add_LinkedList list3 = new Add_LinkedList();
        GfG g = new GfG();
        Node rs = g.addTwoLists(list1.head, list2.head);
		list3.printList(rs);
		System.out.println();
	   T--;}}}    
}

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*The Node is defined as
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
        Node(){}
    }
*/
class GfG
{
	Node addTwoLists(Node first, Node second){
	   
	   if(first==null)
	       return second;
	   if(second==null)
	       return first;
	   
	   Node curr1 = first;
	   Node curr2 = second;
	   Node result = null;
	   Node prev = null;
	   int sum =0;
	   
	   int temp =0;
	   while(curr1!= null && curr2 != null){
	       sum  = (temp  +  curr1.data + curr2.data)%10;
	       temp = ( (temp + curr1.data + curr2.data) > 9 ? 1 : 0  );
	       
	       Node curr3 = new Node(sum);
	       if(result == null)
	        result = curr3;
	       else
	        prev.next = curr3;
	       
	       prev = curr3;
	       
	       curr1 = curr1.next;
	       curr2 = curr2.next;
	       
	       
	   }
	   if(curr1 != null ){
	       while(curr1 != null ){
	           sum  = (temp  +  curr1.data )%10;
	           temp = ( (temp + curr1.data ) > 9 ? 1 : 0  );
	           Node curr3 = new Node(sum);
	           if(result == null)
	            result = curr3;
	           else
	            prev.next = curr3;
	       
	           prev = curr3;
	       
	           curr1 = curr1.next;
	           
	       }
	   }else{
	       while(curr2 != null ){
	           sum  = (temp  +  curr2.data )%10;
	           temp = ( (temp + curr2.data ) > 9 ? 1 : 0  );
	           Node curr3 = new Node(sum);
	           if(result == null)
	            result = curr3;
	           else
	            prev.next = curr3;
	       
	           prev = curr3;
	       
	           curr2 = curr2.next;
	       
	       }
	   
	   }
	   if(temp>0){
	       Node curr3 = new Node(1);
	       prev.next = curr3;
	       prev = curr3;
	       
	   }
	   
	   prev.next = null;
	   
	   return result;
	
   }
} 
