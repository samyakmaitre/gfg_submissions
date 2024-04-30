//{ Driver Code Starts
// driver

#include <bits/stdc++.h>
using namespace std;

/* Linked list Node */
struct Node {
    int data;
    struct Node* next;
    Node(int x) {
        data = x;
        next = NULL;
    }
};

struct Node* buildList(int size)
{
    int val;
    cin>> val;
    
    Node* head = new Node(val);
    Node* tail = head;
    
    for(int i=0; i<size-1; i++)
    {
        cin>> val;
        tail->next = new Node(val);
        tail = tail->next;
    }
    
    return head;
}

void printList(Node* n)
{
    while(n)
    {
        cout<< n->data << " ";
        n = n->next;
    }
    cout<< endl;
}


// } Driver Code Ends
/* node for linked list:

struct Node {
    int data;
    struct Node* next;
    Node(int x) {
        data = x;
        next = NULL;
    }
};

*/

class Solution
{
    public:
    Node* reverse(Node* head){
        if(!head || !head->next) return head;

        Node*prev=NULL, *temp=head, *next=head->next;
        while(next){
            temp->next=prev;
            prev=temp;
            temp=next;
            next=temp->next;
        }
        temp->next=prev;

        return temp;
    }

    Node* addTwoNumbers(Node* l1, Node* l2) {
        if(!l1) return l2;
        if(!l2) return l1;


        Node* head=l1;

        Node* tail;

        int carry=0;
        while(l1 && l2){
            l1->data += carry+l2->data;
            carry=l1->data/10;
            l1->data %= 10;

            tail=l1;

            l1=l1->next;
            l2=l2->next;
        }
        if(l2){
            tail->next=l2;
            l1=l2;
        }
        while(l1){
            l1->data+=carry;
            carry=l1->data/10;
            l1->data %= 10;
            tail=l1;
            l1=l1->next;
        }

        l1=tail;
        while(carry){
            l1->next=new Node(carry);
            carry=l1->data/10;
            l1->data %= 10;
            l1=l1->next;
        }


        return head;
        
        
    }
    //Function to add two numbers represented by linked list.
    struct Node* addTwoLists(struct Node* num1, struct Node* num2)
    {
        // code here
        while(num1->next && num1->data==0){
            num1=num1->next;
        }
        while(num2->next && num2->data==0){
            num2=num2->next;
        }
        
        num1=reverse(num1);
        num2=reverse(num2);
        
        return reverse(addTwoNumbers(num1, num2));
        
    }
};


//{ Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n, m;
        
        cin>>n;
        Node* num1 = buildList(n);
        
        cin>>m;
        Node* num2 = buildList(m);
        Solution ob;
        Node* res = ob.addTwoLists(num1,num2);
        printList(res);
    }
    return 0;
}

// } Driver Code Ends