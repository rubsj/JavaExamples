/**
 *
created by Ruby Jha on 11/18/2018

Implement a queue with two stacks so that each queue operations takes a constant amortized
number of stack operations.

 Solution Approach - in en-queue operation, the new element is entered at the top of stack1.
 In de-queue operation, if stack2 is empty then all the elements are moved to stack2 and
 finally top of stack2 is returned.

 Enqueue has O(1) complexity while dequeue has O(n). 

 */
package com.ruby.algs.stacksAndQueues;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class QueueWithTwoStacks<T> {
  private Stack<T> enqueueStack; // back of the queue, where items will be inserted
  private Stack<T> deQueueStack; // from of the queue , from where item will be removed

    // create empty queue
    public QueueWithTwoStacks(){
        enqueueStack = new Stack<>();
        deQueueStack = new Stack<>();
    }

    // move all items from enqueue stack to dequeue stack
    private void moveItems(){
        while (!enqueueStack.isEmpty()){
            deQueueStack.push(enqueueStack.pop());
        }
    }

    public boolean isQueueEmpty(){
        return deQueueStack.isEmpty() && enqueueStack.isEmpty();
    }

    public int size(){
        return enqueueStack.size() + deQueueStack.size();
    }

    public T peek(){
        if(isQueueEmpty()) throw new NoSuchElementException("Queue underflow");
        if(deQueueStack.isEmpty()){
            moveItems();
        }
        return deQueueStack.peek();
    }

    public void enqueue(T t){
       enqueueStack.push(t);
    }

    public T dequeue(){
        if(isQueueEmpty()) throw new NoSuchElementException("Queue Underflow");
        if(deQueueStack.isEmpty()){
            moveItems();
        }

        return deQueueStack.pop();
    }

    public static void main(String[] args) {
        QueueWithTwoStacks<String> queue = new QueueWithTwoStacks<>();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-")) queue.enqueue(item);
            else if(!queue.isQueueEmpty()) StdOut.print(queue.dequeue() + " ");
        }
        StdOut.printf("( %d left on queue ) %n" , queue.size());
    }
}

