/**
 * Created by Ruby Jha on 11/18/2018
 * <p>
 * Create a data structure that efficiently supports the stack operations (push and pop) and also a return-the-maximum operation.
 * Assume the elements are real numbers so that you can compare them
 * <p>
 * Time Complexity: O(N) for the popMax operation, and O(1)for the other operations, where N is the number of operations performed.
 * <p>
 * Space Complexity: O(N), the maximum size of the stack.
 */
package com.ruby.algs.stacksAndQueues;


import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackWithMax {
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    public StackWithMax() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(Integer item) {
        Integer max = maxStack.isEmpty() ? item : maxStack.peek();
        maxStack.push(max > item ? max : item);
        stack.push(item);
    }

    public Integer pop() {
        maxStack.pop();
        return stack.pop();
    }

    public Integer top() {
        return stack.peek();
    }

    public Integer peekMax() {
        return maxStack.peek();
    }

    //to pop max , get the max item find it in stack and then pop from there as well
    public Integer popMax() {
        Integer max = maxStack.peek();
        Stack<Integer> tempStack = new Stack<>();
        while (!top().equals(max)) {
            tempStack.push(pop());
        }
        pop();
        while (!tempStack.isEmpty()) {
            push(tempStack.pop());
        }
        return max;
    }

    public static void main(String[] args) {
        StackWithMax maxStack = new StackWithMax();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) maxStack.push(new Integer(item));
            else StdOut.print(maxStack.popMax() + " ");
        }
        StdOut.printf("( %d left on queue ) %n", maxStack);
    }
}

