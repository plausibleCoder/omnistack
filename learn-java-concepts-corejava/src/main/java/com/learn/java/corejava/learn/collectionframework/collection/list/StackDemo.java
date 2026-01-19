package com.learn.java.corejava.learn.collectionframework.collection.list;

import java.util.Stack;

public class StackDemo {
    /*
    The Stack class is a legacy class that extends Vector.
    It represents a Last-In, First-Out (LIFO) stack of objects.
    It has specific methods for stack operations: push, pop, peek.
    It is synchronized, just like Vector.
    For modern code, it's better to use ArrayDeque as a stack implementation.
    */
    public static void main(String[] args) {
        System.out.println("--- Demonstrating the Stack class (LIFO) ---");

        Stack<String> stack = new Stack<>();
       

        // 1. Pushing elements onto the stack
        stack.push("Task 1");
        stack.push("Task 2");
        stack.push("Task 3");
        System.out.println("Stack after pushing elements: " + stack);

        // 2. Peeking at the top element (without removing)
        System.out.println("Top element (peek): " + stack.peek());
        System.out.println("Stack after peeking: " + stack);

        // 3. Popping elements from the stack (retrieves and removes)
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack after popping: " + stack);

        // 4. Popping another element
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack after another pop: " + stack);

        // 5. Checking if stack is empty
        System.out.println("Is stack empty? " + stack.empty());
    }
}
