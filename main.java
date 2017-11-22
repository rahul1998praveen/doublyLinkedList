package doublyLinkedList;

import java.util.Random;

public class main {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		 testPalindrome();
		 testKth();
		reverse();
		selectionSort();

	}
	public static void testPalindrome()throws Exception {
		String [] data = {"a", "m", "a", "n", "a", "p", "l", "a", "n", "a", "c", "a", "n", "a", "l", "p", "a", "n", "a", "m", "a"};
		doublyLinkedList<String> ll = new doublyLinkedList<String>();
		
		for(String s : data) {
			ll.addLast(s);
		}
		System.out.println("isPalindrome(): " + ll.isPalindrome());
}
	 public static void testKth()throws Exception {
 		String [] data = {"one", "two", "three", "four", "five", "six"};
		doublyLinkedList<String> ll = new doublyLinkedList<String>();
		
		for(String s : data) {
			ll.addLast(s);
		}
		for(int k = 0; k < data.length; ++k) {
			System.out.println("k: " + k + " " + data[k] + " " + ll.getKthNode(k));
		}
 }
	 public static void reverse()throws Exception {
			String [] data = {"one", "two", "three", "four", "five", "six"};
			doublyLinkedList<String> ll = new doublyLinkedList<String>();
		
			for(String s : data) {
				ll.addLast(s);
			}
			System.out.println("before reverse:\n " );
			ll.display();
			ll.reverse();
			System.out.println("after reverse: \n");
			ll.display();
	    }	
	 public static void selectionSort() throws Exception{
 		Random random = new Random(20010);
		doublyLinkedList<Integer> ll = new doublyLinkedList<Integer>();
		int n = 100;
		for(int i = 0; i < n; i++) {
			ll.addLast(new Integer(random.nextInt(1000)));
		}
		System.out.println("before sorting : \n");
		ll.display();
		doublyLinkedList<Integer> sorted_ll = new doublyLinkedList<Integer>();
		while(!ll.isEmpty()) {
			sorted_ll.addLast(ll.popMin());
		}
		System.out.println("after sorting : \n" );
		sorted_ll.display();
 }

}
