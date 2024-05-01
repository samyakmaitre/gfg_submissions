//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    Node head = null, tail = null;
		    
		    char head_c = sc.next().charAt(0);
		    head = new Node(head_c);
		    tail = head;
		    
		    while(n-- > 1){
		        tail.next = new Node(sc.next().charAt(0));
		        tail = tail.next;
		    }
		    
		    Solution obj = new Solution();
		    //show(head);
		    show(obj.arrangeCV(head));
		    
		}
	}
	
	public static void po(Object o){
	    System.out.println(o);
	}
	
	public static void show(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*
Structure of node class is:
class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    
    public Node arrangeCV(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // Create dummy nodes for vowels and consonants
        Node vowelDummy = new Node('0'); // Dummy node for vowels
        Node consonantDummy = new Node('0'); // Dummy node for consonants
        
        // Pointers to track last nodes of vowel and consonant lists
        Node vowelTail = vowelDummy;
        Node consonantTail = consonantDummy;
        
        // Traverse the original list and separate vowels and consonants
        Node current = head;
        while (current != null) {
            if (isVowel(current.data)) {
                vowelTail.next = current;
                vowelTail = current;
            } else {
                consonantTail.next = current;
                consonantTail = current;
            }
            current = current.next;
        }
        
        // Connect the last node of the vowel list to the first node of the consonant list
        vowelTail.next = consonantDummy.next;
        
        // Disconnect the last node of the consonant list to avoid cycles
        consonantTail.next = null;
        
        // Return the head of the merged list
        return vowelDummy.next;
    }
    
    // Helper function to check if a character is a vowel
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
