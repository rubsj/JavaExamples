/*
 * Created by Ruby Jha on 7/21/2018
 */
package com.ruby.datastructure;

public class Stack<T> {
    private static int MAX_SIZE = 40;
    private Element<T> top;
    private int size = 0;

    public void push(T data) throws StackOverFlowException {
        if (size == MAX_SIZE) {
            throw new StackOverFlowException();
        }
        top = new Element<>(data, top);
        size++;
    }

    public T pop() throws StackUnderFlowException {
        if (size == 0) {
            throw new StackUnderFlowException();
        }
        T popedData = top.getData();
        top = top.getNext();
        return popedData;
    }

    public T peek() throws StackUnderFlowException {
        if (size == 0) {
            throw new StackUnderFlowException();
        }

        return top.getData();
    }
}

