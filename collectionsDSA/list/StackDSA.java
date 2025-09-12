package collectionsDSA.list;

import java.util.*;

public class StackDSA {
    public static void main(String[] args) {
        // 1. CREATION - Multiple ways to create Stack
        Stack<Integer> stack1 = new Stack<>();  // Legacy Stack class
        Deque<Integer> stack2 = new ArrayDeque<>();  // Recommended approach
        LinkedList<Integer> stack3 = new LinkedList<>();  // LinkedList as stack
        
        // 2. BASIC STACK OPERATIONS (LIFO - Last In First Out)
        
        // Push operations - O(1)
        stack1.push(10);  // O(1)
        stack1.push(20);  // O(1)
        stack1.push(30);  // O(1)
        System.out.println("Stack after pushes: " + stack1);
        
        // Peek operation - O(1)
        Integer topElement = stack1.peek();  // O(1) - view top element
        System.out.println("Top element (peek): " + topElement);
        System.out.println("Stack after peek: " + stack1);  // No change
        
        // Pop operations - O(1)
        Integer popped = stack1.pop();  // O(1) - remove and return top
        System.out.println("Popped element: " + popped);
        System.out.println("Stack after pop: " + stack1);
        
        // Check if empty - O(1)
        boolean isEmpty = stack1.isEmpty();  // O(1)
        System.out.println("Is stack empty: " + isEmpty);
        
        // Get size - O(1)
        int size = stack1.size();  // O(1)
        System.out.println("Stack size: " + size);
        
        // 3. COMMON STACK OPERATIONS WITH ARRAYDEQUE (RECOMMENDED)
        Deque<Integer> stack = new ArrayDeque<>();
        
        // Stack operations using Deque methods
        stack.push(100);        // O(1) - push to front
        stack.push(200);        // O(1)
        stack.push(300);        // O(1)
        System.out.println("Deque stack: " + stack);
        
        System.out.println("Peek: " + stack.peek());     // O(1)
        System.out.println("Pop: " + stack.pop());       // O(1)
        System.out.println("After pop: " + stack);
        
        // 4. COMMON DSA PROBLEMS USING STACK
        
        // Balanced parentheses check
        String expression1 = "((()))";
        String expression2 = "(()";
        System.out.println("Is '" + expression1 + "' balanced: " + isBalanced(expression1));
        System.out.println("Is '" + expression2 + "' balanced: " + isBalanced(expression2));
        
        // Reverse a string using stack
        String original = "Hello";
        String reversed = reverseString(original);
        System.out.println("Original: " + original + ", Reversed: " + reversed);
        
        // Evaluate postfix expression
        String postfix = "23+4*";  // (2+3)*4 = 20
        int result = evaluatePostfix(postfix);
        System.out.println("Postfix '" + postfix + "' = " + result);
        
        // Next greater element problem
        int[] arr = {4, 5, 2, 25};
        int[] nextGreater = findNextGreater(arr);
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Next greater: " + Arrays.toString(nextGreater));
    }
    
    // Check balanced parentheses - O(n) time, O(n) space
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    // Reverse string using stack - O(n) time, O(n) space
    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }
        
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }
    
    // Evaluate postfix expression - O(n) time, O(n) space
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');  // Convert char to int
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (ch) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }
    
    // Next greater element - O(n) time, O(n) space
    public static int[] findNextGreater(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }
}

/*
 ============================================================================
                    STACK TIME COMPLEXITY ANALYSIS
 ============================================================================
 
 | Operation                    | Time Complexity | Space Complexity | Description
 |------------------------------|-----------------|------------------|------------
 | push(element)                | O(1)           | O(1)            | Add to top
 | pop()                        | O(1)           | O(1)            | Remove from top
 | peek()                       | O(1)           | O(1)            | View top element
 | isEmpty()                    | O(1)           | O(1)            | Check if empty
 | size()                       | O(1)           | O(1)            | Get element count
 | search(element)              | O(n)           | O(1)            | Linear search
 | iterator()                   | O(1)           | O(1)            | Create iterator
 | clear()                      | O(1)           | O(1)            | Remove all elements
 
 ============================================================================
                    WHEN TO USE STACK
 ============================================================================
 
 ✓ Function call management (recursion simulation)
 ✓ Expression evaluation and parsing
 ✓ Backtracking algorithms
 ✓ Undo mechanisms in applications
 ✓ Browser history implementation
 ✓ Balanced parentheses checking
 ✓ Tree and graph traversal (DFS)
 ✓ Memory management

 ============================================================================
                    WHEN TO AVOID STACK
 ============================================================================
 
 ✗ When you need random access to elements
 ✗ When FIFO behavior is needed (use Queue)
 ✗ When you need to access middle elements frequently
 ✗ When memory is extremely constrained
 ✗ When thread safety is required without synchronization

 ============================================================================
                    COMPARISON OF STACK IMPLEMENTATIONS
 ============================================================================
 
 | Implementation | push() | pop() | peek() | Memory | Notes
 |----------------|--------|-------|--------|--------|-------
 | Stack<Class>   | O(1)   | O(1)  | O(1)   | Higher | Legacy, synchronized
 | ArrayDeque     | O(1)   | O(1)  | O(1)   | Lower  | Recommended, not synchronized
 | LinkedList     | O(1)   | O(1)  | O(1)   | Highest| Node overhead, not recommended

 ============================================================================
                    COMMON DSA INTERVIEW QUESTIONS
 ============================================================================
 
 1. Balanced parentheses/brackets checking - O(n)
 2. Infix to postfix/prefix conversion - O(n)
 3. Evaluation of postfix/prefix expressions - O(n)
 4. Next greater element problem - O(n)
 5. Stock span problem - O(n)
 6. Largest rectangle in histogram - O(n)
 7. Implement queue using two stacks - O(1) amortized
 8. Sort a stack using recursion - O(n²)
 9. Reverse a stack using recursion - O(n)
 10. Design a stack with getMin() in O(1) - O(1)
 11. Celebrity problem - O(n)
 12. Tower of Hanoi - O(2ⁿ)
 13. Iterative tree traversals - O(n)
 14. Decode string problem - O(n)
 15. Valid stack sequences - O(n)
 
 ============================================================================
*/