package SDE.StackAndQueue;

public class ImplementQueueUsingArray {
    
}

class MyQueue {

    int front, rear;
	int arr[] = new int[100005];
	int n = arr.length;
	int count = 0;

    MyQueue()
	{
		front=0;
		rear=0;
	}
	
	//Function to push an element x in a queue.
	void push(int x)
	{
	    // Your code here
	    if(count==n)
	        return;
	    arr[rear%n]=x;
	    rear++;
	    count++;
	} 

    //Function to pop an element from queue and return that element.
	int pop()
	{
		// Your code here
		if(count==0)
		    return -1;
		int ele = arr[front%n];
		arr[front%n]=-1;
		front++;
		count--;
		return ele;
	} 
}